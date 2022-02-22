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
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Classes_et_BD.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Henockl
 */
public class liste extends HttpServlet {

    Collection<String> liste_date = new ArrayList<>();
    Collection<String> liste_absent = new ArrayList<>();
    Collection<String> liste_present = new ArrayList<>();

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
        try ( PrintWriter out = response.getWriter()) {
        }
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
        String message = "Liste par date";
        request.setAttribute("message", message);
        DB bd = new DB();
        bd.connection();
        String query = "select * from presence GROUP by date_presence";
        try {
            liste_date.clear();
            PreparedStatement p = bd.con.prepareStatement(query);
            ResultSet res = p.executeQuery();
            while (res.next()) {
                liste_date.add(res.getString("date_presence"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(liste.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("liste_date", liste_date);
        this.getServletContext().getRequestDispatcher("/WEB-INF/liste.jsp").forward(request, response);
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
        if (request.getParameter("rechercher") != null) {
            liste_present.clear();
            liste_absent.clear();
            String date = (String) request.getParameter("date");
            String dateUTF8 = new String(date.getBytes(), "UTF-8");
            DB data = new DB();
            data.connection();
            String query = "select * from etudiant inner join presence on etudiant.id_etudiant=presence.id_etudiant where satus_presence='present' and presence.date_presence='" + dateUTF8 + "'";
            String query1 = "select * from etudiant inner join presence on etudiant.id_etudiant=presence.id_etudiant where satus_presence='absent' and presence.date_presence='" + dateUTF8 + "'";
            try {
                PreparedStatement p = data.con.prepareStatement(query);
                ResultSet r = p.executeQuery();
                while (r.next()) {
                    int i = 1;
                    String nom = String.valueOf(i) + ". " + r.getString("nom_etudiant") + " " + r.getString("postnom_etudiant") + " " + r.getString("prenom_etudiant");
                    liste_present.add(nom);
                    i++;
                }

            } catch (SQLException ex) {
                Logger.getLogger(liste.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                //absent
                PreparedStatement p1 = data.con.prepareStatement(query1);
                ResultSet r1 = p1.executeQuery();
                while (r1.next()) {
                    int i = 1;
                    String nom = String.valueOf(i) + ". " + r1.getNString("nom_etudiant") + " " + r1.getString("postnom_etudiant") + " " + r1.getString("prenom_etudiant");
                    liste_absent.add(nom);
                    i++;
                }
            } catch (SQLException ex) {
                Logger.getLogger(liste.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        //rechargement du select
        String message = "Liste par date";
        request.setAttribute("message", message);
        DB bd = new DB();
        bd.connection();
        String query = "select * from presence GROUP by date_presence";
        try {
            liste_date.clear();
            PreparedStatement p = bd.con.prepareStatement(query);
            ResultSet res = p.executeQuery();
            while (res.next()) {
                liste_date.add(res.getString("date_presence"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(liste.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("liste_date", liste_date);
        request.setAttribute("liste_present", liste_present);
        request.setAttribute("liste_absent", liste_absent);
        this.getServletContext().getRequestDispatcher("/WEB-INF/liste.jsp").forward(request, response);
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
