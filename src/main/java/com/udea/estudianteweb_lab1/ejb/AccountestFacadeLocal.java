/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.estudianteweb_lab1.ejb;

import com.udea.estudianteweb_lab1.modelo.Accountest;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author arK
 */
@Local
public interface AccountestFacadeLocal {

    void create(Accountest accountest);

    void edit(Accountest accountest);

    void remove(Accountest accountest);

    Accountest find(Object id);

    List<Accountest> findAll();

    List<Accountest> findRange(int[] range);

    int count();

    boolean checkLogin(String u, String p);

    List<Accountest> buscarEstu(int documento);
    
}
