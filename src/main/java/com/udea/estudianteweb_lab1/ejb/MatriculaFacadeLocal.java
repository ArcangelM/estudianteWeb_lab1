/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.estudianteweb_lab1.ejb;

import com.udea.estudianteweb_lab1.modelo.Matricula;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author arK
 */
@Local
public interface MatriculaFacadeLocal {

    void create(Matricula matricula);

    void edit(Matricula matricula);

    void remove(Matricula matricula);

    Matricula find(Object id);

    List<Matricula> findAll();

    List<Matricula> findRange(int[] range);

    int count();

    List<Matricula> matriculasEstu(int idEst);

    boolean updateMatricula(int idMatri,String estado);
    
}
