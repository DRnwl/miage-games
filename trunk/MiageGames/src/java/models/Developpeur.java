/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;

/**
 *
 * @author Pierro
 */
@Entity
@Table(name = "Developpeur")

public class Developpeur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @Column(name = "nomDeveloppeur")
    private String nomDeveloppeur;
    
    @Basic(optional = false)
    @Column(name = "siteDeveloppeur")
    private String siteDeveloppeur;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "developpeur")
    private Collection<Produit> collectionProduit;

    public Developpeur() {
    }

    public Developpeur(Integer id, String nomDeveloppeur, String siteDeveloppeur, Collection<Produit> collectionProduit) {
        this.id = id;
        this.nomDeveloppeur = nomDeveloppeur;
        this.siteDeveloppeur = siteDeveloppeur;
        this.collectionProduit = collectionProduit;
    }

    public Collection<Produit> getCollectionProduit() {
        return collectionProduit;
    }

    public void setCollectionProduit(Collection<Produit> collectionProduit) {
        this.collectionProduit = collectionProduit;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomDeveloppeur() {
        return nomDeveloppeur;
    }

    public void setNomDeveloppeur(String nomDeveloppeur) {
        this.nomDeveloppeur = nomDeveloppeur;
    }

    public String getSiteDeveloppeur() {
        return siteDeveloppeur;
    }

    public void setSiteDeveloppeur(String siteDeveloppeur) {
        this.siteDeveloppeur = siteDeveloppeur;
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
        if (!(object instanceof Developpeur)) {
            return false;
        }
        Developpeur other = (Developpeur) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Developpeur[ id=" + id + " ]";
    }
}
