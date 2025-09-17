package ua.edu.ukma.event_management_micro.user;

import org.springframework.stereotype.Service;

@Service
public class UserManagement {
    public void call(){
        System.out.println("-> called user module API");
    }
}
