package com.zoho.cab.vehicle;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.json.simple.JSONObject;

import com.opensymphony.xwork2.ActionSupport;
import com.zoho.cab.management.VehicleManager;

public class VehicleHandler extends ActionSupport{
	private String vehicleNo;
	private String driverNo;
	private Integer noOfSeats;
	private final VehicleManager manager;
	private InputStream inputStream;
	
	public VehicleHandler() {
		manager = VehicleManager.getVehicleManager();
	}
	
	public String getVehicleInformation() throws Exception{
		System.out.println("Inside the getVehicleInformation method"+vehicleNo);
		Vehicle vehicle = manager.getVehicleInformation(vehicleNo);
		System.out.println("Vehicle :"+vehicle);
		
		JSONObject object = new JSONObject();
		object.put("driverNo",vehicle.getDriver().getDriverNo());
		object.put("driverName",vehicle.getDriver().getDriverName());
		object.put("vehicleNo",vehicle.getVehicleNo());
		object.put("bookedSeats",vehicle.getBookedSeats());
		object.put("totalSeats",vehicle.getNoOfSeats());
		object.put("size",vehicle.getAutomobileType().getSize());
		
		inputStream = new ByteArrayInputStream(object.toJSONString().getBytes("UTF-8"));
		return SUCCESS;
	}
	
	public String bookSeats() throws Exception{
		System.out.println("Inside the bookSeats!");
		System.out.println("vehicleNo:"+vehicleNo+" :: driverNo:"+driverNo+" :: No of seats :"+noOfSeats);
		Vehicle vehicle = manager
			.getVehicleInformation()
			.stream()
			.filter((vehicleItem)->vehicleItem.getVehicleNo().equals(vehicleNo) && vehicleItem.getDriver().getDriverNo().equals(driverNo))
			.findFirst()
			.get();
		
		vehicle.setBookedSeats(vehicle.getBookedSeats()+noOfSeats);
		vehicle.setAvailable(!(vehicle.getNoOfSeats() == vehicle.getBookedSeats()));
		System.out.println("Vehicle :"+vehicleNo+" --> "+vehicle.isAvailable());
		//future enhancement if required!
		//Maintain a user object at the vehicle level, to keep trak of the users booking the vehicle's seats!
		
		JSONObject object = new JSONObject();
		inputStream = new ByteArrayInputStream(object.toJSONString().getBytes("UTF-8"));
		return SUCCESS;
	}

	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public String getDriverNo() {
		return driverNo;
	}

	public void setDriverNo(String driverNo) {
		this.driverNo = driverNo;
	}

	public Integer getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(Integer noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public VehicleManager getManager() {
		return manager;
	}
}
