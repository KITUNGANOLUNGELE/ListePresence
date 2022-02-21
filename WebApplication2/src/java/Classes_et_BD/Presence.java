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
    public String status_presence, id_etudiant;
    public String Mydate;
    //constructeur
    public Presence(int id,String date,String status,String id_etudiant)
    {
        this.id_presence = id;
        this.Mydate = date;
        this.status_presence = status;
        this.id_etudiant = id_etudiant;
    }

    public void enregistrer(Presence et) throws SQLException {
        DB base = new DB();
        base.connection();
        Statement req = base.con.createStatement();
        req.executeUpdate("insert into presence(date_presence,status_presence,id_etudiant) values ('" + et.Mydate + "','" + et.status_presence + "','" + et.id_etudiant + "')");
    }

    public void mettreAjour(Presence et) throws SQLException {
        DB base = new DB();
        base.connection();
        Statement req = base.con.createStatement();
        req.executeUpdate("update etudiant set date_presence='" + et.Mydate + "',status_presence='" + et.status_presence + "',id_etudiant='" + et.id_etudiant + "' where id_presence=" + et.id_presence + "");
    }

    public void supprimer(Presence et) throws SQLException {
        DB base = new DB();
        base.connection();
        Statement req = base.con.createStatement();
        req.executeUpdate("delete from presence where id_presence=" + et.id_presence + "");
    }
}
