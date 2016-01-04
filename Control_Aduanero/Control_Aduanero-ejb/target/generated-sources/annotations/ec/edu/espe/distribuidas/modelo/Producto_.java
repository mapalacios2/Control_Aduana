package ec.edu.espe.distribuidas.modelo;

import ec.edu.espe.distribuidas.modelo.Subpartida;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-01-03T22:40:18")
@StaticMetamodel(Producto.class)
public class Producto_ { 

    public static volatile SingularAttribute<Producto, Subpartida> subpartida;
    public static volatile SingularAttribute<Producto, BigDecimal> porcentajeArancel;
    public static volatile SingularAttribute<Producto, String> descripcion;
    public static volatile SingularAttribute<Producto, String> codigoSubpartida;
    public static volatile SingularAttribute<Producto, BigDecimal> valorProducto;
    public static volatile SingularAttribute<Producto, String> codigoProducto;
    public static volatile SingularAttribute<Producto, BigDecimal> valorArancel;

}