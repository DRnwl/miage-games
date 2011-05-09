/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionnaire;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.*;
import models.Categorie;

/**
 *
 * @author Sangre
 */
@Stateless
@LocalBean
public class GestionnaireCategorie extends GestionnaireCommun<Categorie> {
    
    @PersistenceContext
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public GestionnaireCategorie() {
        super(Categorie.class);
    }
    
    public void creerCategories(){
        create(new Categorie("PC"));
        create(new Categorie("PS3"));
        create(new Categorie("WII"));
        create(new Categorie("XBOX360"));
    }

    
}
