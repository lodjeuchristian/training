<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Inscription</title>
	<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>  
	<link rel="SHORTCUT ICON" href="img/logo/logof3.jpg">
	<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
	<link href="css/formationscss.css" rel="stylesheet" media="screen"> 
	<link href="css/formulaire.css" rel="stylesheet" media="screen"> 
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
<div class="container conteneurinscription laterals" id="fadeOutIn"> 
 
	<div id="wrapper">
 
		<div id="login" class="animate form">
			<form  action="./inscription" id="inscriptionForm" method="POST" autocomplete="on" onSubmit = "return ">   
				<div id="infosformation" align="center" style="width:91%;" class="alert alert-warning">
					<h3>Proposez votre canditature</h3>  
					<hr/>
					<c:if test="${!empty fselected}">
					 	Formation choisie : ${fselected.courseTitle} à  ${fselected.courseLocation} du ${fselected.courseStartDate} au ${fselected.courseEndDate}
					</c:if>
				</div>
				<c:if test="${!empty errorWhileAdding}">
					<div align="center" style="width:91%;" class="alert alert-error">
						<button type="button" class="close" data-dismiss="alert">&times;</button>
						Une erreur est survenue, veuillez recommencer
					</div>
				</c:if>	
				<c:if test="${!empty clientAdded}"> 
					<span id="popupModal" value="openMod"></span>
				</c:if>	 
				
				<p> 
					<label for="nom"> <i class="icon-user" ></i>&nbsp;&nbsp;Nom *</label>
					<input value="<c:out value="${clientCookie.lastName}"/>" id="nom" name="nom" required="required" type="text" placeholder="Entrez votre nom" />
					<input type = "hidden" name="sessionId" value="${fselected.sessionId}" />
				</p>  
				<p> 
					<label for="prenom"> <i class="icon-user" ></i>&nbsp;&nbsp;Prénom *</label>
					<input value="<c:out value="${clientCookie.firstName}"/>" id="prenom" name="prenom" required="required" type="text" placeholder="Entrez votre prénom" />
				</p> 			
				<p> 
					<label for="email" class="youmail"><i class="icon-envelope" ></i>&nbsp;&nbsp;E-mail *</label>
					<input value="<c:out value="${clientCookie.email}"/>" id="email" name="email" required="required" type="email" placeholder="Ex: lodjeuchristian@gmail.com"/> 
				</p>
				<p> 
					<label for="telephone"><i class="icon-globe" ></i>&nbsp;&nbsp;Téléphone</label>
					<span id = "displayPhoneError" align = "center" class="alert alert-error"></span>
					<input value="<c:out value="${clientCookie.phone}"/>" id="telephone" name="telephone"  type="text" placeholder="Ex: 0678513498" />
				</p> 
				<p> 
					<label for="adresse"><i class="icon-home" ></i>&nbsp;&nbsp;Adresse</label>
					<input value="<c:out value="${clientCookie.adress}"/>" id="adresse" name="adresse"  type="text" placeholder="Ex: 06 Rue de la liberté 90000 Belfort" />
				</p> 
				<hr/>
				<c:if test="${empty clientCookie.lastName}"> 
					 <label class="checkbox inline">
						 <input type="checkbox" name="saveclientdata" id="saveclientdata"/> &nbsp;Sauvegarder vos informations
					 </label> 
				</c:if>	
				<c:if test="${!empty clientCookie.lastName}"> 
					 <label class="checkbox inline">
						 <input type="checkbox" checked="checked" name="saveclientdata" id="saveclientdata"/> &nbsp;Sauvegarder vos informations
					 </label> 
				</c:if>	

				<hr/> 
				<p class="signin button"> 
					<input class="btn" type="submit" value="Valider"/> 
				</p>

			</form>
		</div> 
	</div>  
	
	<!-- Affichage du modal -->
	<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	  <div class="modal-header" style="color: #3a87ad" >
		<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
		<h3 id="myModalLabel">Félicitations !!!</h3>
	  </div>
	  <div class="modal-body">
		<p> 
			<b>${clientAdded.firstName} ${clientAdded.lastName}</b>, votre inscription a bien été effectuée.<hr/>
			Date de début de la formation : ${sessionAddedsd}, 
			date de fin : ${sessionAddeded}
		</p>
	  </div>
	  <div class="modal-footer">
		<button class="btn" data-dismiss="modal" aria-hidden="true">Ok</button> 
	  </div>
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
	 
	if($("#popupModal").attr("value") == "openMod"){
		$("#myModal").modal();
		$('#myModal').on('hidden', function () {
			  document.location.href="./formations";
		});	
	}
	
	$("#inscriptionForm").submit(function(){ 
		if(isNaN($("#telephone").val()) == true){
			$("#displayPhoneError").text("Le numéro de téléhone doit être de type numérique et sans espace");
			return false;
		}
		return true;
			
	}); 
</script>
</body>
</html>  