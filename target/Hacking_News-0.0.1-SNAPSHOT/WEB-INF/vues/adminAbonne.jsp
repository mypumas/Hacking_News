<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin : Gestion des Abonnes</title>

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
	$('#abonnes').DataTable({
		  "searching": false,
		  "paging": false
	});
	
	$('.dataTables_length').addClass('bs-select');
});

function lunchmodal(idAbonne,nom,prenom,email)
{	
	
	document.getElementById('idModifierAbonne').value = idAbonne;
	document.getElementById('idModifierNom').value = nom;
	document.getElementById('idModifierPrenom').value = prenom;
	document.getElementById('idModifierEmail').value = email;
		
	$('#modalModifier').modal('show');
}


</script>

</head>

<body>
<%@include file="/WEB-INF/includes/header.jsp" %>

	<form action="ControllerServlet" method="POST">
		<div class="card">
		  <h2 class="display-4 font-italic">Liste des Abonnés</h2>
		</div>
		
		<table id="abonnes" align="center" class="table table-striped table-bordered" style="width:70%">
        <thead>
            <tr>
                <th>Nom</th>
                <th>Prenom</th>
                <th>Email</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${listeAbonnes}" var="abonnes">
        <tr>
                <td class="font-weight-bold">${abonnes.nom}</td>
                <td class="font-weight-bold">${abonnes.prenom}</td>
                <td class="font-weight-bold">${abonnes.email}</td>
                <td>
                <a onmouseover="this.style.cursor='pointer'" onclick="lunchmodal('${abonnes.idAbonne}','${abonnes.nom}','${abonnes.prenom}','${abonnes.email}')"><img title="Modifier Abonné" src="${pageContext.request.contextPath}/images/edit.png" /></a>
                <a href="ControllerServlet?action=deleteAbonne&idAbonne=${abonnes.idAbonne}" onclick="return confirm('Etes vous sûr de vouloir supprimer cet abonné ?')"><img title="Supprimer Abonné" src="${pageContext.request.contextPath}/images/delete.png" /></a></td>
        </tr>
        </c:forEach>
		</tbody>
		</table>
	</form>	
	
	
<div class="modal" id="modalModifier" tabindex="-1">
  <div class="modal-dialog">
    <div class="modal-content">
     <form method="post" action="ControllerServlet">
     
      <div class="modal-header">
        <h5 class="modal-title">Modifier Abonné </h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      
      <div class="modal-body">
       		<table class="table-bordered" align="center">
				<tr>
					<td colspan="2" align="center"><h3 class="text-muted"> Vulnerabilite </h3> 
						<input name="idAbonne" type="hidden" id="idModifierAbonne" >
					</td> 
				</tr>
				<tr>
					<td> Nom </td>
					<td> <input type="text" id="idModifierNom" name="nom" required pattern=[A-Za-z0-9]{1,20}></td> 
				</tr>
				<tr>
					<td> Prenom </td>
					<td> <input type="text" id="idModifierPrenom" name="prenom" required pattern=[A-Za-z0-9]{1,20}></td> 
				</tr>
				<tr>
					<td>Email</td>
					<td><input type="text" id="idModifierEmail" name="email"></td>
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
		   </table>     
      </div>
      
      <div class="modal-footer">
    	  <input type="submit" name="modifierAbonne" value=Modifier class="btn btn-primary"> 
	 	  <input type="reset" name="reset" value="Reset" class="btn btn-secondary">
      </div>
      
      </form>
    </div>
  </div>
</div>

<%@include file="/WEB-INF/includes/footer.jsp" %>	
</body>
</html>