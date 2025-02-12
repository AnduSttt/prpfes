/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.test1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "materialseducations")
@NamedQueries({
    @NamedQuery(name = "Materialseducations.findAll", query = "SELECT m FROM Materialseducations m"),
    @NamedQuery(name = "Materialseducations.findByIdMaterialEducation", query = "SELECT m FROM Materialseducations m WHERE m.idMaterialEducation = :idMaterialEducation")})
public class Materialseducations implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMaterialEducation")
    private Integer idMaterialEducation;
    @JsonIgnore
    @JoinColumn(name = "education", referencedColumnName = "idEducation")
    @ManyToOne
    private Educations education;
    @JsonIgnore
    @JoinColumn(name = "material", referencedColumnName = "idMaterial")
    @ManyToOne
    private Materials material;

    public Materialseducations() {
    }

    public Materialseducations(Integer idMaterialEducation) {
        this.idMaterialEducation = idMaterialEducation;
    }

    public Integer getIdMaterialEducation() {
        return idMaterialEducation;
    }

    public void setIdMaterialEducation(Integer idMaterialEducation) {
        this.idMaterialEducation = idMaterialEducation;
    }

    public Educations getEducation() {
        return education;
    }

    public void setEducation(Educations education) {
        this.education = education;
    }

    public Materials getMaterial() {
        return material;
    }

    public void setMaterial(Materials material) {
        this.material = material;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMaterialEducation != null ? idMaterialEducation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Materialseducations)) {
            return false;
        }
        Materialseducations other = (Materialseducations) object;
        if ((this.idMaterialEducation == null && other.idMaterialEducation != null) || (this.idMaterialEducation != null && !this.idMaterialEducation.equals(other.idMaterialEducation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.test1.entity.Materialseducations[ idMaterialEducation=" + idMaterialEducation + " ]";
    }

}
