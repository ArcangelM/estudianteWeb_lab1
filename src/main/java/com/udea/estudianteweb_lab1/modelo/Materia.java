/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.estudianteweb_lab1.modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author arK
 */
@Entity
@Table(name = "materia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Materia.findAll", query = "SELECT m FROM Materia m"),
    @NamedQuery(name = "Materia.findByCodigo", query = "SELECT m FROM Materia m WHERE m.codigo = :codigo"),
    @NamedQuery(name = "Materia.findByNombreMa", query = "SELECT m FROM Materia m WHERE m.nombreMa = :nombreMa"),
    @NamedQuery(name = "Materia.findByCreditos", query = "SELECT m FROM Materia m WHERE m.creditos = :creditos"),
    @NamedQuery(name = "Materia.findByCodPrerrequisito", query = "SELECT m FROM Materia m WHERE m.codPrerrequisito = :codPrerrequisito")})
public class Materia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo")
    private Integer codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre_ma")
    private String nombreMa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "creditos")
    private int creditos;
    @Column(name = "cod_prerrequisito")
    private Integer codPrerrequisito;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMateria")
    private Collection<Matricula> matriculaCollection;

    public Materia() {
    }

    public Materia(Integer codigo) {
        this.codigo = codigo;
    }

    public Materia(Integer codigo, String nombreMa, int creditos) {
        this.codigo = codigo;
        this.nombreMa = nombreMa;
        this.creditos = creditos;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombreMa() {
        return nombreMa;
    }

    public void setNombreMa(String nombreMa) {
        this.nombreMa = nombreMa;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public Integer getCodPrerrequisito() {
        return codPrerrequisito;
    }

    public void setCodPrerrequisito(Integer codPrerrequisito) {
        this.codPrerrequisito = codPrerrequisito;
    }

    @XmlTransient
    public Collection<Matricula> getMatriculaCollection() {
        return matriculaCollection;
    }

    public void setMatriculaCollection(Collection<Matricula> matriculaCollection) {
        this.matriculaCollection = matriculaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Materia)) {
            return false;
        }
        Materia other = (Materia) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.udea.estudianteweb_lab1.modelo.Materia[ codigo=" + codigo + " ]";
    }
    
}
