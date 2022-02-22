<%-- 
    Document   : liste
    Created on : 19 févr. 2022, 17:22:50
    Author     : Henockl
--%>

<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.Date, java.text.DateFormat" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <title>Liste</title>
    </head>
    <body>  <div class="container" style="text-align: center; background-color: rgba(128,0,0,.7); color:rgba(255,254,254,1); font-family: montserrat;width: 100%">
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
                    <li class="active"><a href="acceuil">Accueil</a></li>
                    <li><a href="appel">Faire l'appel</a></li>
                    <li><a href="liste">Liste de présence selon une date</a></li>
            </div>

            <form method="POST" action="liste">
                <div class="form-group" style="width: 50%; margin: auto">
                    <label for="pwd" style="color: white;">Séléctionnez une date : </label>
                    <select type="text" class="form-control" name="date" style="text-align: center; font-size: 120%; font-weight: bold;">
                        <c:forEach items="${liste_date}" var="date">
                            <option value="<c:out value="${date}"/>"><c:out value="${date}"/></option>
                        </c:forEach>
                    </select><input type="submit" class="btn btn-outline-primary" name="rechercher" value="Rechercher">
                    </form>
                </div>
        </div>
    </nav>
    <div style="width: 90%; margin: auto;">
        <div class="alert-info" style="width: 40%; float: left; margin: 40px 0px 0px 40px; border-radius: 6px;">
            <table class="table table-hover" style="width: 70%; margin: auto; text-align: center;">
                <thead style="text-align: center;">
                    <tr class=" info">
                        <th style="text-align: center; font-family: monserrat; font-weight: bold; font-size: 90%"><h3>Liste des étudiants présents</h3></th>
                    </tr>

                </thead>
                <tbody style="text-align: left; font-family: montserrat;font-weight: bold;">
                    <c:forEach items="${liste_present}" var="present">
                        <tr>
                            <td >
                                <P><c:out value="${present}"/></p>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="alert-info" style="width: 40%; float: left; margin: 40px 0px 0px 40px; border-radius: 6px;">
            <table class="table" style="width: 70%; margin: auto; text-align: center;">
                <thead style="text-align: center;">
                    <tr class=" info">
                        <th style="text-align: center; font-family: monserrat; font-weight: bold; font-size: 90%"><h3>Liste des étudiants absents</h3></th>
                    </tr>

                </thead>
                <tbody style="text-align: left; font-family: montserrat;font-weight: bold;">
                    <c:forEach items="${liste_absent}" var="absent">
                        <tr>
                            <td>
                                <P><c:out value="${absent}"/></p>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>
