package com.posco.linkedin.carpark;

import com.posco.linkedin.carpark.Vehicle.*;

public class Van {

	private VehicleType type;
	
	public Van(VehicleType type) {
		this.type = type;
	}
	
	public VehicleSize getSize() {
		return VehicleSize.MEDIUM;
	}
	
	public VehicleType getType() {
		return type;
	}
}
