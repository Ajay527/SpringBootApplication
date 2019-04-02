package com.data;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
public class CarResource
{
	@GetMapping("hello")
	public CarObject getCar() throws JsonProcessingException
	{
		Car car=new Car();
		car.setManufacturer("Germany");
		car.setName("BMW");
		CarObject carObject = new CarObject();
		carObject.setCar(car);
		return carObject;
		
	}

}
