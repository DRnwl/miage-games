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
@Table (name = "Commande_Client")
@NamedQueries({
    @NamedQuery(name = "Commande_Client.findAll", query = "SELECT c FROM Commande_Client c"),
    
    @NamedQuery(name = "Commande_Client.findById", query = "SELECT c FROM Commande_Client c WHERE c.id = :id"),
    
    @NamedQuery(name = "Commande_Client.findByMontant", query = "SELECT c FROM Commande_Client c WHERE c.montant = :montant"),  
    
    @NamedQuery(name = "Commande_Client.findByDate_achat", query = "SELECT c FROM Commande_Client c WHERE c.date_achat = :date_achat"),
    
    @NamedQuery(name = "Commande_Client.findByNumero_confirmation", query = "SELECT c FROM Commande_Client c WHERE c.numero_confirmation = :numero_confirmation")})

public class Commande_Client implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name="id")
    private Integer id;
    
    @Basic(optional = false)
    @Column(name="montant")
    private Integer montant;
    
    @Basic(optional = false)
    @Column(name = "date_achat")
    private String date_achat;
    
    
    @Basic(optional = false)
    @Column(name="numero_confirmation")
    private int numero_confirmation;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "commande_client")
    private Collection<Produit_Commande> collectionProduitCommande;
    
    @JoinColumn(name="client_id", referencedColumnName="id")
    @ManyToOne(optional = false)
    private Client client;

    public Commande_Client() {
    }

    public Commande_Client(Integer id) {
        this.id = id;
    }

    public Commande_Client(Integer id, Integer montant, String date_achat, int numero_confirmation, Client client) {
        this.id = id;
        this.montant = montant;
        this.date_achat = date_achat;
        this.numero_confirmation = numero_confirmation;
        this.client = client;
    }

    public Client getClient() {
        return client;
    }

    public String getDate_achat() {
        return date_achat;
    }

    public Integer getId() {
        return id;
    }

    public Integer getMontant() {
        return montant;
    }

    public int getNumero_confirmation() {
        return numero_confirmation;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setDate_achat(String date_achat) {
        this.date_achat = date_achat;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setMontant(Integer montant) {
        this.montant = montant;
    }

    public void setNumero_confirmation(int numero_confirmation) {
        this.numero_confirmation = numero_confirmation;
    }

    public Collection<Produit_Commande> getCollectionCommande_produit() {
        return collectionProduitCommande;
    }

    public void setCollectionCommande_produit(Collection<Produit_Commande> collectionCommande_produit) {
        this.collectionProduitCommande = collectionCommande_produit;
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
        if (!(object instanceof Commande_Client)) {
            return false;
        }
        Commande_Client other = (Commande_Client) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Client_Commande[ id=" + id + " ]";
    }
    
}
