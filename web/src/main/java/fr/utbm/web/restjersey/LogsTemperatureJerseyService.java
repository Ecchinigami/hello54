package fr.utbm.web.restjersey;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.utbm.core.dao.LogsTemperatureDao;
import fr.utbm.core.tools.LogsTemperature;

@Path("/logs")
public class LogsTemperatureJerseyService {
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String displayHTML() {
		
		String result = "<!DOCTYPE HTML><html><head><title>Historique</title></head><body><table><tr><th>Action</th><th>Date</th><th>Status</th></tr>";
 
		ArrayList<LogsTemperature> listLogs = LogsTemperatureDao.getListTemperaturesLogs();
		
		for (LogsTemperature logsTemperature : listLogs) {
			result+= "<tr><td>insertion de la temperature : "+logsTemperature.getTemperature()+"</td><td>"+logsTemperature.getDate()+"</td><td>"+logsTemperature.isAccepted()+"</td></tr>";
		}
		
		result += "</table></body></html>";
		
		return result;
	}
}
