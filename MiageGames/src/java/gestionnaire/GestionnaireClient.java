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
    
    
    
}