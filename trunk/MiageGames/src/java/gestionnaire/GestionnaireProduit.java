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
    
    
    public Produit findByNom(String nom){
        try{
            return (Produit)em.createNamedQuery("Produit.findByNom").setParameter("nom", nom).getSingleResult();
        }catch(Exception e){
            return null;
        }
    }
    
    
    
    public Produit findByNomCategorie(String nom, Categorie categorie){
        try{
            return (Produit)em.createNamedQuery("Produit.findByNomCategorie").setParameter("nom", nom).setParameter("categorie", categorie).getSingleResult();
        }catch(Exception e){
           
            return null;
        }
    }
    
    
}
