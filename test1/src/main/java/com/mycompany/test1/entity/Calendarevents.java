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
@Table(name = "calendarevents")
@NamedQueries({
    @NamedQuery(name = "Calendarevents.findAll", query = "SELECT c FROM Calendarevents c"),
    @NamedQuery(name = "Calendarevents.findByIdCalendarEvent", query = "SELECT c FROM Calendarevents c WHERE c.idCalendarEvent = :idCalendarEvent")})
public class Calendarevents implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCalendarEvent")
    private Integer idCalendarEvent;
    @JsonIgnore
    @JoinColumn(name = "employee", referencedColumnName = "EmployeeID")
    @ManyToOne
    private Employees employee;
    @JsonIgnore
    @JoinColumn(name = "event", referencedColumnName = "idEvent")
    @ManyToOne
    private Events event;

    public Calendarevents() {
    }

    public Calendarevents(Integer idCalendarEvent) {
        this.idCalendarEvent = idCalendarEvent;
    }

    public Integer getIdCalendarEvent() {
        return idCalendarEvent;
    }

    public void setIdCalendarEvent(Integer idCalendarEvent) {
        this.idCalendarEvent = idCalendarEvent;
    }

    public Employees getEmployee() {
        return employee;
    }

    public void setEmployee(Employees employee) {
        this.employee = employee;
    }

    public Events getEvent() {
        return event;
    }

    public void setEvent(Events event) {
        this.event = event;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCalendarEvent != null ? idCalendarEvent.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Calendarevents)) {
            return false;
        }
        Calendarevents other = (Calendarevents) object;
        if ((this.idCalendarEvent == null && other.idCalendarEvent != null) || (this.idCalendarEvent != null && !this.idCalendarEvent.equals(other.idCalendarEvent))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.test1.entity.Calendarevents[ idCalendarEvent=" + idCalendarEvent + " ]";
    }

}
