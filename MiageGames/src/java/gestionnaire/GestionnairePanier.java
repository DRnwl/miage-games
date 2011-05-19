/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionnaire;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.annotation.Resource;
import javax.ejb.*;

import javax.persistence.*;
import models.Client;
import models.Commande;
import models.Commande_Client;
import models.Produit;
import panier.ElementPanier;
import panier.Panier;

/**
 *
 * @author Pierro
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class GestionnairePanier {

    @PersistenceContext
    private EntityManager em;
    @Resource
    private SessionContext context;
    @EJB
    private GestionnaireProduit gestionnaireProduit;
    @EJB
    private GestionnaireCommandeClient gestionnaireCommandeClient;
    @EJB
    private GestionnaireCommande gestionnaireCommande;
    @EJB
    private GestionnaireClient gestionnaireClient;

    
    
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    
    public int effectuerCommande(String nom,String prenom,String telephone,String email,String adrFact,
            String adrFactZip,
            String adrFactVille,
            String adrLivraison,
            String adrLivrZip,
            String adrLivrVille,
            Panier panier)
    {
        try {
            
            Client client = ajouterClient(nom, prenom, telephone, email, adrFact, adrFactZip, adrFactVille, adrLivraison, adrLivrZip, adrLivrVille);
            Commande_Client commandeClient = ajouterCommandeClient(client, panier);
            ajouterProduitCommande(commandeClient, panier);
            return commandeClient.getId();
            
        } catch (Exception e) {
            context.setRollbackOnly();
            return 0;
        }
        
       
    }
    
    
    


    public Client ajouterClient(
            String nom,
            String prenom,
            String telephone,
            String email,
            String adrFact,
            String adrFactZip,
            String adrFactVille,
            String adrLivraison,
            String adrLivrZip,
            String adrLivrVille) {

        Client client = new Client();
        client.setNom(nom);
        client.setPrenom(prenom);
        client.setTelephone(telephone);
        client.setEmail(email);
        client.setAdrFact(adrFact);
        client.setAdrFactZip(adrFactZip);
        client.setAdrFactVille(adrFactVille);
        client.setAdrLivraison(adrLivraison);
        client.setAdrLivrZip(adrLivrZip);
        client.setAdrLivrVille(adrLivrVille);


        em.persist(client);
        return client;




    }
    
    
    
    

    public Commande_Client ajouterCommandeClient(Client client, Panier panier) {
        
        Commande_Client commandeClient = new Commande_Client();
        commandeClient.setClient(client);
        commandeClient.setMontant(panier.getTotal());

        Random random = new Random();
        int i = random.nextInt(99999);
        commandeClient.setNumero_confirmation(i);
        
        gestionnaireCommandeClient.create(commandeClient);

        em.persist(commandeClient);

        return commandeClient;


    }
    
    

    public void ajouterProduitCommande(Commande_Client commandeClient, Panier panier) {
        em.flush();

        List<ElementPanier> listeElementPanier = panier.getListeElementsCommande();

        for (ElementPanier scItem : listeElementPanier) {
            
            Commande commande = new Commande();
            commande.setCommandeClient(commandeClient);

            Produit produit = (Produit) scItem.getProduit();
            commande.setProduit(produit);

            commande.setQuantite(scItem.getQuantiteCommande());
            
            gestionnaireProduit.create(produit);

            em.persist(commande);




        }


    }

   
    
    
    
    public Map afficherDetailClients(String login) {
        
        Map contenuMap = new HashMap();

        // on recupere le client

        Client client = gestionnaireClient.findByLogin(login);

        Collection<Commande_Client> listeCommandeClient = client.getCollectionCommandeClient();

        List<Produit> products = new ArrayList<Produit>();


        for (Commande_Client op : listeCommandeClient) {
            Produit p = (Produit) gestionnaireProduit.find(op.getCollectionCommande());
            products.add(p);
        }

        contenuMap.put("produits", products);

        return contenuMap;


    }
}
