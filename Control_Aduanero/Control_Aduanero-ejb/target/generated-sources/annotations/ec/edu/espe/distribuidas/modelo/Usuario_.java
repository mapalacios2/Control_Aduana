package ec.edu.espe.distribuidas.modelo;

import ec.edu.espe.distribuidas.modelo.Operador;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-12-26T01:51:58")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, String> nombre;
    public static volatile SingularAttribute<Usuario, String> correoElectronico;
    public static volatile SingularAttribute<Usuario, String> codigoTipoOperador;
    public static volatile SingularAttribute<Usuario, Date> fechaRegistro;
    public static volatile SingularAttribute<Usuario, Operador> operador;
    public static volatile SingularAttribute<Usuario, String> clave;
    public static volatile SingularAttribute<Usuario, String> codigoOperador;
    public static volatile SingularAttribute<Usuario, String> codigoUsuario;

}