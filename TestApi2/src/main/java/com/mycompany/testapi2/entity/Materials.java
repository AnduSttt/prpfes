/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testapi2.entity;
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
    @NamedQuery(name = "Materials.findByNazvaniye", query = "SELECT m FROM Materials m WHERE m.nazvaniye = :nazvaniye"),
    @NamedQuery(name = "Materials.findByDateUtverchd", query = "SELECT m FROM Materials m WHERE m.dateUtverchd = :dateUtverchd"),
    @NamedQuery(name = "Materials.findByDateRedact", query = "SELECT m FROM Materials m WHERE m.dateRedact = :dateRedact")})
public class Materials implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMaterial")
    private Integer idMaterial;
    @Column(name = "nazvaniye")
    private String nazvaniye;
    @Column(name = "dateUtverchd")
    @Temporal(TemporalType.DATE)
    private Date dateUtverchd;
    @Column(name = "dateRedact")
    @Temporal(TemporalType.DATE)
    private Date dateRedact;
    @OneToMany(mappedBy = "idMaterial")
    private Collection<Materalsobuchenya> materalsobuchenyaCollection;
    @JsonIgnore
    @JoinColumn(name = "idOblast", referencedColumnName = "idOblast")
    @ManyToOne
    private Oblastimaterials idOblast;
    @JsonIgnore
    @JoinColumn(name = "iaSotrudnikAutor", referencedColumnName = "idSotridnik")
    @ManyToOne
    private Sotrudniki iaSotrudnikAutor;
    @JsonIgnore
    @JoinColumn(name = "idStatus", referencedColumnName = "idStatus")
    @ManyToOne
    private Statusesmaterials idStatus;
    @JsonIgnore
    @JoinColumn(name = "idTipe", referencedColumnName = "idTipe")
    @ManyToOne
    private Tipesmaterials idTipe;

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

    public String getNazvaniye() {
        return nazvaniye;
    }

    public void setNazvaniye(String nazvaniye) {
        this.nazvaniye = nazvaniye;
    }

    public Date getDateUtverchd() {
        return dateUtverchd;
    }

    public void setDateUtverchd(Date dateUtverchd) {
        this.dateUtverchd = dateUtverchd;
    }

    public Date getDateRedact() {
        return dateRedact;
    }

    public void setDateRedact(Date dateRedact) {
        this.dateRedact = dateRedact;
    }

    public Collection<Materalsobuchenya> getMateralsobuchenyaCollection() {
        return materalsobuchenyaCollection;
    }

    public void setMateralsobuchenyaCollection(Collection<Materalsobuchenya> materalsobuchenyaCollection) {
        this.materalsobuchenyaCollection = materalsobuchenyaCollection;
    }

    public Oblastimaterials getIdOblast() {
        return idOblast;
    }

    public void setIdOblast(Oblastimaterials idOblast) {
        this.idOblast = idOblast;
    }

    public Sotrudniki getIaSotrudnikAutor() {
        return iaSotrudnikAutor;
    }

    public void setIaSotrudnikAutor(Sotrudniki iaSotrudnikAutor) {
        this.iaSotrudnikAutor = iaSotrudnikAutor;
    }

    public Statusesmaterials getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(Statusesmaterials idStatus) {
        this.idStatus = idStatus;
    }

    public Tipesmaterials getIdTipe() {
        return idTipe;
    }

    public void setIdTipe(Tipesmaterials idTipe) {
        this.idTipe = idTipe;
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
        return "com.mycompany.testapi2.entity.Materials[ idMaterial=" + idMaterial + " ]";
    }
    
}
