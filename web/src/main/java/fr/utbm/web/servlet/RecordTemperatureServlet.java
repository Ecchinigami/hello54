package fr.utbm.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

public class RecordTemperatureServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		JSONObject jObj = new JSONObject(request.getParameter("json")); // this parses the json
        /*Iterator it = jObj.keys(); //gets all the keys

        while(it.hasNext())
        {
            String key = it.next(); // get key
            Object o = jObj.get(key); // get value
            session.putValue(key, o); // store in session
        }*/
	
		long date = (long) jObj.get("date");
		
		// Checker la difference de date entre System.currentTimeMillis() et Filter.intervalDeTemps
		// Si c’est incorrect, on retourne un json d’erreur
	    
	
	    String typeData = (String) jObj.get("typeData");
	    
		/*switch(typeData) {
		    case "temperature":
		        if(recordTemperature(jObj.get("data"))){
				// on affiche un JSON de succes
				}
		
		    break;
		}*/

	} 
	
	private boolean recordTemperature(Object objectdata) {
	//"data": {"temperature": 20}
	    // Check si la température est correct avec l’entity Filter
	    // si non, return false;
	    // enregister la température dans la BDD avec de DAO
	    // enregistrer une entité LogTemperature supplémentaire
	    
	return true;
	}
}
