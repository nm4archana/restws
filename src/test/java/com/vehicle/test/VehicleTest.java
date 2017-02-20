package com.vehicle.test;

import org.junit.Assert;
import org.junit.Test;
import com.vehicle.service.jaxrs.Vehicle;
import com.vehicle.service.jaxrs.VehicleServiceImpl;

public class VehicleTest {

	@Test
	public void testCreate() {
		VehicleServiceImpl services = new VehicleServiceImpl();
		// Create a new vehicle object
		Vehicle vehicle = new Vehicle();
		vehicle.setCClass("Starfighter");
		vehicle.setModel("X-wing");
		vehicle.setMake("T-65A");
		vehicle.setYear(1990);
		services.create(vehicle);

		// Test the created vehicle object
		Vehicle testVehicle = services.Get("1");
		Assert.assertEquals(testVehicle.getId(), 1);
		Assert.assertEquals(testVehicle.getCClass(), "Starfighter");
		Assert.assertEquals(testVehicle.getModel(), "X-wing");
		Assert.assertEquals(testVehicle.getMake(), "T-65A");
		Assert.assertEquals(testVehicle.getYear(), 1990);
	}

	@Test
	public void testUpdate() {
		VehicleServiceImpl services = new VehicleServiceImpl();
		// Create a new vehicle object
		Vehicle vehicle = new Vehicle();
		services.create(vehicle);

		// Test by updating the vehicle object
		Vehicle testVehicle = services.Get("1");
		testVehicle.setMake("T-65C-A2");
		testVehicle.setModel("Y-wing");
		services.update(testVehicle);
		Vehicle updatedVehicle = services.Get("1");
		Assert.assertEquals(updatedVehicle.getMake(), "T-65C-A2");
		Assert.assertEquals(updatedVehicle.getModel(), "Y-wing");
	}

	@Test
	public void testDelete() {
		VehicleServiceImpl services = new VehicleServiceImpl();
		// Create a new vehicle object
		Vehicle vehicle = new Vehicle();
		vehicle.setCClass("Starfighter");
		vehicle.setModel("X-wing");
		vehicle.setMake("T-65A");
		vehicle.setYear(1990);
		services.create(vehicle);
		services.create(vehicle);

		// Test by deleting the vehicle object
		services.delete("1");
		Vehicle deletedVehicle = services.Get("1");
		Assert.assertEquals(deletedVehicle, null);

	}

}