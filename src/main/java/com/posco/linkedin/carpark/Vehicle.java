package com.posco.linkedin.carpark;

public interface Vehicle {

	enum VehicleSize {
		SMALL, MEDIUM, LARGE
	}
	
	enum VehicleType {
		HANDICAP, REGULAR
	}
	
	VehicleSize getSize();
	VehicleType getType();
	
}
