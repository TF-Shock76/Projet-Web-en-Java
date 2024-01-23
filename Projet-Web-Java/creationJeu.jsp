<%@ page contentType="text/html; charset=UTF-8" %>
<!Doctype html>
<html>
	<head>
        <meta name="author" content="Thibault FOUCHET">
	    <title>Création</title>
        <link href="style/main.css" rel="stylesheet">
    </head>
    <body>
        <nav>
            <a class="nav" href="/DS_Fouchet/index.jsp">Accueil</a>
        </nav>
        <h1>Création</h1>
	    <form method="get" action="creerTheme">
	    	<div class="creation" >
	    	    <label for="nomTheme">Nom du thème</label>
			    <input type="text" name="nomTheme"><br><br>
	    	    <button type="submit" class="btn btn-light">Créer un thème</button>
	    	</div>
    	</form><br>


    <form class="creation" method="get" action="creerJeu">
        <div>
            <label for="nomJeu">Nom du jeu</label>
            <input type="text" name="titre">
        </div>
        <div>
            <label for="nbJMin">Nombre de joueurs min</label>
            <input type="number" name="nbJMin" placeholder="2" required>
        </div>
        <div>
            <label for="nbJMax">Nombre de joueurs max</label>
            <input type="number" name="nbJMax" placeholder="10" required>
        </div>
        <button type="submit">Créer un jeu</button>
    </form>
</body>

</html>