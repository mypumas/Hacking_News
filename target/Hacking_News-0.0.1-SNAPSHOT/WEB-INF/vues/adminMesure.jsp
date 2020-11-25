<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin : Gestion des Mesures</title>

<!-- w3school -->
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-black.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.css" >
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.22/css/dataTables.bootstrap4.min.css" >
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.22/css/jquery.dataTables.css">

<!-- JS, Popper.js, and jQuery -->
<script src="https://cdn.datatables.net/1.10.22/js/dataTables.bootstrap4.min.js"></script>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

<script>
$(document).ready(function () {
	$('#mesure').DataTable();
	$('.dataTables_length').addClass('bs-select');
});

function lunchmodal(idMesure,nom,description,vulnerabilite)
{	
	document.getElementById('idIdMesure').value = idMesure;
	document.getElementById('idNomMesure').value = nom;
	document.getElementById('idDescriptionMesure').value = description;
	
	$('#modalModifierMes').modal('show');
}
</script>

</head>

<body>
<%@include file="/WEB-INF/includes/header.jsp" %>

	<form action="ControllerServlet" method="POST">
		<div class="card">
		     <h2 class="display-4 font-italic">Liste des Mesures</h2>
		    <button type="button" class="btn btn-info" data-toggle="modal" data-target="#modalAjouterMes">Ajouter Mesure</button>
		</div>
		<br>
		<table id="mesure" class="table table-striped table-bordered" style="width:100%">
				<thead>
					<tr>
						<th>Mesure</th>
						<th>Description</th>
						<th>Vulnérabilité</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${listeMesure}" var="mesure">	
				<c:choose>
					<c:when test="${not empty idVulnerabilite}">		
					<c:if test="${mesure.vulnerabilite.idVulnerabilite == idVulnerabilite}">			
					<tr>
						<td class="font-weight-bold">${mesure.nomMesure}</td>
						<td>${mesure.descriptionMesure}</td>
						<td>${mesure.vulnerabilite.nom}</td>					
						<td width="80">
							<a onclick="lunchmodal('${mesure.idMesure}','${mesure.nomMesure}','${mesure.descriptionMesure}','${mesure.vulnerabilite.nom}')"><img title="Modifier Mesure" src="${pageContext.request.contextPath}/images/edit.png" /></a>
							<a href="ControllerServlet?action=deleteMesure&idMesure=${mesure.idMesure}" onclick="return confirm('Etes vous sûr de vouloir supprimer cette mesure ?')"><img title="Supprimer Mesure" src="${pageContext.request.contextPath}/images/delete.png" /></a>
						</td>
					</tr>
					</c:if>
					</c:when>
					<c:otherwise>
					<tr>
						<td class="font-weight-bold">${mesure.nomMesure}</td>
						<td>${fn:substring(mesure.descriptionMesure, 0, 200)} .........</td>
						<td>${mesure.vulnerabilite.nom}</td>					
						<td width="80">
							<a onmouseover="this.style.cursor='pointer'" onclick="lunchmodal('${mesure.idMesure}','${mesure.nomMesure}','${mesure.descriptionMesure}','${mesure.vulnerabilite.nom}')"><img title="Modifier Mesure" src="${pageContext.request.contextPath}/images/edit.png" /></a>
							<a href="ControllerServlet?action=deleteMesure&idMesure=${mesure.idMesure}" onclick="return confirm('Etes vous sûr de vouloir supprimer cette mesure ?')"><img title="Supprimer Mesure" src="${pageContext.request.contextPath}/images/delete.png" /></a>
						</td>
					</tr>	
					</c:otherwise>
				</c:choose>
				</c:forEach>				
				</tbody>
		</table>
		
	</form>
		
		
		
<!-- PopUp ajout Mesure -->
<div class="modal" id="modalAjouterMes" tabindex="-1">
  <div class="modal-dialog">
    <div class="modal-content">
     <form method="post" action="ControllerServlet">
     
      <div class="modal-header">
        <h5 class="modal-title">Ajouter Mesure</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      
      <div class="modal-body">
       		<table class="table-bordered" align="center">
				<tr>
					<td colspan="2" align="center"><h3 class="text-muted"> Mesure </h3> 
						
					</td> 
				</tr>
				<tr>
					<td> Nom </td>
					<td> <input type="text" name="nomMesure" required pattern=[A-Za-z0-9\s]{1,20}></td> 
				</tr>
				<tr>
					<td> Description </td>
					<td> <textarea name="descriptionMesure" rows="4" cols="50"></textarea></td> 
				</tr>
				<tr>
					<td> Vulnerabilité </td>
					<td> 
													
						  <select class="form-control" name="idIdVulnerabiliteMesure">
							<option value=""></option>
							<c:forEach items="${listeVulnerabilite}" var="vulnerabilite">							  
								<option value="${vulnerabilite.idVulnerabilite}">${vulnerabilite.nom}</option>
							</c:forEach>
						</select>	
										
					</td> 
				</tr>
		   </table>     
      </div>
      
      <div class="modal-footer">
    	  <input type="submit" name="ajouterMesure" value=Valider class="btn btn-primary"> 
	 	  <input type="reset" name="resetMesure" value="Reset" class="btn btn-secondary">
      </div>
      
      </form>
    </div>
  </div>
</div>

<!-- PopUp Modification -->
<div class="modal" id="modalModifierMes" tabindex="-1">
  <div class="modal-dialog">
    <div class="modal-content">
     <form method="post" action="ControllerServlet">
     
      <div class="modal-header">
        <h5 class="modal-title">Modifier Mesure </h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      
      <div class="modal-body">
       		<table class="table-bordered" align="center">
				<tr>
					<td colspan="2" align="center"><h3 class="text-muted"> Mesure </h3> 
						<input name="idMesure" type="hidden" id="idIdMesure" >
					</td> 
				</tr>
				<tr>
					<td> Nom </td>
					<td> <input type="text" id="idNomMesure" name="nomMesure" required pattern=[A-Za-z0-9\s]{1,20}></td> 
				</tr>
				<tr>
					<td> Description </td>
					<td> <textarea id="idDescriptionMesure" name="descriptionMesure" rows="4" cols="50"></textarea></td> 
				</tr>
				<tr>
					<td> Vulnerabilite </td>
					<td>
						<select class="form-control" name="idVulnerabilite" >
							<option value=""></option>
							<c:forEach items="${listeVulnerabilite}" var="vulnerabilite">
								<option value="${vulnerabilite.idVulnerabilite}">${vulnerabilite.nom}</option>
							</c:forEach>
						</select>
					</td> 
				</tr>
		   </table>     
      </div>
      
      <div class="modal-footer">
    	  <input type="submit" name="modifierMesure" value=Modifier class="btn btn-primary"> 
	 	  <input type="reset" name="reset" value="Reset" class="btn btn-secondary">
      </div>
      
      </form>
    </div>
  </div>
</div>

<%@include file="/WEB-INF/includes/footer.jsp" %>
</body>
</html>