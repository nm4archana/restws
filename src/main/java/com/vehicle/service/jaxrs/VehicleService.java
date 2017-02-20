package com.vehicle.service.jaxrs;

import java.util.List;
import javax.validation.Valid;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

/**
 * Interface that VehicleServiceImpl class has to implement
 */

@Produces({ "application/xml", "application/json" })

public interface VehicleService {
	
	// Returns a list of Vehicle objects created
	@GET
	@Path("/vehicles/")
	List<Vehicle> Get();

	
	// Returns a vehicle object based on the given vehicle id
	@GET
	@Path("/vehicles/{id}/")
	Vehicle Get(@PathParam("id") String id);

	
	// Filtering vehicles based on one or more properties
	@GET
	@Path("/vehicles/filter")
	List<Vehicle> filter(@QueryParam("Class") String Class, @QueryParam("make") String make,
			@QueryParam("model") String model, @QueryParam("year") int year);

	
	// Creates a new vehicle object, sets vehicle id and adds it to the Vehicle
	// list
	@POST
	@Path("/vehicles/")
	Response create(@Valid Vehicle vehicle);

	
	// Updates the attribute values of vehicle object
	@PUT
	@Path("/vehicles/")
	Response update(@Valid Vehicle vehicle);

	
	// Deletes the vehicle object from the list based on the user entered id
	@DELETE
	@Path("/vehicles/{id}/")
	Response delete(@PathParam("id") String id);

}
