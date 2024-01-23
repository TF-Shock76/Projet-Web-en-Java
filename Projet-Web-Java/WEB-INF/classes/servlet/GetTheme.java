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

public class GetTheme extends HttpServlet 
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
		    ResultSet rs = st.executeQuery("select * from Theme order by nom");
		    
		    ArrayList<Theme> dataList = new ArrayList<Theme>();
			while (rs.next()) 
			{ 
	            Theme t = new Theme(Integer.parseInt(rs.getString(1)), rs.getString(2));
	            dataList.add(t);
	        }

	        rs.next();
	        request.setAttribute("theme", dataList);
		    RequestDispatcher rd = request.getRequestDispatcher("/afficherThemes.jsp");
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