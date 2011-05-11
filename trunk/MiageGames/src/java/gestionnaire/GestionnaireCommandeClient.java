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
    
    

   
    
}
