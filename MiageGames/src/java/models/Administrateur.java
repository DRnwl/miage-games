/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Sangre
 */
@Entity
@Table(name = "Administrateur")

@NamedQueries({
    @NamedQuery(name = "Administrateur.findAll", query = "SELECT a FROM Administrateur a"),
    
    @NamedQuery(name = "Administrateur.findById", query = "SELECT a FROM Administrateur a WHERE a.id = :id"),
    
    @NamedQuery(name = "Administrateur.findByLogin", query = "SELECT a FROM Administrateur a WHERE a.login = :login"),

    @NamedQuery(name = "Administrateur.findByPassword", query = "SELECT a FROM Administrateur a WHERE a.password = :password"),
    
    @NamedQuery(name = "Administrateur.findByNom", query = "SELECT a FROM Administrateur a WHERE a.nom = :nom"),

    
    @NamedQuery(name = "Administrateur.findByTelephone", query = "SELECT a FROM Administrateur a WHERE a.telephone = :telephone"),
    
    @NamedQuery(name = "Administrateur.findByEmail", query = "SELECT a FROM Administrateur a WHERE a.email = :email")

})

public class Administrateur implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Column(name = "email")
    private String email;
    
    @Basic(optional = false)
    @Column(name = "telephone")
    private String telephone;

    public Administrateur() {
    }

    public Administrateur(String login, String password, String email) {
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public Administrateur(String login, String password) {
        this.login = login;
        this.password = password;
    }
    
    

    public Administrateur(String login, String password, String nom, String email, String telephone) {
        this.login = login;
        this.password = password;
        this.nom = nom;
        this.email = email;
        this.telephone = telephone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
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
        if (!(object instanceof Administrateur)) {
            return false;
        }
        Administrateur other = (Administrateur) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Administrateur[ id=" + id + " ]";
    }
}
