/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testapi2.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Collection;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 *
 * @author 1208-VM1
 */
@Entity
@Table(name = "tipesmaterials")
@NamedQueries({
    @NamedQuery(name = "Tipesmaterials.findAll", query = "SELECT t FROM Tipesmaterials t"),
    @NamedQuery(name = "Tipesmaterials.findByIdTipe", query = "SELECT t FROM Tipesmaterials t WHERE t.idTipe = :idTipe"),
    @NamedQuery(name = "Tipesmaterials.findByNazvanye", query = "SELECT t FROM Tipesmaterials t WHERE t.nazvanye = :nazvanye")})
public class Tipesmaterials implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTipe")
    private Integer idTipe;
    @Column(name = "nazvanye")
    private String nazvanye;
    @OneToMany(mappedBy = "idTipe")
    private Collection<Materials> materialsCollection;

    public Tipesmaterials() {
    }

    public Tipesmaterials(Integer idTipe) {
        this.idTipe = idTipe;
    }

    public Integer getIdTipe() {
        return idTipe;
    }

    public void setIdTipe(Integer idTipe) {
        this.idTipe = idTipe;
    }

    public String getNazvanye() {
        return nazvanye;
    }

    public void setNazvanye(String nazvanye) {
        this.nazvanye = nazvanye;
    }

    public Collection<Materials> getMaterialsCollection() {
        return materialsCollection;
    }

    public void setMaterialsCollection(Collection<Materials> materialsCollection) {
        this.materialsCollection = materialsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipe != null ? idTipe.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipesmaterials)) {
            return false;
        }
        Tipesmaterials other = (Tipesmaterials) object;
        if ((this.idTipe == null && other.idTipe != null) || (this.idTipe != null && !this.idTipe.equals(other.idTipe))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.testapi2.entity.Tipesmaterials[ idTipe=" + idTipe + " ]";
    }
    
}
