<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Hacking News</title>

<!-- CSS only -->
<link rel="stylesheet"	href="${pageContext.request.contextPath}/css/hackingnews.css">
<link rel="stylesheet"href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet"href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"href="https://www.w3schools.com/lib/w3-theme-black.css">
<link rel="stylesheet"href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<!-- JS, Popper.js, and jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<title>Hackingnews</title>
</head>

<body>
<%@ include file="/WEB-INF/includes/header.jsp"%>


	<h2>Les dernières alertes :</h2>

	<!-- Work Row -->
	<c:forEach items="${listeVulnerabiliteLogiciel}" var="vulnerabiliteLogiciel" varStatus="loop">
		<c:if test="${(loop.index %3) == 0}">
			<div class="tableVirus">
		</c:if>
			<div class="tableQuarter">
				<div class="w3-card w3-white">
					<img class="imgVirus" src="${pageContext.request.contextPath}/images/${vulnerabiliteLogiciel.vulnerabilite.nom}.jpg" />
					<br>
					<h3 class="TitreVirus">${vulnerabiliteLogiciel.vulnerabilite.nom}</h3>
					<div class="tableContainer">
						<textarea style="width: 100%; height: 100px; overflow: hidden; resize: none" disabled="disabled">${vulnerabiliteLogiciel.vulnerabilite.description}</textarea>
							<h7 class="critRed02">Logiciel Impacté: ${vulnerabiliteLogiciel.logiciel.nom} (${vulnerabiliteLogiciel.date})</h7>
							<br>
							<h7 class="critRed02">Criticité: ${vulnerabiliteLogiciel.vulnerabilite.criticite.niveau}</h7>
							<a class="btn-detail" href="ControllerServlet?action=detail&idVulnerabilite=${vulnerabiliteLogiciel.vulnerabilite.idVulnerabilite}">Voir le détail</a>
					</div>
				</div>
			</div>
		<c:if test="${((loop.index+1) %3) == 0}">
			</div>
		</c:if>
	</c:forEach>

<!--appel footer -->
<%@ include file="/WEB-INF/includes/footer.jsp"%>
</body>
</html>