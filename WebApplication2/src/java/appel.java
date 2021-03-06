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
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Classes_et_BD.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.text.DateFormat;

/**
 *
 * @author Henockl
 */
public class appel extends HttpServlet {

    Date date = new Date();
    DateFormat d = DateFormat.getDateInstance(DateFormat.LONG);
    String mydate = d.format(date.getTime());

    Collection<Etudiant> mes_etudiants = new ArrayList<>();

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
        String message = "Faites votre appel ici";
        request.setAttribute("message", message);
        DB base = new DB();
        base.connection();
        String query = "select * from etudiant where date_presence is NULL or date_presence <> '" + mydate + "'";
        try {
            PreparedStatement prep = base.con.prepareStatement(query);
            ResultSet r = prep.executeQuery(query);
            mes_etudiants.clear();
            while (r.next()) {
                Etudiant et = new Etudiant(r.getString("id_etudiant"), r.getString("nom_etudiant"), r.getString("postnom_etudiant"), r.getString("prenom_etudiant"));
                mes_etudiants.add(et);
            }
            request.setAttribute("mes_etudiants", mes_etudiants);

        } catch (SQLException ex) {
            Logger.getLogger(appel.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.getServletContext().getRequestDispatcher("/WEB-INF/appel.jsp").forward(request, response);
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

        if (request.getParameter("present") != null) {
            //update etudiant
            DB db = new DB();
            db.connection();
            try {
                Statement req = db.con.createStatement();
                req.executeUpdate("update etudiant set date_presence = '"+mydate+"' where id_etudiant = '"+request.getParameter("id")+"'");
            } catch (SQLException ex) {
                Logger.getLogger(appel.class.getName()).log(Level.SEVERE, null, ex);
            }
            //enregistrement de la presence
             try {
                Statement req1 = db.con.createStatement();
                req1.executeUpdate("INSERT INTO `presence`(`date_presence`, `satus_presence`, `id_etudiant`) VALUES ('"+mydate+"','Present','"+request.getParameter("id")+"')");
            } catch (SQLException ex) {
                Logger.getLogger(appel.class.getName()).log(Level.SEVERE, null, ex);
            }
            //affichage des etudiants
            
             String message = "Faites votre appel ici";
        request.setAttribute("message", message);
        DB base = new DB();
        base.connection();
        String query = "select * from etudiant where date_presence is NULL or date_presence <> '" + mydate + "'";
        try {
            Statement stat = base.con.createStatement();
            PreparedStatement prep = base.con.prepareStatement(query);
            ResultSet r = prep.executeQuery(query);
            mes_etudiants.clear();
            while (r.next()) {
                Etudiant et = new Etudiant(r.getString("id_etudiant"), r.getString("nom_etudiant"), r.getString("postnom_etudiant"), r.getString("prenom_etudiant"));
                mes_etudiants.add(et);
            }
            request.setAttribute("mes_etudiants", mes_etudiants);

        } catch (SQLException ex) {
            Logger.getLogger(appel.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.getServletContext().getRequestDispatcher("/WEB-INF/appel.jsp").forward(request, response);

            
        }
        //absence
          if (request.getParameter("absent") != null) {
            //update etudiant
            DB db = new DB();
            db.connection();
            try {
                Statement req = db.con.createStatement();
                req.executeUpdate("update etudiant set date_presence = '"+mydate+"' where id_etudiant = '"+request.getParameter("id")+"'");
            } catch (SQLException ex) {
                Logger.getLogger(appel.class.getName()).log(Level.SEVERE, null, ex);
            }
            //enregistrement de la presence
            try {
                Statement req2 = db.con.createStatement();
                req2.executeUpdate("INSERT INTO `presence`(`date_presence`, `satus_presence`, `id_etudiant`) VALUES ('"+mydate+"','Absent','"+request.getParameter("id")+"')");
            } catch (SQLException ex) {
                Logger.getLogger(appel.class.getName()).log(Level.SEVERE, null, ex);
            }
        
            //affichage des etudiants
            
             String message = "Faites votre appel ici";
        request.setAttribute("message", message);
        DB base = new DB();
        base.connection();
        String query = "select * from etudiant where date_presence is NULL or date_presence <> '" + mydate + "'";
        try {
            Statement stat = base.con.createStatement();
            PreparedStatement prep = base.con.prepareStatement(query);
            ResultSet r = prep.executeQuery(query);
            mes_etudiants.clear();
            while (r.next()) {
                Etudiant et = new Etudiant(r.getString("id_etudiant"), r.getString("nom_etudiant"), r.getString("postnom_etudiant"), r.getString("prenom_etudiant"));
                mes_etudiants.add(et);
            }
            request.setAttribute("mes_etudiants", mes_etudiants);

        } catch (SQLException ex) {
            Logger.getLogger(appel.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.getServletContext().getRequestDispatcher("/WEB-INF/appel.jsp").forward(request, response);

            
        }
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
