/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import gestionnaire.GestionnaireClient;
import gestionnaire.GestionnaireCommandeClient;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import models.Client;
import models.Commande_Client;
import models.Produit;

/**
 *
 * @author Sangre
 */
public class ServletClient extends HttpServlet {

    @EJB
    private GestionnaireCommandeClient gestionnaireCommandeClient;
    @EJB
    private GestionnaireClient gestionnaireClient;

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String userPath = request.getServletPath();

        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        if (session.getAttribute("groupeUtilisateur") != null) {
            if (session.getAttribute("groupeUtilisateur").equals("client")) {
                if (userPath.equals("/modifierC")) {

                    RequestDispatcher dp = request.getRequestDispatcher("/utilisateur/modifierCompte.jsp");
                    dp.forward(request, response);
                } else if (userPath.equals("/voirCommandes")) {
                    RequestDispatcher dp = request.getRequestDispatcher("/utilisateur/voirCommandes.jsp");
                    dp.forward(request, response);
                } else if (userPath.equals("/detailCommande")) {
                    System.out.println(request.getParameter("commande"));
                    Commande_Client cl = gestionnaireCommandeClient.findById(Integer.valueOf(request.getParameter("commande")));
                    request.setAttribute("montant", cl.getMontant());
                    session.setAttribute("commandeC", cl.getCollectionCommande());
                    request.setAttribute("page", 0);
                    request.setAttribute("nbPage", (int) cl.getCollectionCommande().size());
                    RequestDispatcher dp = request.getRequestDispatcher("/utilisateur/detailCommande.jsp");
                    dp.forward(request, response);

                }
            }
        } else {
            RequestDispatcher dp = request.getRequestDispatcher("index.jsp");
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
