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
@Table(name = "otguli")
@NamedQueries({
    @NamedQuery(name = "Otguli.findAll", query = "SELECT o FROM Otguli o"),
    @NamedQuery(name = "Otguli.findByIdOtgul", query = "SELECT o FROM Otguli o WHERE o.idOtgul = :idOtgul"),
    @NamedQuery(name = "Otguli.findByDateOtgulNachalo", query = "SELECT o FROM Otguli o WHERE o.dateOtgulNachalo = :dateOtgulNachalo"),
    @NamedQuery(name = "Otguli.findByDateOtgulOkonchaniye", query = "SELECT o FROM Otguli o WHERE o.dateOtgulOkonchaniye = :dateOtgulOkonchaniye")})
public class Otguli implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idOtgul")
    private Integer idOtgul;
    @Column(name = "dateOtgulNachalo")
    @Temporal(TemporalType.DATE)
    private Date dateOtgulNachalo;
    @Column(name = "dateOtgulOkonchaniye")
    @Temporal(TemporalType.DATE)
    private Date dateOtgulOkonchaniye;
    @JsonIgnore
    @JoinColumn(name = "idSotrudnika", referencedColumnName = "idSotridnik")
    @ManyToOne
    private Sotrudniki idSotrudnika;
    @JsonIgnore
    @JoinColumn(name = "idSotrudnikaZamestil", referencedColumnName = "idSotridnik")
    @ManyToOne
    private Sotrudniki idSotrudnikaZamestil;

    public Otguli() {
    }

    public Otguli(Integer idOtgul) {
        this.idOtgul = idOtgul;
    }

    public Integer getIdOtgul() {
        return idOtgul;
    }

    public void setIdOtgul(Integer idOtgul) {
        this.idOtgul = idOtgul;
    }

    public Date getDateOtgulNachalo() {
        return dateOtgulNachalo;
    }

    public void setDateOtgulNachalo(Date dateOtgulNachalo) {
        this.dateOtgulNachalo = dateOtgulNachalo;
    }

    public Date getDateOtgulOkonchaniye() {
        return dateOtgulOkonchaniye;
    }

    public void setDateOtgulOkonchaniye(Date dateOtgulOkonchaniye) {
        this.dateOtgulOkonchaniye = dateOtgulOkonchaniye;
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
        hash += (idOtgul != null ? idOtgul.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Otguli)) {
            return false;
        }
        Otguli other = (Otguli) object;
        if ((this.idOtgul == null && other.idOtgul != null) || (this.idOtgul != null && !this.idOtgul.equals(other.idOtgul))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.testapi2.entity.Otguli[ idOtgul=" + idOtgul + " ]";
    }
    
}
