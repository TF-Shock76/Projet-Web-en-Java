<%@ page import="donnees.Theme"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!Doctype html>
<html>
	<head>
		<meta name="author" content="Thibault FOUCHET">
		<title>Liste des thèmes</title>
		<link href="style/main.css" rel="stylesheet">
	</head>
	<body>
		<nav>
			<a class="nav" href="/DS_Fouchet/index.jsp">Accueil</a>
		</nav>
		<h1>Liste des thèmes</h1>
		<table class="themes">
			<th>Nom du thème</th>
			<c:forEach items="${theme}"  var="current">
			    <tr>
	 			   <td><c:out value="${ current.nom }" /></td>
	 		   </tr>
			</c:forEach>
		</table>
	</body>
</html>

