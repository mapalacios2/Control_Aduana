package ec.edu.espe.distribuidas.modelo;

import ec.edu.espe.distribuidas.modelo.CabeceraDeclaracion;
import ec.edu.espe.distribuidas.modelo.CabeceraFactura;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-01-02T23:19:18")
@StaticMetamodel(DetalleFactura.class)
public class DetalleFactura_ { 

    public static volatile SingularAttribute<DetalleFactura, BigDecimal> iva;
    public static volatile SingularAttribute<DetalleFactura, BigDecimal> total;
    public static volatile SingularAttribute<DetalleFactura, CabeceraFactura> cabeceraFactura;
    public static volatile SingularAttribute<DetalleFactura, Integer> codigoDeclaracion;
    public static volatile SingularAttribute<DetalleFactura, CabeceraDeclaracion> cabeceraDeclaracion;
    public static volatile SingularAttribute<DetalleFactura, String> codigoFactura;
    public static volatile SingularAttribute<DetalleFactura, String> codigoDetalle;

}