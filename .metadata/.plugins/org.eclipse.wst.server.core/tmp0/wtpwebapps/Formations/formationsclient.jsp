<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Clients par formation</title>
	<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>   
 	<script type="text/javascript" src="js/chosen.jquery.js"></script> 
	<script type="text/javascript" src="js/jquery.chained.js"></script> 
	<script type="text/javascript" src="js/jquery.tablesorter.js"></script>
	<link rel="SHORTCUT ICON" href="img/logo/logof3.jpg">
	<link href="css/chosen.css" rel="stylesheet" media="screen">
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
	<center>
	<div style="margin-top:20px">
	<form id="target" method="GET"  action="formationsclient" class="form-inline">
	
		<select name="course" id="coursesList" class="span3">
			<option value="">Choisir un cours</option> 
			<c:forEach var="courses" items="${formations}" >
			<option VALUE="${courses.getCourseCode()}">${courses.courseTitle}</option>
			</c:forEach>
		</select>
		
		<select id="sessionsList" name="session"  class="span3" onclick="enableClick()">
			<option value="">Choisir une session</option> 
			<c:forEach var="singleSession" items="${allSessions.getAllFormations()}">
			<option  value="${singleSession.sessionId}" class="${singleSession.courseCode}"> ${singleSession.courseStartDate} | ${singleSession.courseEndDate} | ${singleSession.courseLocation} </option>
		</c:forEach>
		</select>
		
		<input type="submit" id="clientBySession" class="btn btn-info" value="Rechercher">
		
	</form>
	</div>
  	</center>
  	
  	<div id="infosformation" align="center" class="alert alert-warning"> 
  		<c:choose>
  			<c:when test="${!empty oneSession}">
  				<h3>${oneSession.courseTitle}</h3><hr/>
				<b>Début :</b> ${oneSession.courseStartDate} - <b>Fin :</b>  ${oneSession.courseEndDate}  - <b> Lieu : </b>   ${oneSession.courseLocation}
  			</c:when>
  			<c:otherwise>
  				<h3>Veuillez choisir une session</h3><hr/>
  			</c:otherwise>
  		</c:choose>
  	</div>
  	<c:if test="${nbRecords > -1}">
		<span><i><b>${nbRecords}</b> Enregistrements</i></span>
	</c:if>
	<c:if test="${empty clientsList}">
 		<div align='center'>Aucun résultat</div>
 	</c:if>
  	<hr>
  	<div id="clientList">
  		<c:if test="${!empty clientsList}">
  		<table  id="tablesorter" class="table table-striped table-hover tablesorter table-bordered">
  			<thead>
	  			<th class="sortheader" title="trier par Prénom">Prénom</th>
	  			<th class="sortheader" title="trier par nom">Nom</th>
	  			<th class="sortheader" title="trier par E-mail">E-mail</th>
	  			<th class="sortheader" title="trier par Télephone">Téléphone</th>
	  			<th class="sortheader" title="trier par Adresse">Adresse</th>
  			</thead>
	  		<tbody>
		  		<c:forEach var="client" items="${clientsList}">
		  			<tr>
		  				<td>${client.firstName}</td>
		  				<td>${client.lastName}</td>
		  				<td>${client.email}</td>
		  				<td>${client.phone}</td>
		  				<td>${client.adress}</td>
		  			</tr>
		  		</c:forEach>
	  		</c:if>
	  		</tbody>
	  	</table>
  	</div>
</div>
 




 
<!-- Pied de page --> 
<div class="footer">
      <div class="container" id="footer">  
    	  &copy; Copyright 2013 | LO54 - Lodjeu - Libam - Ntieche
      </div>
</div>
<script type="text/javascript" src="js/formationsclients.js"></script>
<script type="text/javascript"> 
	$('#fadeOutIn').fadeOut(0);
	$('#fadeOutIn').fadeIn(200);
	$("#sessionsList").chained("#coursesList");
	function getClientList(){
		$('#target').submit();
	}

</script>
</body>
</html>  