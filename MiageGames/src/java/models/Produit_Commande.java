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
@Table(name="Produit_Commande")
@NamedQueries({
    @NamedQuery(name = "Produit_Commande.findAll", query = "SELECT o FROM Produit_Commande o"),
    
    @NamedQuery(name = "Produit_Commande.findByClientCommandeId", query = "SELECT o FROM Produit_Commande o WHERE o.commande_ProduitPk.commandeClientId = :commandeClientId"), 
    
    @NamedQuery(name = "Produit_Commande.findByProduitId", query = "SELECT o FROM Produit_Commande o WHERE o.commande_ProduitPk.produitId = :produitId"),  
    
    @NamedQuery(name = "Produit_Commande.findByquantite", query = "SELECT o FROM Produit_Commande o WHERE o.quantite = :quantite")
})
public class Produit_Commande implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    private Produit_CommandePK commande_ProduitPk;
   

    @JoinColumn(name="commande_client_id", referencedColumnName="id", insertable= false, updatable= false)
    @ManyToOne(optional = false)
    private Commande_Client commande_client;
    
    @JoinColumn(name="produit_id", referencedColumnName="id", insertable=false, updatable= false)
    @ManyToOne(optional = false)
    private Produit produit;
    
    @Basic(optional = false)
    @Column(name="quantite")
    private Integer quantite;

    public Produit_Commande() {
    }

    public Produit_Commande(Produit_CommandePK commande_ProduitPk) {
        this.commande_ProduitPk = commande_ProduitPk;
    }

    public Produit_Commande(Produit_CommandePK commande_ProduitPk, Integer quantite) {
        this.commande_ProduitPk = commande_ProduitPk;
        this.quantite = quantite;
    }

    public Produit_Commande(Commande_Client client_commande, Produit produit) {
        this.commande_client = client_commande;
        this.produit = produit;
    }

    public Commande_Client getClient_commande() {
        return commande_client;
    }

    public void setClient_commande(Commande_Client client_commande) {
        this.commande_client = client_commande;
    }

    public Produit_CommandePK getCommande_ProduitPk() {
        return commande_ProduitPk;
    }

    public void setCommande_ProduitPk(Produit_CommandePK commande_ProduitPk) {
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
        if (!(object instanceof Produit_Commande)) {
            return false;
        }
        Produit_Commande other = (Produit_Commande) object;
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
