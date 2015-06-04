package fr.utbm.core.tools;

public class TemperatureFilter {
    public static int minTemperature = 0;
    public static int maxTemperature = 20;
    public static int intervalDeTemps = 30*60*1000; // 30 minutes

    public TemperatureFilter() {
    }

    public static int getMinTemperature() {
        return minTemperature;
    }

    public static int getMaxTemperature() {
        return maxTemperature;
    }

    public static int getIntervalDeTemps() {
        return intervalDeTemps;
    }  
    
    public static void setMinTemperature(int minTemperature){
    	TemperatureFilter.minTemperature=minTemperature;
    }

    public static void setMaxTemperature(int maxTemperature) {
    	TemperatureFilter.maxTemperature = maxTemperature;
    }

    public static void setIntervalDeTemps(int intervalDeTemps) {
    	TemperatureFilter.intervalDeTemps = intervalDeTemps;
    }   
}
