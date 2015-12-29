package ec.edu.espe.distribuidas.modelo;

import ec.edu.espe.distribuidas.modelo.Importador;
import ec.edu.espe.distribuidas.modelo.Origen;
import ec.edu.espe.distribuidas.modelo.Producto;
import ec.edu.espe.distribuidas.modelo.PuertoIngreso;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-12-28T21:12:48")
@StaticMetamodel(Declaracion.class)
public class Declaracion_ { 

    public static volatile SingularAttribute<Declaracion, BigDecimal> totalProducto;
    public static volatile SingularAttribute<Declaracion, BigDecimal> totalArancel;
    public static volatile SingularAttribute<Declaracion, String> codigoOrigen;
    public static volatile SingularAttribute<Declaracion, String> codigoImportador;
    public static volatile SingularAttribute<Declaracion, Date> fechaLlegada;
    public static volatile SingularAttribute<Declaracion, Importador> importador;
    public static volatile SingularAttribute<Declaracion, Integer> codigoDeclaracion;
    public static volatile SingularAttribute<Declaracion, Producto> producto;
    public static volatile SingularAttribute<Declaracion, String> codigoPuerto;
    public static volatile SingularAttribute<Declaracion, PuertoIngreso> puertoIngreso;
    public static volatile SingularAttribute<Declaracion, Integer> cantidadProducto;
    public static volatile SingularAttribute<Declaracion, Integer> codigoDetalle;
    public static volatile SingularAttribute<Declaracion, Origen> origen;
    public static volatile SingularAttribute<Declaracion, String> codigoProducto;

}