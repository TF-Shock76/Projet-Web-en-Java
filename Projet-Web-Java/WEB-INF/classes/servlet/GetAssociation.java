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

import donnees.Theme;
import donnees.Jeu;
import donnees.JeuTheme;

public class GetAssociation extends HttpServlet 
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
		    Statement stJeu = cnx.createStatement();
		    ResultSet rsJeu = stJeu.executeQuery("select * from Jeu");
		    Statement stTheme = cnx.createStatement();
		    ResultSet rsTheme = stTheme.executeQuery("select * from Theme");
		    
		    ArrayList<Theme> lstTheme = new ArrayList<Theme>();
		    ArrayList<Jeu>   lstJeu   = new ArrayList<Jeu>();

			while (rsJeu.next()) 
			{ 
				Jeu   j = new Jeu(Integer.parseInt(rsJeu.getString(1)), rsJeu.getString(2), Integer.parseInt(rsJeu.getString(3)), Integer.parseInt(rsJeu.getString(4))); 
	            lstJeu.add(j);
	        }

	        rsJeu.next();
	        while (rsTheme.next()) 
	        { 
	            Theme t = new Theme(Integer.parseInt(rsTheme.getString(1)), rsTheme.getString(2));
	            lstTheme.add(t);
	        }

	        rsTheme.next();

	        request.setAttribute("theme", lstTheme);
	        request.setAttribute("jeux", lstJeu);
		    RequestDispatcher rd = request.getRequestDispatcher("/association.jsp");
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