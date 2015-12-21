package ec.edu.espe.distribuidas.modelo;

import ec.edu.espe.distribuidas.modelo.TipoOperador;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-12-20T21:52:11")
@StaticMetamodel(Operador.class)
public class Operador_ { 

    public static volatile SingularAttribute<Operador, String> nombre;
    public static volatile SingularAttribute<Operador, String> identificacion;
    public static volatile SingularAttribute<Operador, String> direccion;
    public static volatile SingularAttribute<Operador, String> codigoTipoOperador;
    public static volatile SingularAttribute<Operador, String> telefono;
    public static volatile SingularAttribute<Operador, TipoOperador> tipoOperador;
    public static volatile SingularAttribute<Operador, String> codigoOperador;

}