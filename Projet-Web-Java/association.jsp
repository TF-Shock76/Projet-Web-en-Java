<%@ page import="donnees.Jeu"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!Doctype html>
<html>
	<head>
		<meta name="author" content="Thibault FOUCHET">
	    <title>Association</title>
	    <link href="style/main.css" rel="stylesheet">
	</head>
	<body>
		<nav>
			<a class="nav" href="/DS_Fouchet/index.jsp">Accueil</a>
		</nav>
	    <form class="creation" method="get" action="assoJeuTheme">
	    	<div>
        		<label for="jeux">Choisir un jeu</label>
				<select name="selecJeu">
	    			<option value="">--Choisir un jeu--</option>
					<c:forEach items="${ jeux }"  var="current">
					    <option value="${ current.idJeu }">${ current.titre }</option>
					</c:forEach>
				</select>
			</div><br>
			<div>
        		<label for="theme">Choisir un thème</label>
				<select name="selecTheme">
	    			<option value="">--Choisir un thème--</option>
					<c:forEach items="${ theme }"  var="current">
					    <option value="${ current.idTheme }">${ current.nom }</option>
					</c:forEach>
				</select>
			</div>
	    	<button type="submit" class="btn btn-light">Associer</button>
    	</form>
</body>

</html>