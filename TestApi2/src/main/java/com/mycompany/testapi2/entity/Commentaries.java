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
@Table(name = "commentaries")
@NamedQueries({
    @NamedQuery(name = "Commentaries.findAll", query = "SELECT c FROM Commentaries c"),
    @NamedQuery(name = "Commentaries.findById", query = "SELECT c FROM Commentaries c WHERE c.id = :id"),
    @NamedQuery(name = "Commentaries.findByDateCreated", query = "SELECT c FROM Commentaries c WHERE c.dateCreated = :dateCreated"),
    @NamedQuery(name = "Commentaries.findByDateUpdated", query = "SELECT c FROM Commentaries c WHERE c.dateUpdated = :dateUpdated"),
    @NamedQuery(name = "Commentaries.findByText", query = "SELECT c FROM Commentaries c WHERE c.text = :text")})
public class Commentaries implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "dateCreated")
    @Temporal(TemporalType.DATE)
    private Date dateCreated;
    @Column(name = "dateUpdated")
    @Temporal(TemporalType.DATE)
    private Date dateUpdated;
    @Column(name = "text")
    private String text;
    @JsonIgnore
    @JoinColumn(name = "documentId", referencedColumnName = "id")
    @ManyToOne
    private Documents documentId;
    @JsonIgnore
    @JoinColumn(name = "author", referencedColumnName = "idSotridnik")
    @ManyToOne
    private Sotrudniki author;

    public Commentaries() {
    }

    public Commentaries(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Documents getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Documents documentId) {
        this.documentId = documentId;
    }

    public Sotrudniki getAuthor() {
        return author;
    }

    public void setAuthor(Sotrudniki author) {
        this.author = author;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Commentaries)) {
            return false;
        }
        Commentaries other = (Commentaries) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.testapi2.entity.Commentaries[ id=" + id + " ]";
    }
    
}
