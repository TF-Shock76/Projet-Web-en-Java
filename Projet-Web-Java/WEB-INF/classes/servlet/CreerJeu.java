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

public class CreerJeu extends HttpServlet 
{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException 
	{
		try 
		{
			String titre = request.getParameter("titre");
			String nbJoueursMax = request.getParameter("nbJMax");
			String nbJoueursMin = request.getParameter("nbJMin");

			// recherche et enregistrement du driver
			Class.forName("org.sqlite.JDBC");
			// connexion à la base
			// Connection
			Connection cnx = DriverManager.getConnection("jdbc:sqlite:/C:/apache-tomcat-9.0.41/webapps/DS_Fouchet/WEB-INF/Gestion_de_Jeux.db");

			PreparedStatement st = cnx.prepareStatement("insert into Jeu(titre,nbJoueursMin,nbJoueursMax) values(?,?,?)");
			st.setString(1, titre);
			st.setInt(2, Integer.parseInt(nbJoueursMin));
			st.setInt(3, Integer.parseInt(nbJoueursMax));

			st.executeUpdate();
			cnx.close();

			
			RequestDispatcher rd = request.getRequestDispatcher("/jeux");
			rd.forward(request, response);
		} catch (ClassNotFoundException nfe) {
			// erreur si driver non trouvé
			System.err.println("Driver non trouvé");
			System.exit(-1);
		} catch (SQLException se) {
			// erreur si fichier bado incorrect
			System.err.println("Erreur : " + se.getMessage());
		}
	}
}