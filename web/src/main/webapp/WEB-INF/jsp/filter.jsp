<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
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
                  <li class="active"><a href="./filter">Filtre</a></li>
                  <li><a href="./logs">Historique</a></li>
                </ul>
              </nav>
            </div>
          </div>

          <div class="inner cover">
            <h1 class="cover-heading">Filtre</h1>
            <br/>
            <f:form method="post" action="filter" class="form-horizontal">
				<div class="form-group">
				  <label for="maxTemperature" class="col-sm-4 control-label">Temperature maximale</label>
				  <div class="col-sm-8">
				    <input type="text" id="maxTemperature" name="maxTemperature" value="${maxTemperature }" class="form-control">
				  </div>
				</div>
				<div class="form-group">
				  <label for="minTemperature" class="col-sm-4 control-label">Temperature minimale</label>
				  <div class="col-sm-8">
				    <input type="text" id="minTemperature" name="minTemperature" value="${minTemperature }" class="form-control">
				  </div>
				</div>
				<div class="form-group">
				  <label for="intervalDeTemps" class="col-sm-4 control-label">Interval de temps</label>
				  <div class="col-sm-8">
				    <input type="intervalDeTemps" id="intervalDeTemps" name="intervalDeTemps" value="${intervalDeTemps }" class="form-control">
				  </div>
				</div>
				<div class="form-group">
				  <div class="col-sm-4"></div>
				  <div class="col-sm-8 text-a">
				    <button type="submit" class="btn btn-default">Valider</button>
				  </div>
				</div>
			</form>		        
		
<!-- 	            <label for="maxTemperature">Temperature maximale</label> -->
<%-- 	            <input type="text" id="maxTemperature" name="maxTemperature" value="${maxTemperature }" style="color:black;" /> <br /> --%>
	
<!-- 	            <label for="minTemperature">Temperature minimale</label> -->
<%-- 	            <input type="text" id="minTemperature" name="minTemperature" value="${minTemperature }" style="color:black;" /> <br /> --%>
	
<!-- 	            <label for="intervalDeTemps">Interval de temps</label> -->
<%-- 	            <input type="intervalDeTemps" id="intervalDeTemps" name="intervalDeTemps" value="${intervalDeTemps }" style="color:black;" />  --%>
	            
<!-- 	            <br/><br/>  -->
	            
<!-- 	            <input type="submit" value="Done" style="color:black;" /> -->
		    </f:form>
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