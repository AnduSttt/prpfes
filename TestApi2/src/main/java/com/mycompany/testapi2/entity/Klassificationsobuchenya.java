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
@Table(name = "klassificationsobuchenya")
@NamedQueries({
    @NamedQuery(name = "Klassificationsobuchenya.findAll", query = "SELECT k FROM Klassificationsobuchenya k"),
    @NamedQuery(name = "Klassificationsobuchenya.findByIdClassification", query = "SELECT k FROM Klassificationsobuchenya k WHERE k.idClassification = :idClassification"),
    @NamedQuery(name = "Klassificationsobuchenya.findByNazvaniye", query = "SELECT k FROM Klassificationsobuchenya k WHERE k.nazvaniye = :nazvaniye")})
public class Klassificationsobuchenya implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idClassification")
    private Integer idClassification;
    @Column(name = "nazvaniye")
    private String nazvaniye;
    @OneToMany(mappedBy = "idClassification")
    private Collection<Obicheniya> obicheniyaCollection;

    public Klassificationsobuchenya() {
    }

    public Klassificationsobuchenya(Integer idClassification) {
        this.idClassification = idClassification;
    }

    public Integer getIdClassification() {
        return idClassification;
    }

    public void setIdClassification(Integer idClassification) {
        this.idClassification = idClassification;
    }

    public String getNazvaniye() {
        return nazvaniye;
    }

    public void setNazvaniye(String nazvaniye) {
        this.nazvaniye = nazvaniye;
    }

    public Collection<Obicheniya> getObicheniyaCollection() {
        return obicheniyaCollection;
    }

    public void setObicheniyaCollection(Collection<Obicheniya> obicheniyaCollection) {
        this.obicheniyaCollection = obicheniyaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idClassification != null ? idClassification.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Klassificationsobuchenya)) {
            return false;
        }
        Klassificationsobuchenya other = (Klassificationsobuchenya) object;
        if ((this.idClassification == null && other.idClassification != null) || (this.idClassification != null && !this.idClassification.equals(other.idClassification))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.testapi2.entity.Klassificationsobuchenya[ idClassification=" + idClassification + " ]";
    }
    
}
