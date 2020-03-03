/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.estudianteweb_lab1.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author arK
 */
@Entity
@Table(name = "matricula")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Matricula.findAll", query = "SELECT m FROM Matricula m"),
    @NamedQuery(name = "Matricula.findById", query = "SELECT m FROM Matricula m WHERE m.id = :id"),
    @NamedQuery(name = "Matricula.findByPerAcademico", query = "SELECT m FROM Matricula m WHERE m.perAcademico = :perAcademico"),
    @NamedQuery(name = "Matricula.findByEstadoMa", query = "SELECT m FROM Matricula m WHERE m.estadoMa = :estadoMa")})
public class Matricula implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "per_academico")
    private String perAcademico;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "estado_ma")
    private String estadoMa;
    @JoinColumn(name = "id_estudiante", referencedColumnName = "documento")
    @ManyToOne(optional = false)
    private Accountest idEstudiante;
    @JoinColumn(name = "id_materia", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Materia idMateria;

    public Matricula() {
    }

    public Matricula(Integer id) {
        this.id = id;
    }

    public Matricula(Integer id, String perAcademico, String estadoMa) {
        this.id = id;
        this.perAcademico = perAcademico;
        this.estadoMa = estadoMa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPerAcademico() {
        return perAcademico;
    }

    public void setPerAcademico(String perAcademico) {
        this.perAcademico = perAcademico;
    }

    public String getEstadoMa() {
        return estadoMa;
    }

    public void setEstadoMa(String estadoMa) {
        this.estadoMa = estadoMa;
    }

    public Accountest getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Accountest idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public Materia getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Materia idMateria) {
        this.idMateria = idMateria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Matricula)) {
            return false;
        }
        Matricula other = (Matricula) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.udea.estudianteweb_lab1.modelo.Matricula[ id=" + id + " ]";
    }
    
}
