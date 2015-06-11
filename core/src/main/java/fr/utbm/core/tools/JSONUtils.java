package fr.utbm.core.tools;

import org.json.simple.JSONObject;

import fr.utbm.core.entity.JSONResult;

public class JSONUtils {
	public static final int ERREUR_INCONNUE = 0;
	public static final int ERREUR_JSON_INCORRECT = 1;
	public static final int ERREUR_FONCTION_INCONNUE = 2;
	public static final int ERREUR_PARAMS_INCORRECTS = 3;
	public static final int ERREUR_JSON_FILTRE_REFUSE = 4;

	public static String getJsonFailedById(int idError) {

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
	
	public static String getJsonSuccess(String data) {
		JSONObject obj=new JSONObject();
		
		obj.put("status","success");
		obj.put("data", data);

		return obj.toString();
	}

	public static String getJsonFailed(int idError, String message) {
		JSONObject obj=new JSONObject();

		obj.put("status","error");
		obj.put("errorId",new Integer(idError));
		obj.put("message",message);

		return obj.toString();
	}
	
	public static String getJsonStringResult(JSONResult json) {

		if(json.getStatus() == JSONResult.STATUS_SUCCESS)
			return getJsonSuccess(json.getMessage());
		else 
			return getJsonFailed(json.getIdError(), json.getMessage());
	}
}
