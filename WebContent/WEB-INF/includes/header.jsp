<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">
</head>
<header>
	<!-- ----------------- Navbar ----------------- -->
	<div class="w3-top">
		<div class="w3-bar w3-theme-d2 w3-left-align">
			<a class="w3-bar-item w3-button w3-hide-medium w3-hide-large w3-right w3-hover-white w3-theme-d2" href="javascript:void(0);" onclick="openNav()"><i class="fa fa-bars"></i></a> 
				<a href="ControllerServlet"	class="btn-Home bg-info" style="text-decoration: none; color:#FFFFFF;"><i class="fa fa-home w3-margin-right"></i>Home</a> 
				<a href="ControllerServlet?action=historique" class="btn-Home bg-info" style="text-decoration: none; color:#FFFFFF;">Historique</a>
			<c:if test="${login eq 'admin'}">
				
				<div class="w3-dropdown-hover w3-hide-small">
					<button class="w3-button bg-danger" title="Notifications" style="color:#FFFFFF;">
						Administration <i class="fa fa-caret-down"></i>
					</button>
					<div class="w3-dropdown-content w3-card-4 w3-bar-block">
						<a href="ControllerServlet?action=adminVulnerabilite" class="w3-bar-item w3-button">Vulnerabilite</a> 
						<a href="ControllerServlet?action=adminMesure" class="w3-bar-item w3-button">Mesure</a> 
						<a href="ControllerServlet?action=adminAbonnes" class="w3-bar-item w3-button">Abonnes</a>
					</div>
					
				</div>
				
				<div class="w3-bar w3-theme-d2 w3-right-align">
				<c:choose>
					<c:when test="${not empty nom}">
						<p class="topRight"> ${prenom}	${nom} </p>
						<button class="ConnexionButton"><a href="ControllerServlet?action=deconnexion" style="text-decoration: none;"> Se deconnecter </a></button>
					</c:when>
				</c:choose>
				</div>
				
			</c:if>

		</div>
		<c:if test="${empty nom}">
			<button class="ConnexionButton"	onclick="document.getElementById('id01').style.display='block'"	class="connexionButton" title="connexion">Connexion</button>
		</c:if>
	</div>


	<!------------------- Image Header ----------------- -->
	<div class="w3-display-container w3-animate-opacity">
		<img src="${pageContext.request.contextPath}/images/cybersecurity-04.jpg" alt="banner" style="width: 100%; height: 350px;">
		 <img class="Title" src="${pageContext.request.contextPath}/images/Titre.png" style="width: 101%; height: 80px;" >
			<button class="AbonneButton" data-toggle="modal" data-target="#modalAbonnement">S'Abonner 
		<img class="bellButton" src="${pageContext.request.contextPath}/images/bell.png" width="20" height="20"></button>

	</div>


	<!-- ----------------- Modal ----------------- -->
	<div id="id01" class="w3-modal">
		<div class="mod-container">

			<div class="modal-body">
				<span onclick="document.getElementById('id01').style.display='none'"
					class="w3-button w3-teal w3-display-topright"> <i
					class="fa fa-remove"></i></span>
				<form class="form-inline my-2 my-lg-0" method="post"
					action="ControllerServlet">
					<input class="form-control mr-sm-2" type="text" name="login"
						placeholder="login" aria-label="Search"> <br> <input
						class="form-control mr-sm-2" type="password" name="password"
						placeholder="password" aria-label="Search">

					<div class="mod-footer">
						<br>
						<button align="center" class="btn-01" type="submit"
							name="connection">Se Connecter</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</header>

<div class="modal" id="modalAbonnement" tabindex="-1">
	<div class="modal-dialog">
		<div class="modal-content">
			<form method="post" action="ControllerServlet">

				<div class="modal-header">
					<h5 class="modal-title">Creation Abonnement</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>

				<div class="modal-body">
					<table class="table-bordered" align="center">
						<tr>
							<td>Nom</td>
							<td><input type="text" id="idNomAbonne" name="nomAbonne"
								required pattern=[A-Za-z]{1,20}></td>
						</tr>
						<tr>
							<td>Prenom</td>
							<td><input type="text" id="idPrenomAbonne"
								name="prenomAbonne" required pattern=[A-Za-z]{1,20}></td>
						</tr>
						<tr>
							<td>Email</td>
							<td><input type="text" id="idEmail" name="email"></td>
						</tr>
						<tr>
							<td>Format</td>
							<td><select class="form-control" name="format" id="idFormat">
									<option value="">--------</option>
									<option value="HTML">HTML</option>
									<option value="WORD">WORD</option>
									<option value="XML">XML</option>
							</select></td>
						</tr>
						<tr>
							<td>Frequence</td>
							<td><select class="form-control" name="frequence"
								id="idFrequence">
									<option value="">--------</option>
									<option value="Jour">Jour</option>
									<option value="Semaine">Semaine</option>
									<option value="Mois">Mois</option>
							</select></td>
						</tr>
						<tr>
							<td>Login</td>
							<td><input type="text" id="idLogin" name="login" required
								pattern=[A-Za-z]{1,20}></td>
						</tr>
						<tr>
							<td>Password</td>
							<td><input type="text" id="idPasword" name="password"
								required pattern=[A-Za-z]{1,20}></td>
						</tr>
					</table>
				</div>

				<div class="modal-footer">
					<input type="submit" name="abonnement" value=Valider
						class="btn btn-primary"> <input type="reset" name="reset"
						value="Reset" class="btn btn-secondary">
				</div>

			</form>
		</div>
	</div>
</div>

