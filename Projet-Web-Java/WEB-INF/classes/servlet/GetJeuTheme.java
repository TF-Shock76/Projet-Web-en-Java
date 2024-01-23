package servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import java.sql.*;

import donnees.Jeu;
import donnees.Theme;
import donnees.JeuTheme;


public class GetJeuTheme extends HttpServlet 
{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException 
    {
		try 
		{
		    // recherche et enregistrement du driver
		    Class.forName("org.sqlite.JDBC");
		    // connexion à la base
		    Connection cnx = DriverManager.getConnection("jdbc:sqlite:/C:/apache-tomcat-9.0.41/webapps/DS_Fouchet/WEB-INF/Gestion_de_Jeux.db");
		    //Connection cnx = DriverManager.getConnection("jdbc:sqlite:base.db");
		    
		    Statement st = cnx.createStatement();
			ResultSet rs = st.executeQuery("select * from Jeu");
			PreparedStatement stthemes = cnx.prepareStatement("select t.idTheme, nom From Theme t Join Jeu_Theme jt On t.idTheme = jt.idTheme where idJeu = ?");
		    ArrayList<Jeu> lstJ = new ArrayList<Jeu>();

			while (rs.next()) 
			{ 
	    		int idJeu        = Integer.parseInt(rs.getString(1));
	    		String titre     = rs.getString(2);
	    		int nbJoueursMin = Integer.parseInt(rs.getString(3));
	    		int nbJoueursMax = Integer.parseInt(rs.getString(4));
	    		
	    		Jeu j = new Jeu(idJeu, titre, nbJoueursMin, nbJoueursMax);
	   	        lstJ.add(j);
	    		stthemes.setInt(1, Integer.parseInt(rs.getString(1))); 
	    		ResultSet rsthemes = stthemes.executeQuery(); 

	    		while(rsthemes.next())
	    		{
	    			j.addTheme(new Theme(Integer.parseInt(rsthemes.getString(1)), rsthemes.getString(2)));
	    		}
			}
			
	        request.setAttribute("jt", lstJ);
		    RequestDispatcher rd = request.getRequestDispatcher("/afficherJeuTheme.jsp");
		    rd.forward(request, response);
		    cnx.close();
		}
		catch(ClassNotFoundException nfe) {
		    // erreur si driver non trouvé
		    System.err.println("Driver non trouvé");
		    System.exit(-1);
		}
		catch(SQLException se) {
		    // erreur si fichier bado incorrect
		    System.err.println("Erreur : " + se.getMessage());
		}	
	}
}