/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.*;


/**
 *
 * @author Sangre
 */
@Entity
@Table(name = "CategorieAge")

@NamedQueries({
    @NamedQuery(name = "CategorieAge.findAll", query = "SELECT c FROM CategorieAge c"),
    
    @NamedQuery(name = "CategorieAge.findById", query = "SELECT c FROM CategorieAge c WHERE c.id = :id"),
    
    @NamedQuery(name = "CategorieAge.findByDescription", query = "SELECT c FROM CategorieAge c WHERE c.description = :description"),
    
    @NamedQuery(name = "CategorieAge.findByNom", query = "SELECT c FROM CategorieAge c WHERE c.nom = :nom"),
    
    @NamedQuery(name = "CategorieAge.findByNomImage", query = "SELECT c FROM CategorieAge c WHERE c.nomImage = :nomImage")
})
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
    @Column(name = "nomImage")
    private String nomImage;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categorieAge")
    private Collection<Produit> collectionProduit;
    

    public CategorieAge() {
    }

    public CategorieAge(String nom, String nomImage) {
        this.nom = nom;
        this.nomImage = nomImage;
        collectionProduit = new ArrayList<Produit>();
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

    public Collection<Produit> getCollectionProduit() {
        return collectionProduit;
    }

    public void setCollectionProduit(Collection<Produit> collectionProduit) {
        this.collectionProduit = collectionProduit;
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
