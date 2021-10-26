package com.zoho.cab.management;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.opensymphony.xwork2.ActionSupport;
import com.zoho.cab.driver.Driver;
import com.zoho.cab.vehicle.Vehicle;

public class VehicleManagement extends ActionSupport{
	private final List<Vehicle> vehicleList;
	private InputStream inputStream;
	public VehicleManagement() {
		vehicleList = VehicleManager.getVehicleInformation();
	}
	

	public InputStream getInputStream() {
	    return inputStream;
	}

	public String getVehicleInfo() throws Exception {
		JSONObject jsonInfo = forgeToJson(vehicleList);
		inputStream = new ByteArrayInputStream(jsonInfo.toJSONString().getBytes("UTF-8"));
	    return SUCCESS;
	}
	

	
	private final JSONObject forgeToJson(List<Vehicle> vehicleList) {
		JSONObject jsonObject = new JSONObject();
		JSONArray vehicleInfoArray = new JSONArray();
		
		jsonObject.put("vehicleInfoList", vehicleInfoArray);
		vehicleList.stream().forEach(vehicleInfo->{
			JSONObject VehicleInformation = new JSONObject();
			JSONObject driverInformation = new JSONObject();
			
			Driver driver = vehicleInfo.getDriver();
			driverInformation.put("driverName",driver.getDriverName());
			driverInformation.put("driverNo",driver.getDriverNo());
			driverInformation.put("available",driver.isAvailable());
			
			VehicleInformation.put("vehicleNo",vehicleInfo.getVehicleNo());
			VehicleInformation.put("bookedSeats",vehicleInfo.getBookedSeats());
			VehicleInformation.put("totalSeats",vehicleInfo.getNoOfSeats());
			VehicleInformation.put("size",vehicleInfo.getAutomobileType().getSize());
			VehicleInformation.put("driverInfo", driverInformation);
			VehicleInformation.put("available", vehicleInfo.isAvailable());
			
			vehicleInfoArray.add(VehicleInformation);
		});
		return jsonObject;
	}
}
