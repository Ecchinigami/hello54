package fr.utbm.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FilterParameterServlet extends HttpServlet {
	private static final long serialVersionUID = -8560480135103940019L;
	
	public static final String VUE = "/WEB-INF/jsp/filter.jsp";
    
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        /* Affichage de la page de filtrage */
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
    
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        /* Récupération des champs du formulaire. */
        String maxTemperature = request.getParameter( "maxTemperature" );
        String minTemperature = request.getParameter( "minTemperature" );
        String intervalDeTemps = request.getParameter( "intervalDeTemps" );

        try {
            //changer le filtre
        } catch (Exception e) {
            /* Gérer les erreurs de validation ici. */
        }
    } 
}
