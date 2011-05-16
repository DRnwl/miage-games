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

        if (groupe.equals("visiteur")) {
            if (but.equals("creerC")) {
                creerClient(out, request);
            }
        } else if (groupe.equals("client")) {
            // Un client veut modifier son compte
            if (but.equals("modifierC")) {
                String email = request.getParameter("email");
                int i = 0;
                Client cl = (Client) session.getAttribute("typeUtilisateur");
                if (!cl.getEmail().equals(email)) {
                    if (gestionnaireClient.findByEmail(email) == null) {
                        cl.setEmail(email);
                        i++;
                    } else {
                        out.print("-1");
                        return;
                    }
                }

                if (!cl.getPassword().equals(request.getParameter("password"))) {
                    cl.setPassword(request.getParameter("password"));
                    i++;
                }
                if (!cl.getNom().equals(request.getParameter("nom"))) {
                    cl.setNom(request.getParameter("nom"));
                    i++;
                }
                if (!cl.getPrenom().equals(request.getParameter("prenom"))) {
                    cl.setPrenom(request.getParameter("prenom"));
                    i++;
                }
                if (!cl.getAdrFact().equals(request.getParameter("adresse_f"))) {
                    cl.setAdrFact(request.getParameter("adresse_f"));
                    i++;
                }
                if (!cl.getAdrFactZip().equals(request.getParameter("adresse_f_zip"))) {
                    cl.setAdrFactZip(request.getParameter("adresse_f_zip"));
                    i++;
                }
                if (!cl.getAdrFactVille().equals(request.getParameter("adresse_f_ville"))) {
                    cl.setAdrFactVille(request.getParameter("adresse_f_ville"));
                    i++;
                }
                if (!cl.getAdrLivraison().equals(request.getParameter("adresse_l"))) {
                    cl.setAdrLivraison(request.getParameter("adresse_l"));
                    i++;
                }
                if (!cl.getAdrLivrZip().equals(request.getParameter("adresse_l_zip"))) {
                    cl.setAdrLivrZip(request.getParameter("adresse_l_zip"));
                    i++;

                }
                if (!cl.getAdrLivrVille().equals(request.getParameter("adresse_l_ville"))) {
                    cl.setAdrLivrVille(request.getParameter("adresse_l_ville"));
                    i++;
                }
                if (request.getParameter("num_tel") != null) {
                    cl.setTelephone("");
                }
                if (!cl.getTelephone().equals(request.getParameter("num_tel"))) {
                    cl.setTelephone(request.getParameter("num_tel"));
                    i++;
                }
                if (i > 0) {
                    gestionnaireClient.edit(cl);
                    session.setAttribute("typeUtilisateur", cl);
                    out.print("1");
                } else {
                    out.print("-2");
                }
            }
        } else if (groupe.equals("administrateur")) {
            if (but.equals("creerA")) {
                creerAdmin(out, request);
            } else if (but.equals("modifierA")) {

                String login = request.getParameter("login");
                String email = request.getParameter("email");
                boolean change = false;
                //On regarde si une modification a bien été effectuée
                int i = 0;

                if (session.getAttribute("modifCompte").equals(session.getAttribute("typeUtilisateur"))) {
                    change = true;
                }
                Administrateur adm = (Administrateur) session.getAttribute("modifCompte");
                if (!adm.getEmail().equals(email)) {

                    if (gestionnaireAdministrateur.findByEmail(email) == null) {
                        adm.setEmail(email);
                        i++;
                    } else {
                        out.print("-1");
                        return;
                    }
                }
                if (!adm.getLogin().equals(login)) {
                    if (gestionnaireAdministrateur.findByLogin(login) == null) {
                        adm.setLogin(login);
                        i++;
                    } else {
                        out.print("-2");
                        return;
                    }
                }
                if (!adm.getPassword().equals(request.getParameter("password"))) {
                    adm.setPassword(request.getParameter("password"));
                    i++;
                }
                if (!adm.getNom().equals(request.getParameter("nom"))) {
                    adm.setNom(request.getParameter("nom"));
                    i++;
                }
                if (request.getParameter("num_tel") == null) {
                    adm.setTelephone("");
                }
                if (!adm.getTelephone().equals(request.getParameter("num_tel"))) {
                    adm.setTelephone(request.getParameter("num_tel"));
                    i++;
                }
                if (i > 0) {
                    if (change) {
                        session.setAttribute("login", login);
                        session.setAttribute("typeUtilisateur", adm);
                    } else {
                        session.setAttribute("modifCompte", adm);
                    }
                    gestionnaireAdministrateur.edit(adm);


                    out.print("1");
                } else {
                    out.print("-3");
                }


            } else if (but.equals("supprimerA")) {
                String login = request.getParameter("login");

                // On verifie que l'admin ne peut pas supprimer son propre compte
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
            } else if (but.equals("creerC")) {
                creerClient(out, request);
            } else if (but.equals("modifierC")) {
                String email = request.getParameter("email");
                String login = request.getParameter("login");

                int i = 0;
                Client cl = (Client) session.getAttribute("modifCompte");
                if (!cl.getEmail().equals(email)) {
                    if (gestionnaireClient.findByEmail(email) == null) {
                        cl.setEmail(email);
                        i++;
                    } else {
                        out.print("-1");
                        return;
                    }
                }
                if (!cl.getLogin().equals(login)) {
                    if (gestionnaireAdministrateur.findByLogin(login) == null) {
                        cl.setLogin(login);
                        i++;
                    } else {
                        out.print("-2");
                        return;
                    }
                }
                if (!cl.getPassword().equals(request.getParameter("password"))) {
                    cl.setPassword(request.getParameter("password"));
                    i++;
                }
                if (!cl.getNom().equals(request.getParameter("nom"))) {
                    cl.setNom(request.getParameter("nom"));
                    i++;
                }
                if (!cl.getPrenom().equals(request.getParameter("prenom"))) {
                    cl.setPrenom(request.getParameter("prenom"));
                    i++;
                }
                if (!cl.getAdrFact().equals(request.getParameter("adresse_f"))) {
                    cl.setAdrFact(request.getParameter("adresse_f"));
                    i++;
                }
                if (!cl.getAdrFactZip().equals(request.getParameter("adresse_f_zip"))) {
                    cl.setAdrFactZip(request.getParameter("adresse_f_zip"));
                    i++;
                }
                if (!cl.getAdrFactVille().equals(request.getParameter("adresse_f_ville"))) {
                    cl.setAdrFactVille(request.getParameter("adresse_f_ville"));
                    i++;
                }
                if (!cl.getAdrLivraison().equals(request.getParameter("adresse_l"))) {
                    cl.setAdrLivraison(request.getParameter("adresse_l"));
                    i++;
                }
                if (!cl.getAdrLivrZip().equals(request.getParameter("adresse_l_zip"))) {
                    cl.setAdrLivrZip(request.getParameter("adresse_l_zip"));
                    i++;

                }
                if (!cl.getAdrLivrVille().equals(request.getParameter("adresse_l_ville"))) {
                    cl.setAdrLivrVille(request.getParameter("adresse_l_ville"));
                    i++;
                }
                if (request.getParameter("num_tel") != null) {
                    cl.setTelephone("");
                }
                if (!cl.getTelephone().equals(request.getParameter("num_tel"))) {
                    cl.setTelephone(request.getParameter("num_tel"));
                    i++;
                }
                if (i > 0) {
                    gestionnaireClient.edit(cl);
                    session.setAttribute("modifCompte", cl);
                    out.print("1");
                } else {
                    out.print("-2");
                }
            } else if (but.equals("supprimerC")) {
                String login = request.getParameter("login");

                Client cl = gestionnaireClient.findByLogin(login);
                if (cl != null) {
                    gestionnaireClient.remove(cl);
                    out.print("1");
                } else {
                    out.print("-1");
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
                } else {
                    cl.setTelephone("");
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
                adm = new Administrateur(login, request.getParameter("password"), mail);
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
