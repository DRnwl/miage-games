/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package connexion;

import gestionnaire.GestionnaireAdministrateur;
import gestionnaire.GestionnaireClient;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletConfig;
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
public class ConnexionServlet extends HttpServlet {

    @EJB
    private GestionnaireAdministrateur gestionnaireAdministrateur;
    @EJB
    private GestionnaireClient gestionnaireClient;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

        super.init(servletConfig);

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

        HttpSession session = request.getSession();



        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();

        // on vérifie que la session est bien visiteur.
        if (session.getAttribute("groupeUtilisateur") == "visiteur") {

            // On recupere ce que l'utilisateur a choisi comme login/password
            String login = request.getParameter("login");
            String password = request.getParameter("password");

            // Jquery a deja verifie, mais on le fait par soucis de sécurité
            if (login != null && password != null && !login.equals("") && !password.equals("")) {

                // On cherche le client
                Client cl = gestionnaireClient.findByLogin(login);

                // On verifie qu'on a bien trouvé quelquechose
                if (cl != null) {

                    //On vérifie que le couple login/password est bon
                    if (cl.getPassword().equals(password)) {
                        out.println("1");
                        session.setAttribute("groupeUtilisateur", "utilisateur");
                    } else {
                        out.println("-1");
                    }
                } // Le compte n'existe pas
                else {
                    Administrateur adm = gestionnaireAdministrateur.findByLogin(login);
                    if (adm != null) {

                        //On vérifie que le couple login/password est bon
                        if (adm.getPassword().equals(password)) {
                            out.println("2");
                            session.setAttribute("groupeUtilisateur", "administrateur");
                        } else {
                            out.println("-1");
                        }

                    } else {
                        out.println("-2");
                    }

                }
            } // On indique a la jsp qu'il y a eu une erreur
            else {
                out.println("-1");
            }

        }
        out.flush();
        out.close();
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
