package ua.edu.ukma.event_management_micro;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;

class ModulithDocumentationTest {

    @Test
    void writeModuleDocumentation() {
        // in-memory representation of the application module arrangement derived from the codebase
        // verify whether our code arrangement adheres to the intended constraints
        ApplicationModules modules = ApplicationModules.of(EventManagementMicroApplication.class).verify();
        new Documenter(modules).writeDocumentation();
    }
}