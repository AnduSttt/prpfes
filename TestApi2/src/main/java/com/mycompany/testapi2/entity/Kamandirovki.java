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
@Table(name = "kamandirovki")
@NamedQueries({
    @NamedQuery(name = "Kamandirovki.findAll", query = "SELECT k FROM Kamandirovki k"),
    @NamedQuery(name = "Kamandirovki.findByIdKomandirovka", query = "SELECT k FROM Kamandirovki k WHERE k.idKomandirovka = :idKomandirovka"),
    @NamedQuery(name = "Kamandirovki.findByDateKomandirovkaNachalo", query = "SELECT k FROM Kamandirovki k WHERE k.dateKomandirovkaNachalo = :dateKomandirovkaNachalo"),
    @NamedQuery(name = "Kamandirovki.findByDateKomandirovkaOkonchaniye", query = "SELECT k FROM Kamandirovki k WHERE k.dateKomandirovkaOkonchaniye = :dateKomandirovkaOkonchaniye")})
public class Kamandirovki implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idKomandirovka")
    private Integer idKomandirovka;
    @Column(name = "dateKomandirovkaNachalo")
    @Temporal(TemporalType.DATE)
    private Date dateKomandirovkaNachalo;
    @Column(name = "dateKomandirovkaOkonchaniye")
    @Temporal(TemporalType.DATE)
    private Date dateKomandirovkaOkonchaniye;
    @JsonIgnore
    @JoinColumn(name = "idSotrudnika", referencedColumnName = "idSotridnik")
    @ManyToOne
    private Sotrudniki idSotrudnika;

    public Kamandirovki() {
    }

    public Kamandirovki(Integer idKomandirovka) {
        this.idKomandirovka = idKomandirovka;
    }

    public Integer getIdKomandirovka() {
        return idKomandirovka;
    }

    public void setIdKomandirovka(Integer idKomandirovka) {
        this.idKomandirovka = idKomandirovka;
    }

    public Date getDateKomandirovkaNachalo() {
        return dateKomandirovkaNachalo;
    }

    public void setDateKomandirovkaNachalo(Date dateKomandirovkaNachalo) {
        this.dateKomandirovkaNachalo = dateKomandirovkaNachalo;
    }

    public Date getDateKomandirovkaOkonchaniye() {
        return dateKomandirovkaOkonchaniye;
    }

    public void setDateKomandirovkaOkonchaniye(Date dateKomandirovkaOkonchaniye) {
        this.dateKomandirovkaOkonchaniye = dateKomandirovkaOkonchaniye;
    }

    public Sotrudniki getIdSotrudnika() {
        return idSotrudnika;
    }

    public void setIdSotrudnika(Sotrudniki idSotrudnika) {
        this.idSotrudnika = idSotrudnika;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idKomandirovka != null ? idKomandirovka.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kamandirovki)) {
            return false;
        }
        Kamandirovki other = (Kamandirovki) object;
        if ((this.idKomandirovka == null && other.idKomandirovka != null) || (this.idKomandirovka != null && !this.idKomandirovka.equals(other.idKomandirovka))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.testapi2.entity.Kamandirovki[ idKomandirovka=" + idKomandirovka + " ]";
    }
    
}
