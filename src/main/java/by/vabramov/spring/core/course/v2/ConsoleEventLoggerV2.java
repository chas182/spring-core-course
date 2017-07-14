package by.vabramov.spring.core.course.v2;

public class ConsoleEventLoggerV2 implements EventLoggerV2 {

    public void logEvent(String msg) {
        System.out.println(msg);
    }
}
