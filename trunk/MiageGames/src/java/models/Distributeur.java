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
@Table(name = "Distributeur")

@NamedQueries({
    @NamedQuery(name = "Distributeur.findAll", query = "SELECT d FROM Distributeur d"),
    
    @NamedQuery(name = "Distributeur.findById", query = "SELECT d FROM Distributeur d WHERE d.id = :id"),
    
    @NamedQuery(name = "Distributeur.findByNom_distributeur", query = "SELECT d FROM Distributeur d WHERE d.nom_distributeur = :nom_distributeur"),
    
    @NamedQuery(name = "Distributeur.findBySite_distributeur", query = "SELECT d FROM Distributeur d WHERE d.site_distributeur = :site_distributeur")
})

public class Distributeur implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @Column(name = "nom_distributeur")
    private String nom_distributeur;
    
    @Basic(optional = false)
    @Column(name = "site_distributeur")
    private String site_distributeur;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "distributeur")
    private Collection<Produit> collectionProduit;

    public Distributeur() {
    }

    public Distributeur(String nom_distributeur, String site_distributeur) {
        this.nom_distributeur = nom_distributeur;
        this.site_distributeur = site_distributeur;
        collectionProduit = new ArrayList<Produit>();
    }

    public Distributeur(String nom_distributeur) {
        this.nom_distributeur = nom_distributeur;
        collectionProduit = new ArrayList<Produit>();
    }
    
    public Distributeur(String nom_distributeur, String site_distributeur, Produit produit) {
        this.nom_distributeur = nom_distributeur;
        this.site_distributeur = site_distributeur;
        collectionProduit = new ArrayList<Produit>();
        collectionProduit.add(produit);
    }
   

    

    public Collection<Produit> getCollectionProduit() {
        return collectionProduit;
    }

    public Integer getId() {
        return id;
    }

    public String getNom_distributeur() {
        return nom_distributeur;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getSite_distributeur() {
        return site_distributeur;
    }

    public void setCollectionProduit(Collection<Produit> collectionProduit) {
        this.collectionProduit = collectionProduit;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNom_distributeur(String nom_distributeur) {
        this.nom_distributeur = nom_distributeur;
    }

    public void setSite_distributeur(String site_distributeur) {
        this.site_distributeur = site_distributeur;
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
