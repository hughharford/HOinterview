package com.posco;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RunApp_justAThought {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    SpringApplication.run(RunApp_justAThought.class, args);
		System.out.println("*****************************\n");

		System.out.println(""
				+ ""
				+ "____                    ____                  \n"
				+ "|   |                  |    |                 \n"
				+ "|    |         ___     |    |  __    __       \n"
				+ "|___|  |   |  |   |    |----| |  |  |  |    \n"
				+ "|   |  |   |  |   |    |    | |   | |   |   \n"
				+ "|    |  |_|   |   |    |    | |__|  |__|    \n"
				+ "                              |      |      \n"
				+ "                              |      |      \n"
				+ "run it, run it, run it! \n\n"
				);

		
		int myInt = 45;
		System.out.println("myInt " + myInt + 
				", in binary: " + Integer.toString(myInt,2));
		System.out.println("myInt \n\n");
	
	
	
	}

}
