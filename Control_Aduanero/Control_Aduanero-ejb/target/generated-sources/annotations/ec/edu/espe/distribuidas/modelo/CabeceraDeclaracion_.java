package ec.edu.espe.distribuidas.modelo;

import ec.edu.espe.distribuidas.modelo.Importador;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-01-02T01:22:30")
@StaticMetamodel(CabeceraDeclaracion.class)
public class CabeceraDeclaracion_ { 

    public static volatile SingularAttribute<CabeceraDeclaracion, BigDecimal> total;
    public static volatile SingularAttribute<CabeceraDeclaracion, Date> fechaLlegada;
    public static volatile SingularAttribute<CabeceraDeclaracion, String> codigoCabecera;
    public static volatile SingularAttribute<CabeceraDeclaracion, Importador> importador;
    public static volatile SingularAttribute<CabeceraDeclaracion, BigDecimal> totalProducto;
    public static volatile SingularAttribute<CabeceraDeclaracion, BigDecimal> totalArancel;
    public static volatile SingularAttribute<CabeceraDeclaracion, String> cedula;

}