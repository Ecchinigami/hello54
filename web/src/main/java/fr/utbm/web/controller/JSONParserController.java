package fr.utbm.web.controller;

import java.util.Date;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import fr.utbm.core.dao.SensorDao;
import fr.utbm.core.entity.JSONResult;
import fr.utbm.core.entity.Sensor;
import fr.utbm.core.entity.Temperature;
import fr.utbm.core.tools.JSONUtils;
import fr.utbm.core.tools.TemperatureFilter;
 

/**
 * Handles JSON Parsing
 */
public class JSONParserController {
	
	
	
	
	public JSONParserController() {
	}
	
	public JSONResult parse(String data) {
		
		JSONResult result = new JSONResult();
		result.set_status(JSONResult.STATUS_SUCCESS);
		
		JSONObject jObj = new JSONObject();
		String jsonTextReturned = ""; 
		String jsonText = data;//"{ \"type\": \"insert\", \"typeData\":\"temperature\", \"date\":1000000, \"data\": {\"temperature\": 20}}";
		Object obj;
		JSONArray JSONArray;
		JSONObject JSONObj;
		JSONParser parser = new JSONParser(); 
		
		// Check le JSON qui doit toujours être bien formé, contenir une date, et un JSON data avec les données.

				try{
					obj = parser.parse(jsonText);
					JSONObj = (JSONObject)obj;
				}
				catch(ParseException pe){
					result.set_error(JSONUtils.ERREUR_JSON_INCORRECT, "JSON mal formaté : position: " + pe.getPosition());
					
					return result;
				}catch(Exception e){
					result.set_error(JSONUtils.ERREUR_JSON_INCORRECT, "JSON erreur : "+e);
					return result;
				}
				
				long dateTimestamp = 0;
				try {
					dateTimestamp = (long) JSONObj.get("date");
					result.set_date(dateTimestamp);
				} catch (Exception e) {

					result.set_error(JSONUtils.ERREUR_PARAMS_INCORRECTS, "NumberFormatException : date");
					return result;
				}
				
				
				JSONObject dataJson;
				try {
					dataJson = (JSONObject) JSONObj.get("data");
					String typeData = (String) JSONObj.get("typeData");
					JSONResult resultWithParsedObject = parseObjectDataJSON(result, dataJson, typeData);
					
					if(resultWithParsedObject.getStatus() == JSONResult.STATUS_ERROR)
					{
						return result;
					}
					else
					{
						result = resultWithParsedObject;
					}
					
				} catch (Exception e) {
					
					result.set_error(JSONUtils.ERREUR_PARAMS_INCORRECTS, "Data is not a JSONObject... : "+e);
					return result;
				}
				
				

				String typeRequest = (String) JSONObj.get("type");
								
				switch(typeRequest)
				{
					case "insert":
						result.set_typeRequest(typeRequest);
						break;
						
					case "update":
					case "delete":
					default:
						result.set_typeRequest(typeRequest);
						result.set_error(JSONUtils.ERREUR_FONCTION_INCONNUE, "Requête '"+typeRequest+"' non disponible.");
						return result;
				}
				
		
		
				return result;
		
	}
	
	private JSONResult parseObjectDataJSON(JSONResult jsonResult, JSONObject jsonData, String typeData) {
		
		switch(typeData)
		{
			case "temperature":
				jsonResult = receptionTemperature(jsonResult, jsonData);
				break;
				
			case "sensor":
			default:
				jsonResult.set_error(JSONUtils.ERREUR_PARAMS_INCORRECTS, "Le type d'objet : '"+typeData+"' n'est pas encore disponible.");
				
		}
		
		return jsonResult;
	}
	
	private JSONResult receptionTemperature(JSONResult jsonResult, JSONObject jsonData) {
		
		Temperature temperature = new Temperature();
		
		temperature.setTmp_Date(new Date(jsonResult.getDate()*1000));
		
		SensorDao sd=new SensorDao();
		Sensor s;
		int idSensor;
		try {
			idSensor = (int) jsonData.get("sensor");
			s = sd.getSensorById(idSensor);
		} catch (Exception e) {
			s = null;
		}
		if(s == null) s = sd.getSensorById(1);
		
		temperature.setSensor(s);

		float temperatureValue;
		try {
			Object temp = jsonData.get("temperature");
			if(temp instanceof Long) temperatureValue = (float)((Long) temp).doubleValue();
			else temperatureValue = (float)(double)temp;
			temperature.setTmp_Value(temperatureValue);
			jsonResult.set_data(temperature);
			
		} catch (Exception e) {
			jsonResult.set_error(JSONUtils.ERREUR_PARAMS_INCORRECTS, "La valeur de la température n'est pas indiquée dans les données : "+e);
			return jsonResult;
		}
		
		return jsonResult;
	}

}