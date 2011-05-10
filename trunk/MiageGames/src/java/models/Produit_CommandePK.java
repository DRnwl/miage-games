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
@Embeddable
public class Produit_CommandePK implements Serializable {
    private static final long serialVersionUID = 1L;
   
    @Basic(optional = false)
    @Column(name = "commande_client_id")
    private int commandeClientId;
    
    @Basic(optional = false)
    @Column(name = "produit_id")
    private int produitId;

    public Produit_CommandePK() {
    }

    public Produit_CommandePK(int client_Commande_id, int produit_id) {
        this.commandeClientId = client_Commande_id;
        this.produitId = produit_id;
    }

    public int getClient_Commande_id() {
        return commandeClientId;
    }

    public void setClient_Commande_id(int client_Commande_id) {
        this.commandeClientId = client_Commande_id;
    }

    public int getProduit_id() {
        return produitId;
    }

    public void setProduit_id(int produit_id) {
        this.produitId = produit_id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) commandeClientId;
        hash += (int) produitId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produit_CommandePK)) {
            return false;
        }
        Produit_CommandePK other = (Produit_CommandePK) object;
        if (this.commandeClientId != other.commandeClientId) {
            return false;
        }
        if (this.produitId != other.produitId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Commande_ProduitPK[client_Commande_id=" + commandeClientId + ", produit_id=" + produitId + "]";
    }
    
    
    
    
}
