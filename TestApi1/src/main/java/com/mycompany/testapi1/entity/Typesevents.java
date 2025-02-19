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
@Table(name = "typesevents")
@NamedQueries({
    @NamedQuery(name = "Typesevents.findAll", query = "SELECT t FROM Typesevents t"),
    @NamedQuery(name = "Typesevents.findByIdTypeEvent", query = "SELECT t FROM Typesevents t WHERE t.idTypeEvent = :idTypeEvent"),
    @NamedQuery(name = "Typesevents.findByName", query = "SELECT t FROM Typesevents t WHERE t.name = :name")})
public class Typesevents implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTypeEvent")
    private Integer idTypeEvent;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "typeEvent")
    private Collection<Events> eventsCollection;

    public Typesevents() {
    }

    public Typesevents(Integer idTypeEvent) {
        this.idTypeEvent = idTypeEvent;
    }

    public Integer getIdTypeEvent() {
        return idTypeEvent;
    }

    public void setIdTypeEvent(Integer idTypeEvent) {
        this.idTypeEvent = idTypeEvent;
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
        hash += (idTypeEvent != null ? idTypeEvent.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Typesevents)) {
            return false;
        }
        Typesevents other = (Typesevents) object;
        if ((this.idTypeEvent == null && other.idTypeEvent != null) || (this.idTypeEvent != null && !this.idTypeEvent.equals(other.idTypeEvent))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.testapi1.entity.Typesevents[ idTypeEvent=" + idTypeEvent + " ]";
    }
    
}
