/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionnaire;

import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.*;
import models.Administrateur;

/**
 *
 * @author Pierro
 */
@Stateless
@LocalBean
public class GestionnaireAdministrateur extends  GestionnaireCommun<Administrateur> {

    @PersistenceContext
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }
    
    
    public GestionnaireAdministrateur()
    {
        super(Administrateur.class);
    }
    
    public Administrateur findByLogin(String login){
        try{
            return (Administrateur)em.createNamedQuery("Administrateur.findByLogin").setParameter("login", login).getSingleResult();
        }catch(Exception e){
            return null;
        }
    }
    
    public Administrateur findByEmail(String email){
        try{
            return (Administrateur)em.createNamedQuery("Administrateur.findByEmail").setParameter("email", email).getSingleResult();
        }catch(Exception e){
            return null;
        }
    }
    
}
