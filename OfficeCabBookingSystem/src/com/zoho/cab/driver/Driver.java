package com.zoho.cab.driver;

public class Driver {
	private String driverNo;
	private String driverName;
	private boolean available;
	
	public Driver(String driverNo, String driverName, boolean available) {
		super();
		this.driverNo = driverNo;
		this.driverName = driverName;
		this.available = available;
	}
	public String getDriverNo() {
		return driverNo;
	}
	public void setDriverNo(String driverNo) {
		this.driverNo = driverNo;
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	@Override
	public String toString() {
		return "Driver [driverNo=" + driverNo + ", driverName=" + driverName + ", available=" + available + "]";
	}
}
