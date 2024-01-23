<%@ page import="donnees.Jeu"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!Doctype html>
<html>
	<head>
		<meta name="author" content="Thibault FOUCHET">
		<title>Liste des jeux</title>
		<link href="style/main.css" rel="stylesheet">
	</head>
	<body>
		<nav>
			<a class="nav" href="/DS_Fouchet/index.jsp">Accueil</a>
		</nav>
		<h1>Liste des jeux</h1>
		<table>
			<th>Titre</th>
			<th>Nombre de joueurs minimum</th>
			<th>Nombre de joueurs maximum</th>
			<c:forEach items="${jeux}"  var="current">
			    <tr>
 				    <td><c:out value="${ current.titre }" /></td>
 					<td><c:out value="${ current.nbJoueursMin }" /></td>
 		   			<td><c:out value="${ current.nbJoueursMax }" /></td>
    			</tr>
			</c:forEach>
		</table>
	</body>
</html>

