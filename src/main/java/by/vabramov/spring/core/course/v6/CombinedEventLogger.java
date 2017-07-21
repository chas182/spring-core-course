package by.vabramov.spring.core.course.v6;

import java.util.List;

public class CombinedEventLogger implements EventLogger {

    private List<EventLogger> eventLoggers;

    public CombinedEventLogger(List<EventLogger> eventLoggers) {
        this.eventLoggers = eventLoggers;
    }

    @Override
    public void logEvent(Event event) {
        if (event.getEventType() == null) {
            eventLoggers.stream()
                    .filter(eventLogger -> eventLogger instanceof CacheFileEventLogger)
                    .forEach(eventLogger -> eventLogger.logEvent(event));
            return;
        }
        switch (event.getEventType()) {
            case INFO:
                eventLoggers.stream()
                        .filter(eventLogger -> eventLogger instanceof ConsoleEventLogger)
                        .forEach(eventLogger -> eventLogger.logEvent(event));
                break;
            case ERROR:
                eventLoggers.forEach(eventLogger -> eventLogger.logEvent(event));
                break;
        }
    }

    protected void init() {
        if (eventLoggers == null) {
            throw new IllegalArgumentException("Loggers list must be not null");
        }
    }
}
