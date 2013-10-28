<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> 
	<title>Clients et formations</title>
	<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>  
	<script type="text/javascript" src="js/jquery.tablesorter.js"></script> 
	<script type="text/javascript">
	$(document).ready(function() 
		{ 
		    $("#tablesorter").tablesorter(); 
		} 
	); 
	</script>  
	<link rel="SHORTCUT ICON" href="img/logo/logof3.jpg">
	<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
	<link href="css/formationscss.css" rel="stylesheet" media="screen">
	
</head> 

<body class="body">

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
			<li><a href="./accueil"><i class="icon-home"></i>  Accueil</a></li> 
			<li class="divider-vertical"></li>  
			<li><a href="./formations">  Formations</a></li> 
			<li class="divider-vertical"></li>  
			<li class="dropdown active">
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
<div class="container conteneur laterals" id="fadeOutIn"> 

	<!-- Bloc de recherche -->
	<div style="margin-top:20px;" align="center"> 
		<form id="target" method="GET"  action="clientsformation" class="form-inline"> 
			<select name="course" id="coursesList" class="span3">
				<option value="">Choisir un cours</option> 
				<c:forEach var="cours" items="${courses}">
					<option  value="${cours.code}">${cours.title}</option>
				</c:forEach>
			</select>
			
			<select id="townList" name="ville"  class="span3">
				<option value="">Choisir une ville</option> 
				<c:forEach var="town" items="${towns}">
					<option value="${town.id}">${town.city}</option>
				</c:forEach>
			</select> 
			<input type="submit" class="btn btn-info" value="Filtrer"> 
		</form> 
	</div>
	<c:if test="${nbRecords > -1}">
		<span><i><b>${nbRecords}</b> Enregistrements</i></span>
	</c:if>
	<c:if test="${empty clients}">
 		<div align='center'>Aucun résultat</div>
 	</c:if>
  	<hr> 
  		<c:if test="${!empty clients}">
  		<table  id="tablesorter" class="table table-striped table-hover tablesorter table-bordered">
  			<thead>
	  			<th class="sortheader" title="trier par Prénom">Prénom</th>
	  			<th class="sortheader" title="trier par nom">Nom</th>
	  			<th class="sortheader" title="trier par cours">Cours</th>
	  			<th class="sortheader" title="trier par date">Session</th>
	  			<th class="sortheader" title="trier par ville">Ville</th>
  			</thead>
	  		<tbody>
	  		
		  		<c:forEach var="client" items="${clients}">
		  			<tr>
		  				<td>${client.clientFirstName}</td>
		  				<td>${client.clientLastName}</td>
		  				<td>${client.courseTitle}</td>
		  				<td>${client.courseStartDate}</td>
		  				<td>${client.courseLocation}</td>
		  			</tr>
		  		</c:forEach>	  		
	  		</tbody>
	  	</table>
	  </c:if>
  	</div> 
 
 
<!-- Pied de page -->  
<div class="footer">
      <div class="container" id="footer">   
    	  &copy; Copyright 2013 | LO54 - Lodjeu - Libam -Ntieche
      </div>
</div>
<script type="text/javascript"> 
		$('#fadeOutIn').fadeOut(0);
		$('#fadeOutIn').fadeIn(200);
</script>
</body>
</html> 