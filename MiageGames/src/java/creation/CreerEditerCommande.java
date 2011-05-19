/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package creation;

import gestionnaire.GestionnaireCommandeClient;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Commande_Client;

/**
 *
 * @author Sangre
 */
public class CreerEditerCommande extends HttpServlet {
    @EJB
    private GestionnaireCommandeClient gestionnaireCommandeClient;

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();
        String groupe = (String) session.getAttribute("groupeUtilisateur");

        String but = request.getParameter("but");

        if (groupe.equals("administrateur")) {

            if (but.equals("supprimerCo")) {
                int numConfirm = Integer.valueOf(request.getParameter("num_confirm"));

                Commande_Client comClient = gestionnaireCommandeClient.findByNumC(numConfirm);
                if (comClient != null) {
                    gestionnaireCommandeClient.remove(comClient);
                    out.print("1");
                } else {
                    out.print("-1");
                }
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
