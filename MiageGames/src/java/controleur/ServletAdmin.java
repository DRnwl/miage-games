/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import gestionnaire.GestionnaireAdministrateur;
import gestionnaire.GestionnaireClient;
import gestionnaire.GestionnaireCommandeClient;
import gestionnaire.GestionnaireProduit;
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
import models.Categorie;
import models.Client;
import models.Commande;
import models.Commande_Client;
import models.Produit;

/**
 *
 * @author Sangre
 */
public class ServletAdmin extends HttpServlet {

    @EJB
    private GestionnaireCommandeClient gestionnaireCommandeClient;
    @EJB
    private GestionnaireProduit gestionnaireProduit;
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


                } else if (userPath.equals("/voirProduit")) {
                    RequestDispatcher dp = request.getRequestDispatcher("/admin/voirProduit.jsp");
                    dp.forward(request, response);


                } else if (userPath.equals("/modifierP")) {
                    String nom = request.getParameter("nom");
                    String cat = request.getParameter("categorie");

                    Categorie categorie = null;
                    for (int i = 0; i < ((List<Categorie>) getServletContext().getAttribute("categories")).size(); i++) {
                        if (((List<Categorie>) getServletContext().getAttribute("categories")).get(i).getNom().equals(cat)) {
                            categorie = ((List<Categorie>) getServletContext().getAttribute("categories")).get(i);
                        }
                    }
                    Produit prod = gestionnaireProduit.findByNomCategorie(nom, categorie);
                    if (prod != null) {
                        session.setAttribute("modifProduit", prod);
                        out.print("1");
                    } else {
                        // Le produit n'existe pas
                        out.print("-1");
                    }

                } else if (userPath.equals("/voirCommande")) {


                    RequestDispatcher dp = request.getRequestDispatcher("/admin/voirCommande.jsp");
                    dp.forward(request, response);


                } // Pagination
                else if (userPath.equals("/paginationAdmin")) {
                    String pagi = request.getParameter("pagi");
                    int page = Integer.parseInt(request.getParameter("page")) - 1;
                    int parPage = 5;
                    int debut = page * parPage;
                    double nbPage = 0;
                    List liste;
                    String remplir = "";
                    if (pagi.equals("Admin")) {
                        nbPage = ((gestionnaireAdministrateur.count()));
                        remplir += "<table id='tabAdmin' class='tablesorter'> <thead><tr> "
                                + "<th>Login</th>"
                                + "<th>Nom</th>"
                                + "<th>E-Mail</th>"
                                + "<th>Supprimer</th></tr></thead><tbody> ";


                        liste = gestionnaireAdministrateur.findAllP(debut, parPage);
                        for (int i = 0; i < liste.size(); i++) {
                            remplir += "<tr> <td>" + ((Administrateur) liste.get(i)).getLogin() + "</td>"
                                    + "<td>" + ((Administrateur) liste.get(i)).getNom() + "</td>"
                                    + "<td>" + ((Administrateur) liste.get(i)).getEmail() + "</td>"
                                    + "<td><a href='' onClick='Modif(\"Compte\",\"supprimerA\",\"login=" + ((Administrateur) liste.get(i)).getLogin() + "\",\"Admin\",\""+(page+1)+"\" );return false'><img width='15' height='15' src='css/images/supp.jpg' /></a></td></tr>";
                        }

                    } else if (pagi.equals("Client")) {
                        remplir += "<table id='tabClients' class='tablesorter'> <thead><tr> "
                                + "<th>Login</th>"
                                + "<th>Nom</th>"
                                + "<th>E-Mail</th>"
                                + "<th>Supprimer</th></tr></thead><tbody> ";
                        nbPage = ((gestionnaireClient.count()));
                        liste = gestionnaireClient.findAllP(debut, parPage);
                        for (int i = 0; i < liste.size(); i++) {
                            remplir += "<tr> <td>" + ((Client) liste.get(i)).getLogin() + "</td>"
                                    + "<td>" + ((Client) liste.get(i)).getNom() + "</td>"
                                    + "<td>" + ((Client) liste.get(i)).getEmail() + "</td>"
                                    + "<td><a href='' onClick='Modif(\"Compte\",\"supprimerC\",\"login=" + ((Client) liste.get(i)).getLogin() + "\",\"Client\",\""+(page+1)+"\" );return false'><img width='15' height='15' src='css/images/supp.jpg' /></a></td></tr>";
                        }
                    } else if (pagi.equals("Prod")) {
                        remplir += "<table id='tabProduits' class='tablesorter'> <thead><tr> "
                                + "<th>Nom</th>"
                                + "<th>Categorie</th>"
                                + "<th>Prix</th>"
                                + "<th>Quantite</th>"
                                + "<th>Supprimer</th></tr></thead><tbody> ";
                        nbPage = ((gestionnaireProduit.count()));
                        liste = gestionnaireProduit.findAllP(debut, parPage);
                        for (int i = 0; i < liste.size(); i++) {
                            String s = ((Produit) liste.get(i)).getNom();
                            
                            remplir += "<tr> <td>" + ((Produit) liste.get(i)).getNom() + "</td>"
                                    + "<td>" + ((Produit) liste.get(i)).getCategorie().getNom() + "</td>"
                                    + "<td>" + ((Produit) liste.get(i)).getPrix() + "&euro;</td>"
                                    + "<td>" + ((Produit) liste.get(i)).getQuantiteProduit() + "</td>"
                                    + "<td><a href='#' onClick='Modif(\"Produit\",\"supprimerP\",\"nom=" + s + "&categorie="+((Produit) liste.get(i)).getCategorie().getNom()+ "\",\"Prod\",\""+(page+1)+"\" );return false'><img width='15' height='15' src='css/images/supp.jpg' /></a></td></tr>";
                        }
                    } else {
                        remplir += "<table id='tabProduits' class='tablesorter'> <thead><tr> "
                                + "<th>Numero Commande</th>"
                                + "<th>Client</th>"
                                + "<th>Achat</th>"
                                + "<th>Date achat</th>"
                                + "<th>Total</th>"
                                + "<th>Supprimer</th></tr></thead><tbody> ";
                        nbPage = ((gestionnaireCommandeClient.count()));
                        liste = gestionnaireCommandeClient.findAllP(debut, parPage);
                        for (int i = 0; i < liste.size(); i++) {
                            List<Commande> lis = (List<Commande>) ((Commande_Client) liste.get(i)).getCollectionCommande();
                            remplir += "<tr> <td>" + ((Commande_Client) liste.get(i)).getNumero_confirmation() + "</td>"
                                    + "<td>" + ((Commande_Client) liste.get(i)).getClient().getLogin() + "</td>"
                                    + "<td><ul>";

                            for (int j = 0; j < lis.size(); j++) {
                                remplir += " <li style='font:80%/1 sans-serif;'>" + lis.get(j).getProduit().getNom() + " * " + lis.get(j).getQuantite() + "</li>";
                            }
                            remplir += "</ul></td>"
                                    + "<td>" + ((Commande_Client) liste.get(i)).getDate_achat() + "</td>"
                                    + "<td>" + ((Commande_Client) liste.get(i)).getMontant() + "&euro;</td>"
                                    + "<td><a href='#' onClick='Modif(\"Commande\",\"supprimerCo\",\"num_confirm=" + ((Commande_Client) liste.get(i)).getNumero_confirmation() + "\",\"Comd\",\""+(page+1)+"\" );return false'  ><img width='15' height='15' src='css/images/supp.jpg' /></a></td></tr>";
                        }
                    }
                    if(page >= (nbPage - 1))
                        page = (int)(nbPage - 1);
                    remplir += "</tbody></table>";
                    nbPage = Math.ceil(nbPage / parPage);

                    remplir += "<br /><div class='pagination'>";

                    if (page == 0) {
                        remplir += "<span class='disabled'>Deb</span>"
                                + "<span class='disabled'>Prec</span>";
                    } else {
                        remplir += "<a onClick='loadDataA(" + (1) + ",\"" + pagi + "\");return false' href='#'>Deb</a>"
                                + "<a onClick='loadDataA(" + (page) + ",\"" + pagi + "\");return false' href='#'>Prec</a>";

                    }
                    for (int i = 0; i < nbPage; i++) {

                        if (i == page) {
                            remplir += "<span class='current'>" + (i + 1) + "</span>";
                        } else {
                            remplir += "<a onClick='loadDataA(" + (i + 1) + ",\"" + pagi + "\");return false' href='#'>" + (i + 1) + "</a>";
                        }

                    }
                    if (page >= (nbPage - 1)) {
                        remplir += "<span class='disabled'>Suiv</span>"
                                + "<span class='disabled'>Fin</span>";
                    } else {
                        remplir += "<a onClick='loadDataA(" + (page + 2) + ",\"" + pagi + "\");return false' href='#'>Suiv</a>"
                                + "<a onClick='loadDataA(" + ((int) nbPage) + ",\"" + pagi + "\");return false' href='#'>Fin</a>";
                    }
                    remplir += "</div>";
                    out.print(remplir);


                } else {
                    out.print("-1");
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
