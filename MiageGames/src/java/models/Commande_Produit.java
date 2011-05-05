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
@NamedQueries({
    @NamedQuery(name = "Commande_Produit.findAll", query = "SELECT o FROM Commande_Produit o"),
    @NamedQuery(name = "Commande_Produit.findByClient_Commande_id", query = "SELECT o FROM Commande_Produit o WHERE o.Client_Commande_id = :Client_Commande_id"),   
    @NamedQuery(name = "Commande_Produit.findByProduitId", query = "SELECT o FROM Commande_Produit o WHERE o.Produit_id = :Produit_id"),  
    @NamedQuery(name = "Commande_Produit.findByquantite", query = "SELECT o FROM Commande_Produit o WHERE o.quantite = :quantite")})

public class Commande_Produit implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   

    @JoinColumn(name="Client_Commande_id", referencedColumnName="id")
    private Client_Commande client_commande;
    
    @JoinColumn(name="Produit_id", referencedColumnName="id")
    private Produit produit;
    
    @Basic(optional = false)
    @Column(name="quantite")
    private Integer quantité;

    public Commande_Produit() {
    }

    public Commande_Produit(Client_Commande client_commande, Produit produit, Integer quantité) {
        this.client_commande = client_commande;
        this.produit = produit;
        this.quantité = quantité;
    }

    public Client_Commande getClient_commande() {
        return client_commande;
    }

    public Produit getProduit() {
        return produit;
    }

    public Integer getQuantité() {
        return quantité;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public void setClient_commande(Client_Commande client_commande) {
        this.client_commande = client_commande;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public void setQuantité(Integer quantité) {
        this.quantité = quantité;
    }
    
    

   
    
    

   
    
}
