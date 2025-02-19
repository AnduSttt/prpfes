/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testapi1.entity;

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
@Table(name = "classifications")
@NamedQueries({
    @NamedQuery(name = "Classifications.findAll", query = "SELECT c FROM Classifications c"),
    @NamedQuery(name = "Classifications.findByIdClassification", query = "SELECT c FROM Classifications c WHERE c.idClassification = :idClassification"),
    @NamedQuery(name = "Classifications.findByName", query = "SELECT c FROM Classifications c WHERE c.name = :name")})
public class Classifications implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idClassification")
    private Integer idClassification;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "classification")
    private Collection<Educations> educationsCollection;

    public Classifications() {
    }

    public Classifications(Integer idClassification) {
        this.idClassification = idClassification;
    }

    public Integer getIdClassification() {
        return idClassification;
    }

    public void setIdClassification(Integer idClassification) {
        this.idClassification = idClassification;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Educations> getEducationsCollection() {
        return educationsCollection;
    }

    public void setEducationsCollection(Collection<Educations> educationsCollection) {
        this.educationsCollection = educationsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idClassification != null ? idClassification.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Classifications)) {
            return false;
        }
        Classifications other = (Classifications) object;
        if ((this.idClassification == null && other.idClassification != null) || (this.idClassification != null && !this.idClassification.equals(other.idClassification))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.testapi1.entity.Classifications[ idClassification=" + idClassification + " ]";
    }
    
}
