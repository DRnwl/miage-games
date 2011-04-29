/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Sangre
 */
@Entity
@Table(name = "distributeur")
@NamedQueries({
    @NamedQuery(name = "Distributeur.findAll", query = "SELECT d FROM Distributeur d"),
    @NamedQuery(name = "Distributeur.findById", query = "SELECT d FROM Distributeur d WHERE d.id = :id"),
    @NamedQuery(name = "Distributeur.findByName", query = "SELECT d FROM Distributeur d WHERE d.nom_distributeur = :nom_distributeur")})
public class Distributeur implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;

    @Basic(optional = false)
    @Column(name = "nom_distributeur")
    private String nomDistributeur;
    
    @Basic(optional = false)
    @Column(name = "site_distributeur")
    private String siteDistributeur;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "distributeur")
    private Collection<Produit> collectionProduit;

    public Distributeur() {
    }

    public Distributeur(Integer id, String nomDistributeur) {
        this.id = id;
        this.nomDistributeur = nomDistributeur;
    }

    public Distributeur(Integer id, String nomDistributeur, String siteDistributeur) {
        this.id = id;
        this.nomDistributeur = nomDistributeur;
        this.siteDistributeur = siteDistributeur;
    }
    
    public String getNomDistributeur() {
        return nomDistributeur;
    }

    public void setNomDistributeur(String nomDistributeur) {
        this.nomDistributeur = nomDistributeur;
    }

    public String getSiteDistributeur() {
        return siteDistributeur;
    }

    public void setSiteDistributeur(String siteDistributeur) {
        this.siteDistributeur = siteDistributeur;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Distributeur)) {
            return false;
        }
        Distributeur other = (Distributeur) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Distributeur[ id=" + id + " ]";
    }
    
}
