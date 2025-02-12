/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.test1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Collection;
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

/**
 *
 * @author 1208-VM1
 */
@Entity
@Table(name = "applicants")
@NamedQueries({
    @NamedQuery(name = "Applicants.findAll", query = "SELECT a FROM Applicants a"),
    @NamedQuery(name = "Applicants.findByIdApplicant", query = "SELECT a FROM Applicants a WHERE a.idApplicant = :idApplicant"),
    @NamedQuery(name = "Applicants.findByName", query = "SELECT a FROM Applicants a WHERE a.name = :name"),
    @NamedQuery(name = "Applicants.findBySecondName", query = "SELECT a FROM Applicants a WHERE a.secondName = :secondName"),
    @NamedQuery(name = "Applicants.findByMiddleName", query = "SELECT a FROM Applicants a WHERE a.middleName = :middleName"),
    @NamedQuery(name = "Applicants.findByMeNumber", query = "SELECT a FROM Applicants a WHERE a.meNumber = :meNumber"),
    @NamedQuery(name = "Applicants.findByDescription", query = "SELECT a FROM Applicants a WHERE a.description = :description")})
public class Applicants implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idApplicant")
    private Integer idApplicant;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "secondName")
    private String secondName;
    @Basic(optional = false)
    @Column(name = "middleName")
    private String middleName;
    @Column(name = "meNumber")
    private String meNumber;
    @Column(name = "description")
    private String description;
    @JsonIgnore
    @JoinColumn(name = "post", referencedColumnName = "PositionID")
    @ManyToOne(optional = false)
    private Positions post;
    @OneToMany(mappedBy = "replaces")
    private Collection<Vacations> vacationsCollection;

    public Applicants() {
    }

    public Applicants(Integer idApplicant) {
        this.idApplicant = idApplicant;
    }

    public Applicants(Integer idApplicant, String name, String secondName, String middleName) {
        this.idApplicant = idApplicant;
        this.name = name;
        this.secondName = secondName;
        this.middleName = middleName;
    }

    public Integer getIdApplicant() {
        return idApplicant;
    }

    public void setIdApplicant(Integer idApplicant) {
        this.idApplicant = idApplicant;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getMeNumber() {
        return meNumber;
    }

    public void setMeNumber(String meNumber) {
        this.meNumber = meNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Positions getPost() {
        return post;
    }

    public void setPost(Positions post) {
        this.post = post;
    }

    public Collection<Vacations> getVacationsCollection() {
        return vacationsCollection;
    }

    public void setVacationsCollection(Collection<Vacations> vacationsCollection) {
        this.vacationsCollection = vacationsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idApplicant != null ? idApplicant.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Applicants)) {
            return false;
        }
        Applicants other = (Applicants) object;
        if ((this.idApplicant == null && other.idApplicant != null) || (this.idApplicant != null && !this.idApplicant.equals(other.idApplicant))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.test1.entity.Applicants[ idApplicant=" + idApplicant + " ]";
    }

}
