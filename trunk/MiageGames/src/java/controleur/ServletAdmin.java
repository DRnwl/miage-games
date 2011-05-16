/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import gestionnaire.GestionnaireAdministrateur;
import gestionnaire.GestionnaireClient;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Administrateur;
import models.Client;

/**
 *
 * @author Sangre
 */
public class ServletAdmin extends HttpServlet {
    @EJB
    private GestionnaireClient gestionnaireClient;

    @EJB
    private GestionnaireAdministrateur gestionnaireAdministrateur;

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
            if (session.getAttribute("groupeUtilisateur").equals("administrateur")) {
                if (userPath.equals("/modifierA")) {

                    if (request.getParameter("login") != null) {

                        if (!session.getAttribute("login").equals(request.getParameter("login"))) {
                            Administrateur adm = gestionnaireAdministrateur.findByLogin(request.getParameter("login"));
                            if (adm != null) {
                                session.setAttribute("modifCompte", adm);
                                out.print("1");
                            } else {
                                // Le compte n'existe pas
                                out.print("-1");
                            }
                        } else {
                            // Un admin ne peut pas modifier son propre compte
                            // Il faut qu'il aille sur /modifierA pour ça
                            out.print("-2");
                        }
                    } else {
                        session.setAttribute("modifCompte", session.getAttribute("typeUtilisateur"));
                        RequestDispatcher dp = request.getRequestDispatcher("/admin/modifierAdmin.jsp");
                        dp.forward(request, response);
                    }

                } else if (userPath.equals("/modifierCl")) {
                    String rr = request.getParameter("login");
                    Client cl = gestionnaireClient.findByLogin(request.getParameter("login"));
                    if (cl != null) {
                        session.setAttribute("modifCompte", cl);
                        out.print("1");
                    } else {
                        // Le compte n'existe pas
                        out.print("-1");
                    }

                } else if (userPath.equals("/voirAdmin")) {
                    RequestDispatcher dp = request.getRequestDispatcher("/admin/voirAdmin.jsp");
                    dp.forward(request, response);


                } else if (userPath.equals("/voirClient")) {
                    RequestDispatcher dp = request.getRequestDispatcher("/admin/voirClient.jsp");
                    dp.forward(request, response);


                } // Pagination, je verrais apres si je peux pas faire une servlet a part pour
                // tous les affichages (admin/client/produit/commandes)
                else if (userPath.equals("/paginationAdmin")) {

                    int page = Integer.parseInt(request.getParameter("page")) - 1;
                    int parPage = 10;
                    int debut = page * parPage;
                    double test= 5.9;
                    double nbPage = ((gestionnaireAdministrateur.count()));
                    nbPage = Math.ceil(nbPage/parPage);
                    List<Administrateur> listeA = gestionnaireAdministrateur.findAllP(debut);
                    String remplir = "";
                    for (int i = 0; i < listeA.size(); i++) {
                        remplir += "<div>" + listeA.get(i).getLogin() + "</div>";
                    }
                    remplir += "<br /><div class='pagination'>";

                    if (page == 0) {
                        remplir += "<span class='disabled'>Deb</span>"
                                + "<span class='disabled'>Prec</span>";
                    } else {
                        remplir += "<a onClick='loadDataA(" + (1) + ")' href='#'>Deb</a>"
                                + "<a onClick='loadDataA(" + (page) + ")' href='#'>Prec</a>";

                    }
                    for (int i = 0; i < nbPage; i++) {

                        if (i == page) {
                            remplir += "<span class='current'>" + (i + 1) + "</span>";
                        } 
                        else
                        {
                            remplir += "<a onClick='loadDataA(" + (i + 1) + ")' href='#'>" + (i + 1) + "</a>";
                        }

                    }
                    if (page == (nbPage - 1)) {
                        remplir += "<span class='disabled'>Suiv</span>"
                                + "<span class='disabled'>Fin</span>";
                    } else {
                        remplir += "<a onClick='loadDataA(" + (page + 2) + ")' href='#'>Suiv</a>"
                                + "<a onClick='loadDataA(" + (nbPage) + ")' href='#'>Fin</a>";
                    }

                    out.print(remplir);


                } else {
                    RequestDispatcher dp = request.getRequestDispatcher("index.jsp");
                    dp.forward(request, response);
                }

            } else {
                RequestDispatcher dp = request.getRequestDispatcher("index.jsp");
                dp.forward(request, response);
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
