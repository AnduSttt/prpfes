/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testapi2.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

/**
 *
 * @author 1208-VM1
 */
@Entity
@Table(name = "materalsobuchenya")
@NamedQueries({
    @NamedQuery(name = "Materalsobuchenya.findAll", query = "SELECT m FROM Materalsobuchenya m"),
    @NamedQuery(name = "Materalsobuchenya.findByIdMaterialObuchenya", query = "SELECT m FROM Materalsobuchenya m WHERE m.idMaterialObuchenya = :idMaterialObuchenya")})
public class Materalsobuchenya implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMaterialObuchenya")
    private Integer idMaterialObuchenya;
    @JsonIgnore
    @JoinColumn(name = "idMaterial", referencedColumnName = "idMaterial")
    @ManyToOne
    private Materials idMaterial;
    @JsonIgnore
    @JoinColumn(name = "idObuchenya", referencedColumnName = "idObuchenya")
    @ManyToOne
    private Obicheniya idObuchenya;

    public Materalsobuchenya() {
    }

    public Materalsobuchenya(Integer idMaterialObuchenya) {
        this.idMaterialObuchenya = idMaterialObuchenya;
    }

    public Integer getIdMaterialObuchenya() {
        return idMaterialObuchenya;
    }

    public void setIdMaterialObuchenya(Integer idMaterialObuchenya) {
        this.idMaterialObuchenya = idMaterialObuchenya;
    }

    public Materials getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(Materials idMaterial) {
        this.idMaterial = idMaterial;
    }

    public Obicheniya getIdObuchenya() {
        return idObuchenya;
    }

    public void setIdObuchenya(Obicheniya idObuchenya) {
        this.idObuchenya = idObuchenya;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMaterialObuchenya != null ? idMaterialObuchenya.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Materalsobuchenya)) {
            return false;
        }
        Materalsobuchenya other = (Materalsobuchenya) object;
        if ((this.idMaterialObuchenya == null && other.idMaterialObuchenya != null) || (this.idMaterialObuchenya != null && !this.idMaterialObuchenya.equals(other.idMaterialObuchenya))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.testapi2.entity.Materalsobuchenya[ idMaterialObuchenya=" + idMaterialObuchenya + " ]";
    }
    
}
