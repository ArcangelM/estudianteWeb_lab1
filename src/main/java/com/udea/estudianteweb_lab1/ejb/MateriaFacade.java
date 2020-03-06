/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.estudianteweb_lab1.ejb;

import com.udea.estudianteweb_lab1.modelo.Materia;
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
public class MateriaFacade extends AbstractFacade<Materia> implements MateriaFacadeLocal {

    @PersistenceContext(unitName = "com.udea_estudianteWeb_lab1_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MateriaFacade() {
        super(Materia.class);
    }

    @Override
    public List<Materia> materiasDispoMatricu(String idEst) {
       Query q = em.createQuery("select c from Materia c,Matricula m "+
                "where m.id_estudiante=:idEst "+" and NOT (m.estadoMa=:'aprobada')");
        q.setParameter("idEst", idEst);
        
        
        return q.getResultList();
    }
    
}
