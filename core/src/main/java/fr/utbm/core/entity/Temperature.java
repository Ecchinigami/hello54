package fr.utbm.core.entity;

import java.util.Date;

public class Temperature {
	private int Tmp_Id;
	private float Tmp_Value;
	private Date Tmp_Date;
	private Sensor sensor;
	
	
	public Temperature() {
		super();
	}
	
	public Temperature( float tmp_Value, Date tmp_Date, Sensor sensor) {
		super();
		Tmp_Value = tmp_Value;
		Tmp_Date = tmp_Date;
		this.sensor = sensor;
	}

	public int getTmp_Id() {
		return Tmp_Id;
	}
	public void setTmp_Id(int tmp_Id) {
		Tmp_Id = tmp_Id;
	}
	public float getTmp_Value() {
		return Tmp_Value;
	}
	public void setTmp_Value(float tmp_Value) {
		Tmp_Value = tmp_Value;
	}
	public Date getTmp_Date() {
		return Tmp_Date;
	}
	public void setTmp_Date(Date tmp_Date) {
		Tmp_Date = tmp_Date;
	}
	public Sensor getSensor() {
		return sensor;
	}
	public void setSensor(Sensor sensor) {
		this.sensor = sensor;
	}

}
