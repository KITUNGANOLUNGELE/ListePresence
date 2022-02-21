<%-- 
    Document   : appel.jsp
    Created on : 18 févr. 2022, 08:48:51
    Author     : Henockl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Date, java.text.DateFormat" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
    <body style="font-family: montserrat; background-color: aliceblue;">
        <div class="container" style="text-align: center; background-color: rgba(128,0,0,.7); color:rgba(255,254,254,1); font-family: montserrat;width: 100%">
            <p><h1 style="font-family: montserrat;"><% Date dt = new Date();
                DateFormat d = DateFormat.getDateInstance(DateFormat.LONG);
                out.println("Date du jour : \n" + d.format(dt.getTime()));
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
                    <li><a href="acceuil">Accueil</a></li>
                    <li class="active"><a href="appel">Faire l'appel</a></li>
                    <li><a href="liste">Liste de présence selon une date</a></li>
            </div>
        </div>
    </nav>
    <table class="table table-hover" style="width: 70%; margin: auto; text-align: center;">
        <c:set var="inc" value="0" scope="page"/> 
        <thead style="text-align: center;">
            <tr class=" info">
                <th>ID</th>
                <th>Nom</th>
                <th>Postnom</th>
                <th>Prenom</th>
                <th>Status</th>
            </tr>

        </thead>
        <tbody style="text-align: left;">
            <c:forEach items="${mes_etudiants}" var="Etudiant">
                <tr>
            <form method="POST" action="appel">
                <td>
                    <input name="id" value='<c:out value="${Etudiant.id_etudiant}"/>' readonly="true"/>
                </td>
                <td>
                    <c:out value="${Etudiant.nom_etudiant}"/>
                </td>
                <td>
                    <c:out value="${Etudiant.postnom_etudiant}"/>
                <td>
                    <c:out value="${Etudiant.prenom_etudiant}"/>
                </td>
                <td>
                    <div style="width: 70%; background-color: rgba(0,0,0,.4)">
                        <i class="glyphicon-pencil"></i><input class="btn-success" type="submit" name="present" value="Présent">
                        <i class="glyphicon-pencil"></i><input class="btn-danger" type="submit" name="absent" value="Absent">
                    </div>
                    
                    
                </td>
            </form>

        </tr>
    </c:forEach>
</tbody>

</table>
</body>
</html>
