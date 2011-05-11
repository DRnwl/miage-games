/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionnaire;

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
    
    
}
