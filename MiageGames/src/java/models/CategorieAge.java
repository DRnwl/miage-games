/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Sangre
 */
@Entity
@Table(name = "categorie_age")
@NamedQueries({
    @NamedQuery(name = "Categorie_age.findAll", query = "SELECT c FROM Categorie_age c"),
    @NamedQuery(name = "Categorie_age.findById", query = "SELECT c FROM Categorie_age c WHERE c.id = :id")})
public class CategorieAge implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @Column(name = "nom")
    private String nom;
    
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    
    
    @Basic(optional = false)
    @Column(name = "nom_image")
    private String nomImage;

    public CategorieAge() {
    }

    public CategorieAge(Integer id) {
        this.id = id;
    }

    public CategorieAge(Integer id, String nom, String description, String nomImage) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.nomImage = nomImage;
    }

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNomImage() {
        return nomImage;
    }

    public void setNomImage(String nomImage) {
        this.nomImage = nomImage;
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
        if (!(object instanceof CategorieAge)) {
            return false;
        }
        CategorieAge other = (CategorieAge) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.CategorieAge[ id=" + id + " ]";
    }
    
}
