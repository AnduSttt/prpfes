/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testapi2.entity;

import com.fasterxml.jackson.annotation.JsonGetter;
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
@Table(name = "sotrudniki")
@NamedQueries({
    @NamedQuery(name = "Sotrudniki.findAll", query = "SELECT s FROM Sotrudniki s"),
    @NamedQuery(name = "Sotrudniki.findByIdSotridnik", query = "SELECT s FROM Sotrudniki s WHERE s.idSotridnik = :idSotridnik"),
    @NamedQuery(name = "Sotrudniki.findByFamiliya", query = "SELECT s FROM Sotrudniki s WHERE s.familiya = :familiya"),
    @NamedQuery(name = "Sotrudniki.findByImya", query = "SELECT s FROM Sotrudniki s WHERE s.imya = :imya"),
    @NamedQuery(name = "Sotrudniki.findByOtchestvo", query = "SELECT s FROM Sotrudniki s WHERE s.otchestvo = :otchestvo"),
    @NamedQuery(name = "Sotrudniki.findByWorkNomer", query = "SELECT s FROM Sotrudniki s WHERE s.workNomer = :workNomer"),
    @NamedQuery(name = "Sotrudniki.findByPersolalNomer", query = "SELECT s FROM Sotrudniki s WHERE s.persolalNomer = :persolalNomer"),
    @NamedQuery(name = "Sotrudniki.findByCabinet", query = "SELECT s FROM Sotrudniki s WHERE s.cabinet = :cabinet"),
    @NamedQuery(name = "Sotrudniki.findByCorporatEmail", query = "SELECT s FROM Sotrudniki s WHERE s.corporatEmail = :corporatEmail"),
    @NamedQuery(name = "Sotrudniki.findByDenRoshdeniya", query = "SELECT s FROM Sotrudniki s WHERE s.denRoshdeniya = :denRoshdeniya"),
    @NamedQuery(name = "Sotrudniki.findByOpisaniye", query = "SELECT s FROM Sotrudniki s WHERE s.opisaniye = :opisaniye"),
    @NamedQuery(name = "Sotrudniki.findByPassword", query = "SELECT s FROM Sotrudniki s WHERE s.password = :password"),
    @NamedQuery(name = "Sotrudniki.findByLogin", query = "SELECT s FROM Sotrudniki s WHERE s.login = :login")})
public class Sotrudniki implements Serializable { 

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idSotridnik")
    private Integer idSotridnik;
    @Column(name = "familiya")
    private String familiya;
    @Column(name = "imya")
    private String imya;
    @Column(name = "otchestvo")
    private String otchestvo;
    @Column(name = "workNomer")
    private String workNomer;
    @Column(name = "persolalNomer")
    private String persolalNomer;
    @Column(name = "cabinet")
    private String cabinet;
    @Column(name = "corporatEmail")
    private String corporatEmail;
    @Column(name = "denRoshdeniya")
    @Temporal(TemporalType.DATE)
    private Date denRoshdeniya;
    @Column(name = "opisaniye")
    private String opisaniye;
    @Column(name = "password")
    private String password;
    @Column(name = "login")
    private String login;
    @OneToMany(mappedBy = "author")
    private Collection<Commentaries> commentariesCollection;
    @OneToMany(mappedBy = "idSotrudnika")
    private Collection<Otpuski> otpuskiCollection;
    @OneToMany(mappedBy = "idSotrudnikaZamestil")
    private Collection<Otpuski> otpuskiCollection1;
    @OneToMany(mappedBy = "idSotrudnik")
    private Collection<Sotrudnikworkingcalendar> sotrudnikworkingcalendarCollection;
    @OneToMany(mappedBy = "idSotrudnikOtvetstvenen")
    private Collection<Meropriyatiya> meropriyatiyaCollection;
    @OneToMany(mappedBy = "idSotrudnika")
    private Collection<Otguli> otguliCollection;
    @OneToMany(mappedBy = "idSotrudnikaZamestil")
    private Collection<Otguli> otguliCollection1;
    @OneToMany(mappedBy = "idSotrudnik")
    private Collection<Obuchenyesotrudnikov> obuchenyesotrudnikovCollection;
    @OneToMany(mappedBy = "idSotrudnika")
    private Collection<Otsutstiya> otsutstiyaCollection;
    @OneToMany(mappedBy = "idSotrudnikaZamestil")
    private Collection<Otsutstiya> otsutstiyaCollection1;
    @OneToMany(mappedBy = "iaSotrudnikAutor")
    private Collection<Materials> materialsCollection;
    @JsonIgnore
    @JoinColumn(name = "idDolshnost", referencedColumnName = "idDolshnost")
    @ManyToOne
    private Dolshnosti idDolshnost;
    @JsonIgnore
    @JoinColumn(name = "idPodrazd", referencedColumnName = "idPodrazdelenie")
    @ManyToOne
    private Padrazdeleniya idPodrazd;
    @OneToMany(mappedBy = "idSotrudnika")
    private Collection<Kamandirovki> kamandirovkiCollection;

    public Sotrudniki() {
    }

    @JsonGetter("idDolshnost")
    public int idDolshnost(){
        return idDolshnost.getIdDolshnost();
    }

    public Sotrudniki(Integer idSotridnik) {
        this.idSotridnik = idSotridnik;
    }

    public Integer getIdSotridnik() {
        return idSotridnik;
    }

    public void setIdSotridnik(Integer idSotridnik) {
        this.idSotridnik = idSotridnik;
    }

    public String getFamiliya() {
        return familiya;
    }

