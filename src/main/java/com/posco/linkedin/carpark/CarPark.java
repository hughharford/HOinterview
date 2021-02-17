package com.posco.linkedin.carpark;

import com.posco.linkedin.carpark.Vehicle.*;

public class CarPark {
	private int smallSpaces;
	private int smallHandicap;
	private int mediumSpaces;
	private int mediumHandicap;
	private int largeSpaces;
	private int largeHandicap;
	
	public CarPark(int noSmall, int noSmallHandicap, int noMedium, 
			int noMediumHandicap, int noLarge, int noLargeHandicap) {
		
		this.smallSpaces = noSmall;
		this.smallHandicap = noSmallHandicap;
		this.mediumSpaces = noMedium;
		this.mediumHandicap = noMediumHandicap;
		this.largeSpaces = noLarge;
		this.largeHandicap = noLargeHandicap;
	}
	
	public void park(Vehicle incoming) {
		System.out.println("Parking " + incoming.getType());
		
		
		System.out.println("no spaces left: " + getTotalSpaces());
	}
	
	public int getSmallSpaces() {
		return smallSpaces;
	}

	public int getSmallHandicap() {
		return smallHandicap;
	}

	public int getMediumSpaces() {
		return mediumSpaces;
	}

	public int getMediumHandicap() {
		return mediumHandicap;
	}

	public int getLargeSpaces() {
		return largeSpaces;
	}

	public int getLargeHandicap() {
		return largeHandicap;
	}

	public int getTotalSpaces() {
		int spaces = this.smallSpaces + this.mediumSpaces;
		return spaces;
	}
	
	
}
