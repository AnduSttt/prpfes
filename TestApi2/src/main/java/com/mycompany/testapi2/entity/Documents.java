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
@Table(name = "documents")
@NamedQueries({
    @NamedQuery(name = "Documents.findAll", query = "SELECT d FROM Documents d"),
    @NamedQuery(name = "Documents.findById", query = "SELECT d FROM Documents d WHERE d.id = :id"),
    @NamedQuery(name = "Documents.findByTitle", query = "SELECT d FROM Documents d WHERE d.title = :title"),
    @NamedQuery(name = "Documents.findByDateCreated", query = "SELECT d FROM Documents d WHERE d.dateCreated = :dateCreated"),
    @NamedQuery(name = "Documents.findByDateUpdated", query = "SELECT d FROM Documents d WHERE d.dateUpdated = :dateUpdated"),
    @NamedQuery(name = "Documents.findByCategory", query = "SELECT d FROM Documents d WHERE d.category = :category"),
    @NamedQuery(name = "Documents.findByHasComments", query = "SELECT d FROM Documents d WHERE d.hasComments = :hasComments")})
public class Documents implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "title")
    private String title;
    @Column(name = "dateCreated")
    @Temporal(TemporalType.DATE)
    private Date dateCreated;
    @Column(name = "dateUpdated")
    @Temporal(TemporalType.DATE)
    private Date dateUpdated;
    @Column(name = "category")
    private String category;
    @Column(name = "hasComments")
    private Boolean hasComments;
    @OneToMany(mappedBy = "documentId")
    private Collection<Commentaries> commentariesCollection;

    public Documents() {
    }

    public Documents(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Boolean getHasComments() {
        return hasComments;
    }

    public void setHasComments(Boolean hasComments) {
        this.hasComments = hasComments;
    }

    public Collection<Commentaries> getCommentariesCollection() {
        return commentariesCollection;
    }

    public void setCommentariesCollection(Collection<Commentaries> commentariesCollection) {
        this.commentariesCollection = commentariesCollection;
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
        if (!(object instanceof Documents)) {
            return false;
        }
        Documents other = (Documents) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.testapi2.entity.Documents[ id=" + id + " ]";
    }
    
}
