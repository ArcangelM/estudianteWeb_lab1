package com.udea.estudianteweb_lab1.modelo;

import com.udea.estudianteweb_lab1.modelo.Matricula;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-03-06T00:48:58")
@StaticMetamodel(Accountest.class)
public class Accountest_ { 

    public static volatile SingularAttribute<Accountest, String> password;
    public static volatile SingularAttribute<Accountest, byte[]> foto;
    public static volatile SingularAttribute<Accountest, String> apellido;
    public static volatile SingularAttribute<Accountest, Integer> documento;
    public static volatile CollectionAttribute<Accountest, Matricula> matriculaCollection;
    public static volatile SingularAttribute<Accountest, String> carrera;
    public static volatile SingularAttribute<Accountest, String> nombre;
    public static volatile SingularAttribute<Accountest, String> email;

}