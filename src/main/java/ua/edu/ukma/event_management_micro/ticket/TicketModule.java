package ua.edu.ukma.event_management_micro.ticket;

import org.springframework.modulith.ApplicationModule;

@ApplicationModule(allowedDependencies = {
        "event::api"
})
public class TicketModule {
}
