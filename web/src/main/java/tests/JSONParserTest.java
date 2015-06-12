package tests;
import static org.junit.Assert.*;

import org.junit.Test;

import fr.utbm.core.entity.JSONResult;
import fr.utbm.core.tools.JSONUtils;
import fr.utbm.core.tools.TemperatureFilter;
import fr.utbm.web.controller.JSONFilterController;
import fr.utbm.web.controller.JSONParserController;


public class JSONParserTest {

	@Test
	public void testJSONFormat() {
		String jsonText = "{ \"type\": \"insert\", \"typeData\":\"temperature\", \"date\":1000000, \"data\": {\"temperature\": 20}}";

		JSONResult result;
		
		JSONParserController jsonParserController = new JSONParserController();
		result = jsonParserController.parse(jsonText);
		assertTrue(result.isSuccess()); // Json formaté correctement avec toutes les données requises
		
		// tests JSONS mal formés
		result = jsonParserController.parse("{&}");
		assertTrue(result.isError());
		assertTrue(result.getIdError() == JSONUtils.ERREUR_JSON_INCORRECT);
		
		result = jsonParserController.parse("{ \"type\": \"insert\", \"typeData\":\"temperature\", \"date\":a, \"data\": 20}");
		assertTrue(result.isError());
		assertTrue(result.getIdError() == JSONUtils.ERREUR_JSON_INCORRECT);
		
		
	}
	
	@Test
	public void testMissingData() {
		JSONResult result;
		JSONParserController jsonParserController = new JSONParserController();
		// test manque data
				result = jsonParserController.parse("{ \"type\": \"insert\", \"date\":1000000, \"data\": {\"temperature\": 20}}");
				assertTrue(result.isError());
				assertTrue(result.getIdError() == JSONUtils.ERREUR_PARAMS_INCORRECTS);
				result = jsonParserController.parse("{ \"type\": \"insert\", \"typeData\":\"temperature\", \"data\": {\"temperature\": 20}}");
				assertTrue(result.isError());
				assertTrue(result.getIdError() == JSONUtils.ERREUR_PARAMS_INCORRECTS);
				result = jsonParserController.parse("{ \"type\": \"insert\", \"typeData\":\"temperature\", \"date\":1000000, \"data\": 20}");
				assertTrue(result.isError());
				assertTrue(result.getIdError() == JSONUtils.ERREUR_PARAMS_INCORRECTS);
	}
	
	@Test
	public void testTemperatureParsingAndFilter() {
		JSONResult result;
		JSONParserController jsonParserController = new JSONParserController();
		// test parsing
		result = jsonParserController.parse("{ \"type\": \"insert\", \"typeData\":\"temperature\", \"date\":1000000, \"data\": {\"temperature\": 20}}");
		assertTrue(result.isSuccess());
		// test filter
		JSONFilterController jsonFilterController = new JSONFilterController();
		result = jsonFilterController.filter(result);
		
		assertTrue(result.isError());
		assertTrue(result.getIdError() == JSONUtils.ERREUR_JSON_FILTRE_REFUSE);
		
		result = jsonParserController.parse("{ \"type\": \"insert\", \"typeData\":\"temperature\", \"date\":"+(System.currentTimeMillis()/1000)+", \"data\": {\"temperature\": 20}}");
		result = jsonFilterController.filter(result);
		assertTrue(result.isSuccess());
		
		result = jsonParserController.parse("{ \"type\": \"insert\", \"typeData\":\"temperature\", \"date\":"+(System.currentTimeMillis()/1000)+", \"data\": {\"temperature\": 20}}");
		TemperatureFilter.setMinTemperature((float) 20.1);
		result = jsonFilterController.filter(result);
		assertTrue(result.isError() && result.getIdError() == JSONUtils.ERREUR_JSON_FILTRE_REFUSE);
		
		result = jsonParserController.parse("{ \"type\": \"insert\", \"typeData\":\"temperature\", \"date\":"+(System.currentTimeMillis()/1000)+", \"data\": {\"temperature\": 20}}");
		TemperatureFilter.setMinTemperature((float) 10.0);
		TemperatureFilter.setMaxTemperature((float) 19.9);
		result = jsonFilterController.filter(result);
		assertTrue(result.isError() && result.getIdError() == JSONUtils.ERREUR_JSON_FILTRE_REFUSE);
		
		result = jsonParserController.parse("{ \"type\": \"insert\", \"typeData\":\"temperature\", \"date\":"+(System.currentTimeMillis()/1000)+", \"data\": {\"temperature\": 20}}");
		TemperatureFilter.setMinTemperature((float) 0.0);
		TemperatureFilter.setMaxTemperature((float) 50.0);
		result = jsonFilterController.filter(result);
		assertTrue(TemperatureFilter.getMaxTemperature() == (float)50.0);
		assertTrue(result.isSuccess());
	}
	
	@Test
	public void testAddSensor() {
		JSONResult result;
		JSONParserController jsonParserController = new JSONParserController();
		// test parsing
		result = jsonParserController.parse("{ \"type\": \"insert\", \"typeData\":\"temperature\", \"date\":1000000, \"data\": {\"temperature\": 20, \"sensor\":1}}");
		assertTrue(result.isSuccess());
	}

}
