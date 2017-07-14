package by.vabramov.spring.core.course.v4;

public class ConsoleEventLogger implements EventLogger {

    public void logEvent(Event event) {
        System.out.println(event);
    }
}
