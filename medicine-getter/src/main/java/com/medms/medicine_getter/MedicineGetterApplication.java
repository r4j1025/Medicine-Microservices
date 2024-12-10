package com.medms.medicine_getter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class MedicineGetterApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedicineGetterApplication.class, args);
	}

}
