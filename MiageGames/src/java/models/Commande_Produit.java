/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Pierro
 */
@Entity
@Table(name="Commande_Produit")
public class Commande_Produit implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    private Commande_ProduitPK commande_ProduitPk;
   

    @JoinColumn(name="client_Commande_id", referencedColumnName="id", insertable= false, updatable= false)
    @ManyToOne(optional = false)
    private Client_Commande client_commande;
    
    @JoinColumn(name="produit_id", referencedColumnName="id", insertable=false, updatable= false)
    @ManyToOne(optional = false)
    private Produit produit;
    
    @Basic(optional = false)
    @Column(name="quantite")
    private Integer quantite;

    public Commande_Produit() {
    }

    public Commande_Produit(Commande_ProduitPK commande_ProduitPk) {
        this.commande_ProduitPk = commande_ProduitPk;
    }

    public Commande_Produit(Commande_ProduitPK commande_ProduitPk, Integer quantite) {
        this.commande_ProduitPk = commande_ProduitPk;
        this.quantite = quantite;
    }

    public Commande_Produit(Client_Commande client_commande, Produit produit) {
        this.client_commande = client_commande;
        this.produit = produit;
    }

    public Client_Commande getClient_commande() {
        return client_commande;
    }

    public void setClient_commande(Client_Commande client_commande) {
        this.client_commande = client_commande;
    }

    public Commande_ProduitPK getCommande_ProduitPk() {
        return commande_ProduitPk;
    }

    public void setCommande_ProduitPk(Commande_ProduitPK commande_ProduitPk) {
        this.commande_ProduitPk = commande_ProduitPk;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (commande_ProduitPk != null ? commande_ProduitPk.hashCode() : 0);
        return hash;
    }

   
     @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Commande_Produit)) {
            return false;
        }
        Commande_Produit other = (Commande_Produit) object;
        if ((this.commande_ProduitPk == null && other.commande_ProduitPk != null) || (this.commande_ProduitPk != null && !this.commande_ProduitPk.equals(other.commande_ProduitPk))) {
            return false;
        }
        return true;
    }
    
     
     @Override
    public String toString() {
        return "entity.Commande_Produit[commande_ProduitPk=" + commande_ProduitPk + "]";
    }

   
    
}
