package ua.edu.ukma.event_management_micro.building;

import org.springframework.stereotype.Service;

@Service
public class BuildingManagement {

    public void call(){
        System.out.println("-> called building module API");
    }
}
