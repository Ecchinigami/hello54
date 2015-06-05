package fr.utbm.core.tools;

public class TemperatureFilter {
    public static float minTemperature = 0;
    public static float maxTemperature = 20;
    public static int intervalDeTemps = 30*60; // 30 minutes

    public TemperatureFilter() {
    }

    public static float getMinTemperature() {
        return minTemperature;
    }

    public static float getMaxTemperature() {
        return maxTemperature;
    }

    public static int getIntervalDeTemps() {
        return intervalDeTemps;
    }  
    
    public static void setMinTemperature(float minTemperature){
    	TemperatureFilter.minTemperature=minTemperature;
    }

    public static void setMaxTemperature(float maxTemperature) {
    	TemperatureFilter.maxTemperature = maxTemperature;
    }

    public static void setIntervalDeTemps(int intervalDeTemps) {
    	TemperatureFilter.intervalDeTemps = intervalDeTemps;
    }   
}
