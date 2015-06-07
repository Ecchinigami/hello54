<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                  <li class="active"><a href="./">Accueil</a></li>
                  <li><a href="./filter">Filtre</a></li>
                  <li><a href="./logs">Historique</a></li>
                </ul>
              </nav>
            </div>
          </div>

          <div class="inner cover">
            <h1 class="cover-heading">Concentrateur pour station météo</h1>
            <br/>
            <p class="text-justify">&emsp;&emsp;Cette application développée en JEE a pour but de recevoir des températures au format JSON 
            et de les enregistrer dans une base de données grâce à Hibernate.
            Elle possède également une interface web, ci-présente, qui permet d'afficher 
            les dernières températures recues mais aussi de paramétrer un filter sur la validation de celles-ci.</p>
          </div>

          <div class="mastfoot">
            <div class="inner">
              <p>Projet - LO54</p>
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