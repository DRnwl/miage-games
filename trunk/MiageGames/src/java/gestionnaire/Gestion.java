/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionnaire;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.ejb.*;
import models.Administrateur;
import models.Categorie;
import models.CategorieAge;
import models.CategorieAge;
import models.Client;
import models.Commande;
import models.Commande_Client;
import models.Developpeur;
import models.Editeur;
import models.Produit;


/**
 *
 * @author Pierro
 */
@Stateless
@LocalBean
public class Gestion {

    @EJB
    private GestionnaireAdministrateur gestionnaireAdministrateur;
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
    @EJB
    private GestionnaireDeveloppeur gestionnaireDeveloppeur;
    @EJB
    private GestionnaireEditeur gestionnaireEditeur;
    @EJB
    private GestionnaireCommande gestionnaireCommande;
    
    boolean vide =true;

    public boolean getVide() {
        return vide;
    }

    public void creerDonnees() throws FileNotFoundException {




        vide = false;
        /** EDITEURS */
        Editeur editeur1 = new Editeur("KONAMI");
        Editeur editeur2 = new Editeur("SONY");

        Editeur editeur3 = new Editeur("TAKE2");


        gestionnaireEditeur.create(editeur1);
        gestionnaireEditeur.create(editeur2);

        gestionnaireEditeur.create(editeur3);






        /*** DEVELOPPEURS **/
        //Team Bondi
        Developpeur dev1 = new Developpeur("Team Bondi");
        Developpeur dev2 = new Developpeur("Team Bad");

        Developpeur dev3 = new Developpeur("Team Unit");

        Developpeur dev4 = new Developpeur("Team JSS");

        Developpeur dev5 = new Developpeur("Team CSS");

        gestionnaireDeveloppeur.create(dev1);
        gestionnaireDeveloppeur.create(dev2);
        gestionnaireDeveloppeur.create(dev3);
        gestionnaireDeveloppeur.create(dev4);
        gestionnaireDeveloppeur.create(dev5);




        /****************************************************/
        /* Categories */
        Categorie PC = new Categorie("PC", "categorie PC");
        Categorie DS = new Categorie("DS", "categorie DS");
        Categorie WII = new Categorie("WII", "categorie WII");
        Categorie PSP = new Categorie("PSP", "categorie PSP");
        Categorie XBOX360 = new Categorie("XBOX360", "categorie XBOX360");
        Categorie PS3 = new Categorie("PS3", "categorie PS3");

        gestionnaireCategorie.create(PC);
        gestionnaireCategorie.create(DS);
        gestionnaireCategorie.create(WII);
        gestionnaireCategorie.create(PSP);
        gestionnaireCategorie.create(XBOX360);
        gestionnaireCategorie.create(PS3);



        /****************************************************/
        /* CategorieAge*/
        CategorieAge categorie3 = new CategorieAge("3 ans et plus ", "http://www.micromania.fr/elements/signaletique_3.jpg");
        CategorieAge categorie7 = new CategorieAge("7 ans et plus", "http://www.micromania.fr/elements/signaletique_peur.jpg");
        CategorieAge categorie12 = new CategorieAge("12 ans et plus", "http://www.micromania.fr/elements/signaletique_12.jpg");
        CategorieAge categorie16 = new CategorieAge("16 ans et plus", "http://www.micromania.fr/elements/signaletique_16.jpg");
        CategorieAge categorie18 = new CategorieAge("18 ans et plus", "http://www.micromania.fr/elements/signaletique_18.jpg");

        gestionnaireCategorieAge.create(categorie3);
        gestionnaireCategorieAge.create(categorie7);
        gestionnaireCategorieAge.create(categorie12);
        gestionnaireCategorieAge.create(categorie16);
        gestionnaireCategorieAge.create(categorie18);



        /****************************************************/
        /* Produit*/
        
        
        
        
        /**
         * 
         * String nom, 
         * Double prix,
         * Categorie categorie, 
         * String image, 
         * CategorieAge categorieAge, 
         * String sortie,
         * Developpeur developpeur,
         * Editeur editeur, 
         * int quantiteProduit
         * 
         * 
         * 
         **/
        
        
        
        
        
        
        /* categorie PC*/
        Produit prod1 = new Produit("BRINK 2030", 12.5, PC, "http://www.micromania.fr/imagesprod/41487/41487_jaqr_brink_gfw_eu_pegi_cover_129x171.jpg", categorie3, "12 mai 2011", dev1, editeur1,12,"http://www.youtube.com/v/O6YGOYxtPfc?version=3","mélange captivant de champs de bataille dynamiques, un système de commandes innovateur dont vous ne vous lasserez pas de sitôt!");
        Produit prod2 = new Produit("FABLE III", 50.31, PC, "http://www.micromania.fr/imagesprod/45168/45168_jaqr_fableIIIPC_129x171.jpg", categorie7, "11 mai 2011", dev2, editeur1,12,"http://www.youtube.com/v/uo34rG_3rnU?version=3");
        Produit prod3 = new Produit("The witcher", 20.5, PC, "http://www.micromania.fr/imagesprod/44969/44969_jaqr_witcher2_129x171.jpg", categorie3, "10 mai 2011", dev3, editeur1,12,"http://www.youtube.com/v/zqpnEo-lXwc?version=3");
        Produit prod4 = new Produit("SBK 2011", 10.5, PC, "http://www.micromania.fr/imagesprod/44618/44618_jaqr_sbk2011PC_129x171.jpg", categorie18, "12 mai 2011", dev4, editeur1,12,"http://www.youtube.com/v/9CbCSevdWJ0?version=3");
        Produit prod5 = new Produit("Tales of Monkey", 11.5, PC, "http://www.micromania.fr/imagesprod/44236/44236_jaqr_jaquette1_129x171.jpg", categorie3, "12 mai 2011", dev1, editeur1,12);


        Produit prod6 = new Produit("DARKSPORE", 72.5, PC, "http://www.micromania.fr/imagesprod/43934/43934_jaqr_DarksporeEditionLimiteePC_129x171.jpg", categorie3, "12 mai 2011", dev2, editeur1,12);
        Produit prod7 = new Produit("DUNGEONS", 80.31, PC, "http://www.micromania.fr/imagesprod/44589/44589_jaqr_jaquette1_129x171.jpg", categorie7, "5 mai 2011", dev1, editeur1,12);
        Produit prod8 = new Produit("BATTLEFIELD ", 120.5, PC, "http://www.micromania.fr/imagesprod/44975/44975_jaqr_micromania1_129x171.jpg", categorie12, "10 mai 2011", dev3, editeur1,12);
        Produit prod9 = new Produit("SID MEIERS", 100.5, PC, "http://www.micromania.fr/imagesprod/44809/44809_jaqr_micromania_129x171.jpg", categorie3, "7 mai 2011", dev1, editeur1,12);
        Produit prod10 = new Produit("TITEUF", 11.5, PC, "http://www.micromania.fr/imagesprod/44563/44563_jaqr_jaquette1_129x171.jpg", categorie3, "8 mai 2011", dev5, editeur1,12);




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



        /*** Categorie DS **/
        Produit produitDS1 = new Produit("DRAGON", 34.5, DS, "http://www.micromania.fr/imagesprod/45083/45083_jaqr_dragonquestVI_129x171.jpg", categorie3, "12 mai 2011", dev1, editeur2,7);
        Produit produitDS2 = new Produit("RIO", 39.5, DS, "http://www.micromania.fr/imagesprod/44824/44824_jaqr_riods_129x171.jpg", categorie3, "12 mai 2011", dev2, editeur2,7);
        Produit produitDS3 = new Produit("Meutre a Venise", 9.5, DS, "http://www.micromania.fr/imagesprod/45089/45089_jaqr_meurtresavenise_129x171.jpg", categorie16, "9 mai 2011", dev1, editeur2,7);
        Produit produitDS4 = new Produit("LEGO  ", 31.5, DS, "http://www.micromania.fr/imagesprod/44999/44999_jaqr_legopiratesDS_129x171.jpg", categorie3, "15 mai 2011", dev3, editeur2,7);
        Produit produitDS5 = new Produit("GO DIEGO", 29.5, DS, "http://www.micromania.fr/imagesprod/43794/43794_jaqr_godiegomissionconstructionDS_129x171.jpg", categorie12, "19 mai 2011", dev5, editeur2,7);
        Produit produitDS6 = new Produit("THOR  ", 19.5, DS, "http://www.micromania.fr/imagesprod/44531/44531_jaqr_thorDS_129x171.jpg", categorie3, "12 mai 2011", dev1, editeur2,7);
        Produit produitDS7 = new Produit("BEJEWELED TWIST", 67.5, DS, "http://www.micromania.fr/imagesprod/45182/45182_jaqr_bejeweledtwist_129x171.jpg", categorie3, "12 mai 2011", dev1, editeur3,7);
        Produit produitDS8 = new Produit("18 JEUX DE CARTES", 39.5, DS, "http://www.micromania.fr/imagesprod/45087/45087_jaqr_jaquette_129x171.jpg", categorie7, "21 mai 2011", dev4, editeur3,7);
        Produit produitDS9 = new Produit("DUKE NUKEM", 39.5, DS, "http://www.micromania.fr/imagesprod/39202/39202_jaqr_Micromania_129x171.jpg", categorie3, "22 mai 2011", dev1, editeur3,7);
        Produit produitDS10 = new Produit("OKAMIDEN", 99.5, DS, "http://www.micromania.fr/imagesprod/44033/44033_jaqr_okamiden_129x171.jpg", categorie18, "19 mai 2011", dev4, editeur3,7);





        gestionnaireProduit.create(produitDS1);
        gestionnaireProduit.create(produitDS2);
        gestionnaireProduit.create(produitDS3);
        gestionnaireProduit.create(produitDS4);
        gestionnaireProduit.create(produitDS5);

        gestionnaireProduit.create(produitDS6);
        gestionnaireProduit.create(produitDS7);
        gestionnaireProduit.create(produitDS8);
        gestionnaireProduit.create(produitDS9);
        gestionnaireProduit.create(produitDS10);



        /*****WII **/
        Produit produitWi1 = new Produit("LEGO PIRATES ", 50.99, WII, "http://www.micromania.fr/imagesprod/45007/45007_jaqr_legopirateswii_129x171.jpg", categorie3, "12 mai 2011", dev1, editeur3,6);

        Produit produitWi2 = new Produit("KARAOKE REVOLUTION  ", 87.99, WII, "http://www.micromania.fr/imagesprod/45050/45050_jaqr_jaquette1_129x171.jpg", categorie7, "5 mai 2011", dev2, editeur3,6);

        Produit produitWi3 = new Produit("CABELAS DANGEROUS ", 34.99, WII, "http://www.micromania.fr/imagesprod/45107/45107_jaqr_CDH2011_Wii_SleeveMock_UKFR_129x171.jpg", categorie16, "22 mai 2011", dev1, editeur3,6);

        Produit produitWi4 = new Produit("GUILTY GEAR", 10.99, WII, "http://www.micromania.fr/imagesprod/45266/45266_jaqr_guiltygearWii_129x171.jpg", categorie7, "25 mai 2011", dev3, editeur2,6);

        Produit produitWi5 = new Produit("DANCEDANCE REVOLUTION", 23.99, WII, "http://www.micromania.fr/imagesprod/44636/44636_jaqr_dancedanceRHP4_129x171.jpg", categorie18, "19 mai 2011", dev1, editeur3,6);

        Produit produitWi6 = new Produit("THOR : Dieu du Monde", 12.99, WII, "http://www.micromania.fr/imagesprod/44529/44529_jaqr_thorwii_129x171.jpg", categorie12, "9 mai 2011", dev4, editeur3,6);

        Produit produitWi7 = new Produit("ZUMBA 7", 50.5, WII, "http://www.micromania.fr/imagesprod/43494/43494_jaqr_zumbaWii_129x171.jpg", categorie7, "2 mai 2011", dev1, editeur1,6);

        Produit produitWi8 = new Produit("WE SING ", 19.99, WII, "http://www.micromania.fr/imagesprod/45186/45186_jaqr_Wesingencore+mic_129x171.jpg", categorie3, "28 mai 2011", dev5, editeur1,6);

        Produit produitWi9 = new Produit("THE X FACTOR 2011", 50.99, WII, "http://www.micromania.fr/imagesprod/44559/44559_jaqr_xfactorwii_129x171.jpg", categorie3, "2 mai 2011", dev1, editeur1,6);

        Produit produitWi10 = new Produit("RIO 2009", 3.99, WII, "http://www.micromania.fr/imagesprod/44822/44822_jaqr_riowii_129x171.jpg", categorie3, "2 mai 2011", dev4, editeur1,6);




        gestionnaireProduit.create(produitWi1);
        gestionnaireProduit.create(produitWi2);
        gestionnaireProduit.create(produitWi3);
        gestionnaireProduit.create(produitWi4);
        gestionnaireProduit.create(produitWi5);

        gestionnaireProduit.create(produitWi6);
        gestionnaireProduit.create(produitWi7);
        gestionnaireProduit.create(produitWi8);
        gestionnaireProduit.create(produitWi9);
        gestionnaireProduit.create(produitWi10);




        /**** Categorie PSP ****/
        Produit produitPSP1 = new Produit("PATAPON 2", 29.99, PSP, "http://www.micromania.fr/imagesprod/37457/37457_jaqr_Jaquette-micromania_129x171.jpg", categorie3, "1 mai 2011", dev1, editeur3,5);
        Produit produitPSP2 = new Produit("LEGO PIRATES DES CARAIBES 9", 19.99, PSP, "http://www.micromania.fr/imagesprod/45003/45003_jaqr_legopiratesPSP_129x171.jpg", categorie18, "2 mai 2011", dev3, editeur3,5);
        Produit produitPSP3 = new Produit("PRO EVOLUTION SOCCER 2011 star", 49.99, PSP, "http://www.micromania.fr/imagesprod/42631/42631_jaqr_PES2011PSP_129x171.jpg", categorie18, "3 mai 2011", dev3, editeur3,5);
        Produit produitPSP4 = new Produit("PATAPON 3", 59.99, PSP, "http://www.micromania.fr/imagesprod/42961/42961_jaqr_Patapon3PSP_129x171.jpg", categorie12, "12 mai 2011", dev4, editeur3,5);
        Produit produitPSP5 = new Produit("THE FOOTBALL COLLECTION 2009 star ", 23.99, PSP, "http://www.micromania.fr/imagesprod/38916/38916_jaqr_jaquette_129x171.jpg", categorie7, "5 mai 2011", dev4, editeur3,5);
        Produit produitPSP6 = new Produit("LOCOROCO 2 Essentials 2009", 94.99, PSP, "http://www.micromania.fr/imagesprod/36967/36967_jaqr_locoroco2_129x171.jpg", categorie12, "2 mai 2011", dev1, editeur3,5);
        Produit produitPSP7 = new Produit("THE 3RD BIRTHDAY Edition Twisted 9", 91.99, PSP, "http://www.micromania.fr/imagesprod/44435/44435_jaqr_ULES-01513-3rd-FRA-carton_SEL_129x171.jpg", categorie3, "2 mai 2011", dev4, editeur3,5);
        Produit produitPSP8 = new Produit("WWE ALL STARS 2011", 43.99, PSP, "http://www.micromania.fr/imagesprod/44462/44462_jaqr_wweallstarPSP_129x171.jpg", categorie12, "2 mai 2011", dev1, editeur1,5);

        Produit produitPSP9 = new Produit("RIDGE RACER ", 59.99, PSP, "http://www.micromania.fr/imagesprod/43653/43653_jaqr_jaquette1_129x171.jpg", categorie7, "2 mai 2011", dev5, editeur1,5);

        Produit produitPSP10 = new Produit("RATCHET & BZRTZ", 67.99, PSP, "http://www.micromania.fr/imagesprod/41767/41767_jaqr_jaquette1_129x171.jpg", categorie3, "26 mai 2011", dev1, editeur1,5);



        gestionnaireProduit.create(produitPSP1);
        gestionnaireProduit.create(produitPSP2);
        gestionnaireProduit.create(produitPSP3);
        gestionnaireProduit.create(produitPSP4);
        gestionnaireProduit.create(produitPSP5);

        gestionnaireProduit.create(produitPSP6);
        gestionnaireProduit.create(produitPSP7);
        gestionnaireProduit.create(produitPSP8);
        gestionnaireProduit.create(produitPSP9);
        gestionnaireProduit.create(produitPSP10);





        /****** Categorie XBOX 360 **/
        Produit produitXBOX1 = new Produit("L.A. NOIRE Pack 1 Naked City", 7.99, XBOX360, "http://www.micromania.fr/imagesprod/44256/44256_jaqr_jaquette1_129x171.jpg", categorie12, "2 mai 2009", dev1, editeur2,4);

        Produit produitXBOX2 = new Produit("TRIPLE PACK XBLA", 6.99, XBOX360, "http://www.micromania.fr/imagesprod/45417/45417_jaqr_jaquette1_129x171.jpg", categorie3, "4 mai 2007", dev1, editeur2,4);

        Produit produitXBOX3 = new Produit("MX VS ATV ALIVE", 5.99, XBOX360, "http://www.micromania.fr/imagesprod/44828/44828_jaqr_mxvsatvalive-xbox360_129x171.jpg", categorie18, "2 mai 2008", dev2, editeur2,4);

        Produit produitXBOX4 = new Produit("BRINK 2010", 23.99, XBOX360, "http://www.micromania.fr/imagesprod/41483/41483_jaqr_brink_360_eu_pegi_cover_129x171.jpg", categorie12, "4 mai 2005", dev2, editeur2,4);

        Produit produitXBOX5 = new Produit("LEGO PIRATES DES CARAIBES 2003", 17.99, XBOX360, "http://www.micromania.fr/imagesprod/45009/45009_jaqr_legopiratesx360_129x171.jpg", categorie3, "18 mai 2003", dev1, editeur1,4);

        Produit produitXBOX6 = new Produit("CABELAS DANGEROUS HUNT 201", 12.99, XBOX360, "http://www.micromania.fr/imagesprod/45105/45105_jaqr_CDH2011_Xbox360_SleeveMock_UKFR_129x171.jpg", categorie3, "2 mai 2004", dev1, editeur2,4);

        Produit produitXBOX7 = new Produit("SBK 211", 97.99, XBOX360, "http://www.micromania.fr/imagesprod/44616/44616_jaqr_sbk2011x360_129x171.jpg", categorie3, "12 mai 2006", dev1, editeur1,4);

        Produit produitXBOX8 = new Produit("VIRTUA  4", 77.99, XBOX360, "http://www.micromania.fr/imagesprod/44535/44535_jaqr_virtuatennis4x360_129x171.jpg", categorie7, "12 mai 2005", dev3, editeur1,4);

        Produit produitXBOX9 = new Produit("THOR  2030", 37.99, XBOX360, "http://www.micromania.fr/imagesprod/44527/44527_jaqr_thorx360_129x171.jpg", categorie3, "12 mai 2007", dev3, editeur1,4);

        Produit produitXBOX10 = new Produit("ALIEN BREED TRILOGY 2010", 7.99, XBOX360, "http://www.micromania.fr/imagesprod/45091/45091_jaqr_jaquette_129x171.jpg", categorie3, "2 mai 2004", dev3, editeur2,4);


        gestionnaireProduit.create(produitXBOX1);
        gestionnaireProduit.create(produitXBOX2);
        gestionnaireProduit.create(produitXBOX3);
        gestionnaireProduit.create(produitXBOX4);
        gestionnaireProduit.create(produitXBOX5);

        gestionnaireProduit.create(produitXBOX6);
        gestionnaireProduit.create(produitXBOX7);
        gestionnaireProduit.create(produitXBOX8);
        gestionnaireProduit.create(produitXBOX9);
        gestionnaireProduit.create(produitXBOX10);










        /****** Categorie PS3**/
        Produit produitPS1 = new Produit("L.A. NOIRE Pack 1 Naked City 2030", 7.99, PS3, "http://www.micromania.fr/imagesprod/44254/44254_jaqr_jaquette1_129x171.jpg", categorie3, "11 mai 2011", dev2, editeur2,2);

        Produit produitPS2 = new Produit("MX VS ATV ALIVE 2099", 6.99, PS3, "http://www.micromania.fr/imagesprod/44830/44830_jaqr_mxvsatvalive-ps3_129x171.jpg", categorie12, "21 mai 2010", dev2, editeur2,2);

        Produit produitPS3 = new Produit("BRINK mortel", 4.99, PS3, "http://www.micromania.fr/imagesprod/41485/41485_jaqr_brink_ps3_eu_pegi_cover_129x171.jpg", categorie12, "19 mai 2010", dev1, editeur3,2);

        Produit produitPS4 = new Produit("NO MORE HEROES : Heroes Paradise 900", 5.99, PS3, "http://www.micromania.fr/imagesprod/44639/44639_jaqr_micromania1_129x171.jpg", categorie18, "3 mai 2010", dev3, editeur2,2);

        Produit produitPS5 = new Produit("BUNDLE 7", 17.99, PS3, "http://www.micromania.fr/imagesprod/44888/44888_jaqr_jaquette_129x171.jpg", categorie3, "29 mai 2007", dev1, editeur3,2);

        Produit produitPS6 = new Produit("SNIPER GHOST WARRIOR 2030", 33.99, PS3, "http://www.micromania.fr/imagesprod/43918/43918_jaqr_sniper_ps3_129x171.jpg", categorie12, "2 mai 2002", dev4, editeur2,2);

        Produit produitPS7 = new Produit("MORTAL KOMBAT 8", 11.99, PS3, "http://www.micromania.fr/imagesprod/43923/43923_jaqr_Micromania_129x171.jpg", categorie12, "12 mai 2001", dev4, editeur2,2);

        Produit produitPS8 = new Produit("MORTAL KOMBAT Collector Edition 999", 99.99, PS3, "http://www.micromania.fr/imagesprod/44380/44380_jaqr_MK9_CE_PS3PEGIFR_3D_129x171.jpg", categorie12, "11 mai 2011", dev5, editeur1,2);

        Produit produitPS9 = new Produit("PORTAL ", 18.99, PS3, "http://www.micromania.fr/imagesprod/44284/44284_jaqr_PORTAL3PS3_129x171.jpg", categorie12, "2 mai 2011", dev5, editeur2,2);

        Produit produitPS10 = new Produit("OPERATION FLASHPOINT : Red River 2020 ", 67.99, PS3, "http://www.micromania.fr/imagesprod/44963/44963_jaqr_OFP3PS3rgbWIPpack2DPEGI_129x171.jpg", categorie3, "9 mai 2011", dev5, editeur1,2);




        gestionnaireProduit.create(produitPS1);
        gestionnaireProduit.create(produitPS2);
        gestionnaireProduit.create(produitPS3);
        gestionnaireProduit.create(produitPS4);

        gestionnaireProduit.create(produitPS5);
        gestionnaireProduit.create(produitPS6);
        gestionnaireProduit.create(produitPS7);
        gestionnaireProduit.create(produitPS8);
        gestionnaireProduit.create(produitPS9);
        gestionnaireProduit.create(produitPS10);





        /****** LES CLIENTS *******/
        Double varMontant = 0.0;
        String varDate_Achat = "";
        int varNumero_confirmation = 0;

        int varQuantite = 0;



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
        String varLogin = "";
        String varPassword = "";
        String varNom = "";
        String varPrenom = "";

        String varTelephone = "";
        String varEmail = "";
        String varAdrFact = "";
        String varAdrFactZip = "";

        String varAdrFactVille = "";
        String varAdrLivraison = "";
        String varAdrLivrZip = "";
        String varAdrLivrVille = "";


        Client clientk = new Client();

        /********/
        Commande_Client commandeClient1 = new Commande_Client();

        Commande commande = new Commande();
        
        Scanner scanner = new Scanner(new File ("/Users/Sangre.Sangre-PC/Documents/NetBeansProjects/M1 Miage/trunk/MiageGames/setup/clients.txt"));

        while (scanner.hasNext()) {


            String ligne = scanner.nextLine();

            Scanner scan2 = new Scanner(ligne);
            scan2.useDelimiter("\\s*;\\s*");

            if (scan2.hasNext()) {

                varLogin = scan2.next();
                varPassword = scan2.next();
                varNom = scan2.next();
                varPrenom = scan2.next();


                varTelephone = scan2.next();
                varEmail = scan2.next();
                varAdrFact = scan2.next();
                varAdrFactZip = scan2.next();

                varAdrFactVille = scan2.next();
                varAdrLivraison = scan2.next();
                varAdrLivrZip = scan2.next();
                varAdrLivrVille = scan2.next();



                String test = scan2.next();
                varMontant = Double.valueOf(test);
                varDate_Achat = scan2.next();
                varNumero_confirmation = scan2.nextInt();


                varQuantite = scan2.nextInt();



            }




            clientk = new Client(varLogin, varPassword, varNom, varPrenom, varTelephone, varEmail, varAdrFact, varAdrFactZip, varAdrFactVille, varAdrLivraison, varAdrLivrZip, varAdrLivrVille);
            gestionnaireClient.create(clientk);

            commandeClient1 = new Commande_Client(varMontant, varDate_Achat, varNumero_confirmation, clientk);
            gestionnaireCommandeClient.create(commandeClient1);
            gestionnaireCommandeClient.create(commandeClient1);

            commande = new Commande(commandeClient1, produitPS1, varQuantite);
            gestionnaireCommande.create(commande);gestionnaireCommande.create(commande);





            scan2.close();


        }


        scanner.close();













        /****** LES Admins *******/
        /************************/
        Administrateur admin1 = new Administrateur("Vincent", "Claver", "Vincent", "admin@admin.com", "0000000000");

        Administrateur admin2 = new Administrateur("Jackson", "Madison", "Elmo", "risus@seddolorFusce.com", "0000000000");
        Administrateur admin3 = new Administrateur("Hamilton", "Lillian", "Zeus", "egestas.ligula.Nullam@vitae.edu", "0000000000");
        Administrateur admin4 = new Administrateur("Brent", "Leigh", "Hiram", "Mauris.vel@necenim.ca", "0000000000");
        Administrateur admin5 = new Administrateur("Thane", "Helen", "Welch", "nunc@libero.ca", "0000000000");
        Administrateur admin6 = new Administrateur("Len", "Virginia", "Maddox", "eu.nulla.at@enimsit.org", "3857147266");
        Administrateur admin7 = new Administrateur("Elmo", "Nevada", "Mullen", "malesuada@mitempor.ca", "3857147266");
        Administrateur admin8 = new Administrateur("Oscar", "Joan", "Hodges", "leo.elementum@non.org", "3857147266");
        Administrateur admin9 = new Administrateur("Lucius", "Blythe", "Barnes", "mauris.sagittis@risusIn.ca", "3857147266");
        Administrateur admin10 = new Administrateur("Cade", "Camille", "Oliver", "euismod.est@urnaNunc.ca", "3857147266");
        Administrateur admin11 = new Administrateur("Travis", "Gillian", "Giles", "In.ornare@Curae;.ca", "3857147266");
        Administrateur admin12 = new Administrateur("Amal", "Yetta", "Castaneda", "elementum@malesuadafamesac.com", "3857147266");
        Administrateur admin13 = new Administrateur("Nigel", "Willa", "Nolan", "consequat.auctor.nunc@mollis.ca", "3857147266");
        Administrateur admin14 = new Administrateur("Kasimir", "Aiko", "Mcneil", "at.augue.id@Proin.edu", "3857147266");
        Administrateur admin15 = new Administrateur("Cullen", "Maia", "Quinn", "volutpat.Nulla.facilisis@milacinia.org", "9139588791");
        Administrateur admin16 = new Administrateur("Eaton", "Janna", "Mckee", "aliquam.arcu.Aliquam@tempuseu.ca", "9139588791");
        Administrateur admin17 = new Administrateur("Ashton", "Beverly", "Williamson", "sit.amet@ligulaNullamfeugiat.ca", "9139588791");
        Administrateur admin18 = new Administrateur("Amery", "Mayo", "Noah", "risus.Donec.nibh@ultriciesornare.org", "9139588791");
        Administrateur admin19 = new Administrateur("Dolan", "Amela", "Lambert", "sem.Nulla.interdum@infaucibusorci.org", "9139588791");
        Administrateur admin20 = new Administrateur("Dean", "Sade", "Beau", "eu.metus@egestaslacinia.com", "9139588791");
        Administrateur admin21 = new Administrateur("Sylvester", "Jana", "Mathews", "Cum.sociis@Aliquam.edu", "9139588791");
        Administrateur admin22 = new Administrateur("Jelani", "Debra", "Wheeler", "tempor.arcu@pellentesque.com", "9139588791");
        Administrateur admin23 = new Administrateur("Kenttt", "Zena", "Graves", "consectetuer.adipiscing@aodiosemper.edu", "9139588791");
        Administrateur admin24 = new Administrateur("Louis", "Rina", "Sanford", "Cras.dolor.dolor@Curabiturdictum.ca", "9139588791");
        Administrateur admin25 = new Administrateur("Dennis", "Minerva", "Hayes", "Nunc@sit.ca", "9139588791");
        Administrateur admin26 = new Administrateur("Marshall", "Germaine", "Noel", "Curabitur.sed@sit.com", "9139588791");
        Administrateur admin27 = new Administrateur("Brenden", "Jade", "Benjamin", "Cras.eu.tellus@parturientmontesnascetur.com", "6519276286");
        Administrateur admin28 = new Administrateur("Tucker", "Chelsea", "Ortiz", "gravida.sagittis.Duis@vitaesodales.com", "6519276286");
        Administrateur admin29 = new Administrateur("Lyle", "Ruth", "Mcclure", "ipsum@Sed.org", "6519276286");
        Administrateur admin30 = new Administrateur("Eagan", "Daphne", "Elliott", "vehicula.risus@lectusantedictum.edu", "6519276286");
        Administrateur admin31 = new Administrateur("Clarke", "Amanda", "Cameron", "mi.pede.nonummy@accumsaninterdumlibero.ca", "6519276286");
        Administrateur admin32 = new Administrateur("Orlando", "Judith", "Roy", "Sed.dictum@augueSedmolestie.org", "6519276286");
        Administrateur admin33 = new Administrateur("Samson", "Jescie", "Burgess", "quis.arcu@seddolorFusce.edu", "6519276286");
        Administrateur admin34 = new Administrateur("Price", "Camille", "Wilkinson", "porta.elit.a@Aenean.org", "6519276286");
        Administrateur admin35 = new Administrateur("Lane", "Dorothy", "Griffin", "mauris.Morbi.non@lacusMauris.ca", "6519276286");
        Administrateur admin36 = new Administrateur("Abbot", "Calista", "Oneill", "Vestibulum.ante.ipsum@turpisvitaepurus.edu", "6519276286");
        Administrateur admin37 = new Administrateur("Laurenzoo", "Wynter", "Rocha", "in@inceptoshymenaeosMauris.org", "4965133818");
        Administrateur admin38 = new Administrateur("Kane", "Claire", "Jin", "rutrum.justo@lacusUtnec.edu", "4965133818");
        Administrateur admin39 = new Administrateur("Malcolm", "Nita", "Jason", "Proin.dolor.Nulla@velfaucibus.ca", "4965133818");
        Administrateur admin40 = new Administrateur("Mohammad", "Angela", "Wilcox", "non.vestibulum@etpede.com", "4965133818");
        Administrateur admin41 = new Administrateur("Wazza", "Sandra", "Mejia", "in.felis.Nulla@est.org", "4965133818");
        Administrateur admin42 = new Administrateur("Silas", "Lael", "Ramirez", "sagittis@egetipsum.com", "4965133818");
        Administrateur admin43 = new Administrateur("Ivor", "Yuri", "Gates", "aliquet.vel@ametanteVivamus.ca", "4965133818");
        Administrateur admin44 = new Administrateur("Lionel", "Noel", "Crane", "dignissim.lacus@loremtristique.edu", "4965133818");
        Administrateur admin45 = new Administrateur("Asher", "Breanna", "Willis", "hendrerit.Donec.porttitor@ultriciesdignissimlacus.com", "4965133818");
        Administrateur admin46 = new Administrateur("Griffith", "Reagan", "Stuart", "Proin@tristiquealiquetPhasellus.org", "4965133818");
        Administrateur admin47 = new Administrateur("Shad", "Marny", "Reyes", "Donec.tincidunt.Donec@at.org", "4965133818");
        Administrateur admin48 = new Administrateur("Victor", "Lara", "Bullock", "nec.imperdiet.nec@Proin.org", "4965133818");
        Administrateur admin49 = new Administrateur("Callum", "Shelby", "Manning", "laoreet.posuere.enim@ut.ca", "4965133818");
        Administrateur admin50 = new Administrateur("Herrod", "Rachel", "Koch", "vestibulum@cursus.edu", "4965133818");
        Administrateur admin51 = new Administrateur("Keefe", "Mari", "Mcknight", "Praesent.eu.nulla@Infaucibus.edu", "4965133818");
        Administrateur admin52 = new Administrateur("Stone", "Harriet", "Burke", "fames.ac.turpis@faucibus.ca", "7261179984");
        Administrateur admin53 = new Administrateur("Plato", "Nichole", "Owens", "lorem.lorem@natoquepenatibuset.org", "7261179984");
        Administrateur admin54 = new Administrateur("Hashim", "Gail", "Oneil", "Suspendisse.aliquet@quamCurabiturvel.edu", "7261179984");
        Administrateur admin55 = new Administrateur("Colorado", "Daphne", "Freeman", "vulputate@Curae;.com", "7261179984");
        Administrateur admin56 = new Administrateur("Omar", "Demetria", "Salas", "molestie.tortor@posuere.ca", "7261179984");

        Administrateur admin57 = new Administrateur("Jesse", "Brianna", "Macias", "Nam.interdum@rutrumjustoPraesent.com", "7261179984");
        Administrateur admin58 = new Administrateur("Hoyt", "Stephanie", "Watts", "penatibus.et.magnis@feugiatnecdiam.com", "7261179984");
        Administrateur admin59 = new Administrateur("Lawrence", "Macey", "Weaver", "tortor@orciDonecnibh.org", "7261179984");
        Administrateur admin60 = new Administrateur("Kenyon", "Melanie", "Houston", "tristique.aliquet@egestasrhoncusProin.com", "7261179984");

        gestionnaireAdministrateur.create(admin1);
        gestionnaireAdministrateur.create(admin2);
        gestionnaireAdministrateur.create(admin3);
        gestionnaireAdministrateur.create(admin4);
        gestionnaireAdministrateur.create(admin5);
        gestionnaireAdministrateur.create(admin6);
        gestionnaireAdministrateur.create(admin7);
        gestionnaireAdministrateur.create(admin8);
        gestionnaireAdministrateur.create(admin9);
        gestionnaireAdministrateur.create(admin10);
        gestionnaireAdministrateur.create(admin11);
        gestionnaireAdministrateur.create(admin12);
        gestionnaireAdministrateur.create(admin13);
        gestionnaireAdministrateur.create(admin14);
        gestionnaireAdministrateur.create(admin15);
        gestionnaireAdministrateur.create(admin16);
        gestionnaireAdministrateur.create(admin17);
        gestionnaireAdministrateur.create(admin18);
        gestionnaireAdministrateur.create(admin19);
        gestionnaireAdministrateur.create(admin20);
        gestionnaireAdministrateur.create(admin21);
        gestionnaireAdministrateur.create(admin22);
        gestionnaireAdministrateur.create(admin23);
        gestionnaireAdministrateur.create(admin24);
        gestionnaireAdministrateur.create(admin25);
        gestionnaireAdministrateur.create(admin26);
        gestionnaireAdministrateur.create(admin27);
        gestionnaireAdministrateur.create(admin28);
        gestionnaireAdministrateur.create(admin29);
        gestionnaireAdministrateur.create(admin30);
        gestionnaireAdministrateur.create(admin31);
        gestionnaireAdministrateur.create(admin32);
        gestionnaireAdministrateur.create(admin33);
        gestionnaireAdministrateur.create(admin34);
        gestionnaireAdministrateur.create(admin35);
        gestionnaireAdministrateur.create(admin36);
        gestionnaireAdministrateur.create(admin37);
        gestionnaireAdministrateur.create(admin38);
        gestionnaireAdministrateur.create(admin39);
        gestionnaireAdministrateur.create(admin40);
        gestionnaireAdministrateur.create(admin41);
        gestionnaireAdministrateur.create(admin42);
        gestionnaireAdministrateur.create(admin43);
        gestionnaireAdministrateur.create(admin44);
        gestionnaireAdministrateur.create(admin45);
        gestionnaireAdministrateur.create(admin46);
        gestionnaireAdministrateur.create(admin47);
        gestionnaireAdministrateur.create(admin48);
        gestionnaireAdministrateur.create(admin49);
        gestionnaireAdministrateur.create(admin50);
        gestionnaireAdministrateur.create(admin51);
        gestionnaireAdministrateur.create(admin52);
        gestionnaireAdministrateur.create(admin53);
        gestionnaireAdministrateur.create(admin54);
        gestionnaireAdministrateur.create(admin55);
        gestionnaireAdministrateur.create(admin56);
        gestionnaireAdministrateur.create(admin57);
        gestionnaireAdministrateur.create(admin58);
        gestionnaireAdministrateur.create(admin59);
        gestionnaireAdministrateur.create(admin60);

        /************************/
        /*** FIN AJOUT ADMIN ***/
    }
}
