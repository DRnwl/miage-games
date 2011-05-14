/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionnaire;

import javax.ejb.*;
import models.Administrateur;
import models.Categorie;
import models.CategorieAge;
import models.CategorieAge;
import models.Client;
import models.Commande_Client;
import models.Produit;
import models.Produit_Commande;
import models.Produit_CommandePK;

/**
 *
 * @author Pierro
 */
@Stateless
@LocalBean
public class Gestion {

    @EJB
    private GestionnaireProduit gestionnaireProduit;
    @EJB
    private GestionnaireCategorie gestionnaireCategorie;
    @EJB
    private GestionnaireCategorieAge gestionnaireCategorieAge;
    @EJB
    private GestionnaireClient gestionnaireClient;
    
    @EJB
    private GestionnaireCommandeClient gestionnaireCommandeClient;

    public void creerDonnees() {


        

        /****************************************************/
        /* CategorieAge*/
        CategorieAge categorie3 = new CategorieAge("trois", "age > 3 ans");
        CategorieAge categorie7 = new CategorieAge("sept", "age > 7 ans");
        CategorieAge categorie12 = new CategorieAge("douze", "age > 12 ans");
        CategorieAge categorie16 = new CategorieAge("seize", "age > 16 ans");
        CategorieAge categorie18 = new CategorieAge("dixHuit", "age > 18 ans");

        gestionnaireCategorieAge.create(categorie3);
        gestionnaireCategorieAge.create(categorie7);
        gestionnaireCategorieAge.create(categorie12);
        gestionnaireCategorieAge.create(categorie16);
        gestionnaireCategorieAge.create(categorie18);

        /****************************************************/
        /* Produit*/
        /* categorie PC*/
        Produit prod1 = new Produit("prod1", 12.5);
        
        Produit prod2 = new Produit("Brink", 50.31);
        Produit prod3 = new Produit("Tales Of Monkey Island", 20.5);
        Produit prod4 = new Produit("Sbk 2011", 10.5);
        Produit prod5 = new Produit("Portal", 11.5);


        Produit prod6 = new Produit("The Blood", 9.99);
        Produit prod7 = new Produit("West", 31.5);
        Produit prod8 = new Produit("Monkey", 2.5);
        Produit prod9 = new Produit("Sbk 20", 40.5);
        Produit prod10 = new Produit("Portal Deys", 11.5);



       
        
        
        
        /****************************************************/
        /* Categories */
        Categorie PC = new Categorie("PC", "categorie PC", prod1);
        
        
        Categorie DS = new Categorie("DS", "categorie DS", prod10);
        Categorie WII = new Categorie("WII", "categorie WII", prod2);
        Categorie PSP = new Categorie("PSP", "categorie PSP", prod4);
        Categorie XBOX360 = new Categorie("XBOX360", "categorie XBOX360", prod5);
        Categorie PS3 = new Categorie("PS3", "categorie PS3", prod3);


        
        
        gestionnaireProduit.create(prod1);
        gestionnaireProduit.create(prod2);
        gestionnaireProduit.create(prod3);
        gestionnaireProduit.create(prod4);
        gestionnaireProduit.create(prod5);


        gestionnaireProduit.create(prod6);
        gestionnaireProduit.create(prod7);
        gestionnaireProduit.create(prod8);
        gestionnaireProduit.create(prod9);
        gestionnaireProduit.create(prod10);
        
        
        
        
        gestionnaireCategorie.create(PC);
        gestionnaireCategorie.create(DS);
        gestionnaireCategorie.create(WII);
        gestionnaireCategorie.create(PSP);
        gestionnaireCategorie.create(XBOX360);
        gestionnaireCategorie.create(PS3);


        /****** LES CLIENTS *******/
        Client client1 = new Client("Vincent", "Vincent", "Charles", "Alex");
        Client client2 = new Client("Pierre", "Pierre", "Kader", "Al");

        gestionnaireClient.create(client1);
        gestionnaireClient.create(client2);
        
        
        // commande du client 1
        
        Commande_Client commandeClient1 = new Commande_Client(11.5, "12/05/2011", 123333, client1);
        gestionnaireCommandeClient.create(commandeClient1);
        
        // client1 va commande prod10
        
        
        /****** LES Admins *******/
        Administrateur admin1 = new Administrateur("Vincent", "Claver");




    }
}
