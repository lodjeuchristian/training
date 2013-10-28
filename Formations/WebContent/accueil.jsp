<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> 
	<title>Accueil</title> 
	<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>  
	<link rel="SHORTCUT ICON" href="img/logo/logof3.jpg">
	<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
	<link href="css/formationscss.css" rel="stylesheet" media="screen">
</head> 

<body>

<!-- Entete --> 
<div class="navbar navbar-fixed-top" >
  <div class="navbar-inner">
	  <div class="container"> 
		<a class="brand" href="./accueil" style="padding-top: 8px; padding-bottom: 0px;">
	      <b style="color:#0088cc;font-weight:bold;font-family:'Bauhaus 93';font-size:25px;margin-right:-5px;">F</b>
	      <span style="color:#555;font-size:18px;">ormations</span>
	    </a> 
		 
		<!-- Barre de menu --> 
	    <ul class="nav"> 
	    	
	    	<li class="divider-vertical"></li>   
			<li class="active"><a href="./accueil"><i class="icon-home"></i>  Accueil</a></li> 
			<li class="divider-vertical"></li>  
			<li><a href="./formations">  Formations</a></li> 
			<li class="divider-vertical"></li>  
			<li class="dropdown">
			    <a href="#" class="dropdown-toggle" data-toggle="dropdown">  Candidatures
			      <b class="caret"></b>
			    </a>
			    <ul class="dropdown-menu">
			       <li><a href="./clientsformation"> Clients et formations</a></li>
			       <li><a href="./formationsclient"> Clients par formation</a></li>
			    </ul>
			</li> 
			<li class="divider-vertical"></li> 
			
	    </ul> 
	    
	    <form id="searchForm" action="./formations?op=filter" method="GET" class="navbar-search pull-right">  
		  <input type="text" class="input-medium search-query" placeholder="Rechercher" id="cours" name="cours">  
		</form> 
		
	 </div>
 </div>
</div>


<!-- Corps -->
<div id="banniere" style="height:60%">
	<img src="./img/banniere16.jpg" width="100%" height="8%" /> 
</div>

<div class="container conteneurwtborder" id="fadeOutIn"> 
	<div class="row">
		<a href="./formations">
	        <div class="span2 hero-unit divbtn">
	          <p>Formations<br/>et inscriptions</p>  
	        </div>
	    </a>
	    <a href="./formationsclient">
	        <div class="span2 hero-unit divbtn">
	           <p>Liste des Clients<br/>par formation</p> 
	       </div>
	    </a>
	    <a href="./clientsformation">
	        <div class="span2 hero-unit divbtn">
	           <p>Liste des Clients<br/>et formations</p>
	        </div>
	    </a>
    </div>
</div>
 
<!-- Pied de page -->  
<div class="footer">
      <div class="container" id="footer">   
    	  &copy; Copyright 2013 | LO54 - Lodjeu - Libam -Ntieche
      </div>
</div>
<script type="text/javascript"> 
		$('#fadeOutIn').fadeOut(0);
		$('#fadeOutIn').fadeIn(500);
</script>
</body>
</html>