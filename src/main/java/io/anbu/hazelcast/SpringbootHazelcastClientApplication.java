package io.anbu.hazelcast;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import io.anbu.hazelcast.domain.Location;
import io.anbu.hazelcast.domain.LocationRepository;

@SpringBootApplication
public class SpringbootHazelcastClientApplication {
	
	@Autowired
	LocationRepository locationRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootHazelcastClientApplication.class, args);
	}
	
	@EventListener(ApplicationReadyEvent.class)
	public void ready() { 
		
		Location location = new Location();
		location.setId("1");
		location.setName("Test Name");
		location.setDescription("Test Description");

		locationRepository.save(location);
		locationRepository.findAll().forEach(System.out::println);
	}
}
