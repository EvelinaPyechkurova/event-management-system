package ua.edu.ukma.event_management_micro.event;

import org.springframework.modulith.ApplicationModule;

@ApplicationModule (allowedDependencies = {
        "building::api",
        "user"
})
public class EventModule {
}
