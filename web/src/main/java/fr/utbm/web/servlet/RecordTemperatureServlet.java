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
import fr.utbm.core.entity.Sensor;
import fr.utbm.core.entity.Temperature;
import fr.utbm.core.tools.LogsTemperature;
import fr.utbm.core.tools.TemperatureFilter;


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
		System.out.println("parse JSON"); 

		//http://code.google.com/p/json-simple/wiki/DecodingExamples
		// { "type": "insert", "typeData":"temperature", "date":TIMESTAMP, "data": {"temperature": 20}}

		JSONObject jObj = new JSONObject();
		String jsonTextReturned = ""; 
		String jsonText = request.getParameter("json");//"{ \"type\": \"insert\", \"typeData\":\"temperature\", \"date\":1000000, \"data\": {\"temperature\": 20}}";
		Object obj;
		JSONArray JSONArray;
		JSONObject JSONObj;
		JSONParser parser = new JSONParser();               

		try{
			obj = parser.parse(jsonText);
			JSONObj = (JSONObject)obj;
		}
		catch(ParseException pe){
			System.out.println("position: " + pe.getPosition());
			System.out.println(pe);
			displayResult(getJsonFailed(ERREUR_JSON_INCORRECT, "JSON mal formaté : position: " + pe.getPosition()), response);
			return;
		}catch(Exception e){
			displayResult(getJsonFailed(ERREUR_JSON_INCORRECT, "JSON erreur : "+e), response);
			return;
		}

		String typeRequest = (String) JSONObj.get("type");
		if(typeRequest == null || !typeRequest.equals("insert"))
		{
			displayResult(getJsonFailedById(ERREUR_FONCTION_INCONNUE), response);
			return;
		}

		String typeData = (String) JSONObj.get("typeData");
		if(typeData == null || !typeData.equals("temperature"))
		{
			displayResult(getJsonFailedById(ERREUR_PARAMS_INCORRECTS), response);
			return;
		}

		long dateTimestamp = 0;
		Date d;
		try {
			dateTimestamp = (long) JSONObj.get("date");
			d = new Date(dateTimestamp);
		} catch (Exception e) {
			displayResult(getJsonFailed(ERREUR_PARAMS_INCORRECTS, "NumberFormatException date"), response);
			return;
		}

		// TODO : check si date acceptée

		JSONObject data;
		try {
			data = (JSONObject) JSONObj.get("data");
		} catch (Exception e) {
			displayResult(getJsonFailed(ERREUR_PARAMS_INCORRECTS, "Data is not a JSONObject..."), response);
			return;
		}

		int temperature;
		try {
			temperature = (int)(long)data.get("temperature");
		} catch (Exception e) {
			displayResult(getJsonFailed(ERREUR_PARAMS_INCORRECTS, "Temperature is missing in Data..."+e), response);
			return;
		}

		if(temperature < TemperatureFilter.getMinTemperature() || temperature > TemperatureFilter.getMaxTemperature())
		{
			displayResult(getJsonFailed(ERREUR_JSON_FILTRE_REFUSE, "Temperature refusée par le filtre"), response);
			return;
		}

		System.out.println("TypeRequest : "+typeRequest+" , typeData : "+typeData+" , date : "+dateTimestamp+" , data : ");

		// Enregistrer température en BDD

		TemperatureDao td=new TemperatureDao();
		SensorDao sd=new SensorDao();
		Sensor s=sd.getSensorById(1);
		Temperature t=new Temperature(temperature, d, s);
		td.insererTemperature(t);

		// save logs 
		LogsTemperature logTmp = new LogsTemperature();
		logTmp.setAccepted(true);
		logTmp.setDate(new Date());
		logTmp.setTemperature(temperature);
		LogsTemperatureDao.listTemperature().add(logTmp);
		
		jsonTextReturned = getJsonSuccess("test");

		if(jsonTextReturned.equals(""))
			jsonTextReturned = getJsonFailedById(ERREUR_INCONNUE);

		displayResult(jsonTextReturned, response);
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

	private String getJsonSuccess(String data) {
		JSONObject obj=new JSONObject();
		
		obj.put("status","success");
		obj.put("data", data);

		return obj.toString();
	}

	private String getJsonFailedById(int idError) {

		String message;

		switch(idError)
		{
		case ERREUR_JSON_INCORRECT:
			message = "Le fichier JSON est malformé";
			break;

		case ERREUR_FONCTION_INCONNUE:
			message = "Fonction inconnue";
			break;

		case ERREUR_PARAMS_INCORRECTS:
			message = "Il manque des parametres au fichier JSON";
			break;

		case ERREUR_JSON_FILTRE_REFUSE:
			message = "Cette valeur a été filtrée, le JSON a donc été refusé";
			break;

		default:
			message = "Erreur inconnue";
		}

		return getJsonFailed(idError, message);
	}

	private String getJsonFailed(int idError, String message) {
		JSONObject obj=new JSONObject();

		obj.put("status","error");
		obj.put("errorId",new Integer(idError));
		obj.put("message",message);

		return obj.toString();
	}
}