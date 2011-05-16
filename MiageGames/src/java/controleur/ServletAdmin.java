/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import gestionnaire.GestionnaireAdministrateur;
import java.io.IOException;
import java.io.PrintWriter;
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
                        String str = request.getParameter("login");
                        if (!session.getAttribute("login").equals(request.getParameter("login"))) {
                            Administrateur adm = gestionnaireAdministrateur.findByLogin(request.getParameter("login"));
                            if (adm != null) {
                                session.setAttribute("modifCompte", adm);
                                out.print("1");
                            } else {
                                out.print("-1");
                            }
                        } else {
                            out.print("-2");
                        }
                    } else {
                        session.setAttribute("modifCompte", session.getAttribute("typeUtilisateur"));
                        RequestDispatcher dp = request.getRequestDispatcher("/admin/modifierAdmin.jsp");
                        dp.forward(request, response);
                    }
                    
                }
                if (userPath.equals("/voirAdmin")) {
                    RequestDispatcher dp = request.getRequestDispatcher("/admin/voirAdmin.jsp");
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
