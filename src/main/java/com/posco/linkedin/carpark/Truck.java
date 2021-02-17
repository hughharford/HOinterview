package com.posco.linkedin.carpark;

import com.posco.linkedin.carpark.Vehicle.*;

public class Truck {

	private VehicleType type;
	
	public Truck(VehicleType type) {
		this.type = type;
	}
	
	public VehicleSize getSize() {
		return VehicleSize.LARGE;
	}
	
	public VehicleType getType() {
		return type;
	}
}
