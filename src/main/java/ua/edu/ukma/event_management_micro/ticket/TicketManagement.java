package ua.edu.ukma.event_management_micro.ticket;

import org.springframework.stereotype.Service;
import ua.edu.ukma.event_management_micro.user.UserManagement;
import ua.edu.ukma.event_management_micro.event.EventManagement;


@Service
public class TicketManagement {

    private final UserManagement userManagement;
    private final EventManagement eventManagement;

    public TicketManagement(UserManagement userManagement, EventManagement eventManagement) {
        this.userManagement = userManagement;
        this.eventManagement = eventManagement;
    }

    public void call(){
        userManagement.call();
        eventManagement.call();
        System.out.println("---> called ticked module API");
    }
}
