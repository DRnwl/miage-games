/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionnaire;

import java.math.BigDecimal;
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
    
    public void creerProduitsTest(){
        
        Produit prod = new Produit();
        Produit prod1 = new Produit();
        Produit prod2 = new Produit();
        Produit prod3 = new Produit();
        Produit prod4 = new Produit();
        
        prod.setNom("FarCry");
        prod1.setNom("NWN2");
        prod2.setNom("Aion");
        prod3.setNom("WoW");
        prod4.setNom("Crysis 2");
        
        prod.setDescription("blablablablablablabla");
        
        create(prod);
        create(prod1);
        create(prod2);
        create(prod3);
        create(prod4);
        
    }
}
