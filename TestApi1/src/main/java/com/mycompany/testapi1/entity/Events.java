/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testapi1.entity;

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
@Table(name = "events")
@NamedQueries({
    @NamedQuery(name = "Events.findAll", query = "SELECT e FROM Events e"),
    @NamedQuery(name = "Events.findByIdEvent", query = "SELECT e FROM Events e WHERE e.idEvent = :idEvent"),
    @NamedQuery(name = "Events.findByName", query = "SELECT e FROM Events e WHERE e.name = :name"),
    @NamedQuery(name = "Events.findByDateTimeEvent", query = "SELECT e FROM Events e WHERE e.dateTimeEvent = :dateTimeEvent"),
    @NamedQuery(name = "Events.findByResponsible", query = "SELECT e FROM Events e WHERE e.responsible = :responsible"),
    @NamedQuery(name = "Events.findByDescription", query = "SELECT e FROM Events e WHERE e.description = :description")})
public class Events implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEvent")
    private Integer idEvent;
    @Column(name = "name")
    private String name;
    @Column(name = "dateTimeEvent")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTimeEvent;
    @Column(name = "responsible")
    private Integer responsible;
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "event")
    private Collection<Calendarevents> calendareventsCollection;
    @JsonIgnore
    @JoinColumn(name = "statusEvent", referencedColumnName = "idStetuEvent")
    @ManyToOne
    private Statusesevents statusEvent;
    @JsonIgnore
    @JoinColumn(name = "typeEvent", referencedColumnName = "idTypeEvent")
    @ManyToOne
    private Typesevents typeEvent;

    public Events() {
    }

    public Events(Integer idEvent) {
        this.idEvent = idEvent;
    }

    public Integer getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(Integer idEvent) {
        this.idEvent = idEvent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateTimeEvent() {
        return dateTimeEvent;
    }

    public void setDateTimeEvent(Date dateTimeEvent) {
        this.dateTimeEvent = dateTimeEvent;
    }

    public Integer getResponsible() {
        return responsible;
    }

    public void setResponsible(Integer responsible) {
        this.responsible = responsible;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Collection<Calendarevents> getCalendareventsCollection() {
        return calendareventsCollection;
    }

    public void setCalendareventsCollection(Collection<Calendarevents> calendareventsCollection) {
        this.calendareventsCollection = calendareventsCollection;
    }

    public Statusesevents getStatusEvent() {
        return statusEvent;
    }

    public void setStatusEvent(Statusesevents statusEvent) {
        this.statusEvent = statusEvent;
    }

    public Typesevents getTypeEvent() {
        return typeEvent;
    }

    public void setTypeEvent(Typesevents typeEvent) {
        this.typeEvent = typeEvent;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEvent != null ? idEvent.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Events)) {
            return false;
        }
        Events other = (Events) object;
        if ((this.idEvent == null && other.idEvent != null) || (this.idEvent != null && !this.idEvent.equals(other.idEvent))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.testapi1.entity.Events[ idEvent=" + idEvent + " ]";
    }
    
}
