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

@Table(name="Commande")
@NamedQueries({
    @NamedQuery(name = "Commande.findAll", query = "SELECT o FROM Commande o"),
    
  
    @NamedQuery(name = "Commande.findByquantite", query = "SELECT o FROM Commande o WHERE o.quantite = :quantite")
})

public class Commande implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    
    @JoinColumn(name = "commande_client_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Commande_Client commandeClient;
    
    @JoinColumn(name = "produit_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Produit produit;
    
    @Basic(optional = false)
    @Column(name = "quantite")
    private Integer quantite;
    
    
    public Commande() {
    }

    

    public Commande(Commande_Client commandeClient, Produit produit, Integer quantite) {
        this.commandeClient = commandeClient;
        commandeClient.getCollectionCommande().add(this);
        this.produit = produit;
        produit.getCollectionCommande().add(this);
        this.quantite = quantite;
    }

    public Commande_Client getCommandeClient() {
        return commandeClient;
    }

    public void setCommandeClient(Commande_Client commandeClient) {
        this.commandeClient = commandeClient;
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
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof Commande)) {
            return false;
        }
        Commande other = (Commande) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Commande[ id=" + id + " ]";
    }
}
