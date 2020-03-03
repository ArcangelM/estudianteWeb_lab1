package com.udea.estudianteweb_lab1.modelo;

import com.udea.estudianteweb_lab1.modelo.Accountest;
import com.udea.estudianteweb_lab1.modelo.Materia;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-03-02T20:48:36")
@StaticMetamodel(Matricula.class)
public class Matricula_ { 

    public static volatile SingularAttribute<Matricula, String> estadoMa;
    public static volatile SingularAttribute<Matricula, String> perAcademico;
    public static volatile SingularAttribute<Matricula, Materia> idMateria;
    public static volatile SingularAttribute<Matricula, Accountest> idEstudiante;
    public static volatile SingularAttribute<Matricula, Integer> id;

}