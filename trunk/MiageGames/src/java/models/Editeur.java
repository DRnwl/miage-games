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
@Table(name = "Editeur")
@NamedQueries({
    @NamedQuery(name = "Editeur.findAll", query = "SELECT c FROM Editeur c"),
    @NamedQuery(name = "Editeur.findById", query = "SELECT c FROM Editeur c WHERE c.id = :id"),
    @NamedQuery(name = "Editeur.findByNomEditeur", query = "SELECT c FROM Editeur c WHERE c.nomEditeur = :nomEditeur"),
    @NamedQuery(name = "Editeur.findBySiteEditeur", query = "SELECT c FROM Editeur c WHERE c.siteEditeur = :siteEditeur")
})
public class Editeur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @Column(name = "nomEditeur")
    private String nomEditeur;
    
    @Basic(optional = false)
    @Column(name = "siteEditeur")
    private String siteEditeur;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "editeur")
    private Collection<Produit> collectionProduit;

    public Editeur() {
    }

    public Editeur(Integer id) {
        this.id = id;
    }

    public Editeur(Integer id, String nomEditeur, String siteEditeur, Collection<Produit> collectionProduit) {
        this.id = id;
        this.nomEditeur = nomEditeur;
        this.siteEditeur = siteEditeur;
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

    public String getNomEditeur() {
        return nomEditeur;
    }

    public void setNomEditeur(String nomEditeur) {
        this.nomEditeur = nomEditeur;
    }

    public String getSiteEditeur() {
        return siteEditeur;
    }

    public void setSiteEditeur(String siteEditeur) {
        this.siteEditeur = siteEditeur;
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
        if (!(object instanceof Editeur)) {
            return false;
        }
        Editeur other = (Editeur) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Editeur[ id=" + id + " ]";
    }
}
