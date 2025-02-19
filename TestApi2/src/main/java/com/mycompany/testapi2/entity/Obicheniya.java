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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 *
 * @author 1208-VM1
 */
@Entity
@Table(name = "obicheniya")
@NamedQueries({
    @NamedQuery(name = "Obicheniya.findAll", query = "SELECT o FROM Obicheniya o"),
    @NamedQuery(name = "Obicheniya.findByIdObuchenya", query = "SELECT o FROM Obicheniya o WHERE o.idObuchenya = :idObuchenya"),
    @NamedQuery(name = "Obicheniya.findByName", query = "SELECT o FROM Obicheniya o WHERE o.name = :name"),
    @NamedQuery(name = "Obicheniya.findByOpisaniye", query = "SELECT o FROM Obicheniya o WHERE o.opisaniye = :opisaniye")})
public class Obicheniya implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idObuchenya")
    private Integer idObuchenya;
    @Column(name = "name")
    private String name;
    @Column(name = "opisaniye")
    private String opisaniye;
    @JsonIgnore
    @JoinColumn(name = "idClassification", referencedColumnName = "idClassification")
    @ManyToOne
    private Klassificationsobuchenya idClassification;
    @OneToMany(mappedBy = "idObuchenya")
    private Collection<Materalsobuchenya> materalsobuchenyaCollection;
    @OneToMany(mappedBy = "idObuchenya")
    private Collection<Obuchenyesotrudnikov> obuchenyesotrudnikovCollection;

    public Obicheniya() {
    }

    public Obicheniya(Integer idObuchenya) {
        this.idObuchenya = idObuchenya;
    }

    public Integer getIdObuchenya() {
        return idObuchenya;
    }

    public void setIdObuchenya(Integer idObuchenya) {
        this.idObuchenya = idObuchenya;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOpisaniye() {
        return opisaniye;
    }

    public void setOpisaniye(String opisaniye) {
        this.opisaniye = opisaniye;
    }

    public Klassificationsobuchenya getIdClassification() {
        return idClassification;
    }

    public void setIdClassification(Klassificationsobuchenya idClassification) {
        this.idClassification = idClassification;
    }

    public Collection<Materalsobuchenya> getMateralsobuchenyaCollection() {
        return materalsobuchenyaCollection;
    }

    public void setMateralsobuchenyaCollection(Collection<Materalsobuchenya> materalsobuchenyaCollection) {
        this.materalsobuchenyaCollection = materalsobuchenyaCollection;
    }

    public Collection<Obuchenyesotrudnikov> getObuchenyesotrudnikovCollection() {
        return obuchenyesotrudnikovCollection;
    }

    public void setObuchenyesotrudnikovCollection(Collection<Obuchenyesotrudnikov> obuchenyesotrudnikovCollection) {
        this.obuchenyesotrudnikovCollection = obuchenyesotrudnikovCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idObuchenya != null ? idObuchenya.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Obicheniya)) {
            return false;
        }
        Obicheniya other = (Obicheniya) object;
        if ((this.idObuchenya == null && other.idObuchenya != null) || (this.idObuchenya != null && !this.idObuchenya.equals(other.idObuchenya))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.testapi2.entity.Obicheniya[ idObuchenya=" + idObuchenya + " ]";
    }
    
}
