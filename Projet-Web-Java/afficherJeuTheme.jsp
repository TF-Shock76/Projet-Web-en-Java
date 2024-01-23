<%@ page import="donnees.Jeu"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<!Doctype html>
<html>
	<head>
		<meta name="author" content="Thibault FOUCHET">
		<title>Liste des jeux et de leur(s) thème(s)</title>
		<link href="style/main.css" rel="stylesheet">
	</head>
	<body>
		<nav>
			<a class="nav" href="/DS_Fouchet/index.jsp">Accueil</a>
		</nav>
		<h1>Liste des jeux et de leur(s) thèmes</h1>
		<table>
			<tr>
				<th>Titre</th>
				<th>Nombre de joueurs minimum</th>
				<th>Nombre de joueurs maximum</th>
				<th>Theme(s)</th>
			</tr>
			<c:forEach items="${jt}"  var="current">
			    <td><c:out value="${ current.titre }" /></th>
			    <td><c:out value="${ current.nbJoueursMin }" /></th>
			    <td><c:out value="${ current.nbJoueursMax }" /></th>
			    <td>
				<c:forEach items="${ current.themes }"  var="theme">
	        	    <c:out value="${ theme.nom }" /><br>
	        		
	        	</c:forEach>
	        	</td>
		    </c:forEach>
		    
		</table>
	</body>
</html>

