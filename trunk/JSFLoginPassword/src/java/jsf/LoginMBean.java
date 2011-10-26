/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author michel
 */
@Named(value = "loginMBean")
@SessionScoped
public class LoginMBean implements Serializable {

    private Utilisateur utilisateur;
    private String login;
    private String password;
    private boolean connected = false;
    private String message = "Veuillez vous identifier :";

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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

    public boolean isConnected() {
        return connected;
    }

    public void setConnected(boolean connected) {
        this.connected = connected;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    /** Creates a new instance of LoginMBean */
    public LoginMBean() {
    }

    public void deconnexion() {
        connected = false;
        message = "Veuillez vous identifier :";
    }

    public void checkLogin() {
        // Normalement à partir du login on devrait demander à l'ejb
        // gestionnaireUtilisateur de chercher dans la BD et retourner un 
        // utilisateur qu'on met dans la propriété utilisateur.
        // Là on simule...
        connected = (login.equals("michel") && password.equals("toto"));
        if (connected) {
            message = "Bienvenue, vous êtes connecté en tant que " + login + " ! ";
        } else {
            message = "Mauvais login/password, veuillez recommencer !";
        }

    }
}
