package fr.utbm.web.servlet; 

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date; 

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse; 

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException; 

import fr.utbm.core.dao.LogsTemperatureDao;
import fr.utbm.core.dao.SensorDao;
import fr.utbm.core.dao.TemperatureDao;
import fr.utbm.core.entity.JSONResult;
import fr.utbm.core.entity.Sensor;
import fr.utbm.core.entity.Temperature;
import fr.utbm.core.tools.JSONUtils;
import fr.utbm.core.tools.LogsTemperature;
import fr.utbm.core.tools.TemperatureFilter;
import fr.utbm.web.controller.JSONActionController;
import fr.utbm.web.controller.JSONFilterController;
import fr.utbm.web.controller.JSONParserController;


public class RecordTemperatureServlet extends HttpServlet { 

	public static final int ERREUR_INCONNUE = 0;	
	public static final int ERREUR_JSON_INCORRECT = 1;	
	public static final int ERREUR_FONCTION_INCONNUE = 2;	
	public static final int ERREUR_PARAMS_INCORRECTS = 3;	
	public static final int ERREUR_JSON_FILTRE_REFUSE = 4; 

	// Pour tester :	
	// http://localhost:8080/projet/record?json={ "type": "insert", "typeData":"temperature", "date":1000000, "data": {"temperature": 20}}


	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		System.out.println("JSON GET");
		parseJson(request, response);
	} 

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("JSON POST");	
		parseJson(request, response);	
	} 

	private void parseJson(HttpServletRequest request, HttpServletResponse response) {

		//http://code.google.com/p/json-simple/wiki/DecodingExamples
		// { "type": "insert", "typeData":"temperature", "date":TIMESTAMP, "data": {"temperature": 20}}
		String jsonText = request.getParameter("json");//"{ \"type\": \"insert\", \"typeData\":\"temperature\", \"date\":1000000, \"data\": {\"temperature\": 20}}";

		JSONResult result;
		
		JSONParserController jsonParserController = new JSONParserController();
		result = jsonParserController.parse(jsonText);
		if(result.isError())
		{
			displayResult(JSONUtils.getJsonStringResult(result), response);
			return;
		}
		
		JSONFilterController jsonFilterController = new JSONFilterController();
		result = jsonFilterController.filter(result);
		
		JSONActionController jsonActionController = new JSONActionController();
		result = jsonActionController.doAction(result);
		
		if(result.isSuccess() && result.getData() != null)
		{
			result.set_message(result.getData().toString());
		}
		
		
		displayResult(JSONUtils.getJsonStringResult(result), response);
	}

	private void displayResult(String result, HttpServletResponse response) {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out;
		
		try {
			out = response.getWriter();

			try {
				out.println(result);
			} finally {
				out.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
}