/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import gestionnaire.Gestion;
import gestionnaire.GestionnaireCategorie;
import gestionnaire.GestionnaireCategorieAge;
import gestionnaire.GestionnaireClient;
import gestionnaire.GestionnaireProduit;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Categorie;
import models.Client;
import models.Commande;
import models.Commande_Client;
import models.Produit;
import panier.ElementPanier;
import panier.Panier;

/**
 *
 * @author Sangre
 */
public class ServletPrincipal extends HttpServlet {

    @EJB
    private GestionnaireProduit gestionnaireProduit;
    @EJB
    private GestionnaireCategorie gestionnaireCategorie;
    @EJB
    private GestionnaireClient gestionnaireClient;
    @EJB
    private Gestion gestion;
    

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

        super.init(servletConfig);

        // Si aucune catégorie n'existe, on les crées
        if (gestionnaireCategorie.count() < 1) {
            try {
                gestion.creerDonnees();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ServletPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                System.err.println("Fichier introuvable!!!");
            }
        }




        // On stock la liste des categories 
        getServletContext().setAttribute("categories", gestionnaireCategorie.findAll());
        getServletContext().setAttribute("produits", gestionnaireProduit.findAll());
    }

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        String userPath = request.getServletPath();
        HttpSession session = request.getSession();
        Categorie categorie = null;
        Collection<Produit> categoryProducts;




        if (session.getAttribute("groupeUtilisateur") != null) {

            System.out.println(session.getAttribute("groupeUtilisateur"));

            if (userPath.equals("/categorie")) {
                // On recupere la valeur de cat pour aller dans la categorie souhaitée
                String nomCategorie = request.getParameter("cat");


                if (nomCategorie != null && !nomCategorie.equals("")) {

                    categorie = gestionnaireCategorie.findByNom(nomCategorie);
                    if (categorie != null) {
                        session.setAttribute("categorie", categorie);
                        categoryProducts = categorie.getCollectionProduit();
                        session.setAttribute("categoryProducts", categoryProducts);




                    } // on affiche tous les produits
                    else {
                    }

                    RequestDispatcher dp = request.getRequestDispatcher("/vente/categorie.jsp?cat=" + nomCategorie);
                    dp.forward(request, response);
                }


            } else if (userPath.equals("/creerClient")) {
                if (session.getAttribute("groupeUtilisateur").equals("visiteur")) {
                    RequestDispatcher dp = request.getRequestDispatcher("/creerClient.jsp");
                    dp.forward(request, response);
                } else {
                    RequestDispatcher dp = request.getRequestDispatcher("home.jsp");
                    dp.forward(request, response);
                }

            } else if (userPath.equals("/information")) {

                String nomProduit = request.getParameter("nomProduit");



                request.setAttribute("nomProduit", nomProduit);

                getServletContext().setAttribute("produitRecherche", gestionnaireProduit.findByNom(nomProduit));




                RequestDispatcher dp = request.getRequestDispatcher("/vente/information.jsp?nomProduit=" + nomProduit);
                dp.forward(request, response);


            } else if (userPath.equals("/panier")) {


                String clear = request.getParameter("clear");

                if ((clear != null) && clear.equals("true")) {

                    Panier panier = (Panier) session.getAttribute("panier");

                    panier.effacerPanier();
                }




                RequestDispatcher dp = request.getRequestDispatcher("/vente/panier.jsp");
                dp.forward(request, response);


            } else if (userPath.equals("/paiement")) {


                if (session.getAttribute("groupeUtilisateur").equals("client")) {

                    String login = (String) session.getAttribute("login");

                    Client client = gestionnaireClient.findByLogin(login);
                    System.out.println("login "+login);
                    Commande_Client commandeClient = new Commande_Client();
                    commandeClient.setClient(client);

                    Panier panier = (Panier) session.getAttribute("panier");
                    commandeClient.setMontant(panier.getTotal());
                    System.out.println("montant total:  " +panier.getTotal());
                    
                    Random random = new Random();
                    int i = random.nextInt(999);
                    commandeClient.setNumero_confirmation(i);

                    List<ElementPanier> listeElementPanier = panier.getListeElementsCommande();

                    for (ElementPanier scItem : listeElementPanier) {

                        Commande commande = new Commande();
                        commande.setCommandeClient(commandeClient);

                        Produit produit = (Produit) scItem.getProduit();
                        commande.setProduit(produit);
                        System.out.println("nom produit: "+produit.getNom());

                        commande.setQuantite(scItem.getQuantiteCommande());
                        
                       
                        




                    }

                }


                RequestDispatcher dp = request.getRequestDispatcher("/vente/paiement.jsp");
                dp.forward(request, response);




            } else {
                RequestDispatcher dp = request.getRequestDispatcher("home.jsp");
                dp.forward(request, response);
            }


        } else {
            session.setAttribute("groupeUtilisateur", "visiteur");
            System.out.println(session.getAttribute("groupeUtilisateur"));
            RequestDispatcher dp = request.getRequestDispatcher("home.jsp");
            dp.forward(request, response);
        }
    }
// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userPath = request.getServletPath();
        HttpSession session = request.getSession();
        Panier panier = (Panier) session.getAttribute("panier");
        //Validator validator = new Validator();


        // if addToCart action is called
        if (userPath.equals("/addToCart")) {

            // if user is adding item to cart for first time
            // create cart object and attach it to user session
            if (panier == null) {

                panier = new Panier();
                session.setAttribute("panier", panier);
            }

            // get user input from request
            String nomProduitCommande = request.getParameter("nomProduitCommande");

            if (!nomProduitCommande.isEmpty()) {

                Produit produit = gestionnaireProduit.findByNom(nomProduitCommande);
                panier.ajouterProduit(produit);
                session.setAttribute("liste", panier.getListeElementsCommande());
            }

            RequestDispatcher dp = request.getRequestDispatcher("home.jsp");
            dp.forward(request, response);

        } else if (userPath.equals("/updateCart")) {

            // get input from request
            String nomProduitCommande = request.getParameter("nomProduitCommande");
            String quantite = request.getParameter("quantite");



            Produit produit = gestionnaireProduit.findByNom(nomProduitCommande);
            panier.miseAjour(produit, quantite);


            //userPath = "/vente/panier.jsp";

            RequestDispatcher dp = request.getRequestDispatcher("/vente/panier.jsp");
            dp.forward(request, response);

        }











    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
