/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionnaire;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.*;
import models.Distributeur;

/**
 *
 * @author Pierro
 */
@Stateless
@LocalBean
public class GestionnaireDistributeur extends GestionnaireCommun<Distributeur> {

    @PersistenceContext
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }
    
    
    public GestionnaireDistributeur()
    {
        super(Distributeur.class);
    }
    
    public Distributeur findByNom_distributeur(String nom){
        try{
            return (Distributeur)em.createNamedQuery("Distributeur.findByNom_distributeur").setParameter("nom_distributeur", nom).getSingleResult();
        }catch(Exception e){
            return null;
        }
    }
}
