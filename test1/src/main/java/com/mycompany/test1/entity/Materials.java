/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.test1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Collection;
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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

/**
 *
 * @author 1208-VM1
 */
@Entity
@Table(name = "materials")
@NamedQueries({
    @NamedQuery(name = "Materials.findAll", query = "SELECT m FROM Materials m"),
    @NamedQuery(name = "Materials.findByIdMaterial", query = "SELECT m FROM Materials m WHERE m.idMaterial = :idMaterial"),
    @NamedQuery(name = "Materials.findByNameMaterial", query = "SELECT m FROM Materials m WHERE m.nameMaterial = :nameMaterial"),
    @NamedQuery(name = "Materials.findByDateUpdate", query = "SELECT m FROM Materials m WHERE m.dateUpdate = :dateUpdate"),
    @NamedQuery(name = "Materials.findByAutor", query = "SELECT m FROM Materials m WHERE m.autor = :autor"),
    @NamedQuery(name = "Materials.findByDateAccept", query = "SELECT m FROM Materials m WHERE m.dateAccept = :dateAccept")})
public class Materials implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMaterial")
    private Integer idMaterial;
    @Column(name = "nameMaterial")
    private String nameMaterial;
    @Column(name = "dateUpdate")
    @Temporal(TemporalType.DATE)
    private Date dateUpdate;
    @Column(name = "autor")
    private String autor;
    @Column(name = "dateAccept")
    @Temporal(TemporalType.DATE)
    private Date dateAccept;
    @OneToMany(mappedBy = "material")
    private Collection<Materialseducations> materialseducationsCollection;
    @JsonIgnore
    @JoinColumn(name = "region", referencedColumnName = "idRegion")
    @ManyToOne
    private Regions region;
    @JsonIgnore
    @JoinColumn(name = "status", referencedColumnName = "idStatus")
    @ManyToOne
    private Statuses status;
    @JsonIgnore
    @JoinColumn(name = "type", referencedColumnName = "idType")
    @ManyToOne
    private Types type;

    public Materials() {
    }

    public Materials(Integer idMaterial) {
        this.idMaterial = idMaterial;
    }

    public Integer getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(Integer idMaterial) {
        this.idMaterial = idMaterial;
    }

    public String getNameMaterial() {
        return nameMaterial;
    }

    public void setNameMaterial(String nameMaterial) {
        this.nameMaterial = nameMaterial;
    }

    public Date getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(Date dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Date getDateAccept() {
        return dateAccept;
    }

    public void setDateAccept(Date dateAccept) {
        this.dateAccept = dateAccept;
    }

    public Collection<Materialseducations> getMaterialseducationsCollection() {
        return materialseducationsCollection;
    }

    public void setMaterialseducationsCollection(Collection<Materialseducations> materialseducationsCollection) {
        this.materialseducationsCollection = materialseducationsCollection;
    }

    public Regions getRegion() {
        return region;
    }

    public void setRegion(Regions region) {
        this.region = region;
    }

    public Statuses getStatus() {
        return status;
    }

    public void setStatus(Statuses status) {
        this.status = status;
    }

    public Types getType() {
        return type;
    }

    public void setType(Types type) {
        this.type = type;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMaterial != null ? idMaterial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Materials)) {
            return false;
        }
        Materials other = (Materials) object;
        if ((this.idMaterial == null && other.idMaterial != null) || (this.idMaterial != null && !this.idMaterial.equals(other.idMaterial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.test1.entity.Materials[ idMaterial=" + idMaterial + " ]";
    }

}
