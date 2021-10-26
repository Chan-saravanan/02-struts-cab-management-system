package com.zoho.cab.vehicle;

public enum AutoMobileType {
	SMALL("S", 6),
	MEDIUM("M", 10),
	LARGE("L", 20),
	EXTRA_LARGE("X_L", 40);
	
	private String size;
	private int availableSeats;
	private AutoMobileType(String size, int availableSeats) {
		this.size = size;
		this.availableSeats = availableSeats;
	}
	
	public String getSize() {
		return size;
	}
	public int getAvailableSeats() {
		return availableSeats;
	}
}
