package fr.utbm.core;

import java.util.Date;

import fr.utbm.core.dao.SensorDao;
import fr.utbm.core.dao.TemperatureDao;
import fr.utbm.core.entity.Sensor;
import fr.utbm.core.entity.Temperature;

/**
 * Hello world!
 *
 */
public class App {
	
	
	

    public static void main(String[] args) {
    	
    	TemperatureDao td=new TemperatureDao();
    	SensorDao sd=new SensorDao();
    	Sensor s=sd.getSensorById(10000);
    	if(s == null) s = sd.getSensorById(1);
    	Temperature t=new Temperature(20, new Date(),s);
    	td.insererTemperature(t);
    }
}
