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
@Table(name = "oblastimaterials")
@NamedQueries({
    @NamedQuery(name = "Oblastimaterials.findAll", query = "SELECT o FROM Oblastimaterials o"),
    @NamedQuery(name = "Oblastimaterials.findByIdOblast", query = "SELECT o FROM Oblastimaterials o WHERE o.idOblast = :idOblast"),
    @NamedQuery(name = "Oblastimaterials.findByNazvanye", query = "SELECT o FROM Oblastimaterials o WHERE o.nazvanye = :nazvanye")})
public class Oblastimaterials implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idOblast")
    private Integer idOblast;
    @Column(name = "nazvanye")
    private String nazvanye;
    @OneToMany(mappedBy = "idOblast")
    private Collection<Materials> materialsCollection;

    public Oblastimaterials() {
    }

    public Oblastimaterials(Integer idOblast) {
        this.idOblast = idOblast;
    }

    public Integer getIdOblast() {
        return idOblast;
    }

    public void setIdOblast(Integer idOblast) {
        this.idOblast = idOblast;
    }

    public String getNazvanye() {
        return nazvanye;
    }

    public void setNazvanye(String nazvanye) {
        this.nazvanye = nazvanye;
    }

    public Collection<Materials> getMaterialsCollection() {
        return materialsCollection;
    }

    public void setMaterialsCollection(Collection<Materials> materialsCollection) {
        this.materialsCollection = materialsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOblast != null ? idOblast.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Oblastimaterials)) {
            return false;
        }
        Oblastimaterials other = (Oblastimaterials) object;
        if ((this.idOblast == null && other.idOblast != null) || (this.idOblast != null && !this.idOblast.equals(other.idOblast))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.testapi2.entity.Oblastimaterials[ idOblast=" + idOblast + " ]";
    }
    
}
