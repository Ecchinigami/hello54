package fr.utbm.core.dao;

import java.util.ArrayList;
import java.util.Date; 

import fr.utbm.core.tools.LogsTemperature;
import fr.utbm.core.entity.Temperature;
 

public class LogsTemperatureDao {

	public static ArrayList<LogsTemperature> listTemperature() {

		ArrayList<LogsTemperature> arr = new ArrayList<LogsTemperature>();
		
		LogsTemperature t = new LogsTemperature();
		t.setAccepted(true);
		t.setDate(new Date());
		t.setTemperature(20);
		
		arr.add(t);
		
		return arr;
		
	}
}