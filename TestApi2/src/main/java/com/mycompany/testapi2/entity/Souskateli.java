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
@Table(name = "souskateli")
@NamedQueries({
    @NamedQuery(name = "Souskateli.findAll", query = "SELECT s FROM Souskateli s"),
    @NamedQuery(name = "Souskateli.findByIdSoiskatel", query = "SELECT s FROM Souskateli s WHERE s.idSoiskatel = :idSoiskatel"),
    @NamedQuery(name = "Souskateli.findByFamiliya", query = "SELECT s FROM Souskateli s WHERE s.familiya = :familiya"),
    @NamedQuery(name = "Souskateli.findByImya", query = "SELECT s FROM Souskateli s WHERE s.imya = :imya"),
    @NamedQuery(name = "Souskateli.findByOtchestvo", query = "SELECT s FROM Souskateli s WHERE s.otchestvo = :otchestvo"),
    @NamedQuery(name = "Souskateli.findByPersolalNomer", query = "SELECT s FROM Souskateli s WHERE s.persolalNomer = :persolalNomer"),
    @NamedQuery(name = "Souskateli.findByDenRoshdeniya", query = "SELECT s FROM Souskateli s WHERE s.denRoshdeniya = :denRoshdeniya"),
    @NamedQuery(name = "Souskateli.findByOpisaniye", query = "SELECT s FROM Souskateli s WHERE s.opisaniye = :opisaniye")})
public class Souskateli implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idSoiskatel")
    private Integer idSoiskatel;
    @Column(name = "familiya")
    private String familiya;
    @Column(name = "imya")
    private String imya;
    @Column(name = "otchestvo")
    private String otchestvo;
    @Column(name = "persolalNomer")
    private String persolalNomer;
    @Column(name = "denRoshdeniya")
    @Temporal(TemporalType.DATE)
    private Date denRoshdeniya;
    @Column(name = "opisaniye")
    private String opisaniye;
    @JsonIgnore
    @JoinColumn(name = "idDolshnost", referencedColumnName = "idDolshnost")
    @ManyToOne
    private Dolshnosti idDolshnost;

    public Souskateli() {
    }

    public Souskateli(Integer idSoiskatel) {
        this.idSoiskatel = idSoiskatel;
    }

    public Integer getIdSoiskatel() {
        return idSoiskatel;
    }

    public void setIdSoiskatel(Integer idSoiskatel) {
        this.idSoiskatel = idSoiskatel;
    }

    public String getFamiliya() {
        return familiya;
    }

    public void setFamiliya(String familiya) {
        this.familiya = familiya;
    }

    public String getImya() {
        return imya;
    }

    public void setImya(String imya) {
        this.imya = imya;
    }

    public String getOtchestvo() {
        return otchestvo;
    }

    public void setOtchestvo(String otchestvo) {
        this.otchestvo = otchestvo;
    }

    public String getPersolalNomer() {
        return persolalNomer;
    }

    public void setPersolalNomer(String persolalNomer) {
        this.persolalNomer = persolalNomer;
    }

    public Date getDenRoshdeniya() {
        return denRoshdeniya;
    }

    public void setDenRoshdeniya(Date denRoshdeniya) {
        this.denRoshdeniya = denRoshdeniya;
    }

    public String getOpisaniye() {
        return opisaniye;
    }

    public void setOpisaniye(String opisaniye) {
        this.opisaniye = opisaniye;
    }

    public Dolshnosti getIdDolshnost() {
        return idDolshnost;
    }

    public void setIdDolshnost(Dolshnosti idDolshnost) {
        this.idDolshnost = idDolshnost;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSoiskatel != null ? idSoiskatel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Souskateli)) {
            return false;
        }
        Souskateli other = (Souskateli) object;
        if ((this.idSoiskatel == null && other.idSoiskatel != null) || (this.idSoiskatel != null && !this.idSoiskatel.equals(other.idSoiskatel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.testapi2.entity.Souskateli[ idSoiskatel=" + idSoiskatel + " ]";
    }
    
}
