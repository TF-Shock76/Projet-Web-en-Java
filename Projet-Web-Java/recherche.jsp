<%@ page contentType="text/html; charset=UTF-8" %>
<!Doctype html>
<html>
	<head>
		<meta name="author" content="Thibault FOUCHET">
	    <title>Recherche en fonction du nombre de joueurs</title>
	    <link href="style/main.css" rel="stylesheet">
	</head>
	<body>
		<nav>
			<a class="nav" href="/DS_Fouchet/index.jsp">Accueil</a>
		</nav>
	    <form class="creation" method="get" action="recherche">
	    	<div>
        		<label for="nbJMax">Nombre de joueurs Max</label>
        		<input type="number" name="nbJMax" placeholder="10" required>
			</div><br>
	    	<button type="submit" class="btn btn-light">Rechercher</button>
    	</form>
</body>

</html>