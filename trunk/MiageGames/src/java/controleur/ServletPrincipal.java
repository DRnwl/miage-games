/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import gestionnaire.Gestion;
import gestionnaire.GestionnaireCategorie;
import gestionnaire.GestionnaireCategorieAge;
import gestionnaire.GestionnaireProduit;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
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
import models.Produit;

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
