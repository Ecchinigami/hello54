
package fr.utbm.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.utbm.core.dao.LogsTemperatureDao;

public class LogsTemperatureServlet extends HttpServlet {  
    
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
        request.setAttribute("logtemperature", LogsTemperatureDao.getListTemperaturesLogs());  
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/logs.jsp").forward(request, response);  
    }  
 
} 