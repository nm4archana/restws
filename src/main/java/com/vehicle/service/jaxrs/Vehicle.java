package com.vehicle.service.jaxrs;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Vehicle class declares all the attributes of a vehicle object
 *
 */

@XmlRootElement(name = "Vehicle")
public class Vehicle {

	private int Id;

	@Min(1950)
	@Max(2050)
	private int Year;

	@NotNull(message = "Make is required")
	private String Make;

	@NotNull(message = "Model is required")
	private String Model;

	@NotNull(message = "Class is required")
	private String Class;

	public String getCClass() {
		return Class;
	}

	public void setCClass(@NotNull String Class) {
		this.Class = Class;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public int getYear() {
		return Year;
	}

	public void setYear(int year) {
		Year = year;
	}

	public String getMake() {
		return Make;
	}

	public void setMake(@NotNull String make) {
		Make = make;
	}

	public String getModel() {
		return Model;
	}

	public void setModel(@NotNull String model) {
		Model = model;
	}

}
