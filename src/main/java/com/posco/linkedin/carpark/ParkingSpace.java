package com.posco.linkedin.carpark;

public class ParkingSpace implements Space {

	private VehicleSize size;
	private VehicleType type;
	private boolean isTaken;
	
	
	public ParkingSpace(VehicleSize size, VehicleType type) {
		this.size = size;
		this.type = type;
	}
	
	@Override
	public VehicleSize getSize() {
		return this.size;
	}

	@Override
	public VehicleType getType() {
		return this.type;

	}

	@Override
	public boolean getIsTaken() {
		return this.isTaken;
	}

	@Override
	public void setIsTaken(boolean taken) {
		this.isTaken = taken;
		
	}

	
}
