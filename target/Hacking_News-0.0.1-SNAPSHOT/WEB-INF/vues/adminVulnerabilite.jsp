<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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

$(document).ready(function() {
    $('#vulnerabilite').DataTable();
} );

function lunchmodal(idVulnerabilite,nom,description,criticite)
{	
	
	document.getElementById('idModifierVulnerabilite').value = idVulnerabilite;
	document.getElementById('idModifierNom').value = nom;
	document.getElementById('idModifierDescription').value = description;
	
	$('#modalModifier').modal('show');
}

function lunchmodalAddMesure(idVulnerabilite)
{	
	document.getElementById('idIdVulnerabiliteMesure').value = idVulnerabilite;
	$('#modalAddMesure').modal('show');
}

</script>
</head>
<body>
	<%@include file="/WEB-INF/includes/header.jsp" %>


	<form action="ControllerServlet" method="POST">
		<div class="card">
			<h2 class="display-4 font-italic">Liste des Vulnerabilités</h2>
		  	 <button type="button" class="btn btn-info" data-toggle="modal" data-target="#modalAjouter"> Ajouter Vulnerabilite</button>
		</div>
		
		<br>
	   		<table id="vulnerabilite" class="table table-striped table-bordered" style="width:100%">
					<thead>
						<tr>
							<th scope="col">Intitulé</th>
							<th scope="col">Description</th>
							<th scope="col">Criticité</th>
							<th scope="col" width="100px">Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listeVulnerabilite}" var="vulnerabilite">
						<tr>
							<td class="font-weight-bold">${vulnerabilite.nom}</td>
							<td>${fn:substring(vulnerabilite.description, 0, 200)} (.................)</td>
							<c:choose>
								<c:when test="${vulnerabilite.criticite.niveau == 'Extrême'}">
									<td class="p-3 mb-2 bg-danger text-white">${vulnerabilite.criticite.niveau}</td>
								</c:when>
								<c:when test="${vulnerabilite.criticite.niveau == 'Elevée'}">
									<td class="p-3 mb-2 bg-danger text-white">${vulnerabilite.criticite.niveau}</td>
								</c:when>
								<c:when test="${vulnerabilite.criticite.niveau == 'Modérée'}">
									<td class="p-3 mb-2 bg-warning text-dark">${vulnerabilite.criticite.niveau}</td>
								</c:when>
								<c:otherwise>
									<td class="p-3 mb-2 bg-success text-white">${vulnerabilite.criticite.niveau}</td>
								</c:otherwise>
							</c:choose>
							<td>
								<a onmouseover="this.style.cursor='pointer'" onclick="lunchmodalAddMesure('${vulnerabilite.idVulnerabilite}')" ><img title="Ajouter Mesure" src="${pageContext.request.contextPath}/images/add.png" /></a>
								<a onmouseover="this.style.cursor='pointer'" onclick="lunchmodal('${vulnerabilite.idVulnerabilite}','${vulnerabilite.nom}','${vulnerabilite.description}','${vulnerabilite.criticite.niveau}')"><img title="Modifier Vulnerabilite" src="${pageContext.request.contextPath}/images/edit.png" /></a>
								<a href="ControllerServlet?action=deleteVulnerabilite&idVulnerabilite=${vulnerabilite.idVulnerabilite}" onclick="return confirm('Etes vous sûr de vouloir supprimer cette vulnaribilitée ?')"><img title="Supprimer Vulnaribilité" src="${pageContext.request.contextPath}/images/delete.png" /></a>
							</td>
						</tr>
						</c:forEach>	
					</tbody>
				</table>
	</form>	

