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
@Table(name = "otsutstiya")
@NamedQueries({
    @NamedQuery(name = "Otsutstiya.findAll", query = "SELECT o FROM Otsutstiya o"),
    @NamedQuery(name = "Otsutstiya.findByIdOtsutstviya", query = "SELECT o FROM Otsutstiya o WHERE o.idOtsutstviya = :idOtsutstviya"),
    @NamedQuery(name = "Otsutstiya.findByDateOtsustviya", query = "SELECT o FROM Otsutstiya o WHERE o.dateOtsustviya = :dateOtsustviya")})
public class Otsutstiya implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idOtsutstviya")
    private Integer idOtsutstviya;
    @Column(name = "dateOtsustviya")
    @Temporal(TemporalType.DATE)
    private Date dateOtsustviya;
    @JsonIgnore
    @JoinColumn(name = "idSotrudnika", referencedColumnName = "idSotridnik")
    @ManyToOne
    private Sotrudniki idSotrudnika;
    @JsonIgnore
    @JoinColumn(name = "idSotrudnikaZamestil", referencedColumnName = "idSotridnik")
    @ManyToOne
    private Sotrudniki idSotrudnikaZamestil;

    public Otsutstiya() {
    }

    public Otsutstiya(Integer idOtsutstviya) {
        this.idOtsutstviya = idOtsutstviya;
    }

    public Integer getIdOtsutstviya() {
        return idOtsutstviya;
    }

    public void setIdOtsutstviya(Integer idOtsutstviya) {
        this.idOtsutstviya = idOtsutstviya;
    }

    public Date getDateOtsustviya() {
        return dateOtsustviya;
    }

    public void setDateOtsustviya(Date dateOtsustviya) {
        this.dateOtsustviya = dateOtsustviya;
    }

    public Sotrudniki getIdSotrudnika() {
        return idSotrudnika;
    }

    public void setIdSotrudnika(Sotrudniki idSotrudnika) {
        this.idSotrudnika = idSotrudnika;
    }

    public Sotrudniki getIdSotrudnikaZamestil() {
        return idSotrudnikaZamestil;
    }

    public void setIdSotrudnikaZamestil(Sotrudniki idSotrudnikaZamestil) {
        this.idSotrudnikaZamestil = idSotrudnikaZamestil;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOtsutstviya != null ? idOtsutstviya.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Otsutstiya)) {
            return false;
        }
        Otsutstiya other = (Otsutstiya) object;
        if ((this.idOtsutstviya == null && other.idOtsutstviya != null) || (this.idOtsutstviya != null && !this.idOtsutstviya.equals(other.idOtsutstviya))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.testapi2.entity.Otsutstiya[ idOtsutstviya=" + idOtsutstviya + " ]";
    }
    
}
