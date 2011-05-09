/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.*;

/**
 *
 * @author Pierro
 */
@Entity
@Table(name = "Produit")
public class Produit implements Serializable {

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
    @Column(name = "prix")
    private BigDecimal prix;
    // Categorie_id reference la cle primaire "id" de la table "Categorie"
    @JoinColumn(name = "Categorie_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Categorie categorie;
    @JoinColumn(name = "Distributeur_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Distributeur distributeur;
    @Basic(optional = false)
    @Column(name = "tags")
    private ArrayList<String> tags;
    @Basic(optional = false)
    @Column(name = "sortie")
    private String sortie;
    @JoinColumn(name = "CategorieAge_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CategorieAge categorieAge;
    @JoinColumn(name = "Editeur_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Editeur editeur;
    @JoinColumn(name = "Developpeur_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Developpeur developpeur;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produit")
    private Collection<Commande_Produit> CollectionCommande_Produit;

    public Produit() {
    }

    public Produit(Integer id) {
        this.id = id;
    }

    public Produit(Integer id, String nom, BigDecimal prix, Categorie categorie, Distributeur distributeur, ArrayList<String> tags, String sortie, CategorieAge categorieAge, Editeur editeur, Developpeur developpeur, Collection<Commande_Produit> CollectionCommande_Produit) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.categorie = categorie;
        this.distributeur = distributeur;
        this.tags = tags;
        this.sortie = sortie;
        this.categorieAge = categorieAge;
        this.editeur = editeur;
        this.developpeur = developpeur;
        this.CollectionCommande_Produit = CollectionCommande_Produit;
    }

    public Collection<Commande_Produit> getCollectionCommande_Produit() {
        return CollectionCommande_Produit;
    }

    public void setCollectionCommande_Produit(Collection<Commande_Produit> CollectionCommande_Produit) {
        this.CollectionCommande_Produit = CollectionCommande_Produit;
    }

    public String getSortie() {
        return sortie;
    }

    public void setSortie(String sortie) {
        this.sortie = sortie;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public CategorieAge getCategorieAge() {
        return categorieAge;
    }

    public void setCategorieAge(CategorieAge categorieAge) {
        this.categorieAge = categorieAge;
    }

    public Developpeur getDeveloppeur() {
        return developpeur;
    }

    public void setDeveloppeur(Developpeur developpeur) {
        this.developpeur = developpeur;
    }

    public Distributeur getDistributeur() {
        return distributeur;
    }

    public void setDistributeur(Distributeur distributeur) {
        this.distributeur = distributeur;
    }

    public Editeur getEditeur() {
        return editeur;
    }

    public void setEditeur(Editeur editeur) {
        this.editeur = editeur;
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

    public BigDecimal getPrix() {
        return prix;
    }

    public void setPrix(BigDecimal prix) {
        this.prix = prix;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
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
        if (!(object instanceof Produit)) {
            return false;
        }
        Produit other = (Produit) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Produit[ id=" + id + " ]";
    }
}
