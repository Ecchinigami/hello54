package fr.utbm.core.tools;

public class LogsTemperature {
    private int temperature;
    private long date;
    private boolean accepted;

    public LogsTemperature() {
    }

    public LogsTemperature(int temperature, long date, boolean accepted) {
        this.temperature = temperature;
        this.date = date;
        this.accepted = accepted;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }
    
    
}
