package fr.utbm.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.utbm.core.tools.TemperatureFilter;

public class FilterParameterServlet extends HttpServlet {
    public static final String VUE = "/WEB-INF/jsp/filter.jsp";
    public static final TemperatureFilter f=new TemperatureFilter();
    
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        /* Affichage de la page de filtrage */
        request.setAttribute("maxTemperature", f.getMaxTemperature());
        request.setAttribute("minTemperature", f.getMinTemperature());
        request.setAttribute("intervalDeTemps", f.getIntervalDeTemps());

        //System.out.println(f.getMaxTemperature());
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
    
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        /* Récupération des champs du formulaire. */
       int maxTemperature = Integer.parseInt(request.getParameter( "maxTemperature" ));
       int minTemperature = Integer.parseInt(request.getParameter( "minTemperature" ));
       int intervalDeTemps = Integer.parseInt(request.getParameter( "intervalDeTemps" ));

        try {
            f.setMaxTemperature(maxTemperature);
            f.setMinTemperature(minTemperature);
            f.setIntervalDeTemps(intervalDeTemps);
            
            /* Re Affichage de la page de filtrage */
            request.setAttribute("maxTemperature", maxTemperature);
            request.setAttribute("minTemperature", minTemperature);
            request.setAttribute("intervalDeTemps", intervalDeTemps);
            this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
        } catch (Exception e) {
            /* Gérer les erreurs de validation ici. */
        }

    }
}