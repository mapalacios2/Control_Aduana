package ec.edu.espe.distribuidas.modelo;

import ec.edu.espe.distribuidas.modelo.CabeceraFactura;
import ec.edu.espe.distribuidas.modelo.Declaracion;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-12-20T16:17:40")
@StaticMetamodel(DetalleFactura.class)
public class DetalleFactura_ { 

    public static volatile SingularAttribute<DetalleFactura, BigDecimal> total;
    public static volatile SingularAttribute<DetalleFactura, CabeceraFactura> cabeceraFactura;
    public static volatile SingularAttribute<DetalleFactura, Integer> codigoDeclaracion;
    public static volatile SingularAttribute<DetalleFactura, String> codigoFactura;
    public static volatile SingularAttribute<DetalleFactura, Declaracion> declaracion;
    public static volatile SingularAttribute<DetalleFactura, Integer> codigoDetalle;

}