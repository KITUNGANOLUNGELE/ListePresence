/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes_et_BD;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Henockl
 */
public class Etudiant {
    public String id_etudiant,nom_etudiant,postnom_etudiant,prenom_etudiant;
    
    public void enregistrer(String stat) throws SQLException
    {
        DB base = new DB();
        base.connection();
        Statement req = base.con.createStatement();
        req.executeUpdate(stat);
    }
    public void mettreAjour(String stat, String param) throws SQLException
    {
        DB base = new DB();
        base.connection();
        Statement req = base.con.createStatement();
        req.executeUpdate(stat);
    }
    public void supprimer(String stat, String param) throws SQLException
    {
        DB base = new DB();
        base.connection();
        Statement req = base.con.createStatement();
        req.executeUpdate(stat);
    }
}
