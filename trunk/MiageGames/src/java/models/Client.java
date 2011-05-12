/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.*;


/**
 *
 * @author Pierro
 */
@Entity
@Table(name = "Client")

@NamedQueries({
    @NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c"),
    
    @NamedQuery(name = "Client.findById", query = "SELECT c FROM Client c WHERE c.id = :id"),
    
    @NamedQuery(name = "Client.findByLogin", query = "SELECT c FROM Client c WHERE c.login = :login"),
    
    @NamedQuery(name = "Client.findByPassword", query = "SELECT c FROM Client c WHERE c.password = :password"),
    
    @NamedQuery(name = "Client.findByNom", query = "SELECT c FROM Client c WHERE c.nom = :nom"),
    
    @NamedQuery(name = "Client.findByPrenom", query = "SELECT c FROM Client c WHERE c.prenom = :prenom"),
    
    @NamedQuery(name = "Client.findByTelephone", query = "SELECT c FROM Client c WHERE c.telephone = :telephone"),
    
    @NamedQuery(name = "Client.findByEmail", query = "SELECT c FROM Client c WHERE c.email = :email"),
    
    @NamedQuery(name = "Client.findByAdresse", query = "SELECT c FROM Client c WHERE c.adresse = :adresse")
})

public class Client implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    // @Basic
    // C'est l'annotation la plus simple pour indiquer qu'une propriété est persistante 
    //(c'est-à-dire gérée par JPA).
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @Column(name = "login")
    private String login;
    
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    
    @Basic(optional = false)
    @Column(name = "nom")
    private String nom;
    
    @Basic(optional = false)
    @Column(name = "prenom")
    private String prenom;
    
    @Basic(optional = false)
    @Column(name = "telephone")
    private String telephone;
    
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    
    @Basic(optional = false)
    @Column(name = "adresse")
    private String adresse;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    private Collection<Commande_Client> collectionCommandeClient;

    public Client() {
    }

    public Client(String login, String password, String nom, String prenom) {
        this.login = login;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        collectionCommandeClient = new ArrayList<Commande_Client>();
    }

    public Client(String login, String password, String nom, String prenom, String telephone, String email, String adresse) {
        this.login = login;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.email = email;
        this.adresse = adresse;
        collectionCommandeClient = new ArrayList<Commande_Client>();

    }

    public Client(String login, String password, String nom, String prenom, String telephone, String email, String adresse, Commande_Client commandeClient) {
        this.login = login;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.email = email;
        this.adresse = adresse;
        collectionCommandeClient = new ArrayList<Commande_Client>();
        collectionCommandeClient.add(commandeClient);

    }
    
 

    
    public String getAdresse() {
        return adresse;
    }

    public String getEmail() {
        return email;
    }

    public Integer getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getNom() {
        return nom;
    }

    public String getPassword() {
        return password;
    }

    public String getPrenom() {
        return prenom;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Collection<Commande_Client> getCollectionClient_commande() {
        return collectionCommandeClient;
    }

    public void setCollectionClient_commande(Collection<Commande_Client> collectionClient_commande) {
        this.collectionCommandeClient = collectionClient_commande;
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
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Client[ id=" + id + " ]";
    }
}