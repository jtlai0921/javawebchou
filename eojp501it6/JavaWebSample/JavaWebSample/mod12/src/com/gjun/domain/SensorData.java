package com.gjun.domain;

import java.util.List;

public class SensorData implements java.io.Serializable{
	//attribute
	private String id; //device Id
	private String time; //ISO 8601 format
	private double lat; //緯度
	private double lon; //經度
	private boolean save; //儲存狀態
	private List<String> value; //多資訊字串(集合收集)
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLon() {
		return lon;
	}
	public void setLan(double lon) {
		this.lon = lon;
	}
	public boolean isSave() {
		return save;
	}
	public void setSave(boolean save) {
		this.save = save;
	}
	public List<String> getValue() {
		return value;
	}
	public void setValue(List<String> value) {
		this.value = value;
	}

	
}
