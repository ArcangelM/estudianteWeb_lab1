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
import javax.persistence.Lob;
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
@Table(name = "accountest")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Accountest.findAll", query = "SELECT a FROM Accountest a"),
    @NamedQuery(name = "Accountest.findByDocumento", query = "SELECT a FROM Accountest a WHERE a.documento = :documento"),
    @NamedQuery(name = "Accountest.findByNombre", query = "SELECT a FROM Accountest a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "Accountest.findByApellido", query = "SELECT a FROM Accountest a WHERE a.apellido = :apellido"),
    @NamedQuery(name = "Accountest.findByCarrera", query = "SELECT a FROM Accountest a WHERE a.carrera = :carrera"),
    @NamedQuery(name = "Accountest.findByEmail", query = "SELECT a FROM Accountest a WHERE a.email = :email"),
    @NamedQuery(name = "Accountest.findByPassword", query = "SELECT a FROM Accountest a WHERE a.password = :password")})
public class Accountest implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "documento")
    private Integer documento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "apellido")
    private String apellido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "carrera")
    private String carrera;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "foto")
    private byte[] foto;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Id
    @Size(max = 50)
    @Column(name = "email")
    private String email;
    @Size(max = 50)
    @Column(name = "password")
    private String password;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstudiante")
    private Collection<Matricula> matriculaCollection;

    public Accountest() {
    }

    public Accountest(Integer documento) {
        this.documento = documento;
    }

    public Accountest(Integer documento, String nombre, String apellido, String carrera, byte[] foto) {
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.carrera = carrera;
        this.foto = foto;
    }

    public Integer getDocumento() {
        return documento;
    }

    public void setDocumento(Integer documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        hash += (documento != null ? documento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Accountest)) {
            return false;
        }
        Accountest other = (Accountest) object;
        if ((this.documento == null && other.documento != null) || (this.documento != null && !this.documento.equals(other.documento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.udea.estudianteweb_lab1.modelo.Accountest[ documento=" + documento + " ]";
    }
    
}
