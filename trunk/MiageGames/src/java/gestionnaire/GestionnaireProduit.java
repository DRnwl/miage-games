/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionnaire;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.*;
import models.Produit;
/**
 *
 * @author Sangre
 */
@Stateless
@LocalBean
public class GestionnaireProduit extends GestionnaireCommun<Produit>{

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public GestionnaireProduit() {
        super(Produit.class);
    }
}
