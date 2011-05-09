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
public class Commande_ProduitPK implements Serializable {
    private static final long serialVersionUID = 1L;
   
    @Basic(optional = false)
    @Column(name = "client_Commande_id")
    private int client_Commande_id;
    
    @Basic(optional = false)
    @Column(name = "produit_id")
    private int produit_id;

    public Commande_ProduitPK() {
    }

    public Commande_ProduitPK(int client_Commande_id, int produit_id) {
        this.client_Commande_id = client_Commande_id;
        this.produit_id = produit_id;
    }

    public int getClient_Commande_id() {
        return client_Commande_id;
    }

    public void setClient_Commande_id(int client_Commande_id) {
        this.client_Commande_id = client_Commande_id;
    }

    public int getProduit_id() {
        return produit_id;
    }

    public void setProduit_id(int produit_id) {
        this.produit_id = produit_id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) client_Commande_id;
        hash += (int) produit_id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Commande_ProduitPK)) {
            return false;
        }
        Commande_ProduitPK other = (Commande_ProduitPK) object;
        if (this.client_Commande_id != other.client_Commande_id) {
            return false;
        }
        if (this.produit_id != other.produit_id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Commande_ProduitPK[client_Commande_id=" + client_Commande_id + ", produit_id=" + produit_id + "]";
    }
    
    
    
    
}
