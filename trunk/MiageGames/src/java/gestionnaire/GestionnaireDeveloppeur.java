/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionnaire;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.*;
import models.Developpeur;

/**
 *
 * @author Pierro
 */
@Stateless
@LocalBean
public class GestionnaireDeveloppeur extends GestionnaireCommun<Developpeur> {

   @PersistenceContext
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }
    
    public GestionnaireDeveloppeur()
    {
        super(Developpeur.class);
    }
    
}
