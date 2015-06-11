package fr.utbm.web.controller;

import fr.utbm.core.entity.JSONResult;
import fr.utbm.core.entity.Temperature;
import fr.utbm.core.tools.JSONUtils;
import fr.utbm.core.tools.TemperatureFilter;

public class JSONFilterController {
	
	
	public JSONFilterController() {
	}
	
	public JSONResult filter(JSONResult json) {
		
		if(json.getData() instanceof Temperature)
		{
			json = temperatureFilter(json);
		}
		
		return json;
	}
	
	
	private JSONResult temperatureFilter(JSONResult jsonResult) {
		
		long currentDate = System.currentTimeMillis() / 1000;
		
		if(jsonResult.getDate() < currentDate - TemperatureFilter.getIntervalDeTemps() || jsonResult.getDate() > currentDate + TemperatureFilter.getIntervalDeTemps())
		{
			jsonResult.set_error(JSONUtils.ERREUR_JSON_FILTRE_REFUSE, "Date refusée par le filtre (Date trop ancienne ou trop récente)");
			return jsonResult;
		}
		
		Temperature temp = (Temperature) jsonResult.getData();

		if(temp.getTmp_Value() < TemperatureFilter.getMinTemperature() || temp.getTmp_Value() > TemperatureFilter.getMaxTemperature())
		{
			jsonResult.set_error(JSONUtils.ERREUR_JSON_FILTRE_REFUSE, "Temperature \""+temp.getTmp_Value()+"\" refusée par le filtre : ["+TemperatureFilter.getMinTemperature()+", "+TemperatureFilter.getMaxTemperature()+"]");
			return jsonResult;
		}
		
		return jsonResult;
		
	}

}
