/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.test1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

/**
 *
 * @author 1208-VM1
 */
@Entity
@Table(name = "educations")
@NamedQueries({
    @NamedQuery(name = "Educations.findAll", query = "SELECT e FROM Educations e"),
    @NamedQuery(name = "Educations.findByIdEducation", query = "SELECT e FROM Educations e WHERE e.idEducation = :idEducation"),
    @NamedQuery(name = "Educations.findByDateStart", query = "SELECT e FROM Educations e WHERE e.dateStart = :dateStart"),
    @NamedQuery(name = "Educations.findByDateEnd", query = "SELECT e FROM Educations e WHERE e.dateEnd = :dateEnd"),
    @NamedQuery(name = "Educations.findByDescription", query = "SELECT e FROM Educations e WHERE e.description = :description")})
public class Educations implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEducation")
    private Integer idEducation;
    @Column(name = "dateStart")
    @Temporal(TemporalType.DATE)
    private Date dateStart;
    @Column(name = "dateEnd")
    @Temporal(TemporalType.DATE)
    private Date dateEnd;
    @Column(name = "description")
    private String description;
    @JsonIgnore
    @JoinColumn(name = "classification", referencedColumnName = "idClassification")
    @ManyToOne
    private Classifications classification;
    @OneToMany(mappedBy = "education")
    private Collection<Materialseducations> materialseducationsCollection;
    @OneToMany(mappedBy = "education")
    private Collection<Employeeseducations> employeeseducationsCollection;

    public Educations() {
    }

    public Educations(Integer idEducation) {
        this.idEducation = idEducation;
    }

    public Integer getIdEducation() {
        return idEducation;
    }

    public void setIdEducation(Integer idEducation) {
        this.idEducation = idEducation;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Classifications getClassification() {
        return classification;
    }

    public void setClassification(Classifications classification) {
        this.classification = classification;
    }

    public Collection<Materialseducations> getMaterialseducationsCollection() {
        return materialseducationsCollection;
    }

    public void setMaterialseducationsCollection(Collection<Materialseducations> materialseducationsCollection) {
        this.materialseducationsCollection = materialseducationsCollection;
    }

    public Collection<Employeeseducations> getEmployeeseducationsCollection() {
        return employeeseducationsCollection;
    }

    public void setEmployeeseducationsCollection(Collection<Employeeseducations> employeeseducationsCollection) {
        this.employeeseducationsCollection = employeeseducationsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEducation != null ? idEducation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Educations)) {
            return false;
        }
        Educations other = (Educations) object;
        if ((this.idEducation == null && other.idEducation != null) || (this.idEducation != null && !this.idEducation.equals(other.idEducation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.test1.entity.Educations[ idEducation=" + idEducation + " ]";
    }

}
