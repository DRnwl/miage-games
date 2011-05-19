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

                } else if (userPath.equals("/pagination")) {
                    String page = request.getParameter("page");
                    if (page == null || page.equals("") || page.equals("0")) {
                        page = "1";
                        request.setAttribute("page", page);
                    }
                    
                    int pagee = Integer.parseInt(page) - 1;
                    double nbPage = 0;
                    List<Produit> liste = (List<Produit>) (session.getAttribute("commande"));
                    nbPage = liste.size();
                    
                    String remplir = "";
                    for (int i = 0; i < liste.size(); i++) {
                        
                        remplir += "<div ><div class='cl'>&nbsp;</div><div class='article'><div class='flottante'>"
                                + "<a href='information?nomProduit=" + liste.get(i).getNom() + "'><img src='" + liste.get(i).getImage() + "' alt='' /> </a>"
                                + "</div><div class ='flottante' > <h3><li><a href='information?nomProduit=" + liste.get(i).getNom() + "'>" + liste.get(i).getNom() + "</a></h3>"
                                + "<br><h4 style='font-size: 11px'> Sortie : <br>" + liste.get(i).getSortie() + " </h4><br><h5> Categorie:" + liste.get(i).getCategorie().getNom() + "</h5><br><h6 style='font-size: 12px'>"
                                + " Classification: <br>" + liste.get(i).getCategorieAge().getNom() + "</h6>"
                                + "</div><div class ='flottante'><strong class='price'>Prix : " + liste.get(i).getPrix() + "</strong> &euro;"
                                + "<br><strong class='price'>Quantité: " + (liste.get(i).getCollectionCommande().size()) + "</strong></div><div class ='flottante'> "
                                + "<strong class='price'>Total :" + (liste.get(i).getPrix() * liste.get(i).getCollectionCommande().size()) + "</strong> &euro;</div>";

                    }
                    remplir += "<br /><div class='pagination'>";


                    if (pagee == 0) {
                        remplir += "<span class='disabled'>Deb</span>"
                                + "<span class='disabled'>Prec</span>";
                    } else {
                        remplir += "<a 'onClick='loadData(" + (1) + ",\"pagination\")' href='#'>Deb</a>"
                                + "<a onClick='loadData(" + (pagee) + ",\"pagination\")' href='#'>Prec</a>";
                    }

                    for (int i = 0; i < nbPage; i++) {

                        if (i == pagee) {
                            remplir += "<span class='current'>" + (i + 1) + "</span>";
                        } else {
                            remplir += "<a  onClick='loadData(" + (i + 1) + ",\"pagination\")' href='#'>" + (i + 1) + "</a>";
                        }

                    }
                    if (pagee == (nbPage - 1)) {
                        remplir += "<span class='disabled'>Suiv</span>"
                                + "<span class='disabled'>Fin</span>";
                    } else {
                        remplir += "<a  onClick='loadData(" + (pagee + 2) + ",\"pagination\")' href='#'>Suiv</a>"
                                + "<a  onClick='loadData(" + ((int) nbPage) + ",\"pagination\")' href='#'>Fin</a>";
                    }
                    remplir += "</div>";
                    out.print(remplir);

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
