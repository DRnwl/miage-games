/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionnaire;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.*;
import models.Editeur;

/**
 *
 * @author Pierro
 */
@Stateless
@LocalBean
public class GestionnaireEditeur extends GestionnaireCommun<Editeur> {

    @PersistenceContext
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }
    
    public GestionnaireEditeur()
    {
        super(Editeur.class);
    }
    
    public Editeur findByNomEditeur(String nom){
        try{
            return (Editeur)em.createNamedQuery("Editeur.findByNomEditeur").setParameter("nomEditeur", nom).getSingleResult();
        }catch(Exception e){
            return null;
        }
    }
    
}