<div class="modal" id="modalAjouter" tabindex="-1">
  <div class="modal-dialog">
    <div class="modal-content">
     <form method="post" action="ControllerServlet">
     
      <div class="modal-header">
        <h5 class="modal-title">Ajouter Vulnerabilite </h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      
      <div class="modal-body">
       		<table class="table-bordered" align="center">
				<tr>
					<td colspan="2" align="center"><h3 class="text-muted"> Vulnerabilite </h3> 
						
					</td> 
				</tr>
				<tr>
					<td> Nom </td>
					<td> <input type="text" name="nom" required pattern=[A-Za-z]{1,20}></td> 
				</tr>
				<tr>
					<td> Description </td>
					<td> <textarea name="description" rows="4" cols="40"></textarea></td> 
				</tr>
				<tr>
					<td> Criticite </td>
					<td> 
						<select class="form-control" name="criticite" >
							<option value="-------">-------</option>
							<c:forEach items="${listeCriticite}" var="criticite">
								<option value="${criticite.idCriticite}">${criticite.niveau}</option>
							</c:forEach>
						</select>
					</td> 
				</tr>
		   </table>     
      </div>
      
      <div class="modal-footer">
    	  <input type="submit" name="creerVulnerabilite" value=Valider class="btn btn-primary"> 
	 	  <input type="reset" name="reset" value="Reset" class="btn btn-secondary">
      </div>
      
      </form>
    </div>
  </div>
</div>

<div class="modal" id="modalModifier" tabindex="-1">
  <div class="modal-dialog">
    <div class="modal-content">
     <form method="post" action="ControllerServlet">
     
      <div class="modal-header">
        <h5 class="modal-title">Modifier Vulnerabilite </h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      
      <div class="modal-body">
       		<table class="table-bordered" align="center">
				<tr>
					<td colspan="2" align="center"><h3 class="text-muted"> Vulnerabilite </h3> 
						<input name="idVulnerabilite" type="hidden" id="idModifierVulnerabilite" >
					</td> 
				</tr>
				<tr>
					<td> Nom </td>
					<td> <input type="text" id="idModifierNom" name="nom" required pattern=[A-Za-z0-9]{1,20}></td> 
				</tr>
				<tr>
					<td> Description </td>
					<td> <textarea id="idModifierDescription" name="description" rows="5" cols="40"></textarea></td> 
				</tr>
				<tr>
					<td> Criticite </td>
					<td> 
						<select class="form-control" name="criticite" >
							<option value="-------">-------</option>
							<c:forEach items="${listeCriticite}" var="criticite">
								<option value="${criticite.idCriticite}">${criticite.niveau}</option>
							</c:forEach>
						</select>
					</td> 
				</tr>
		   </table>     
      </div>
      
      <div class="modal-footer">
    	  <input type="submit" name="modifierVulnerabilite" value=Modifier class="btn btn-primary"> 
	 	  <input type="reset" name="reset" value="Reset" class="btn btn-secondary">
      </div>
      
      </form>
    </div>
  </div>
</div>

<div class="modal" id="modalAddMesure" tabindex="-1">
  <div class="modal-dialog">
    <div class="modal-content">
     <form method="post" action="ControllerServlet">
     
      <div class="modal-header">
        <h5 class="modal-title">Ajouter Mesure </h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      
      <div class="modal-body">
       		<table class="table-bordered" align="center">
				<tr>
					<td colspan="2" align="center"><h3 class="text-muted"> Mesure </h3> 
						<input name="idIdVulnerabiliteMesure" type="hidden" id="idIdVulnerabiliteMesure" >
					</td> 
				</tr>
				<tr>
					<td> Nom </td>
					<td> <input type="text" id="idNom" name="nomMesure" required pattern=[A-Za-z0-9]{1,20}></td> 
				</tr>
				<tr>
					<td> Description </td>
					<td> <textarea id="idDescription" name="descriptionMesure" rows="4" cols="40"></textarea></td> 
				</tr>
		   </table>     
      </div>
      
      <div class="modal-footer">
    	  <input type="submit" name="ajouterMesure" value=Ajouter class="btn btn-primary"> 
	 	  <input type="reset" name="reset" value="Reset" class="btn btn-secondary">
      </div>
      
      </form>
    </div>
  </div>
</div>
	
		<%@include file="/WEB-INF/includes/footer.jsp" %>
</body>
</html>