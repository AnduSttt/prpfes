/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.test1.entity;

import java.io.Serializable;
import java.util.Collection;
import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
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
@Table(name = "positions")
@NamedQueries({
    @NamedQuery(name = "Positions.findAll", query = "SELECT p FROM Positions p"),
    @NamedQuery(name = "Positions.findByPositionID", query = "SELECT p FROM Positions p WHERE p.positionID = :positionID"),
    @NamedQuery(name = "Positions.findByPositionName", query = "SELECT p FROM Positions p WHERE p.positionName = :positionName")})
public class Positions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PositionID")
    private Integer positionID;
    @Column(name = "PositionName")
    private String positionName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
    private Collection<Applicants> applicantsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "positionID")
    private Collection<Employees> employeesCollection;

    public Positions() {
    }

    public Positions(Integer positionID) {
        this.positionID = positionID;
    }

    public Integer getPositionID() {
        return positionID;
    }

    public void setPositionID(Integer positionID) {
        this.positionID = positionID;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public Collection<Applicants> getApplicantsCollection() {
        return applicantsCollection;
    }

    public void setApplicantsCollection(Collection<Applicants> applicantsCollection) {
        this.applicantsCollection = applicantsCollection;
    }

    public Collection<Employees> getEmployeesCollection() {
        return employeesCollection;
    }

    public void setEmployeesCollection(Collection<Employees> employeesCollection) {
        this.employeesCollection = employeesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (positionID != null ? positionID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Positions)) {
            return false;
        }
        Positions other = (Positions) object;
        if ((this.positionID == null && other.positionID != null) || (this.positionID != null && !this.positionID.equals(other.positionID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.test1.entity.Positions[ positionID=" + positionID + " ]";
    }
    
}
