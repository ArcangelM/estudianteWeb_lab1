/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.estudianteweb_lab1.ejb;

import com.udea.estudianteweb_lab1.modelo.Accountest;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author arK
 */
@Stateless
public class AccountestFacade extends AbstractFacade<Accountest> implements AccountestFacadeLocal {

    @PersistenceContext(unitName = "com.udea_estudianteWeb_lab1_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AccountestFacade() {
        super(Accountest.class);
    }

    @Override
    public boolean checkLogin(String u, String p) {
        Query q = em.createQuery("select a from Accountest a "+
                "where a.email=:u and a.password=:p");
        q.setParameter("u", u);
        q.setParameter("p", p);
        
        return q.getResultList().size()>0;
    }
    
    public List<String> traerStudent(String u, String p) {
        Query q = em.createQuery("select a from Accountest a "+
                "where a.email=:u and a.password=:p");
        q.setParameter("u", u);
        q.setParameter("p", p);
        
        return q.getResultList();
    }
    
}
