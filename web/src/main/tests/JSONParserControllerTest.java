import static org.junit.Assert.*;

import org.junit.Test;

import fr.utbm.core.entity.JSONResult;
import fr.utbm.core.tools.JSONUtils;
import fr.utbm.web.controller.JSONParserController;


public class JSONParserControllerTest {

	@Test
	public void test() {
		String jsonText = "{ \"type\": \"insert\", \"typeData\":\"temperature\", \"date\":1000000, \"data\": {\"temperature\": 20}}";

		JSONResult result;
		
		JSONParserController jsonParserController = new JSONParserController();
		result = jsonParserController.parse(jsonText);
		
		assertTrue(result.isError());
		assertTrue(result.getIdError() == JSONUtils.ERREUR_JSON_FILTRE_REFUSE);
		
	}

}
