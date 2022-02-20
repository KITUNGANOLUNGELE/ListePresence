/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes_et_BD;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.text.DateFormat;

/**
 *
 * @author Henockl
 */
public class Presence {
    public int id_presence;
    Date date = new Date();
    DateFormat d = DateFormat.getDateInstance(DateFormat.LONG);
    public String status_presence, id_etudiant;
    public String Mydate = d.format(date.getTime());
    
       
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
