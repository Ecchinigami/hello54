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
    	System.out.println("1");
    	TemperatureDao td=new TemperatureDao();
    	System.out.println("2");
    	SensorDao sd=new SensorDao();
    	System.out.println("3");
    	Sensor s=sd.getSensorById(1);
    	System.out.println("4");
    	Temperature t=new Temperature(20, new Date(),s);
    	System.out.println("5");
    	td.insererTemperature(t);
    	System.out.println("6");
    }
}
