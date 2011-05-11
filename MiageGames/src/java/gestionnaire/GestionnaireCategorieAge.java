/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionnaire;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.*;
import models.CategorieAge;

/**
 *
 * @author Pierro
 */
@Stateless
@LocalBean
public class GestionnaireCategorieAge extends GestionnaireCommun<CategorieAge> {

    @PersistenceContext
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }
    
    public GestionnaireCategorieAge()
    {
        super(CategorieAge.class);
    }
    
    
    
}
