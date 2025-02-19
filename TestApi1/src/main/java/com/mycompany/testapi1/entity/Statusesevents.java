/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testapi1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Collection;
import jakarta.persistence.Basic;
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
@Table(name = "statusesevents")
@NamedQueries({
    @NamedQuery(name = "Statusesevents.findAll", query = "SELECT s FROM Statusesevents s"),
    @NamedQuery(name = "Statusesevents.findByIdStetuEvent", query = "SELECT s FROM Statusesevents s WHERE s.idStetuEvent = :idStetuEvent"),
    @NamedQuery(name = "Statusesevents.findByName", query = "SELECT s FROM Statusesevents s WHERE s.name = :name")})
public class Statusesevents implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idStetuEvent")
    private Integer idStetuEvent;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "statusEvent")
    private Collection<Events> eventsCollection;

    public Statusesevents() {
    }

    public Statusesevents(Integer idStetuEvent) {
        this.idStetuEvent = idStetuEvent;
    }

    public Integer getIdStetuEvent() {
        return idStetuEvent;
    }

    public void setIdStetuEvent(Integer idStetuEvent) {
        this.idStetuEvent = idStetuEvent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Events> getEventsCollection() {
        return eventsCollection;
    }

    public void setEventsCollection(Collection<Events> eventsCollection) {
        this.eventsCollection = eventsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idStetuEvent != null ? idStetuEvent.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Statusesevents)) {
            return false;
        }
        Statusesevents other = (Statusesevents) object;
        if ((this.idStetuEvent == null && other.idStetuEvent != null) || (this.idStetuEvent != null && !this.idStetuEvent.equals(other.idStetuEvent))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.testapi1.entity.Statusesevents[ idStetuEvent=" + idStetuEvent + " ]";
    }
    
}
