/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testapi2.entity;
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
@Table(name = "tipimeropriyatya")
@NamedQueries({
    @NamedQuery(name = "Tipimeropriyatya.findAll", query = "SELECT t FROM Tipimeropriyatya t"),
    @NamedQuery(name = "Tipimeropriyatya.findByIdTip", query = "SELECT t FROM Tipimeropriyatya t WHERE t.idTip = :idTip"),
    @NamedQuery(name = "Tipimeropriyatya.findByNazvanye", query = "SELECT t FROM Tipimeropriyatya t WHERE t.nazvanye = :nazvanye")})
public class Tipimeropriyatya implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTip")
    private Integer idTip;
    @Column(name = "nazvanye")
    private String nazvanye;
    @OneToMany(mappedBy = "idTip")
    private Collection<Meropriyatiya> meropriyatiyaCollection;

    public Tipimeropriyatya() {
    }

    public Tipimeropriyatya(Integer idTip) {
        this.idTip = idTip;
    }

    public Integer getIdTip() {
        return idTip;
    }

    public void setIdTip(Integer idTip) {
        this.idTip = idTip;
    }

    public String getNazvanye() {
        return nazvanye;
    }

    public void setNazvanye(String nazvanye) {
        this.nazvanye = nazvanye;
    }

    public Collection<Meropriyatiya> getMeropriyatiyaCollection() {
        return meropriyatiyaCollection;
    }

    public void setMeropriyatiyaCollection(Collection<Meropriyatiya> meropriyatiyaCollection) {
        this.meropriyatiyaCollection = meropriyatiyaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTip != null ? idTip.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipimeropriyatya)) {
            return false;
        }
        Tipimeropriyatya other = (Tipimeropriyatya) object;
        if ((this.idTip == null && other.idTip != null) || (this.idTip != null && !this.idTip.equals(other.idTip))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.testapi2.entity.Tipimeropriyatya[ idTip=" + idTip + " ]";
    }
    
}
