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

public class RechercheJoueurs extends HttpServlet 
{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException 
	{
		try 
		{
		String nbJMax = request.getParameter("nbJMax");
			
			// recherche et enregistrement du driver
			Class.forName("org.sqlite.JDBC");
			// connexion à la base
			// Connection
			Connection cnx = DriverManager.getConnection("jdbc:sqlite:/C:/apache-tomcat-9.0.41/webapps/DS_Fouchet/WEB-INF/Gestion_de_Jeux.db");
				    Statement st = cnx.createStatement();

			ResultSet rs = st.executeQuery("select * from Jeu where nbJoueursMax >='" + nbJMax + "'");
			

		    ArrayList<Jeu> dataList = new ArrayList<Jeu>();
			while (rs.next()) { 

	            Jeu j = new Jeu(rs.getString(1), Integer.parseInt(rs.getString(2)), Integer.parseInt(rs.getString(3)));

	            dataList.add(j);
	        }

	        rs.next();
	        request.setAttribute("jeux", dataList);
		    RequestDispatcher rd = request.getRequestDispatcher("/afficherJeux.jsp");
		    rd.forward(request, response);
		    cnx.close();
		
		} catch (ClassNotFoundException nfe) {
			// erreur si driver non trouvé
			System.err.println("Driver non trouvé");
			System.exit(-1);
		} catch (SQLException se) {
			// erreur si fichier bado incorrect
			System.err.println("Erreur : " + se.getMessage());
			System.exit(-1);
		}
	}
}