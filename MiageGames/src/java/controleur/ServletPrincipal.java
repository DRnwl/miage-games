/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import gestionnaire.Gestion;
import gestionnaire.GestionnaireCategorie;
import gestionnaire.GestionnaireCategorieAge;
import gestionnaire.GestionnaireClient;
import gestionnaire.GestionnaireCommande;
import gestionnaire.GestionnaireCommandeClient;
import gestionnaire.GestionnaireProduit;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
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
    private GestionnaireCommande gestionnaireCommande;
    @EJB
    private GestionnaireCommandeClient gestionnaireCommandeClient;
    @EJB
    private GestionnaireClient gestionnaireClient;
    @EJB
    private GestionnaireCategorieAge gestionnaireCategorieAge;
    @EJB
    private GestionnaireProduit gestionnaireProduit;
    @EJB
    private GestionnaireCategorie gestionnaireCategorie;
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
        getServletContext().setAttribute("categorieAge", gestionnaireCategorieAge.findAll());

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
        Panier panier = (Panier) session.getAttribute("panier");

        if (session.getAttribute("groupeUtilisateur") == null) {

            session.setAttribute("groupeUtilisateur", "visiteur");
        }

        if (userPath.equals("/ServletPrincipal")) {
            String page = request.getParameter("page");
            if (page == null || page.equals("") || page.equals("0")) {
                page = "1";
                request.setAttribute("page", page);
            }

            int pagee = Integer.parseInt(page) - 1;
            int parPage = 5;
            int debut = pagee * parPage;
            double nbPage = 0;
            List<Produit> liste = gestionnaireProduit.findAllP(debut, parPage);
            String but = request.getParameter("but");
            nbPage = ((gestionnaireProduit.count()));
            nbPage = Math.ceil(nbPage / parPage);
            if (but == null) {
                but = "";
            }
            if (!but.equals("reload")) {

                request.setAttribute("listeP", liste);
                request.setAttribute("page", pagee);
                request.setAttribute("nbPage", (int) nbPage);

                RequestDispatcher dp = request.getRequestDispatcher("home.jsp");
                dp.forward(request, response);
            } else {

                response.setContentType("text/plain");
                PrintWriter out = response.getWriter();

                String remplir = "";
                for (int i = 0; i < liste.size(); i++) {
                    remplir += "<div ><div class='cl'>&nbsp;</div><div class='article'><div class='flottante'>"
                            + "<a href='information?nomProduit=" + liste.get(i).getNom() + "'><img src='" + liste.get(i).getImage() + "' alt='' /> </a>"
                            + "</div><div class ='flottante' > <h3><li><a href='information?nomProduit=" + liste.get(i).getNom() + "'>" + liste.get(i).getNom() + "</a></h3>"
                            + "<br><h4 style='font-size: 11px'> Sortie : <br>" + liste.get(i).getSortie() + " </h4><br><h5> Categorie:" + liste.get(i).getCategorie().getNom() + "</h5><br><h6 style='font-size: 12px'>"
                            + "  Classification: <br>" + liste.get(i).getCategorieAge().getNom() + "</h6>"
                            + "</div><div class ='flottante'><strong class='price'>Prix : " + liste.get(i).getPrix() + "</strong> &euro;"
                            + "<td><form class='formulaire' action='addToCart' method='post'>"
                            + " <input type='hidden' name='nomProduitCommande' value='" + liste.get(i).getNom() + "'>"
                            + " <input class='button' type='submit' name='submit' value=Achat /> </form>  </td><br></div></div><br class='clear'></div>";

                }

                remplir += "<br /><div class='pagination'>";


                if (pagee == 0) {
                    remplir += "<span class='disabled'>Deb</span>"
                            + "<span class='disabled'>Prec</span>";
                } else {
                    remplir += "<a 'onClick='loadData(" + (1) + ",\"ServletPrincipal\")' href='#'>Deb</a>"
                            + "<a onClick='loadData(" + (pagee) + ",\"ServletPrincipal\")' href='#'>Prec</a>";
                }

                for (int i = 0; i < nbPage; i++) {

                    if (i == pagee) {
                        remplir += "<span class='current'>" + (i + 1) + "</span>";
                    } else {
                        remplir += "<a  onClick='loadData(" + (i + 1) + ",\"ServletPrincipal\")' href='#'>" + (i + 1) + "</a>";
                    }

                }
                if (pagee >= (nbPage - 1)) {
                    remplir += "<span class='disabled'>Suiv</span>"
                            + "<span class='disabled'>Fin</span>";
                } else {
                    remplir += "<a  onClick='loadData(" + (pagee + 2) + ",\"ServletPrincipal\")' href='#'>Suiv</a>"
                            + "<a  onClick='loadData(" + ((int) nbPage) + ",\"ServletPrincipal\")' href='#'>Fin</a>";
                }
                remplir += "</div>";
                out.print(remplir);

            }

        } else if (userPath.equals("/categorie")) {
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




        } else if (userPath.equals(
                "/creerClient")) {
            if (session.getAttribute("groupeUtilisateur").equals("visiteur")) {
                RequestDispatcher dp = request.getRequestDispatcher("/creerClient.jsp");
                dp.forward(request, response);
            } else {
                RequestDispatcher dp = request.getRequestDispatcher("home.jsp");
                dp.forward(request, response);
            }

        } else if (userPath.equals(
                "/information")) {

            String nomProduit = request.getParameter("nomProduit");



            request.setAttribute("nomProduit", nomProduit);

            getServletContext().setAttribute("produitRecherche", gestionnaireProduit.findByNom(nomProduit));


            RequestDispatcher dp = request.getRequestDispatcher("/vente/information.jsp?nomProduit=" + nomProduit);
            dp.forward(request, response);




        } else if (userPath.equals("/panier")) {


            String clear = request.getParameter("clear");

            if ((clear != null) && clear.equals("true")) {

                Panier panierr = (Panier) session.getAttribute("panier");

                panierr.effacerPanier();
            }




            RequestDispatcher dp = request.getRequestDispatcher("/vente/panier.jsp");
            dp.forward(request, response);


        } else if (userPath.equals("/paiement")) {


            if (session.getAttribute("groupeUtilisateur").equals("client")) {

                String login = (String) session.getAttribute("login");

                Client client = gestionnaireClient.findByLogin(login);
                System.out.println("login " + login);
                Commande_Client commandeClient = new Commande_Client();
                commandeClient.setClient(client);
                client.getCollectionCommandeClient().add(commandeClient);

                double total = (double) Math.round(panier.getTotal() * 100) / 100;
                commandeClient.setMontant(total);
                System.out.println("montant total:  " + total);

                Random random = new Random();
                int i = random.nextInt(99999);
                commandeClient.setNumero_confirmation(i);

                gestionnaireCommandeClient.create(commandeClient);


                List<ElementPanier> listeElementPanier = panier.getListeElementsCommande();

                for (ElementPanier scItem : listeElementPanier) {

                    Commande commande = new Commande();
                    commande.setCommandeClient(commandeClient);

                    Produit produit = (Produit) scItem.getProduit();
                    commande.setProduit(produit);
                    System.out.println("nom produit: " + produit.getNom());

                    commande.setQuantite(scItem.getQuantiteCommande());

                    gestionnaireCommande.create(commande);
                    commandeClient.getCollectionCommande().add(commande);


                }

                gestionnaireCommandeClient.edit(commandeClient);
                gestionnaireClient.edit(client);
                client = gestionnaireClient.findByLogin(login);
                session.setAttribute("typeUtilisateur", client);
                session.setAttribute("montantTotal", panier.getTotal());
                session.setAttribute("panier", null);

            }


            RequestDispatcher dp = request.getRequestDispatcher("/vente/paiement.jsp");
            dp.forward(request, response);

        } else if (userPath.equals("/addToCart")) {


            if (panier == null) {

                panier = new Panier();
                session.setAttribute("panier", panier);
            }

            String nomProduitCommande = request.getParameter("nomProduitCommande");

            if (!nomProduitCommande.isEmpty()) {

                Produit produit = gestionnaireProduit.findByNom(nomProduitCommande);
                panier.ajouterProduit(produit);
                session.setAttribute("liste", panier.getListeElementsCommande());
            }

            String page = request.getParameter("page");
            if (page == null || page.equals("") || page.equals("0")) {
                page = "1";
                request.setAttribute("page", page);
            }

            int pagee = Integer.parseInt(page) - 1;
            int parPage = 5;
            int debut = pagee * parPage;
            double nbPage = 0;
            List<Produit> liste = gestionnaireProduit.findAllP(debut, parPage);
            String but = request.getParameter("but");
            nbPage = ((gestionnaireProduit.count()));
            nbPage = Math.ceil(nbPage / parPage);

            request.setAttribute("listeP", liste);
            request.setAttribute("page", pagee);
            request.setAttribute("nbPage", (int) nbPage);

            RequestDispatcher dp = request.getRequestDispatcher("home.jsp");
            dp.forward(request, response);

        } else if (userPath.equals("/updateCart")) {


            String nomProduitCommande = request.getParameter("nomProduitCommande");
            String quantite = request.getParameter("quantite");



            Produit produit = gestionnaireProduit.findByNom(nomProduitCommande);
            panier.miseAjour(produit, quantite);



            RequestDispatcher dp = request.getRequestDispatcher("/vente/panier.jsp");
            dp.forward(request, response);

        } else {
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
        processRequest(request, response);




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
