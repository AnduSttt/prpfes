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
@Table(name = "statusesmaterials")
@NamedQueries({
    @NamedQuery(name = "Statusesmaterials.findAll", query = "SELECT s FROM Statusesmaterials s"),
    @NamedQuery(name = "Statusesmaterials.findByIdStatus", query = "SELECT s FROM Statusesmaterials s WHERE s.idStatus = :idStatus"),
    @NamedQuery(name = "Statusesmaterials.findByNazvanye", query = "SELECT s FROM Statusesmaterials s WHERE s.nazvanye = :nazvanye")})
public class Statusesmaterials implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idStatus")
    private Integer idStatus;
    @Column(name = "nazvanye")
    private String nazvanye;
    @OneToMany(mappedBy = "idStatus")
    private Collection<Materials> materialsCollection;

    public Statusesmaterials() {
    }

    public Statusesmaterials(Integer idStatus) {
        this.idStatus = idStatus;
    }

    public Integer getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(Integer idStatus) {
        this.idStatus = idStatus;
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
        hash += (idStatus != null ? idStatus.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Statusesmaterials)) {
            return false;
        }
        Statusesmaterials other = (Statusesmaterials) object;
        if ((this.idStatus == null && other.idStatus != null) || (this.idStatus != null && !this.idStatus.equals(other.idStatus))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.testapi2.entity.Statusesmaterials[ idStatus=" + idStatus + " ]";
    }
    
}
