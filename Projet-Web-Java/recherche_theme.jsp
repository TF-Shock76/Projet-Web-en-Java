<%@ page import="donnees.Jeu"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!Doctype html>
<html>
	<head>
		<meta name="author" content="Thibault FOUCHET">
	    <title>Recherche en fonction d'un thème</title>
	    <link href="style/main.css" rel="stylesheet">
	</head>
	<body>
		<nav>
			<a class="nav" href="/DS_Fouchet/index.jsp">Accueil</a>
		</nav>
	    <form class="creation" method="get" action="rechercheT">
	    	<div><br>
        		<label for="theme">Choisir un thème</label>
				<select name="jeuByTheme">
	    			<option value="">--Choisir un thème--</option>
					<c:forEach items="${theme}"  var="current">
					    <option value="${ current.idTheme }">${ current.nom }</option>
					</c:forEach>
				</select>
			</div><br>
	    	<button type="submit" class="btn btn-light">Rechercher</button>
    	</form>
</body>

</html>