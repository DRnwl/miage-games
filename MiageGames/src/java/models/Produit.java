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
@NamedQueries({
    @NamedQuery(name = "Produit.findAll", query = "SELECT p FROM Produit p"),
    @NamedQuery(name = "Produit.findById", query = "SELECT p FROM Produit p WHERE p.id = :id"),
    @NamedQuery(name = "Produit.findByNom", query = "SELECT p FROM Produit p WHERE p.nom = :nom"),
    @NamedQuery(name = "Produit.findByPrix", query = "SELECT p FROM Produit p WHERE p.prix = :prix"),
    @NamedQuery(name = "Produit.findByDistributeur", query = "SELECT p FROM Produit p WHERE p.Distributeur_id = :Distributeur_id"),
    @NamedQuery(name = "Produit.findByEditeur", query = "SELECT p FROM Produit p WHERE p.editeur = :editeur"),
    @NamedQuery(name = "Produit.findByDeveloppeur", query = "SELECT p FROM Produit p WHERE p.developpeur = :developpeur"),
    @NamedQuery(name = "Produit.findByCategorie", query = "SELECT p FROM Produit p WHERE p.Categorie_id = :Categorie_id")
})
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
    @ManyToOne(optional= false)
    private Distributeur distributeur;
    
    @Basic(optional = false)
    @Column(name = "tags")
    private ArrayList<String> tags;
    
    @Basic(optional = false)
    @Column(name = "developpeur")
    private String developpeur;
    
    @Basic(optional = false)
    @Column(name = "Editeur")
    private String Editeur;
    
    @JoinColumn(name = "CategorieAge_id", referencedColumnName = "id")
    @ManyToOne(optional= false)
    private CategorieAge categorieAge;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produit")
    private Collection<Commande_Produit> CollectionCommande_Produit;

    public Produit() {
    }

    public Produit(Integer id) {
        this.id = id;
    }

    public Produit(Integer id, String nom, BigDecimal prix, Categorie categorie, Distributeur distributeur, ArrayList<String> tags, String developpeur, String Editeur, CategorieAge categorieAge) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.categorie = categorie;
        this.distributeur = distributeur;
        this.tags = tags;
        this.developpeur = developpeur;
        this.Editeur = Editeur;
        this.categorieAge = categorieAge;
    }

    public String getEditeur() {
        return Editeur;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public CategorieAge getCategorieAge() {
        return categorieAge;
    }

    public String getDeveloppeur() {
        return developpeur;
    }

    public Distributeur getDistributeur() {
        return distributeur;
    }

    public Integer getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public BigDecimal getPrix() {
        return prix;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setEditeur(String Editeur) {
        this.Editeur = Editeur;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public void setCategorieAge(CategorieAge categorieAge) {
        this.categorieAge = categorieAge;
    }

    public void setDeveloppeur(String developpeur) {
        this.developpeur = developpeur;
    }

    public void setDistributeur(Distributeur distributeur) {
        this.distributeur = distributeur;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrix(BigDecimal prix) {
        this.prix = prix;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public Collection<Commande_Produit> getCollectionCommande_Produit() {
        return CollectionCommande_Produit;
    }

    public void setCollectionCommande_Produit(Collection<Commande_Produit> CollectionCommande_Produit) {
        this.CollectionCommande_Produit = CollectionCommande_Produit;
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
