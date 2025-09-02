package com.deliverytech.delivery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.deliverytech.delivery.component.DataLoader;

@SpringBootApplication
public class DeliveryApiApplication {

	public static void main(String[] args) {
		//executar o dataloader aki
		//DataLoader dataLoader = new DataLoader();
		//dataLoader.run(args);
		SpringApplication.run(DeliveryApiApplication.class, args);
	}

}
