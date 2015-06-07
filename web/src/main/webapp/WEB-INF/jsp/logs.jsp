<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<!DOCTYPE html>
<html lang="en"><head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="http://getbootstrap.com/favicon.ico">

    <title>LO54 Projet - Concentrateur pour station météo</title>

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

    <!-- Custom styles for this template -->
    <link href="./cover.css" rel="stylesheet">
  </head>

  <body>

    <div class="site-wrapper">

      <div class="site-wrapper-inner">

        <div class="cover-container">

          <div class="masthead clearfix">
            <div class="inner">
              <h3 class="masthead-brand">Concentrateur</h3>
              <nav>
                <ul class="nav masthead-nav">
                  <li><a href="./">Accueil</a></li>
                  <li><a href="./filter">Filtre</a></li>
                  <li class="active"><a href="./logs">Historique</a></li>
                </ul>
              </nav>
            </div>
          </div>

          <div class="inner cover">
            <h1 class="cover-heading">Historique</h1>
            <br/>
            <table class="table">  
			    <tr>  
			        <th>Action</th>  
			        <th>Date</th>  
			        <th>Status</th>
			    </tr>  
			      
			    <c:forEach var="logtemperature" items="${logtemperature}">  
			        <tr>  
			            <td>insertion de la temperature ${logtemperature.temperature}</td>  
			            <td>${logtemperature.date}</td>  
			            <td>${logtemperature.accepted}</td>
			        </tr>  
			    </c:forEach>  
			</table>  
          </div>

          <div class="mastfoot">
            <div class="inner">
              <p>LO54</p>
            </div>
          </div>

        </div>

      </div>

    </div>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
  

</body></html>