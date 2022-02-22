/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Classes_et_BD.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Henockl
 */
public class acceuil extends HttpServlet {
    String sqlresponse;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String message = "L2 Info(résau et conception)";
        request.setAttribute("message", message);

        this.getServletContext().getRequestDispatcher("/WEB-INF/acceuil.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("Enregistrer") != null && request.getParameter("id_etudiant") != "") {
            String id = request.getParameter("id_etudiant");
            String nom = request.getParameter("nom_etudiant");
            String postnom = request.getParameter("postnom_etudiant");
            String prenom = request.getParameter("prenom_etudiant");
            Etudiant et = new Etudiant(id, nom, postnom, prenom);
            try {
                et.enregistrer(et);
                 sqlresponse = "<div class=\" alert-success\" style=\"text-align: center; width: 60%; margin: auto; font-size: 150%; font-weight: bold;\">succès</div>";
            } catch (SQLException ex) {
                Logger.getLogger(acceuil.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (request.getParameter("Modifier") != null && request.getParameter("id_etudiant") != "") {
            String id = request.getParameter("id_etudiant");
            String nom = request.getParameter("nom_etudiant");
            String postnom = request.getParameter("postnom_etudiant");
            String prenom = request.getParameter("prenom_etudiant");
            Etudiant et = new Etudiant(id, nom, postnom, prenom);
            try {
                et.mettreAjour(et);
                sqlresponse = "<div class=\" alert-succes\" style=\"text-align: center; width: 60%; margin: auto; font-size: 150%; font-weight: bold;\"> succès</div>";
            } catch (SQLException ex) {
                Logger.getLogger(acceuil.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
         String message = "L2 Info(résau et conception)";
        request.setAttribute("message", message);
         request.setAttribute("sqlresponse", sqlresponse);
         this.getServletContext().getRequestDispatcher("/WEB-INF/acceuil.jsp").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
