package com.vehicle.service.jaxrs;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Response;

/**
 * Service Implementation class which has methods for create, delete, update and
 * get. It implements VehicleService interface and has methods for validating
 * year, make model and class that is entered by the user
 * 
 */
public class VehicleServiceImpl implements VehicleService {
	private int currentId = 0;

	// To save the vehicle objects created
	List<Vehicle> vehicles = new ArrayList<Vehicle>();

	public VehicleServiceImpl() {
		
	}

	// Will return list of vehicle objects
	@Override
	public List<Vehicle> Get() {
		// TODO Auto-generated method stub
		return vehicles;
	}

	// Will return a vehicle object, given Id
	@Override
	public Vehicle Get(String id) {
		int currId = Integer.parseInt(id);
		Vehicle vehicle = null;
		for (int i = 0; i < vehicles.size(); i++) {
			if (vehicles.get(i).getId() == currId) {
				vehicle = vehicles.get(i);
				return vehicle;

			}

		}
		return vehicle;
	}

	// Create a vehicle object and add it to list
	@Override
	public Response create(Vehicle vehicle) {
		vehicle.setId(++currentId);
		vehicles.add(vehicle);
		return Response.ok(vehicle).build();
	}

	// Get a vehicle object, update it, and add it to list
	@Override
	public Response update(Vehicle vehicle) {
		Response response = null;

		for (int i = 0; i < vehicles.size(); i++) {
			if (vehicles.get(i).getId() == vehicle.getId()) {
				vehicles.remove(vehicles.get(i));
				vehicles.add(vehicle);
				response = Response.ok().build();
				break;
			} else {
				response = Response.notModified().build();
			}
		}
		return response;
	}

	// Get the vehicle object and delete it
	@Override
	public Response delete(String id) {
		int currid = Integer.parseInt(id);
		Response response = null;

		for (int i = 0; i < vehicles.size(); i++) {
			if (vehicles.get(i).getId() == currid) {
				vehicles.remove(i);
				response = Response.ok().build();
				break;
			} else {
				response = Response.notModified().build();

			}
		}
		return response;

	}

	// Returns a list of vehicle objects based on one or more vehicle properties
	@Override
	public List<Vehicle> filter(String Class, String make, String model, int year) {
		// TODO Auto-generated method stub
		List<Vehicle> resultList = new ArrayList<Vehicle>();
		List<Vehicle> currList = new ArrayList<Vehicle>();
		currList = Get();
		for (int i = 0; i < currList.size(); i++) {
			if ((currList.get(i).getCClass().equalsIgnoreCase(Class) || Class == null)
					&& (currList.get(i).getModel().equalsIgnoreCase(model) || model == null)
					&& (currList.get(i).getMake().equalsIgnoreCase(make) || make == null)
					&& (currList.get(i).getYear() == year || year == 0)) {
				resultList.add(currList.get(i));
			}
		}

		return resultList;
	}
}
