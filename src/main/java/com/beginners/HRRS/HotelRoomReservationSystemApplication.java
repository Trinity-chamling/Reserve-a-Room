package com.beginners.HRRS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})

@SpringBootApplication

public class HotelRoomReservationSystemApplication {

	public static void main(String[] args)

	{
		SpringApplication.run(HotelRoomReservationSystemApplication.class, args);
	}
}
