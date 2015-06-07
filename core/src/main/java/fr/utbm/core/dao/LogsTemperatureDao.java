package fr.utbm.core.dao;

import java.util.ArrayList;
import java.util.Date; 

import fr.utbm.core.tools.LogsTemperature;
import fr.utbm.core.entity.Temperature;
 

public class LogsTemperatureDao {
	
	private static ArrayList<LogsTemperature> arr = new ArrayList<LogsTemperature>();

	static{

		ArrayList<LogsTemperature> arr = new ArrayList<LogsTemperature>();
		
		LogsTemperature t = new LogsTemperature();
		t.setAccepted(true);
		t.setDate(new Date());
		t.setTemperature(20);
		
		arr.add(t);
	}
	
	public static boolean addTemperatureLog(LogsTemperature t){
		while (arr.size() >= 10) {
			arr.remove(0);
		}
		
		return arr.add(t);
	}
	
	public static ArrayList<LogsTemperature>  getListTemperaturesLogs(){
		return arr;
	}
	
}