    public void setFamiliya(String familiya) {
        this.familiya = familiya;
    }

    public String getImya() {
        return imya;
    }

    public void setImya(String imya) {
        this.imya = imya;
    }

    public String getOtchestvo() {
        return otchestvo;
    }

    public void setOtchestvo(String otchestvo) {
        this.otchestvo = otchestvo;
    }

    public String getWorkNomer() {
        return workNomer;
    }

    public void setWorkNomer(String workNomer) {
        this.workNomer = workNomer;
    }

    public String getPersolalNomer() {
        return persolalNomer;
    }

    public void setPersolalNomer(String persolalNomer) {
        this.persolalNomer = persolalNomer;
    }

    public String getCabinet() {
        return cabinet;
    }

    public void setCabinet(String cabinet) {
        this.cabinet = cabinet;
    }

    public String getCorporatEmail() {
        return corporatEmail;
    }

    public void setCorporatEmail(String corporatEmail) {
        this.corporatEmail = corporatEmail;
    }

    public Date getDenRoshdeniya() {
        return denRoshdeniya;
    }

    public void setDenRoshdeniya(Date denRoshdeniya) {
        this.denRoshdeniya = denRoshdeniya;
    }

    public String getOpisaniye() {
        return opisaniye;
    }

    public void setOpisaniye(String opisaniye) {
        this.opisaniye = opisaniye;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Collection<Commentaries> getCommentariesCollection() {
        return commentariesCollection;
    }

    public void setCommentariesCollection(Collection<Commentaries> commentariesCollection) {
        this.commentariesCollection = commentariesCollection;
    }

    public Collection<Otpuski> getOtpuskiCollection() {
        return otpuskiCollection;
    }

    public void setOtpuskiCollection(Collection<Otpuski> otpuskiCollection) {
        this.otpuskiCollection = otpuskiCollection;
    }

    public Collection<Otpuski> getOtpuskiCollection1() {
        return otpuskiCollection1;
    }

    public void setOtpuskiCollection1(Collection<Otpuski> otpuskiCollection1) {
        this.otpuskiCollection1 = otpuskiCollection1;
    }

    public Collection<Sotrudnikworkingcalendar> getSotrudnikworkingcalendarCollection() {
        return sotrudnikworkingcalendarCollection;
    }

    public void setSotrudnikworkingcalendarCollection(Collection<Sotrudnikworkingcalendar> sotrudnikworkingcalendarCollection) {
        this.sotrudnikworkingcalendarCollection = sotrudnikworkingcalendarCollection;
    }

    public Collection<Meropriyatiya> getMeropriyatiyaCollection() {
        return meropriyatiyaCollection;
    }

    public void setMeropriyatiyaCollection(Collection<Meropriyatiya> meropriyatiyaCollection) {
        this.meropriyatiyaCollection = meropriyatiyaCollection;
    }

    public Collection<Otguli> getOtguliCollection() {
        return otguliCollection;
    }

    public void setOtguliCollection(Collection<Otguli> otguliCollection) {
        this.otguliCollection = otguliCollection;
    }

    public Collection<Otguli> getOtguliCollection1() {
        return otguliCollection1;
    }

    public void setOtguliCollection1(Collection<Otguli> otguliCollection1) {
        this.otguliCollection1 = otguliCollection1;
    }

    public Collection<Obuchenyesotrudnikov> getObuchenyesotrudnikovCollection() {
        return obuchenyesotrudnikovCollection;
    }

    public void setObuchenyesotrudnikovCollection(Collection<Obuchenyesotrudnikov> obuchenyesotrudnikovCollection) {
        this.obuchenyesotrudnikovCollection = obuchenyesotrudnikovCollection;
    }

    public Collection<Otsutstiya> getOtsutstiyaCollection() {
        return otsutstiyaCollection;
    }

    public void setOtsutstiyaCollection(Collection<Otsutstiya> otsutstiyaCollection) {
        this.otsutstiyaCollection = otsutstiyaCollection;
    }

    public Collection<Otsutstiya> getOtsutstiyaCollection1() {
        return otsutstiyaCollection1;
    }

    public void setOtsutstiyaCollection1(Collection<Otsutstiya> otsutstiyaCollection1) {
        this.otsutstiyaCollection1 = otsutstiyaCollection1;
    }

    public Collection<Materials> getMaterialsCollection() {
        return materialsCollection;
    }

    public void setMaterialsCollection(Collection<Materials> materialsCollection) {
        this.materialsCollection = materialsCollection;
    }

    public Dolshnosti getIdDolshnost() {
        return idDolshnost;
    }

    public void setIdDolshnost(Dolshnosti idDolshnost) {
        this.idDolshnost = idDolshnost;
    }

    public Padrazdeleniya getIdPodrazd() {
        return idPodrazd;
    }

    public void setIdPodrazd(Padrazdeleniya idPodrazd) {
        this.idPodrazd = idPodrazd;
    }

    public Collection<Kamandirovki> getKamandirovkiCollection() {
        return kamandirovkiCollection;
    }

    public void setKamandirovkiCollection(Collection<Kamandirovki> kamandirovkiCollection) {
        this.kamandirovkiCollection = kamandirovkiCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSotridnik != null ? idSotridnik.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sotrudniki)) {
            return false;
        }
        Sotrudniki other = (Sotrudniki) object;
        if ((this.idSotridnik == null && other.idSotridnik != null) || (this.idSotridnik != null && !this.idSotridnik.equals(other.idSotridnik))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.testapi2.entity.Sotrudniki[ idSotridnik=" + idSotridnik + " ]";
    }

}
