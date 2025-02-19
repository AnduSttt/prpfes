/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testapi2.entity;
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
@Table(name = "meropriyatiya")
@NamedQueries({
    @NamedQuery(name = "Meropriyatiya.findAll", query = "SELECT m FROM Meropriyatiya m"),
    @NamedQuery(name = "Meropriyatiya.findByIdMeropriyatya", query = "SELECT m FROM Meropriyatiya m WHERE m.idMeropriyatya = :idMeropriyatya"),
    @NamedQuery(name = "Meropriyatiya.findByDateNachalo", query = "SELECT m FROM Meropriyatiya m WHERE m.dateNachalo = :dateNachalo"),
    @NamedQuery(name = "Meropriyatiya.findByDateKomandirovkaOkonchaniye", query = "SELECT m FROM Meropriyatiya m WHERE m.dateKomandirovkaOkonchaniye = :dateKomandirovkaOkonchaniye"),
    @NamedQuery(name = "Meropriyatiya.findByVremyaNachala", query = "SELECT m FROM Meropriyatiya m WHERE m.vremyaNachala = :vremyaNachala"),
    @NamedQuery(name = "Meropriyatiya.findByVremyaOconchnya", query = "SELECT m FROM Meropriyatiya m WHERE m.vremyaOconchnya = :vremyaOconchnya"),
    @NamedQuery(name = "Meropriyatiya.findByOpisanye", query = "SELECT m FROM Meropriyatiya m WHERE m.opisanye = :opisanye")})
public class Meropriyatiya implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMeropriyatya")
    private Integer idMeropriyatya;
    @Column(name = "dateNachalo")
    @Temporal(TemporalType.DATE)
    private Date dateNachalo;
    @Column(name = "dateKomandirovkaOkonchaniye")
    @Temporal(TemporalType.DATE)
    private Date dateKomandirovkaOkonchaniye;
    @Column(name = "vremyaNachala")
    @Temporal(TemporalType.TIME)
    private Date vremyaNachala;
    @Column(name = "vremyaOconchnya")
    @Temporal(TemporalType.TIME)
    private Date vremyaOconchnya;
    @Column(name = "opisanye")
    private String opisanye;
    @JsonIgnore
    @JoinColumn(name = "idSotrudnikOtvetstvenen", referencedColumnName = "idSotridnik")
    @ManyToOne
    private Sotrudniki idSotrudnikOtvetstvenen;
    @JsonIgnore
    @JoinColumn(name = "idStatus", referencedColumnName = "idStatus")
    @ManyToOne
    private Statusesmeropriyatya idStatus;
    @JsonIgnore
    @JoinColumn(name = "idTip", referencedColumnName = "idTip")
    @ManyToOne
    private Tipimeropriyatya idTip;

    public Meropriyatiya() {
    }

    public Meropriyatiya(Integer idMeropriyatya) {
        this.idMeropriyatya = idMeropriyatya;
    }

    public Integer getIdMeropriyatya() {
        return idMeropriyatya;
    }

    public void setIdMeropriyatya(Integer idMeropriyatya) {
        this.idMeropriyatya = idMeropriyatya;
    }

    public Date getDateNachalo() {
        return dateNachalo;
    }

    public void setDateNachalo(Date dateNachalo) {
        this.dateNachalo = dateNachalo;
    }

    public Date getDateKomandirovkaOkonchaniye() {
        return dateKomandirovkaOkonchaniye;
    }

    public void setDateKomandirovkaOkonchaniye(Date dateKomandirovkaOkonchaniye) {
        this.dateKomandirovkaOkonchaniye = dateKomandirovkaOkonchaniye;
    }

    public Date getVremyaNachala() {
        return vremyaNachala;
    }

    public void setVremyaNachala(Date vremyaNachala) {
        this.vremyaNachala = vremyaNachala;
    }

    public Date getVremyaOconchnya() {
        return vremyaOconchnya;
    }

    public void setVremyaOconchnya(Date vremyaOconchnya) {
        this.vremyaOconchnya = vremyaOconchnya;
    }

    public String getOpisanye() {
        return opisanye;
    }

    public void setOpisanye(String opisanye) {
        this.opisanye = opisanye;
    }

    public Sotrudniki getIdSotrudnikOtvetstvenen() {
        return idSotrudnikOtvetstvenen;
    }

    public void setIdSotrudnikOtvetstvenen(Sotrudniki idSotrudnikOtvetstvenen) {
        this.idSotrudnikOtvetstvenen = idSotrudnikOtvetstvenen;
    }

    public Statusesmeropriyatya getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(Statusesmeropriyatya idStatus) {
        this.idStatus = idStatus;
    }

    public Tipimeropriyatya getIdTip() {
        return idTip;
    }

    public void setIdTip(Tipimeropriyatya idTip) {
        this.idTip = idTip;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMeropriyatya != null ? idMeropriyatya.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Meropriyatiya)) {
            return false;
        }
        Meropriyatiya other = (Meropriyatiya) object;
        if ((this.idMeropriyatya == null && other.idMeropriyatya != null) || (this.idMeropriyatya != null && !this.idMeropriyatya.equals(other.idMeropriyatya))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.testapi2.entity.Meropriyatiya[ idMeropriyatya=" + idMeropriyatya + " ]";
    }
    
}
