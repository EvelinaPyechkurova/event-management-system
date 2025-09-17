package ua.edu.ukma.event_management_micro; // application module package

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.modulith.Modulith;

import ua.edu.ukma.event_management_micro.building.BuildingManagement;
import ua.edu.ukma.event_management_micro.user.UserManagement;
import ua.edu.ukma.event_management_micro.ticket.TicketManagement;
import ua.edu.ukma.event_management_micro.event.EventManagement;


@Modulith(sharedModules = "core")
@SpringBootApplication
public class EventManagementMicroApplication implements CommandLineRunner {
	private final BuildingManagement buildingManagement;
	private final UserManagement userManagement;
	private final EventManagement eventManagement;
	private final TicketManagement ticketManagement;

	public EventManagementMicroApplication(
			BuildingManagement buildingManagement,
			UserManagement userManagement,
			TicketManagement ticketManagement,
			EventManagement eventManagement) {
		this.buildingManagement = buildingManagement;
		this.userManagement = new UserManagement();
		this.eventManagement = eventManagement;
		this.ticketManagement = ticketManagement;
	}

	public static void main(String[] args) {
		SpringApplication.run(EventManagementMicroApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		callAPI();
	}

	private void callAPI() {
		System.out.println("CALLING BUILDING API");
		buildingManagement.call();
		System.out.print("\n\nCALLING USER API\n");
		userManagement.call();
		System.out.print("\n\nCALLING EVENT API\n");
		eventManagement.call();
		System.out.print("\n\nCALLING TICKET API\n");
		ticketManagement.call();
	}
}
