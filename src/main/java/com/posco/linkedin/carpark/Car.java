package com.posco.linkedin.carpark;

public class Car implements Vehicle {

	private VehicleType type;
	
	public Car(VehicleType type) {
		this.type = type;
	}
	
	public VehicleSize getSize() {
		return VehicleSize.SMALL;
	}
	
	public VehicleType getType() {
		return type;
	}
}
