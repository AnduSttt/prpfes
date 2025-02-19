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
@Table(name = "padrazdeleniya")
@NamedQueries({
    @NamedQuery(name = "Padrazdeleniya.findAll", query = "SELECT p FROM Padrazdeleniya p"),
    @NamedQuery(name = "Padrazdeleniya.findByIdPodrazdelenie", query = "SELECT p FROM Padrazdeleniya p WHERE p.idPodrazdelenie = :idPodrazdelenie"),
    @NamedQuery(name = "Padrazdeleniya.findByOpisanie", query = "SELECT p FROM Padrazdeleniya p WHERE p.opisanie = :opisanie"),
    @NamedQuery(name = "Padrazdeleniya.findByKodPodrazdelenia", query = "SELECT p FROM Padrazdeleniya p WHERE p.kodPodrazdelenia = :kodPodrazdelenia"),
    @NamedQuery(name = "Padrazdeleniya.findByNazvaniye", query = "SELECT p FROM Padrazdeleniya p WHERE p.nazvaniye = :nazvaniye")})
public class Padrazdeleniya implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPodrazdelenie")
    private Integer idPodrazdelenie;
    @Column(name = "opisanie")
    private String opisanie;
    @Column(name = "kodPodrazdelenia")
    private String kodPodrazdelenia;
    @Column(name = "nazvaniye")
    private String nazvaniye;
    @OneToMany(mappedBy = "idPodrazd")
    private Collection<Sotrudniki> sotrudnikiCollection;

    public Padrazdeleniya() {
    }

    public Padrazdeleniya(Integer idPodrazdelenie) {
        this.idPodrazdelenie = idPodrazdelenie;
    }

    public Integer getIdPodrazdelenie() {
        return idPodrazdelenie;
    }

    public void setIdPodrazdelenie(Integer idPodrazdelenie) {
        this.idPodrazdelenie = idPodrazdelenie;
    }

    public String getOpisanie() {
        return opisanie;
    }

    public void setOpisanie(String opisanie) {
        this.opisanie = opisanie;
    }

    public String getKodPodrazdelenia() {
        return kodPodrazdelenia;
    }

    public void setKodPodrazdelenia(String kodPodrazdelenia) {
        this.kodPodrazdelenia = kodPodrazdelenia;
    }

    public String getNazvaniye() {
        return nazvaniye;
    }

    public void setNazvaniye(String nazvaniye) {
        this.nazvaniye = nazvaniye;
    }

    public Collection<Sotrudniki> getSotrudnikiCollection() {
        return sotrudnikiCollection;
    }

    public void setSotrudnikiCollection(Collection<Sotrudniki> sotrudnikiCollection) {
        this.sotrudnikiCollection = sotrudnikiCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPodrazdelenie != null ? idPodrazdelenie.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Padrazdeleniya)) {
            return false;
        }
        Padrazdeleniya other = (Padrazdeleniya) object;
        if ((this.idPodrazdelenie == null && other.idPodrazdelenie != null) || (this.idPodrazdelenie != null && !this.idPodrazdelenie.equals(other.idPodrazdelenie))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.testapi2.entity.Padrazdeleniya[ idPodrazdelenie=" + idPodrazdelenie + " ]";
    }
    
}
