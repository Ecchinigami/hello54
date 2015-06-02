package fr.utbm.core.tools;

public class FilterTemperature {
    public static final int minTemperature = 0;
    public static final int maxTemperature = 20;
    public static final int intervalDeTemps = 30*60*1000; // 30 minutes

    public FilterTemperature() {
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
    
}
