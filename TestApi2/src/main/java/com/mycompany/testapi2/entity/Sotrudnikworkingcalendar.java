/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testapi2.entity;
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
@Table(name = "sotrudnikworkingcalendar")
@NamedQueries({
    @NamedQuery(name = "Sotrudnikworkingcalendar.findAll", query = "SELECT s FROM Sotrudnikworkingcalendar s"),
    @NamedQuery(name = "Sotrudnikworkingcalendar.findByIdSotrudnikWorkingCalendar", query = "SELECT s FROM Sotrudnikworkingcalendar s WHERE s.idSotrudnikWorkingCalendar = :idSotrudnikWorkingCalendar")})
public class Sotrudnikworkingcalendar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idSotrudnikWorkingCalendar")
    private Integer idSotrudnikWorkingCalendar;
    @JsonIgnore
    @JoinColumn(name = "idSotrudnik", referencedColumnName = "idSotridnik")
    @ManyToOne
    private Sotrudniki idSotrudnik;
    @JsonIgnore
    @JoinColumn(name = "idWorkingCalendar", referencedColumnName = "Id")
    @ManyToOne
    private Workingcalendar idWorkingCalendar;

    public Sotrudnikworkingcalendar() {
    }

    public Sotrudnikworkingcalendar(Integer idSotrudnikWorkingCalendar) {
        this.idSotrudnikWorkingCalendar = idSotrudnikWorkingCalendar;
    }

    public Integer getIdSotrudnikWorkingCalendar() {
        return idSotrudnikWorkingCalendar;
    }

    public void setIdSotrudnikWorkingCalendar(Integer idSotrudnikWorkingCalendar) {
        this.idSotrudnikWorkingCalendar = idSotrudnikWorkingCalendar;
    }

    public Sotrudniki getIdSotrudnik() {
        return idSotrudnik;
    }

    public void setIdSotrudnik(Sotrudniki idSotrudnik) {
        this.idSotrudnik = idSotrudnik;
    }

    public Workingcalendar getIdWorkingCalendar() {
        return idWorkingCalendar;
    }

    public void setIdWorkingCalendar(Workingcalendar idWorkingCalendar) {
        this.idWorkingCalendar = idWorkingCalendar;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSotrudnikWorkingCalendar != null ? idSotrudnikWorkingCalendar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sotrudnikworkingcalendar)) {
            return false;
        }
        Sotrudnikworkingcalendar other = (Sotrudnikworkingcalendar) object;
        if ((this.idSotrudnikWorkingCalendar == null && other.idSotrudnikWorkingCalendar != null) || (this.idSotrudnikWorkingCalendar != null && !this.idSotrudnikWorkingCalendar.equals(other.idSotrudnikWorkingCalendar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.testapi2.entity.Sotrudnikworkingcalendar[ idSotrudnikWorkingCalendar=" + idSotrudnikWorkingCalendar + " ]";
    }
    
}
