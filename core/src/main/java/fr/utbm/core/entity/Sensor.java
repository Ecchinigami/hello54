package fr.utbm.core.entity;

public class Sensor {
	private int Sen_Id;
	private String Sen_Label;
	private int Sta_Id;
	
	public int getSta_Id() {
		return Sta_Id;
	}

	public void setSta_Id(int sta_Id) {
		Sta_Id = sta_Id;
	}

	public Sensor() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Sensor(int sen_Id, String sen_Label) {
		super();
		Sen_Id = sen_Id;
		Sen_Label = sen_Label;
	}

	public int getSen_Id() {
		return Sen_Id;
	}
	public void setSen_Id(int sen_Id) {
		Sen_Id = sen_Id;
	}
	public String getSen_Label() {
		return Sen_Label;
	}
	public void setSen_Label(String sen_Label) {
		Sen_Label = sen_Label;
	}
	
}
