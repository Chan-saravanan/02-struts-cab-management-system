package com.zoho.cab.management;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import com.zoho.cab.driver.Driver;
import com.zoho.cab.vehicle.AutoMobileType;
import com.zoho.cab.vehicle.Vehicle;

public class VehicleManager {
	private static final List<Vehicle> vehicleList = new ArrayList<>();
	private static final VehicleManager manager = new VehicleManager(); 
	
	public static VehicleManager getVehicleManager() {
		return manager;
	}
	
	public static List<Vehicle> getVehicleInformation() {
		return vehicleList;
	}

	private VehicleManager() {
		getVechicleInformation(vehicleList);
	}
	
	
	private void getVechicleInformation(List<Vehicle> vehicleList) {
		IntStream.range(1, 21).forEach(index->{
			vehicleList.add(prepareVehicle(index));
		});
	}
	
	private Vehicle prepareVehicle(int index) {
		AutoMobileType[] autoMobileTypes = AutoMobileType.values();
		AutoMobileType vehicleType = autoMobileTypes[new Random().ints(1, 0, autoMobileTypes.length-1).findFirst().getAsInt()];
		int noOfSeats = vehicleType.getAvailableSeats(), bookedSeats = new Random().ints(1, vehicleType.getAvailableSeats()).findFirst().getAsInt();
		Vehicle vehicle = 
		new Vehicle(
			"Car-".concat(String.valueOf(index)),
			vehicleType,
			noOfSeats,
			bookedSeats,
			!(noOfSeats == bookedSeats),
			new Driver("DRV-".concat(String.valueOf(index)), "Driver-000".concat(String.valueOf(index)), true)
		);
		return vehicle;
	}
	
	public Vehicle getVehicleInformation(String vehicleNo) {
		return 
		vehicleList
		.stream()
		.filter((vehicle)-> vehicle.getVehicleNo().equals(vehicleNo))
		.findFirst()
		.orElseGet(()->{
			return vehicleList.get(0);
		});
	}
}
