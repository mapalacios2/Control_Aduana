/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.servicio;

import ec.edu.espe.distribuidas.modelo.Declaracion;
import ec.edu.espe.distribuidas.modelo.DetalleFactura;
import ec.edu.espe.distribuidas.modelo.Importador;
import ec.edu.espe.distribuidas.modelo.Origen;
import ec.edu.espe.distribuidas.modelo.Producto;
import ec.edu.espe.distribuidas.modelo.PuertoIngreso;
import ec.edu.espe.distribuidas.modelo.dao.DeclaracionDAO;
import ec.edu.espe.distribuidas.modelo.dao.DetalleFacturaDAO;
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
    DetalleFacturaDAO detalleFacturaDAO;
    @EJB
    ImportadorDAO importadorDAO;

    public void crearDeclaracion(Declaracion declaracion) {
        this.declaracionDAO.insert(declaracion);
    }

    public void crearCabeceraDeclaracion(Declaracion declaracion) {
        Importador importadorTemp = this.importadorDAO.findById(declaracion.getCodigoImportador(), false);
        Date fecha = new Date();
        if (importadorTemp != null) {
            declaracion.setImportador(importadorTemp);
            declaracion.setFechaLlegada(fecha);
        } else {
            throw new MensajeExcepcion("Importador no encontrado.");
        }
    }

    public void insertarDeclaracion(Declaracion delcaracion, Producto producto, PuertoIngreso puerto, Origen origen, Importador importador) {
       // Declaracion declaracionTemp = this.declaracionDAO.findById(delcaracion.getCodigoDeclaracion(), false);
//        Servicio servicioTemp = this.servicioDAO.findById(servicio.getCodigo(), false);
//        Medicamento medicamentoTemp = this.medicamentoDAO.findById(medicamento.getCodigo(), false);
       Declaracion declaracion = new Declaracion();
//        if (declaracionTemp == null) {
//            throw new MensajeExcepcion("La declaracion a la que hace referencia no existe.");
//        } else {
            if (producto != null) {
    
                declaracion.setProducto(producto);
                declaracion.setPuertoIngreso(puerto);
                declaracion.setOrigen(origen);
                //declaracion.setCodigoDeclaracion(declaracion.getCodigoDeclaracion());
                declaracion.setCodigoOrigen(origen.getCodigoOrigen());
                declaracion.setCodigoPuerto(puerto.getCodigoPuerto());
                declaracion.setCodigoProducto(producto.getCodigoProducto());
                declaracion.setCodigoImportador(importador.getCodigoImportador());
                //calcularTotalesDeclaracion(declaracion);
                declaracion.setTotalProducto(producto.getValorProducto());
                declaracion.setTotalArancel(producto.getValorArancel());
                Date fecha = new Date();
                declaracion.setFechaLlegada(fecha);
                declaracion.setCantidadProducto(1);               
                this.declaracionDAO.insert(declaracion);
            }else {
                    throw new MensajeExcepcion("No existe el producto para generar la declaracion.");
                }
        
    }

    public List<Declaracion> obtenerDetallesPorCodigoDeclaracion(Declaracion declaracion) {
        Declaracion declaracionTemp = new Declaracion();
        declaracionTemp.setCodigoDeclaracion(declaracion.getCodigoDeclaracion());
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
//    public void calcularTotalesDeclaracion(Declaracion declaracion)  {
//        List<Declaracion> detalles = this.obtenerDetallesPorCodigoDeclaracion(declaracion);
//        BigDecimal totalProducto = new BigDecimal(0.0);
//        BigDecimal valorArancel = new BigDecimal(0.0);
//        BigDecimal total = new BigDecimal(0.0);
//        if (detalles != null && !detalles.isEmpty()) {
//            for (Declaracion obj : detalles) {
//                totalProducto = totalProducto.add(obj.getTotalProducto());
//                valorArancel = valorArancel.add(obj.getTotalArancel());
//            }
//        } else {
//            throw new MensajeExcepcion("No se encontraron detalles de esa declaracion.");
//        }
//        declaracion.setTotalProducto(totalProducto);
//        declaracion.setTotalArancel(valorArancel);
//        //this.declaracionDAO.update(declaracion);
//    }
    
}
