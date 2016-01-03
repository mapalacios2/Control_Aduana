/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.servicio;


import ec.edu.espe.distribuidas.modelo.CabeceraDeclaracion;
import ec.edu.espe.distribuidas.modelo.Declaracion;
import ec.edu.espe.distribuidas.modelo.Importador;
import ec.edu.espe.distribuidas.modelo.Origen;
import ec.edu.espe.distribuidas.modelo.Producto;
import ec.edu.espe.distribuidas.modelo.PuertoIngreso;
import ec.edu.espe.distribuidas.modelo.dao.CabeceraDeclaracionDAO;
import ec.edu.espe.distribuidas.modelo.dao.DeclaracionDAO;
import ec.edu.espe.distribuidas.modelo.dao.ImportadorDAO;
import ec.edu.espe.distribuidas.modelo.dao.OrigenDAO;
import ec.edu.espe.distribuidas.modelo.dao.ProductoDAO;
import ec.edu.espe.distribuidas.modelo.dao.PuertoIngresoDAO;
import ec.edu.espe.distribuidas.util.MensajeExcepcion;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author Marco Antonio
 */
@LocalBean
@Stateless
public class DeclaracionServicio {
    
    @EJB
    OrigenDAO origenDAO;
    @EJB
    PuertoIngresoDAO puertoDAO;
    @EJB
    ProductoDAO productoDAO;
    @EJB
    DeclaracionDAO declaracionDAO;
    @EJB
    CabeceraDeclaracionDAO cabeceraDeclaracionDAO;
    @EJB
    ImportadorDAO importadorDAO;

    public void crearDeclaracion(CabeceraDeclaracion cabeceraDeclaracion) {
        this.cabeceraDeclaracionDAO.insert(cabeceraDeclaracion);
    }

    public void crearCabeceraDeclaracion(CabeceraDeclaracion cabeceraDeclaracion) {
        Importador importadorTemp = this.importadorDAO.findById(cabeceraDeclaracion.getCedula(), false);
        Date fecha = new Date();
        if (importadorTemp != null) {
            cabeceraDeclaracion.setImportador(importadorTemp);
            cabeceraDeclaracion.setFechaLlegada(fecha);
        } else {
            throw new MensajeExcepcion("Importador no encontrado.");
        }
    }

    public void insertarDeclaracion(CabeceraDeclaracion cabeceraDeclaracion, Producto producto, PuertoIngreso puerto, Origen origen, Importador importador, Integer cantidad) {
      CabeceraDeclaracion cabeceraDeclaracionTemp = this.cabeceraDeclaracionDAO.findById(cabeceraDeclaracion.getCodigoCabecera(), false);
//        Servicio servicioTemp = this.servicioDAO.findById(servicio.getCodigo(), false);
//        Medicamento medicamentoTemp = this.medicamentoDAO.findById(medicamento.getCodigo(), false);
       Declaracion declaracion = new Declaracion();
        if (cabeceraDeclaracionTemp == null) {
            throw new MensajeExcepcion("La declaracion a la que hace referencia el detalle no existe.");
        } else {
            if (producto != null && puerto !=null && origen!=null) {
                declaracion.setProducto(producto);
                declaracion.setPuertoIngreso(puerto);
                declaracion.setOrigen(origen);
                //declaracion.setCodigoDeclaracion(cabeceraDeclaracion.getCodigoCabecera());
                declaracion.setCodigoOrigen(origen.getCodigoOrigen());
                declaracion.setCodigoPuerto(puerto.getCodigoPuerto());
                declaracion.setCodigoProducto(producto.getCodigoProducto());
                declaracion.setPrecioUnitario(producto.getValorProducto());
                declaracion.setValorArancel(producto.getValorArancel());
                declaracion.setCodigoCabecera(cabeceraDeclaracion.getCodigoCabecera());
                declaracion.setCantidadProducto(cantidad); 
                Double total=(declaracion.getPrecioUnitario().doubleValue())*(declaracion.getCantidadProducto());
                BigDecimal valorTotal = new BigDecimal(total);
                declaracion.setValorTotal(valorTotal);
                this.declaracionDAO.insert(declaracion);
            }else {
                    throw new MensajeExcepcion("Los valores de producto, puerto y origen no pueden ser nulos.");
                }
        }
        
    }

    public List<Declaracion> obtenerDetallesPorCodigoDeclaracion(CabeceraDeclaracion cabeceraDeclaracion) {
        Declaracion declaracionTemp = new Declaracion();
        declaracionTemp.setCodigoCabecera(cabeceraDeclaracion.getCodigoCabecera());
        List<Declaracion> detalles = this.declaracionDAO.find(declaracionTemp);
        if (detalles != null && !detalles.isEmpty()) {
            return detalles;
        } else {
            return null;
        }
    }
    public List<Declaracion> obtenerDeclaracion(){
        return this.declaracionDAO.findAll();
    }
    public void calcularTotalesDeclaracion(CabeceraDeclaracion cabeceraDeclaracion)  {
        List<Declaracion> detalles = this.obtenerDetallesPorCodigoDeclaracion(cabeceraDeclaracion);
        BigDecimal valorTotal = new BigDecimal(0.0);
        BigDecimal valorArancel = new BigDecimal(0.0);
        BigDecimal total = new BigDecimal(0.0);
        if (detalles != null && !detalles.isEmpty()) {
            for (Declaracion obj : detalles) {
                valorTotal = valorTotal.add(obj.getValorTotal());
                valorArancel = valorArancel.add(obj.getValorArancel());
            }
        } else {
            throw new MensajeExcepcion("No se encontraron detalles de esa declaracion.");
        }
        total=valorTotal.add(valorArancel);
        cabeceraDeclaracion.setTotalProducto(valorTotal);
        cabeceraDeclaracion.setTotalArancel(valorArancel);
        cabeceraDeclaracion.setTotal(total);
        this.cabeceraDeclaracionDAO.update(cabeceraDeclaracion);
    }
    
}
