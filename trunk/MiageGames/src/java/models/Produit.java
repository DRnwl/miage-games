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
    @NamedQuery(name = "Produit.findBySortie", query = "SELECT p FROM Produit p WHERE p.sortie = :sortie"),
    @NamedQuery(name = "Produit.findByDescription", query = "SELECT p FROM Produit p WHERE p.description = :description"),
    @NamedQuery(name = "Produit.findByImage", query = "SELECT p FROM Produit p WHERE p.image = :image"),
    @NamedQuery(name = "Produit.findByQuantiteProduit", query = "SELECT p FROM Produit p WHERE p.quantiteProduit = :quantiteProduit")

    
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
    private Double prix;
    
    // categorie_id reference la cle primaire "id" de la table "Categorie"
    @JoinColumn(name = "categorie_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Categorie categorie;
    
    @JoinColumn(name = "distributeur_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Distributeur distributeur;
    
    @Basic(optional = false)
    @Column(name = "tags")
    private ArrayList<String> tags;
    
    @Basic(optional = false)
    @Column(name = "sortie")
    private String sortie;
    
    @Basic(optional = false)
    @Column(name = "image")
    private String image;
    
    @Basic(optional = false)
    @Column(name = "video")
    private String video;
    
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    
    @Basic(optional = false)
    @Column(name = "quantiteProduit")
    private int quantiteProduit;
    
    
    @JoinColumn(name = "categorieAge_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CategorieAge categorieAge;
    
    @JoinColumn(name = "editeur_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Editeur editeur;
    
    @JoinColumn(name = "developpeur_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Developpeur developpeur;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produit")
    private Collection<Produit_Commande> collectionProduitCommande;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produit")
    private Collection<Commande> collectionCommande;

    public Produit() {
    }

    public Produit(String nom, Double prix, Categorie categorie, String image, CategorieAge categorieAge, String sortie, Developpeur developpeur, Editeur editeur) {
        this.nom = nom;
        this.prix = prix;
        this.categorie = categorie;
        this.image = image;
        categorie.getCollectionProduit().add(this);
        collectionProduitCommande = new ArrayList<Produit_Commande>();
        this.categorieAge = categorieAge;
        categorieAge.getCollectionProduit().add(this);
        this.sortie = sortie;
        this.developpeur = developpeur;
        developpeur.getCollectionProduit().add(this);
        this.editeur = editeur;
        editeur.getCollectionProduit().add(this);
        collectionCommande = new ArrayList<Commande>();
    }
    
    
    public Produit(String nom, Double prix, Categorie categorie, String image, CategorieAge categorieAge, String sortie, Developpeur developpeur, Editeur editeur, int quantiteProduit) {
        this.nom = nom;
        this.prix = prix;
        this.categorie = categorie;
        this.image = image;
        categorie.getCollectionProduit().add(this);
        collectionProduitCommande = new ArrayList<Produit_Commande>();
        this.categorieAge = categorieAge;
        categorieAge.getCollectionProduit().add(this);
        this.sortie = sortie;
        this.developpeur = developpeur;
        developpeur.getCollectionProduit().add(this);
        this.editeur = editeur;
        editeur.getCollectionProduit().add(this);
        collectionCommande = new ArrayList<Commande>();
        this.quantiteProduit = quantiteProduit;
    }
    
    
    
    // constructeur avec video
    
     public Produit(String nom, Double prix, Categorie categorie, String image, CategorieAge categorieAge, String sortie, Developpeur developpeur, Editeur editeur, int quantiteProduit, String video) {
        this.nom = nom;
        this.prix = prix;
        this.categorie = categorie;
        this.image = image;
        categorie.getCollectionProduit().add(this);
        collectionProduitCommande = new ArrayList<Produit_Commande>();
        this.categorieAge = categorieAge;
        categorieAge.getCollectionProduit().add(this);
        this.sortie = sortie;
        this.developpeur = developpeur;
        developpeur.getCollectionProduit().add(this);
        this.editeur = editeur;
        editeur.getCollectionProduit().add(this);
        collectionCommande = new ArrayList<Commande>();
        this.quantiteProduit = quantiteProduit;
        this.video = video;
    }
     
     
     // constructeur avec description
      public Produit(String nom, Double prix, Categorie categorie, String image, CategorieAge categorieAge, String sortie, Developpeur developpeur, Editeur editeur, int quantiteProduit, String video,String description) {
        this.nom = nom;
        this.prix = prix;
        this.categorie = categorie;
        this.image = image;
        categorie.getCollectionProduit().add(this);
        collectionProduitCommande = new ArrayList<Produit_Commande>();
        this.categorieAge = categorieAge;
        categorieAge.getCollectionProduit().add(this);
        this.sortie = sortie;
        this.developpeur = developpeur;
        developpeur.getCollectionProduit().add(this);
        this.editeur = editeur;
        editeur.getCollectionProduit().add(this);
        collectionCommande = new ArrayList<Commande>();
        this.quantiteProduit = quantiteProduit;
        this.video = video;
        this.description = description;
    }
     
    
    

    public Produit(String nom, Double prix, Categorie categorie, CategorieAge categorieAge) {
        this.nom = nom;
        this.prix = prix;
        this.categorie = categorie;
        this.categorieAge = categorieAge;
        collectionProduitCommande = new ArrayList<Produit_Commande>();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }
    
    
    
    
    

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public int getQuantiteProduit() {
        return quantiteProduit;
    }

    public void setQuantiteProduit(int quantiteProduit) {
        this.quantiteProduit = quantiteProduit;
    }

    
    
    
    

    public Collection<Produit_Commande> getCollectionProduitCommande() {
        return collectionProduitCommande;
    }

    public void setCollectionProduitCommande(Collection<Produit_Commande> CollectionProduitCommande) {
        this.collectionProduitCommande = CollectionProduitCommande;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Collection<Commande> getCollectionCommande() {
        return collectionCommande;
    }

    public void setCollectionCommande(Collection<Commande> collectionCommande) {
        this.collectionCommande = collectionCommande;
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
