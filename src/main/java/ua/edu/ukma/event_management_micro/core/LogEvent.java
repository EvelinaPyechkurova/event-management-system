package ua.edu.ukma.event_management_micro.core;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class LogEvent extends ApplicationEvent {
    private final String logMessage;

    public LogEvent(Object source, String logMessage) {
        super(source);
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        this.logMessage = logMessage;
    }
}