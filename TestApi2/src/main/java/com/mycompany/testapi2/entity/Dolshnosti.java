/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testapi2.entity;

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
@Table(name = "dolshnosti")
@NamedQueries({
    @NamedQuery(name = "Dolshnosti.findAll", query = "SELECT d FROM Dolshnosti d"),
    @NamedQuery(name = "Dolshnosti.findByIdDolshnost", query = "SELECT d FROM Dolshnosti d WHERE d.idDolshnost = :idDolshnost"),
    @NamedQuery(name = "Dolshnosti.findByNazvaniye", query = "SELECT d FROM Dolshnosti d WHERE d.nazvaniye = :nazvaniye")})
public class Dolshnosti implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDolshnost")
    private Integer idDolshnost;
    @Column(name = "nazvaniye")
    private String nazvaniye;
    @OneToMany(mappedBy = "idDolshnost")
    private Collection<Sotrudniki> sotrudnikiCollection;
    @OneToMany(mappedBy = "idDolshnost")
    private Collection<Souskateli> souskateliCollection;

    public Dolshnosti() {
    }

    public Dolshnosti(Integer idDolshnost) {
        this.idDolshnost = idDolshnost;
    }

    public Integer getIdDolshnost() {
        return idDolshnost;
    }

    public void setIdDolshnost(Integer idDolshnost) {
        this.idDolshnost = idDolshnost;
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

    public Collection<Souskateli> getSouskateliCollection() {
        return souskateliCollection;
    }

    public void setSouskateliCollection(Collection<Souskateli> souskateliCollection) {
        this.souskateliCollection = souskateliCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDolshnost != null ? idDolshnost.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dolshnosti)) {
            return false;
        }
        Dolshnosti other = (Dolshnosti) object;
        if ((this.idDolshnost == null && other.idDolshnost != null) || (this.idDolshnost != null && !this.idDolshnost.equals(other.idDolshnost))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.testapi2.entity.Dolshnosti[ idDolshnost=" + idDolshnost + " ]";
    }
    
}
