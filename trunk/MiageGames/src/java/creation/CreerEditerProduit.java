/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package creation;

import gestionnaire.GestionnaireCategorie;
import gestionnaire.GestionnaireCategorieAge;
import gestionnaire.GestionnaireDeveloppeur;
import gestionnaire.GestionnaireDistributeur;
import gestionnaire.GestionnaireEditeur;
import gestionnaire.GestionnaireProduit;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Categorie;
import models.Developpeur;
import models.Distributeur;
import models.Editeur;
import models.Produit;

/**
 *
 * @author Sangre
 */
public class CreerEditerProduit extends HttpServlet {

    @EJB
    private GestionnaireDistributeur gestionnaireDistributeur;
    @EJB
    private GestionnaireEditeur gestionnaireEditeur;
    @EJB
    private GestionnaireDeveloppeur gestionnaireDeveloppeur;
    @EJB
    private GestionnaireCategorieAge gestionnaireCategorieAge;
    @EJB
    private GestionnaireCategorie gestionnaireCategorie;
    @EJB
    private GestionnaireProduit gestionnaireProduit;

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
        String cat = request.getParameter("categorie");
        Categorie categorie = null;
        
        for(int i =0; i<((List<Categorie>)getServletContext().getAttribute("categories")).size();i++)
        {
            if(((List<Categorie>)getServletContext().getAttribute("categories")).get(i).getNom().equals(cat))
                categorie = ((List<Categorie>)getServletContext().getAttribute("categories")).get(i);
        }

        // va permettre de savoir si on cree/modifie/supprime un produit

        String but = request.getParameter("but");

        if (groupe.equals("administrateur")) {
            if (but.equals("creerP")) {
                
                creerProduit(categorie, out, request);
            } else if (but.equals("modifierP")) {

                String nom = request.getParameter("nom");
                int i = 0;
                Produit prod = (Produit) session.getAttribute("modifProduit");

                if (!prod.getNom().equals(nom)) {
                    if (gestionnaireProduit.findByNomCategorie(nom, categorie) == null) {
                        prod.setNom(nom);
                        i++;
                    } else {
                        out.print("-1");
                        return;
                    }
                }
                else
                
                if (!prod.getDescription().equals(request.getParameter("description"))) {
                    prod.setDescription(request.getParameter("description"));
                    i++;
                }
                if (!prod.getSortie().equals(request.getParameter("date_sortie"))) {
                    prod.setSortie(request.getParameter("sortie"));
                    i++;
                }
                if (prod.getQuantiteProduit()!= Integer.parseInt(request.getParameter("quantite"))) {
                    prod.setQuantiteProduit(Integer.parseInt(request.getParameter("quantite")));
                    i++;
                }
                if (!prod.getImage().equals(request.getParameter("image"))) {
                    prod.setImage(request.getParameter("image"));
                    i++;
                }
                if (!prod.getPrix().equals(Double.valueOf(request.getParameter("prix")))) {
                    prod.setPrix(Double.valueOf(request.getParameter("prix")));
                    i++;
                }
                if (prod.getCategorie().getNom().equals(request.getParameter("categorie"))) {
                    prod.setCategorie(categorie);
                    i++;
                }
                if (!prod.getCategorieAge().getNom().equals(request.getParameter("categorie_age"))) {
                    prod.setCategorieAge(gestionnaireCategorieAge.findByNom(request.getParameter("categorie_age")));
                    i++;

                }
                if (!prod.getDeveloppeur().getNomDeveloppeur().equals(request.getParameter("developpeur"))) {
                    Developpeur dev = gestionnaireDeveloppeur.findByNomDeveloppeur(request.getParameter("developpeur"));
                    if (dev == null) {
                        gestionnaireDeveloppeur.create(dev);
                    }

                    prod.setDeveloppeur(dev);
                    i++;
                }
                if (!prod.getDistributeur().getNom_distributeur().equals(request.getParameter("distributeur"))) {
                    Distributeur dis = gestionnaireDistributeur.findByNom_distributeur(request.getParameter("distributeur"));
                    if (dis == null) {
                        gestionnaireDistributeur.create(dis);
                    }

                    prod.setDistributeur(dis);
                    i++;
                }
                if (!prod.getEditeur().getNomEditeur().equals(request.getParameter("editeur"))) {
                    Editeur edt = gestionnaireEditeur.findByNomEditeur(request.getParameter("editeur"));
                    if (edt == null) {
                        gestionnaireEditeur.create(edt);
                    }

                    prod.setEditeur(edt);
                    i++;
                }

                if (i > 0) {
                    gestionnaireProduit.edit(prod);
                    session.setAttribute("modifProduit", prod);
                    out.print("1");
                } else {
                    out.print("-2");
                }
            } else if (but.equals("supprimerP")) {
                String nom = request.getParameter("nom");

                Produit prod = gestionnaireProduit.findByNomCategorie(nom,categorie);
                if (prod != null) {
                    gestionnaireProduit.remove(prod);
                    out.print("1");
                } else {
                    out.print("-1");
                }
            }



            out.flush();

            out.close();
        }
    }
// Methode de création d'un client

    public void creerProduit(Categorie cat, PrintWriter out, HttpServletRequest request) {

        String nom = request.getParameter("nom");
        // On regarde si le nom de produit existe deja
        Produit prod = gestionnaireProduit.findByNomCategorie(nom, cat);

        if (prod != null) {
            // -1 -> erreur Produit existant
            out.print("-1");
        } else {

            prod = new Produit(nom, Double.valueOf(request.getParameter("prix")),
                    cat, gestionnaireCategorieAge.findByNom(request.getParameter("categorie_age")));

            prod.setDescription(request.getParameter("description"));

            prod.setSortie(request.getParameter("date_sortie"));
            prod.setImage(request.getParameter("image"));
            prod.setQuantiteProduit(Integer.parseInt(request.getParameter("quantite")));


            Developpeur dev = gestionnaireDeveloppeur.findByNomDeveloppeur(request.getParameter("developpeur"));

            // Si le developpeur n'existe pas, on le crée
            if (dev == null) {
                dev = new Developpeur(request.getParameter("developpeur"));
                gestionnaireDeveloppeur.create(dev);
            }
            Distributeur dis = gestionnaireDistributeur.findByNom_distributeur(request.getParameter("distributeur"));

            // si le distributeur n'existe pas, on le crée
            if (dis == null) {
                dis = new Distributeur(request.getParameter("distributeur"));
                gestionnaireDistributeur.create(dis);
            }


            Editeur edt = gestionnaireEditeur.findByNomEditeur(request.getParameter("editeur"));

            // Si l'editeur n'existe pas, on le crée
            if (edt == null) {
                edt = new Editeur(request.getParameter("editeur"));
                gestionnaireEditeur.create(edt);
            }

            prod.setDeveloppeur(dev);
            prod.setEditeur(edt);
            prod.setDistributeur(dis);
            
            gestionnaireProduit.create(prod);
            // 1 -> Success
            out.print("1");


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
