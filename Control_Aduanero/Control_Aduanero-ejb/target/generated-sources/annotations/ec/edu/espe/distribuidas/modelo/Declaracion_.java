package ec.edu.espe.distribuidas.modelo;

import ec.edu.espe.distribuidas.modelo.CabeceraDeclaracion;
import ec.edu.espe.distribuidas.modelo.Origen;
import ec.edu.espe.distribuidas.modelo.Producto;
import ec.edu.espe.distribuidas.modelo.PuertoIngreso;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-01-02T01:48:16")
@StaticMetamodel(Declaracion.class)
public class Declaracion_ { 

    public static volatile SingularAttribute<Declaracion, String> codigoOrigen;
    public static volatile SingularAttribute<Declaracion, BigDecimal> precioUnitario;
    public static volatile SingularAttribute<Declaracion, String> codigoCabecera;
    public static volatile SingularAttribute<Declaracion, String> codigoDeclaracion;
    public static volatile SingularAttribute<Declaracion, CabeceraDeclaracion> cabeceraDeclaracion;
    public static volatile SingularAttribute<Declaracion, Producto> producto;
    public static volatile SingularAttribute<Declaracion, BigDecimal> valorTotal;
    public static volatile SingularAttribute<Declaracion, String> codigoPuerto;
    public static volatile SingularAttribute<Declaracion, PuertoIngreso> puertoIngreso;
    public static volatile SingularAttribute<Declaracion, Integer> cantidadProducto;
    public static volatile SingularAttribute<Declaracion, String> codigoProducto;
    public static volatile SingularAttribute<Declaracion, Origen> origen;
    public static volatile SingularAttribute<Declaracion, BigDecimal> valorArancel;

}