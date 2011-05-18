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

    /*** client **/
    /**
     * 
     * String login, 
     * String password, 
     * String nom, 
     * String prenom, 
     * String telephone,
     * String email, 
     * String adrFact, 
     * String adrFactZip, 
     * String adrFactVille, 
     * String adrLivraison, 
     * String adrLivrZip, 
     * String adrLivrVille
     * 
     **/
    private Client ajouterClient(
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

    private Commande_Client ajouterCommandeClient(Client client, Panier panier) {
        Commande_Client commandeClient = new Commande_Client();
        commandeClient.setClient(client);
        commandeClient.setMontant(panier.getTotal());

        Random random = new Random();
        int i = random.nextInt(99999);
        commandeClient.setNumero_confirmation(i);

        em.persist(commandeClient);

        return commandeClient;


    }

    private void ajouterProduitCommande(Commande_Client commandeClient, Panier panier) {
        em.flush();

        List<ElementPanier> listeElementPanier = panier.getListeElementsCommande();

        for (ElementPanier scItem : listeElementPanier) {
            String nomProduit = scItem.getProduit().getNom();


            Commande commande = new Commande();
            commande.setCommandeClient(commandeClient);

            Produit produit = (Produit) scItem.getProduit();
            commande.setProduit(produit);


            int quantite = scItem.getQuantiteCommande();

            em.persist(commande);




        }


    }

    /*
     * public Map getOrderDetails(int orderId) {
    
    Map orderMap = new HashMap();
    
    // get order
    CustomerOrder order = customerOrderFacade.find(orderId);
    
    // get customer
    Customer customer = order.getCustomer();
    
    // get all ordered products
    List<OrderedProduct> orderedProducts = orderedProductFacade.findByOrderId(orderId);
    
    // get product details for ordered items
    List<Product> products = new ArrayList<Product>();
    
    for (OrderedProduct op : orderedProducts) {
    
    Product p = (Product) productFacade.find(op.getOrderedProductPK().getProductId());
    products.add(p);
    }
    
    // add each item to orderMap
    orderMap.put("orderRecord", order);
    orderMap.put("customer", customer);
    orderMap.put("orderedProducts", orderedProducts);
    orderMap.put("products", products);
    
    return orderMap;
    }
     * 
     * 
     **/
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
