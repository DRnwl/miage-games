/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionnaire;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import models.Categorie;

/**
 *
 * @author Pierro
 */
public class GestionnaireCategorie extends GestionnaireCommun<Categorie> {
    
    @PersistenceContext
    
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public GestionnaireCategorie() {
        super(Categorie.class);
    }

    
}
