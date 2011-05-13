/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionnaire;

import java.math.BigDecimal;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.*;
import models.Categorie;
import models.Produit;

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
    
    public Categorie findByNom(String nom){
        try{
            return (Categorie)em.createNamedQuery("Categorie.findByNom").setParameter("nom", nom).getSingleResult();
        }catch(Exception e){
            return null;
        }
    }

    
}
