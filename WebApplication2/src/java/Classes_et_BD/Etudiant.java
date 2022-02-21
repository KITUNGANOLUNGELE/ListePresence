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

    public String id_etudiant, nom_etudiant, postnom_etudiant, prenom_etudiant;

    public Etudiant(String id, String nom, String postnom, String prenom) {
        this.id_etudiant = id;
        this.nom_etudiant = nom;
        this.postnom_etudiant = postnom;
        this.prenom_etudiant = prenom;
    }
    public String getId_etudiant()
    {
        return this.id_etudiant;
    }
     public String getNom_etudiant()
    {
        return this.nom_etudiant;
    }
      public String getPostnom_etudiant()
    {
        return this.postnom_etudiant;
    }
       public String getPrenom_etudiant()
    {
        return this.prenom_etudiant;
    }

    public void enregistrer(Etudiant et) throws SQLException {
        DB base = new DB();
        base.connection();
        Statement req = base.con.createStatement();
        req.executeUpdate("insert into etudiant values ('" + et.id_etudiant + "','" + et.nom_etudiant + "','" + et.postnom_etudiant + "','" + et.prenom_etudiant + "')");
    }

    public void mettreAjour(Etudiant et) throws SQLException {
        DB base = new DB();
        base.connection();
        Statement req = base.con.createStatement();
        req.executeUpdate("update etudiant set nom_etudiant='" + et.nom_etudiant + "',postnom_etudiant='" + et.postnom_etudiant + "',prenom_etudiant='" + et.prenom_etudiant + "' where id_etudiant='" + et.id_etudiant + "'");
    }

    public void supprimer(Etudiant et) throws SQLException {
        DB base = new DB();
        base.connection();
        Statement req = base.con.createStatement();
        req.execute("delete * from etudiant where id_etudiant='" + et.id_etudiant + "'");
    }
}
