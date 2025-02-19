/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testapi1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
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
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

/**
 *
 * @author 1208-VM1
 */
@Entity
@Table(name = "absents")
@NamedQueries({
    @NamedQuery(name = "Absents.findAll", query = "SELECT a FROM Absents a"),
    @NamedQuery(name = "Absents.findByIdAbsent", query = "SELECT a FROM Absents a WHERE a.idAbsent = :idAbsent"),
    @NamedQuery(name = "Absents.findByDescription", query = "SELECT a FROM Absents a WHERE a.description = :description"),
    @NamedQuery(name = "Absents.findByDateStart", query = "SELECT a FROM Absents a WHERE a.dateStart = :dateStart"),
    @NamedQuery(name = "Absents.findByDateEnd", query = "SELECT a FROM Absents a WHERE a.dateEnd = :dateEnd")})
public class Absents implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAbsent")
    private Integer idAbsent;
    @Column(name = "description")
    private String description;
    @Column(name = "dateStart")
    @Temporal(TemporalType.DATE)
    private Date dateStart;
    @Column(name = "dateEnd")
    @Temporal(TemporalType.DATE)
    private Date dateEnd;
    @JsonIgnore
    @JoinColumn(name = "employee", referencedColumnName = "EmployeeID")
    @ManyToOne
    private Employees employee;

    public Absents() {
    }

    public Absents(Integer idAbsent) {
        this.idAbsent = idAbsent;
    }

    public Integer getIdAbsent() {
        return idAbsent;
    }

    public void setIdAbsent(Integer idAbsent) {
        this.idAbsent = idAbsent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Employees getEmployee() {
        return employee;
    }

    public void setEmployee(Employees employee) {
        this.employee = employee;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAbsent != null ? idAbsent.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Absents)) {
            return false;
        }
        Absents other = (Absents) object;
        if ((this.idAbsent == null && other.idAbsent != null) || (this.idAbsent != null && !this.idAbsent.equals(other.idAbsent))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.testapi1.entity.Absents[ idAbsent=" + idAbsent + " ]";
    }
    
}
