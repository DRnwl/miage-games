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
    
    public void creerCategoriesTest(){
        create(new Categorie("PC"));
        create(new Categorie("DS"));
        create(new Categorie("WII"));
        create(new Categorie("PSP"));
        create(new Categorie("XBOX360"));
        create(new Categorie("3DS"));
        create(new Categorie("PS3"));
    }
    
    public Categorie findByNom(String nom){
        try{
            return (Categorie)em.createNamedQuery("Categorie.findByNom").setParameter("nom", nom).getSingleResult();
        }catch(Exception e){
            return null;
        }
    }

    
}
