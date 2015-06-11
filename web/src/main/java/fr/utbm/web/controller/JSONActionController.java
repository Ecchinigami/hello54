package fr.utbm.web.controller;

import java.util.Date;

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
 

/**
 * Handles JSON Parsing
 */
public class JSONActionController {
	
	
	
	
	public JSONActionController() {
	}
	
	public JSONResult doAction(JSONResult jsonResult) {
		
		switch(jsonResult.getTypeRequest())
		{
			case "insert":
				jsonResult = insertQuery(jsonResult);
				break;
			default:
				jsonResult.set_error(JSONUtils.ERREUR_FONCTION_INCONNUE, "JsonActionFilter : fonction inconnue \""+jsonResult.getTypeRequest()+"\"");
		}
		
		return jsonResult;
	}
	
	private JSONResult insertQuery(JSONResult jsonResult) {
		
		if(jsonResult.getData() instanceof Temperature)
		{
			jsonResult = insertTemperature(jsonResult);
		}
		else
		{
			jsonResult.set_error(JSONUtils.ERREUR_PARAMS_INCORRECTS, "JsonActionFilter : Objet inconnu \""+jsonResult.getData()+"\"");
		}
		
		return jsonResult;
		
	}
	
	
	private JSONResult insertTemperature(JSONResult jsonResult) {
		
		Temperature temperature = (Temperature)jsonResult.getData();
		
		// Enregistrer tout en logs
		LogsTemperature logTmp = new LogsTemperature();
		logTmp.setAccepted(jsonResult.isError());
		logTmp.setDate(temperature.getTmp_Date());
		logTmp.setTemperature(temperature.getTmp_Value());
		LogsTemperatureDao.addTemperatureLog(logTmp);
		
		if(!jsonResult.isError())
		{
			// Enregistrer température en BDD
			
			SensorDao sd=new SensorDao();
			Sensor s=sd.getSensorById(1);
			TemperatureDao tDao = new TemperatureDao();
			tDao.insererTemperature(temperature);
		}
		
		return jsonResult;
		
		
	}
	
	
	
	
	

}