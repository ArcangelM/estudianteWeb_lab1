/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.estudianteweb_lab1.ejb;

import com.udea.estudianteweb_lab1.modelo.Matricula;
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
public class MatriculaFacade extends AbstractFacade<Matricula> implements MatriculaFacadeLocal {

    @PersistenceContext(unitName = "com.udea_estudianteWeb_lab1_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MatriculaFacade() {
        super(Matricula.class);
    }

    @Override
    public List<Matricula> matriculasEstu(int idEst) {
         Query q = em.createQuery("select m from Matricula m, Accountest c where m.idEstudiante = c "+
                 "and c.documento=:idEst and (m.estadoMa=\"aprobada\" OR m.estadoMa=\"matriculada\")");
        q.setParameter("idEst", idEst);
        
        
        return q.getResultList();
    }

    @Override
    public boolean updateMatricula(int idMatri,String estado) {
        Query q = em.createQuery("UPDATE Matricula m SET m.perAcademico =:estado where m.id=:idMatri");
        q.setParameter("idMatri", idMatri);
        q.setParameter("estado", estado);
        
        
        return q.getResultList().size()==1;
    }
    
    
    
}
