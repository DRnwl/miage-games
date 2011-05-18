/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package panier;

import models.Produit;

/**
 *
 * @author Pierro
 */
public class ElementPanier {
    
    
    private Produit produit;
    private int quantiteCommande;

    public ElementPanier(Produit produit) {
        this.produit = produit;
        quantiteCommande = 1;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public int getQuantiteCommande() {
        return quantiteCommande;
    }

    public void setQuantiteCommande(int quantiteCommande) {
        this.quantiteCommande = quantiteCommande;
    }
    
    
    public void incrementerQuantiteCommande() {
        quantiteCommande++;
    }

    public void decrementQuantiteCommande() {
        quantiteCommande--;
    }

    public double getTotal() {
        double total = 0;
        total = (this.getQuantiteCommande() * produit.getPrix().doubleValue());
        return total;
    }
    
    
    
}
