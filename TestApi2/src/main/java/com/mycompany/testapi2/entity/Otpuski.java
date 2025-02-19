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
@Table(name = "otpuski")
@NamedQueries({
    @NamedQuery(name = "Otpuski.findAll", query = "SELECT o FROM Otpuski o"),
    @NamedQuery(name = "Otpuski.findByIdOtpusk", query = "SELECT o FROM Otpuski o WHERE o.idOtpusk = :idOtpusk"),
    @NamedQuery(name = "Otpuski.findByDateOtpuskNachalo", query = "SELECT o FROM Otpuski o WHERE o.dateOtpuskNachalo = :dateOtpuskNachalo"),
    @NamedQuery(name = "Otpuski.findByDateOtpusklOkonchaniye", query = "SELECT o FROM Otpuski o WHERE o.dateOtpusklOkonchaniye = :dateOtpusklOkonchaniye")})
public class Otpuski implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idOtpusk")
    private Integer idOtpusk;
    @Column(name = "dateOtpuskNachalo")
    @Temporal(TemporalType.DATE)
    private Date dateOtpuskNachalo;
    @Column(name = "dateOtpusklOkonchaniye")
    @Temporal(TemporalType.DATE)
    private Date dateOtpusklOkonchaniye;
    @JsonIgnore
    @JoinColumn(name = "idSotrudnika", referencedColumnName = "idSotridnik")
    @ManyToOne
    private Sotrudniki idSotrudnika;
    @JsonIgnore
    @JoinColumn(name = "idSotrudnikaZamestil", referencedColumnName = "idSotridnik")
    @ManyToOne
    private Sotrudniki idSotrudnikaZamestil;

    public Otpuski() {
    }

    public Otpuski(Integer idOtpusk) {
        this.idOtpusk = idOtpusk;
    }

    public Integer getIdOtpusk() {
        return idOtpusk;
    }

    public void setIdOtpusk(Integer idOtpusk) {
        this.idOtpusk = idOtpusk;
    }

    public Date getDateOtpuskNachalo() {
        return dateOtpuskNachalo;
    }

    public void setDateOtpuskNachalo(Date dateOtpuskNachalo) {
        this.dateOtpuskNachalo = dateOtpuskNachalo;
    }

    public Date getDateOtpusklOkonchaniye() {
        return dateOtpusklOkonchaniye;
    }

    public void setDateOtpusklOkonchaniye(Date dateOtpusklOkonchaniye) {
        this.dateOtpusklOkonchaniye = dateOtpusklOkonchaniye;
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
        hash += (idOtpusk != null ? idOtpusk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Otpuski)) {
            return false;
        }
        Otpuski other = (Otpuski) object;
        if ((this.idOtpusk == null && other.idOtpusk != null) || (this.idOtpusk != null && !this.idOtpusk.equals(other.idOtpusk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.testapi2.entity.Otpuski[ idOtpusk=" + idOtpusk + " ]";
    }
    
}
