/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testapi1.entity;

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
@Table(name = "uvoleni")
@NamedQueries({
    @NamedQuery(name = "Uvoleni.findAll", query = "SELECT u FROM Uvoleni u"),
    @NamedQuery(name = "Uvoleni.findByIdUvolen", query = "SELECT u FROM Uvoleni u WHERE u.idUvolen = :idUvolen"),
    @NamedQuery(name = "Uvoleni.findByDate", query = "SELECT u FROM Uvoleni u WHERE u.date = :date")})
public class Uvoleni implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idUvolen")
    private Integer idUvolen;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @JsonIgnore
    @JoinColumn(name = "idEmployeer", referencedColumnName = "EmployeeID")
    @ManyToOne
    private Employees idEmployeer;

    public Uvoleni() {
    }

    public Uvoleni(Integer idUvolen) {
        this.idUvolen = idUvolen;
    }

    public Integer getIdUvolen() {
        return idUvolen;
    }

    public void setIdUvolen(Integer idUvolen) {
        this.idUvolen = idUvolen;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Employees getIdEmployeer() {
        return idEmployeer;
    }

    public void setIdEmployeer(Employees idEmployeer) {
        this.idEmployeer = idEmployeer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUvolen != null ? idUvolen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Uvoleni)) {
            return false;
        }
        Uvoleni other = (Uvoleni) object;
        if ((this.idUvolen == null && other.idUvolen != null) || (this.idUvolen != null && !this.idUvolen.equals(other.idUvolen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.testapi1.entity.Uvoleni[ idUvolen=" + idUvolen + " ]";
    }
    
}
