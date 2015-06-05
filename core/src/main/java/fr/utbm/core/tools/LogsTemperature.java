package fr.utbm.core.tools;

import java.util.Date;

public class LogsTemperature {
    private float temperature;
    private Date date;
    private boolean accepted;

    public LogsTemperature() {
    }

    public LogsTemperature(float temperature, Date date, boolean accepted) {
        this.temperature = temperature;
        this.date = date;
        this.accepted = accepted;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }
    
    
}
