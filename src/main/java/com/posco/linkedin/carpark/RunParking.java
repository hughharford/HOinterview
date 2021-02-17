package com.posco.linkedin.carpark;

import com.posco.linkedin.carpark.Vehicle;
import com.posco.linkedin.carpark.Vehicle.VehicleType;


public class RunParking {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CarPark cp = new CarPark(10, 1, 20, 2, 30, 3);
		cp.park(new Car(VehicleType.REGULAR));


		
	}

}
