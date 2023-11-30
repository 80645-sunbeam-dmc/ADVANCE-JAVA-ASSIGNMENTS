package com.sunbeam.dmc;

public class HumiditySensor implements Sensor{

	private int humdigit;

	public int getHumdigit() {
		return humdigit;
	}

	@Override
	public String toString() {
		return "HumiditySensor [humdigit=" + humdigit + "]";
	}

	public void setHumdigit(int humdigit) {
		this.humdigit = humdigit;
	}

	@Override
	public void readvalue() {
		// TODO Auto-generated method stub
		
	}
}
