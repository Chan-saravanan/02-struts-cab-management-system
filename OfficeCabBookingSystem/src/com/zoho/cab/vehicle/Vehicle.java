package com.zoho.cab.vehicle;

import com.zoho.cab.driver.Driver;

public class Vehicle {
	private String vehicleNo;
	private AutoMobileType automobileType;
	private int noOfSeats;//total seats
	private int bookedSeats;//booked seats
	private boolean available;
	private Driver driver;
	
	public Vehicle() {
		// TODO Auto-generated constructor stub
	}

	public Vehicle(String vehicleNo, AutoMobileType automobileType, int noOfSeats, int bookedSeats, boolean available, Driver driver) {
		this.vehicleNo = vehicleNo;
		this.automobileType = automobileType;
		this.noOfSeats = noOfSeats;
		this.bookedSeats = bookedSeats;
		this.available = available;
		this.driver = driver;
	}

	public String getVehicleNo() {
		return vehicleNo;
	}
	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}
	public AutoMobileType getAutomobileType() {
		return automobileType;
	}
	public void setAutomobileType(AutoMobileType automobileType) {
		this.automobileType = automobileType;
	}
	
	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public int getBookedSeats() {
		return bookedSeats;
	}
	public void setBookedSeats(int bookedSeats) {
		this.bookedSeats = bookedSeats;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	public Driver getDriver() {
		return driver;
	}
	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	@Override
	public String toString() {
		return "Vehicle [vehicleNo=" + vehicleNo + ", automobileType=" + automobileType + ", noOfSeats=" + noOfSeats
				+ ", bookedSeats=" + bookedSeats + ", available=" + available + ", driver=" + driver + "]";
	}
}
