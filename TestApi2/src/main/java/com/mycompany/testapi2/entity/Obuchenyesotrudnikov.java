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
@Table(name = "obuchenyesotrudnikov")
@NamedQueries({
    @NamedQuery(name = "Obuchenyesotrudnikov.findAll", query = "SELECT o FROM Obuchenyesotrudnikov o"),
    @NamedQuery(name = "Obuchenyesotrudnikov.findByIdObuchenyaSotrudnika", query = "SELECT o FROM Obuchenyesotrudnikov o WHERE o.idObuchenyaSotrudnika = :idObuchenyaSotrudnika"),
    @NamedQuery(name = "Obuchenyesotrudnikov.findByDateNachala", query = "SELECT o FROM Obuchenyesotrudnikov o WHERE o.dateNachala = :dateNachala"),
    @NamedQuery(name = "Obuchenyesotrudnikov.findByDateOkonchanya", query = "SELECT o FROM Obuchenyesotrudnikov o WHERE o.dateOkonchanya = :dateOkonchanya")})
public class Obuchenyesotrudnikov implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idObuchenyaSotrudnika")
    private Integer idObuchenyaSotrudnika;
    @Column(name = "dateNachala")
    @Temporal(TemporalType.DATE)
    private Date dateNachala;
    @Column(name = "dateOkonchanya")
    @Temporal(TemporalType.DATE)
    private Date dateOkonchanya;
    @JsonIgnore
    @JoinColumn(name = "idObuchenya", referencedColumnName = "idObuchenya")
    @ManyToOne
    private Obicheniya idObuchenya;
    @JsonIgnore
    @JoinColumn(name = "idSotrudnik", referencedColumnName = "idSotridnik")
    @ManyToOne
    private Sotrudniki idSotrudnik;

    public Obuchenyesotrudnikov() {
    }

    public Obuchenyesotrudnikov(Integer idObuchenyaSotrudnika) {
        this.idObuchenyaSotrudnika = idObuchenyaSotrudnika;
    }

    public Integer getIdObuchenyaSotrudnika() {
        return idObuchenyaSotrudnika;
    }

    public void setIdObuchenyaSotrudnika(Integer idObuchenyaSotrudnika) {
        this.idObuchenyaSotrudnika = idObuchenyaSotrudnika;
    }

    public Date getDateNachala() {
        return dateNachala;
    }

    public void setDateNachala(Date dateNachala) {
        this.dateNachala = dateNachala;
    }

    public Date getDateOkonchanya() {
        return dateOkonchanya;
    }

    public void setDateOkonchanya(Date dateOkonchanya) {
        this.dateOkonchanya = dateOkonchanya;
    }

    public Obicheniya getIdObuchenya() {
        return idObuchenya;
    }

    public void setIdObuchenya(Obicheniya idObuchenya) {
        this.idObuchenya = idObuchenya;
    }

    public Sotrudniki getIdSotrudnik() {
        return idSotrudnik;
    }

    public void setIdSotrudnik(Sotrudniki idSotrudnik) {
        this.idSotrudnik = idSotrudnik;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idObuchenyaSotrudnika != null ? idObuchenyaSotrudnika.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Obuchenyesotrudnikov)) {
            return false;
        }
        Obuchenyesotrudnikov other = (Obuchenyesotrudnikov) object;
        if ((this.idObuchenyaSotrudnika == null && other.idObuchenyaSotrudnika != null) || (this.idObuchenyaSotrudnika != null && !this.idObuchenyaSotrudnika.equals(other.idObuchenyaSotrudnika))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.testapi2.entity.Obuchenyesotrudnikov[ idObuchenyaSotrudnika=" + idObuchenyaSotrudnika + " ]";
    }
    
}
