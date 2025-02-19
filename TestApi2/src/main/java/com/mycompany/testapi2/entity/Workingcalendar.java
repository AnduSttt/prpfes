/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testapi2.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
@Table(name = "workingcalendar")
@NamedQueries({
    @NamedQuery(name = "Workingcalendar.findAll", query = "SELECT w FROM Workingcalendar w"),
    @NamedQuery(name = "Workingcalendar.findById", query = "SELECT w FROM Workingcalendar w WHERE w.id = :id"),
    @NamedQuery(name = "Workingcalendar.findByExceptionDate", query = "SELECT w FROM Workingcalendar w WHERE w.exceptionDate = :exceptionDate"),
    @NamedQuery(name = "Workingcalendar.findByIsWorkingDay", query = "SELECT w FROM Workingcalendar w WHERE w.isWorkingDay = :isWorkingDay")})
public class Workingcalendar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "ExceptionDate")
    @Temporal(TemporalType.DATE)
    private Date exceptionDate;
    @Basic(optional = false)
    @Column(name = "IsWorkingDay")
    private boolean isWorkingDay;
    @OneToMany(mappedBy = "idWorkingCalendar")
    private Collection<Sotrudnikworkingcalendar> sotrudnikworkingcalendarCollection;

    public Workingcalendar() {
    }

    public Workingcalendar(Integer id) {
        this.id = id;
    }

    public Workingcalendar(Integer id, Date exceptionDate, boolean isWorkingDay) {
        this.id = id;
        this.exceptionDate = exceptionDate;
        this.isWorkingDay = isWorkingDay;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getExceptionDate() {
        return exceptionDate;
    }

    public void setExceptionDate(Date exceptionDate) {
        this.exceptionDate = exceptionDate;
    }

    public boolean getIsWorkingDay() {
        return isWorkingDay;
    }

    public void setIsWorkingDay(boolean isWorkingDay) {
        this.isWorkingDay = isWorkingDay;
    }

    public Collection<Sotrudnikworkingcalendar> getSotrudnikworkingcalendarCollection() {
        return sotrudnikworkingcalendarCollection;
    }

    public void setSotrudnikworkingcalendarCollection(Collection<Sotrudnikworkingcalendar> sotrudnikworkingcalendarCollection) {
        this.sotrudnikworkingcalendarCollection = sotrudnikworkingcalendarCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Workingcalendar)) {
            return false;
        }
        Workingcalendar other = (Workingcalendar) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.testapi2.entity.Workingcalendar[ id=" + id + " ]";
    }
    
}
