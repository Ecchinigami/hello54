package fr.utbm.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.utbm.core.dao.LogsTemperatureDao;

public class LogsTemperatureServlet extends HttpServlet {  
    
    private LogsTemperatureDao dao;  
  
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
        request.setAttribute("logTemperature", dao.listTemperature());  
        getServletContext().getRequestDispatcher("/logs.jsp").forward(request, response);  
    }  
  
}  
