<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Formations</title>
	<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script> 
	<script type="text/javascript" src="js/jquery-ui-1.10.2.custom.js"></script> 
	<script type="text/javascript" src="js/bootstrap.min.js"></script>  
	
	<link rel="SHORTCUT ICON" href="img/logo/logof3.jpg">
	<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
	<link href="css/formationscss.css" rel="stylesheet" media="screen">
	<link href="css/smoothness/jquery-ui-1.10.2.custom.css" rel="stylesheet">
</head> 

<body class="body">
<!--  Entete --> 
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
			<li  class="active"><a href="./formations">  Formations</a></li> 
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
<div class="container conteneur laterals" id="fadeOutIn">
	<div id="filterform" align="center">
		<form id="searchForm" action="./formations?op=filter" method="GET" class="form-inline">  
		  <input type="text" id="cours" class="span2" name="cours" value="${cookie.ccours.value}" placeholder="Cours"> 
		  <input type="text" id="date"   name="date"  placeholder="Date">
		  <select name="lieu" id="lieu" class="span2" placeholder="Lieu">
		  	<option value="" selected><b>Choisir un Lieu</b></option>
		  	<c:forEach var="location" items="${allLocations}">
		  		<option value="${location.city}">${location.city}</option>
		  	</c:forEach>  
		  </select> 
		  <input type="hidden" value="filter" name="op"/> 
		  <button type="submit" class="btn btn-info">Filtrer</button>
		  <input type="button" class="btn" id="reinitialiser" value="Reinitialiser" />
		</form>
	</div>
	<c:if test="${nbRecords <= 1}">
		<span align="center" ><i><b>${nbRecords}</b> enregistrement</i></span>	
	</c:if>
	<c:if test="${nbRecords > 1}">
		<span><i><b>${nbRecords}</b> enregistrements</i></span>	
	</c:if>
	<hr/> 
  	<c:if test="${empty allFormations}">
 		<div align='center'>Aucun résultat</div>
 	</c:if>
 	<c:if test="${!empty allFormations}">
		<table id="formationsTable" class="table table-striped table-hover tablesorter table-bordered">
		    <thead>
		        <tr class="success">
		        	<th id="sortbycode" title="Triez par code" class="sortheader">Code du cours</th>
		        	<th id="sortbytitle" title="Triez par titre" class="sortheader">Titre du cours</th>
		        	<th id="sortbylocation" title="Triez par lieu" class="sortheader">Lieu</th>
		        	<th id="sortbystartdate" title="Triez par date de début" class="sortheader">Date de début</th>
		        	<th id="sortbyenddate" title="Triez par date de fin" class="sortheader">Date de fin</th> 
		        	<th>Inscription</th>
		        </tr>
		    </thead>
		    <tbody> 
		    	<c:forEach var="formation" items="${allFormations}">
					<tr> 
				        <td class="rowformation" id="${formation.sessionId}">${formation.courseCode}</td>
				        <td class="rowformation" id="${formation.sessionId}">${formation.courseTitle}</td>
				        <td class="rowformation" id="${formation.sessionId}">${formation.courseLocation}</td>
				        <td class="rowformation" id="${formation.sessionId}">${formation.courseStartDate}</td>
				        <td class="rowformation" id="${formation.sessionId}">${formation.courseEndDate}</td> 
				        <td class="rowformation" id="${formation.sessionId}"><a href="./inscription?num=${formation.sessionId}">Inscription</a></td>
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
<script type="text/javascript" src="js/formations.js"></script>
<script type="text/javascript"> 
		$('#fadeOutIn').fadeOut(0);
		$('#fadeOutIn').fadeIn(200);
</script>
</body>
</html>  