/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionnaire;

import javax.ejb.*;
import javax.ejb.LocalBean;
import javax.persistence.*;
import models.Commande;

/**
 *
 * @author Pierro
 */
@Stateless
@LocalBean
public class GestionnaireCommande extends GestionnaireCommun<Commande> {

     @PersistenceContext
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }
    
    public GestionnaireCommande()
    {
        super(Commande.class);
    }
    
}
