package com.udea.estudianteweb_lab1.modelo;

import com.udea.estudianteweb_lab1.modelo.Matricula;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-03-02T20:48:36")
@StaticMetamodel(Materia.class)
public class Materia_ { 

    public static volatile SingularAttribute<Materia, Integer> codigo;
    public static volatile SingularAttribute<Materia, String> nombreMa;
    public static volatile CollectionAttribute<Materia, Matricula> matriculaCollection;
    public static volatile SingularAttribute<Materia, Integer> creditos;
    public static volatile SingularAttribute<Materia, Integer> codPrerrequisito;

}