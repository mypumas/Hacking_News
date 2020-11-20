<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detail Vulnerabilite</title>
<!-- CSS only -->
<link rel="stylesheet"href="${pageContext.request.contextPath}/css/index.css">
<link rel="stylesheet"href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet"href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"href="https://www.w3schools.com/lib/w3-theme-black.css">
<link rel="stylesheet"href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<!-- JS, Popper.js, and jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</head>

<body>

	<%@ include file="/WEB-INF/includes/header.jsp"%>
	
	<div class="album py-5 bg-light">
    <div class="container">

      <div class="row">
        <c:forEach items="${listeVulnerabiliteLogiciel}" var="vulnerabiliteLogiciel" varStatus="loop">
        <c:if test="${vulnerabiliteLogiciel.vulnerabilite.idVulnerabilite == idVulnerabilite}">
        <c:if test="${vulnerabiliteLogiciel.logiciel.idLogiciel == idLogiciel}">
        <div class="col-md-12">
          <div class="card mb-4 shadow-sm">
            <svg class="bd-placeholder-img card-img-top" width="100%" height="70" xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder: Thumbnail"><rect width="100%" height="100%" fill="#55595c"/><text x="50%" y="50%" fill="#eceeef" dy=".3em">${fn:toUpperCase(vulnerabiliteLogiciel.vulnerabilite.nom)}</text></svg>
            
            <div class="card-body">
              <p class="card-text">
              	<div class="alert alert-info" role="alert">
              		Logiciel  : <a href="ControllerServlet?action=vulnarebiliteLogiciel&idLogiciel=${vulnerabiliteLogiciel.logiciel.idLogiciel}">${vulnerabiliteLogiciel.logiciel.nom}</a>
              	</div>
			  </p>
			  <c:choose>
					<c:when test="${vulnerabiliteLogiciel.vulnerabilite.criticite.niveau == 'Extrême'}">
						<div class="alert alert-danger" role="alert">
				  			<p class="card-text">Criticité : <a href="ControllerServlet?action=vulnarebiliteCriticite&idCriticite=${vulnerabiliteLogiciel.vulnerabilite.criticite.idCriticite}">${vulnerabiliteLogiciel.vulnerabilite.criticite.niveau}</a></p>
						</div>
					</c:when>
					<c:when test="${vulnerabiliteLogiciel.vulnerabilite.criticite.niveau == 'Elevée'}">
						<div class="alert alert-danger" role="alert">
							<p class="card-text">Criticité : <a href="ControllerServlet?action=vulnarebiliteCriticite&idCriticite=${vulnerabiliteLogiciel.vulnerabilite.criticite.idCriticite}">${vulnerabiliteLogiciel.vulnerabilite.criticite.niveau}</a></p>
						</div>
					</c:when>
					<c:when test="${vulnerabiliteLogiciel.vulnerabilite.criticite.niveau == 'Modérée'}">
						<div class="alert alert-warning" role="alert">
							<p class="card-text">Criticité : <a href="ControllerServlet?action=vulnarebiliteCriticite&idCriticite=${vulnerabiliteLogiciel.vulnerabilite.criticite.idCriticite}">${vulnerabiliteLogiciel.vulnerabilite.criticite.niveau}</a></p>
						</div>
					</c:when>
					<c:otherwise>
						<div class="alert alert-success" role="alert">
							<p class="card-text">Criticité : <a href="ControllerServlet?action=vulnarebiliteCriticite&idCriticite=${vulnerabiliteLogiciel.vulnerabilite.criticite.idCriticite}">${vulnerabiliteLogiciel.vulnerabilite.criticite.niveau}</a></p>
						</div>
					</c:otherwise>
			  </c:choose>
			  <div class="alert alert-secondary" role="alert">
			    	 <p class="card-text">${vulnerabiliteLogiciel.vulnerabilite.description}</p>
			  </div>
              <div class="d-flex justify-content-between align-items-center">
                <small class="text-muted">${vulnerabiliteLogiciel.date}</small>
              </div>
            </div>
          </div>
        </div>
        
         <div class="col-md-12">
          <div class="card mb-4 shadow-sm">
            <svg class="bd-placeholder-img card-img-top" width="100%" height="40" xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder: Thumbnail"><rect width="100%" height="100%" fill="#55595c"/><text x="50%" y="50%" fill="#eceeef" dy=".3em">	LISTE DES MESURES</text></svg>
  			
            <div class="card-body">
              <c:forEach items="${listeMesure}" var="mesure">	
			  <c:if test="${mesure.vulnerabilite.idVulnerabilite == vulnerabiliteLogiciel.vulnerabilite.idVulnerabilite}">
				  <div class="alert alert-info" role="alert">
              		<p class="card-text">${mesure.nomMesure}</p>
              	  </div>
				  <div class="alert alert-secondary" role="alert">
				    	 <p class="card-text">${mesure.descriptionMesure}</p>
				  </div>
			  </c:if>
			  </c:forEach>
            </div>
          </div>
        </div>
        
      </c:if>
      </c:if>
      </c:forEach>
	 </div>
    </div>
    </div>

<!--appel footer -->
<%@ include file="/WEB-INF/includes/footer.jsp"%>
</body>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</html>