/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package connexion;

import gestionnaire.GestionnaireAdministrateur;
import gestionnaire.GestionnaireClient;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
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
public class CreerEditerCompteServlet extends HttpServlet {

    @EJB
    private GestionnaireAdministrateur gestionnaireAdministrateur;
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
        String groupe = (String) session.getAttribute("groupeUtilisateur");
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();


        // va permettre de savoir si on cree/modifie/supprime:
        //  un Admin
        //  un client
        String but = request.getParameter("but");

        if (groupe.equals("client")) {
            // On crée un nouvel client
            if (but.equals("creerU")) {
                creerClient(out, request);
            } else if (but.equals("modifierU")) {
            }
        } else if (groupe.equals("administrateur")) {
            if (but.equals("creerA")) {
                creerAdmin(out, request);
            } else if (but.equals("modifierA")) {
            } else if (but.equals("modifierU")) {
            } 
            else if (but.equals("supprimerU")) {
                String login = request.getParameter("login");

                Client cl = gestionnaireClient.findByLogin(login);
                if (cl != null) {
                    gestionnaireClient.remove(cl);
                    out.print("1");
                } else {
                    out.print("-1");
                }
            } 
            else if (but.equals("supprimerA")) {
                String login = request.getParameter("login");

                // On verifie que l'admin ne veut pas supprimer son propre compte
                if (((String) session.getAttribute("login")).equals(login)) {
                    out.print("-2");
                } else {
                    Administrateur adm = gestionnaireAdministrateur.findByLogin(login);
                    if (adm != null) {
                        gestionnaireAdministrateur.remove(adm);
                        out.print("1");
                    } else {
                        out.print("-1");
                    }
                }
            }
        }

        out.flush();

        out.close();
    }
// Methode de création d'un client

    public void creerClient(PrintWriter out, HttpServletRequest request) {

        String login = request.getParameter("login");
        String mail = request.getParameter("email");

        // On regarde si le login existe deja
        Client cl = gestionnaireClient.findByLogin(login);

        if (cl != null) {
            // -1 -> erreur Login existant
            out.print("-1");
        } else {

            // On regarde si l'email est déja utilisé
            cl = gestionnaireClient.findByEmail(mail);
            if (cl != null) {
                // -2 -> erreur Email existant
                out.print("-2");
            } else {

                // on cree l'client
                cl = new Client(login, request.getParameter("password"), mail);
                cl.setNom(request.getParameter("nom"));
                cl.setPrenom(request.getParameter("prenom"));
                cl.setAdrFact(request.getParameter("adresse_f"));
                cl.setAdrFactZip(request.getParameter("adresse_f_zip"));
                cl.setAdrFactVille(request.getParameter("adresse_f_ville"));
                cl.setAdrLivraison(request.getParameter("adresse_l"));
                cl.setAdrLivrZip(request.getParameter("adresse_l_zip"));
                cl.setAdrLivrVille(request.getParameter("adresse_l_ville"));

                if (request.getParameter("num_tel") != null) {
                    cl.setTelephone(request.getParameter("num_tel"));
                }
                gestionnaireClient.create(cl);

                // 1 -> Success
                out.print("1");

            }
        }

        out.flush();
        out.close();
    }

    // Methode de création d'un client
    public void supprimerClient(PrintWriter out, HttpServletRequest request) {

        String login = request.getParameter("login");
        Client cl = gestionnaireClient.findByLogin(login);

        if (cl == null) {
            // -1 -> erreur Login inexistant
            out.print("-1");
        } else {
        }
    }
    // Methode de création d'un admin

    public void creerAdmin(PrintWriter out, HttpServletRequest request) {
        String login = request.getParameter("login");
        String mail = request.getParameter("email");

        // On regarde si le login existe deja
        Administrateur adm = gestionnaireAdministrateur.findByLogin(login);

        if (adm != null) {
            // -1 -> erreur Login existant
            out.print("-1");
        } else {

            // On regarde si l'email est déja utilisé
            adm = gestionnaireAdministrateur.findByEmail(mail);
            if (adm != null) {
                // -2 -> erreur Email existant
                out.print("-2");
            } else {

                // on cree l'client
                adm = new Administrateur(login, mail);
                adm.setPassword(request.getParameter("password"));
                adm.setNom(request.getParameter("nom"));

                if (request.getParameter("num_tel") != null) {
                    adm.setTelephone(request.getParameter("num_tel"));
                }
                gestionnaireAdministrateur.create(adm);

                // 1 -> Success
                out.print("1");

            }
        }

        out.flush();
        out.close();
    }

    public void supprimerAdmin(PrintWriter out, HttpServletRequest request) {

        String login = request.getParameter("login");

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
