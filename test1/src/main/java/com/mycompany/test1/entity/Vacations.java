/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.test1.entity;

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
@Table(name = "vacations")
@NamedQueries({
    @NamedQuery(name = "Vacations.findAll", query = "SELECT v FROM Vacations v"),
    @NamedQuery(name = "Vacations.findByIdVacation", query = "SELECT v FROM Vacations v WHERE v.idVacation = :idVacation"),
    @NamedQuery(name = "Vacations.findByDateStart", query = "SELECT v FROM Vacations v WHERE v.dateStart = :dateStart"),
    @NamedQuery(name = "Vacations.findByDateEnd", query = "SELECT v FROM Vacations v WHERE v.dateEnd = :dateEnd")})
public class Vacations implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idVacation")
    private Integer idVacation;
    @Column(name = "dateStart")
    @Temporal(TemporalType.DATE)
    private Date dateStart;
    @Column(name = "dateEnd")
    @Temporal(TemporalType.DATE)
    private Date dateEnd;
    @JsonIgnore
@JoinColumn
(name = "replaces", referencedColumnName = "idApplicant")
    @ManyToOne
    private Applicants replaces;
    @JsonIgnore
@JoinColumn
(name = "eployee", referencedColumnName = "EmployeeID")
    @ManyToOne
    private Employees eployee;

    public Vacations() {
    }

    public Vacations(Integer idVacation) {
        this.idVacation = idVacation;
    }

    public Integer getIdVacation() {
        return idVacation;
    }

    public void setIdVacation(Integer idVacation) {
        this.idVacation = idVacation;
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

    public Applicants getReplaces() {
        return replaces;
    }

    public void setReplaces(Applicants replaces) {
        this.replaces = replaces;
    }

    public Employees getEployee() {
        return eployee;
    }

    public void setEployee(Employees eployee) {
        this.eployee = eployee;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVacation != null ? idVacation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vacations)) {
            return false;
        }
        Vacations other = (Vacations) object;
        if ((this.idVacation == null && other.idVacation != null) || (this.idVacation != null && !this.idVacation.equals(other.idVacation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.test1.entity.Vacations[ idVacation=" + idVacation + " ]";
    }
    
}
