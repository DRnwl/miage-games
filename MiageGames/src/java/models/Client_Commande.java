/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;


/**
 *
 * @author Pierro
 */
@Entity
@Table (name = "Client_Commande")
@NamedQueries({
    @NamedQuery(name = "Client_Commande.findAll", query = "SELECT c FROM Client_Commande c"),
    @NamedQuery(name = "Client_Commande.findById", query = "SELECT c FROM Client_Commande c WHERE c.id = :id"),
    @NamedQuery(name = "Client_Commande.findByClient", query = "SELECT c FROM Client_Commande c WHERE c.Client_id = :Client_id"), // manually created  
    @NamedQuery(name = "Client_Commande.findByMontant", query = "SELECT c FROM Client_Commande c WHERE c.montant = :montant"),  
    @NamedQuery(name = "Client_Commande.findByDate_achat", query = "SELECT c FROM Client_Commande c WHERE c.date_achat = :date_achat"),
    @NamedQuery(name = "Client_Commande.findByNumero_confirmation", query = "SELECT c FROM Client_Commande c WHERE c.numero_confirmation = :numero_confirmation")})

public class Client_Commande implements Serializable {
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
    
    @JoinColumn(name="Client_id", referencedColumnName="id")
    private Client client;

    public Client_Commande() {
    }

    public Client_Commande(Integer id) {
        this.id = id;
    }

    public Client_Commande(Integer id, Integer montant, String date_achat, int numero_confirmation, Client client) {
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

    
    
    
    
    
  

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Client_Commande)) {
            return false;
        }
        Client_Commande other = (Client_Commande) object;
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
