package ua.edu.ukma.event_management_micro.event;
import org.springframework.stereotype.Service;
import ua.edu.ukma.event_management_micro.building.BuildingManagement;
import ua.edu.ukma.event_management_micro.user.UserManagement;

@Service
public class EventManagement {

    private final UserManagement userManagement;
    private final BuildingManagement buildingManagement;

    public EventManagement(
            UserManagement userManagement,
            BuildingManagement buildingManagement
    ) {
        this.userManagement = userManagement;
        this.buildingManagement = buildingManagement;
    }

    public void call(){
        userManagement.call();
        buildingManagement.call();
        System.out.println("---> called event module API");
    }
}
