/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Sangre
 */
public class ConnexionServlet extends HttpServlet {

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
        String test = "utilisateur";
        session.setAttribute("groupeUtilisateur", test);
        
        //On récupere le login et le password de la personne qui veut se logger;
        request.getParameter("login");
        /*
        if (LeNom == null) {
        LeNom = "";
        }
        if (motPasse == null) {
        motPasse = "";
        }
        if (pass == null) {
        pass = "";
        }
        
        if (session.getAttribute("nom") == null) {
        // cas ou l'utilisateur n'a rien mis
        if (LeNom.equals("admin") && motPasse.equals("admin")) {
        if (pass.equals("verifierLoginPassword")) {
        session.setAttribute("login", LeNom);
        session.setAttribute("password", motPasse);
        forwardTo = "home.jsp?action=todo";
        message = "Vous êtes loggé !";
        }
        
        } else {
        forwardTo = "home.jsp?action=todo";
        message = "Combinaison login/password incorrect!!";
        }
        } else {
        forwardTo = "home.jsp?action=todo";
        }*/
        
        // On envoit la reponse a la page pour savoir si oui ou non l'utilisateur existe
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        out.println("1");
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