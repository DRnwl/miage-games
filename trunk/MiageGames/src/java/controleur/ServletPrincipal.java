/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import gestionnaire.GestionnaireCategorie;
import gestionnaire.GestionnaireProduit;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sangre
 */
public class ServletPrincipal extends HttpServlet {
    @EJB
    private GestionnaireProduit gestionnaireProduit;
    @EJB
    private GestionnaireCategorie gestionnaireCategorie;
    
    

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

        super.init(servletConfig);
        
        // Si aucune catégorie n'existe, on les crées
        if(gestionnaireCategorie.count() < 1)
             gestionnaireCategorie.creerCategoriesTest();
        
        if(gestionnaireProduit.count() < 1)
            gestionnaireProduit.creerProduitsTest();
        
        
        // On stock la liste des catégories 
        getServletContext().setAttribute("categories", gestionnaireCategorie.findAll());
        getServletContext().setAttribute("produits", gestionnaireProduit.findAll());
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
        
         
         String userPath = request.getServletPath();
        
         System.out.println(userPath);
         RequestDispatcher dp = request.getRequestDispatcher("home.jsp");

        dp.forward(request, response);
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
