/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionnaire;

import javax.ejb.*;
import javax.persistence.*;
import models.Client;

/**
 *
 * @author Pierro
 */
@Stateless
@LocalBean
public class GestionnaireClient  extends  GestionnaireCommun<Client> {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @PersistenceContext
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }
    
    public GestionnaireClient()
    {
        super(Client.class);
    }
    
    public Client findByLogin(String login){
        try{
            return (Client)em.createNamedQuery("Client.findByLogin").setParameter("login", login).getSingleResult();
        }catch(Exception e){
            return null;
        }
    }
    
    public Client findByEmail(String email){
        try{
            return (Client)em.createNamedQuery("Client.findByEmail").setParameter("email", email).getSingleResult();
        }catch(Exception e){
            return null;
        }
    }
    
    public Client findByLoginEmail(String login, String email){
        try{
            return (Client)em.createNamedQuery("Client.findByLoginEmail").setParameter("login", login).setParameter("email", email).getSingleResult();
        }catch(Exception e){
            return null;
        }
    }
    
}
