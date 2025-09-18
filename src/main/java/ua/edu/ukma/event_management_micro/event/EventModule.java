package ua.edu.ukma.event_management_micro.event;

import org.springframework.modulith.ApplicationModule;
import org.springframework.modulith.NamedInterface;

@ApplicationModule (allowedDependencies = {
        "building::api",
        "user::api"
})
@NamedInterface("api")
public class EventModule {
}
