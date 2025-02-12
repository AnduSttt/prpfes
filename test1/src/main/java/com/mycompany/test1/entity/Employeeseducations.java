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
@Table(name = "employeeseducations")
@NamedQueries({
    @NamedQuery(name = "Employeeseducations.findAll", query = "SELECT e FROM Employeeseducations e"),
    @NamedQuery(name = "Employeeseducations.findByIdEployeeEducation", query = "SELECT e FROM Employeeseducations e WHERE e.idEployeeEducation = :idEployeeEducation")})
public class Employeeseducations implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEployeeEducation")
    private Integer idEployeeEducation;
    @JsonIgnore
    @JoinColumn(name = "education", referencedColumnName = "idEducation")
    @ManyToOne
    private Educations education;
    @JsonIgnore
    @JoinColumn(name = "employee", referencedColumnName = "EmployeeID")
    @ManyToOne
    private Employees employee;

    public Employeeseducations() {
    }

    public Employeeseducations(Integer idEployeeEducation) {
        this.idEployeeEducation = idEployeeEducation;
    }

    public Integer getIdEployeeEducation() {
        return idEployeeEducation;
    }

    public void setIdEployeeEducation(Integer idEployeeEducation) {
        this.idEployeeEducation = idEployeeEducation;
    }

    public Educations getEducation() {
        return education;
    }

    public void setEducation(Educations education) {
        this.education = education;
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
        hash += (idEployeeEducation != null ? idEployeeEducation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employeeseducations)) {
            return false;
        }
        Employeeseducations other = (Employeeseducations) object;
        if ((this.idEployeeEducation == null && other.idEployeeEducation != null) || (this.idEployeeEducation != null && !this.idEployeeEducation.equals(other.idEployeeEducation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.test1.entity.Employeeseducations[ idEployeeEducation=" + idEployeeEducation + " ]";
    }

}
