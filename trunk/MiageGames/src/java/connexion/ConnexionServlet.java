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
        
        // On recupere ce que l'client a choisi comme login/password
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String groupe = request.getParameter("groupe");

        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();

        // on vérifie que la session est bien visiteur.
        if (session.getAttribute("groupeUtilisateur").equals("visiteur")) {

            // Jquery a deja verifie, mais on le fait par soucis de sécurité
            if (login != null && password != null && !login.equals("") && !password.equals("")) {
                // Si on veut se logger en client
                if (groupe.equals("usr")) {
                    // On cherche le client
                    Client cl = gestionnaireClient.findByLogin(login);

                    // On verifie qu'on a bien trouvé quelquechose
                    if (cl != null) {

                        //On vérifie que le couple login/password est bon
                        if (cl.getPassword().equals(password)) {
                            // 1 -> Success
                            out.println("1");
                            session.setAttribute("groupeUtilisateur", "client");
                            session.setAttribute("login", login);
                            session.setAttribute("typeUtilisateur", cl);
                        } else {
                            // -1 -> erreur Le login existe mais le mdp est mauvais
                            out.println("-1");
                        }
                    } 
                    else {
                        // -2 -> Le compte n'existe pas
                        out.println("-2");
                    }
                }
                // Si on veut se logger en admin
                else if (groupe.equals("adm")) {
                    Administrateur adm = gestionnaireAdministrateur.findByLogin(login);
                    if (adm != null) {

                        //On vérifie que le couple login/password est bon
                        if (adm.getPassword().equals(password)) {
                            // 1 -> Success
                            out.println("1");
                            session.setAttribute("groupeUtilisateur", "administrateur");
                            session.setAttribute("login", login);
                            session.setAttribute("typeUtilisateur", adm);
                        } else {
                             // -1 -> erreur Le login existe mais le mdp est mauvais
                            out.println("-1");
                        }

                    } else {
                        // -2 -> Le compte n'existe pas
                        out.println("-2");
                    }

                }
                else
                    out.println("-1");
            } // On indique a la jsp qu'il y a eu une erreur
            else {
                out.println("-1");
            }

        }
        // L'client peut passer sur un compte administrateur
        else if(session.getAttribute("groupeUtilisateur").equals("client"))
        {
             if (login != null && password != null && !login.equals("") && !password.equals("")) {
                 Administrateur adm = gestionnaireAdministrateur.findByLogin(login);
                    if (adm != null) {

                        //On vérifie que le couple login/password est bon
                        if (adm.getPassword().equals(password)) {
                            // 1 -> Success
                            out.println("1");
                            session.setAttribute("groupeUtilisateur", "administrateur");
                            session.setAttribute("login", login);
                            session.setAttribute("typeUtilisateur", adm);
                        } else {
                            // -1 -> erreur Le login existe mais le mdp est mauvais
                            out.println("-1");
                        }

                    } else {
                        // -2 -> erreur Le compte n'existe pas
                        out.println("-2");
                    }
             }
             else {
                 // -1 -> erreur 
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
