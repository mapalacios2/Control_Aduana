package ec.edu.espe.distribuidas.modelo;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-12-26T01:51:58")
@StaticMetamodel(CabeceraFactura.class)
public class CabeceraFactura_ { 

    public static volatile SingularAttribute<CabeceraFactura, String> nombre;
    public static volatile SingularAttribute<CabeceraFactura, String> identificacion;
    public static volatile SingularAttribute<CabeceraFactura, BigDecimal> totalFactura;
    public static volatile SingularAttribute<CabeceraFactura, Integer> codigoFactura;
    public static volatile SingularAttribute<CabeceraFactura, Date> fechaEmision;
    public static volatile SingularAttribute<CabeceraFactura, Integer> codigoDetalle;

}