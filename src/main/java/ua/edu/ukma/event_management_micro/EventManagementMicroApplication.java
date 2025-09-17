package ua.edu.ukma.event_management_micro; // application module package

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.modulith.Modulith;

@Modulith(sharedModules = "core")
@SpringBootApplication
public class EventManagementMicroApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventManagementMicroApplication.class, args);
	}

}
