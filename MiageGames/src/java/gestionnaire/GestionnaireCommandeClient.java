/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionnaire;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.*;
import models.Commande_Client;

/**
 *
 * @author Pierro
 */
@Stateless
@LocalBean
public class GestionnaireCommandeClient extends GestionnaireCommun<Commande_Client> {
    
    @PersistenceContext
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }
 
    public GestionnaireCommandeClient()
    {
        super(Commande_Client.class);
    }
    
    public Commande_Client findById(int id){
        try{
            return (Commande_Client)em.createNamedQuery("Commande_Client.findById").setParameter("id", id).getSingleResult();
        }catch(Exception e){
            return null;
        }
    }

   public Commande_Client findByNumC(int num){
        try{
            return (Commande_Client)em.createNamedQuery("Commande_Client.findByNumero_confirmation").setParameter("numero_confirmation", num).getSingleResult();
        }catch(Exception e){
            return null;
        }
    }
    
}
