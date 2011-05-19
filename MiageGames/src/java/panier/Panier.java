/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package panier;

import java.util.ArrayList;
import java.util.List;
import models.Produit;

/**
 *
 * @author Pierro
 */
public class Panier {
    
    List<ElementPanier> listeElementPanier;
    int nombreElements;
    double total;

    public Panier() {
        
        listeElementPanier = new ArrayList<ElementPanier>();
        nombreElements = 0;
        total = 0;
    }
    
    
    
    
    
    
    // ajout d'un ElementPanier dans le panier
    // si le produit existe on incremente seulement sa quantiteCommande
    
    
    public synchronized void ajouterProduit(Produit produit) {

        boolean nouvoElement = true;
        
        
        // produit existe deja dans le panier, on incremente sa quantiteCommande
        for (ElementPanier elementPanier : listeElementPanier) {

            if (elementPanier.getProduit().getNom().equals(produit.getNom())   
                    && elementPanier.getProduit().getCategorie().getNom().equals(produit.getCategorie().getNom())) {

                nouvoElement = false;
                elementPanier.incrementerQuantiteCommande();
            }
        }

        // cas ou c'est un nouvo produit que l'on veut mettre au panier
        if (nouvoElement) {
            ElementPanier elementPanier = new ElementPanier(produit);
            listeElementPanier.add(elementPanier);
        }
    }
    
    
    
    public synchronized void miseAjour(Produit produit, String quantite) {

        int qty = -1;
        qty = Integer.valueOf(quantite);
        if (qty >= 0) {

            ElementPanier elementPanier = null;

            for (ElementPanier scItem : listeElementPanier) {
                
                // on cherche le produit en question par son nom et categorie
                if (scItem.getProduit().getNom().equals(produit.getNom())
                        && scItem.getProduit().getCategorie().getNom().equals(produit.getCategorie().getNom())) {

                    if (qty != 0) {
                        // set elementPanier quantity to new value
                        scItem.setQuantiteCommande(qty);
                    } else {
                        // if quantity equals 0, save elementPanier and break
                        elementPanier = scItem;
                        break;
                    }
                }
            }

            if (elementPanier != null) {
                // remove from cart
                listeElementPanier.remove(elementPanier);
            }
        }
    }

    public synchronized List<ElementPanier> getListeElementsCommande() {
        return listeElementPanier;
    }
    
    

    public synchronized int getNombreElements() {
        nombreElements = 0;
        
        for (ElementPanier elementPanier : listeElementPanier)
        {
            nombreElements+=elementPanier.getQuantiteCommande();
        }
        
        return nombreElements;
    }
    
    
    // prix reel du produit sans frais de transport

    public synchronized double getSubtotal() {
        total = 0;
        
        for (ElementPanier elementPanier: listeElementPanier)
        {
            Produit produit = (Produit)elementPanier.getProduit();
            total+=(elementPanier.getQuantiteCommande() * produit.getPrix());
        }
        
        return total;
    }
    
    
    // prix total que le client va payer y compris les frais de transport
    
    public synchronized void calculateTotal(String surcharge) {

        double montant = 0;

        // cast surcharge as double
        double s = Double.parseDouble(surcharge);

        montant = this.getSubtotal();
        montant += s;

        total = montant;
    }

    
    // retourne le prix total y compris les frais de transport
    public synchronized double getTotal() {
        return total;
    }

       
    
   
    // on vide le panier
    public synchronized void effacerPanier() {
        listeElementPanier.clear();
        nombreElements = 0;
        total = 0;
    }
    
    
    
    
}
