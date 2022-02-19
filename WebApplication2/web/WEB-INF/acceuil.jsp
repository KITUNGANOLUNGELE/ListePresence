<%-- 
    Document   : acceuil
    Created on : 18 févr. 2022, 02:13:21
    Author     : Henockl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Date, java.text.DateFormat" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <title>Acceuil</title>
        <style>
        </style>
    </head>
    <body style="font-family: montserrat; background-color: aliceblue;">
        <div class="container" style="text-align: center; background-color: rgba(128,0,0,.7); color:rgba(255,254,254,1); font-family: montserrat;width: 100%">
            <p><h1 style="font-family: montserrat;"><% Date dt = new Date();
                DateFormat d = DateFormat.getDateInstance(DateFormat.LONG);
              out.println("Date du jour : \n"+d.format(dt.getTime()));
            %></h1></p><hr>
      <h2 style="text-align: center; font-family: montserrat; color: rgba(0,0,0,.5); font-size: 150%;"><span class="glyphicon glyphicon-user" style="color: black"></span>${message}</h2>
        </div>
        <nav class="navbar navbar-inverse" style="background-color: rgba(0,0,0,1);">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="acceuil">Accueil</a></li>
        <li><a href="appel">Faire l'appel</a></li>
        <li><a href="liste">Liste de présence selon une date</a></li>
        
    </div>
  </div>
</nav>
        
        <!-- Formulaire d'enregistrement -->
        <form method="POST">     
        <div class="form-group" style="width: 50%; margin: auto">
  <label for="usr">ID:</label>
  <input type="text" class="form-control" name="id_etudiant" id="id_etudiant">
 </div>
 <div class="form-group" style="width: 50%; margin: auto">
  <label for="usr">Nom:</label>
  <input type="text" class="form-control" name="nom_etudiant" id="nom_etudiant">
</div>
<div class="form-group" style="width: 50%; margin: auto">
  <label for="pwd">Postnom:</label>
  <input type="text" class="form-control" name="postnom_etudiant" id="postnom_etudiant">
</div>
            <div class="form-group" style="width: 50%; margin: auto">
                <label for="pwd">Prenom:</label>
                <input type="text" class="form-control" name="prenom_etudiant" id="prenom_etudiant">

                <div style="margin: 10px auto 10px auto">
                    <div class="form-group" style="width: 50%; margin: auto">
                        <input class="btn-sm btn-success" type="submit"  name="Enregistrer" id="Enregistrer" value="Enregistrer">
                        <input class="btn-sm btn-danger" type="submit"  name="Supprimer" id="Supprimer" value="Supprimer">
                        <input class="btn-sm btn-primary" type="submit"  name="Modifier" id="Modifier" value="Modifier">
                    </div>
  </div>
</div>
</form>
</body>
</html>
