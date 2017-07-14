package by.vabramov.spring.core.course.v4;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    private Client client;
    private ConsoleEventLogger consoleEventLogger;

    public App(Client client, ConsoleEventLogger consoleEventLogger) {
        this.client = client;
        this.consoleEventLogger = consoleEventLogger;
    }

    public void logEvent(Event event) {
        event.setMsg(client.getFullName() + " checked this event");
        consoleEventLogger.logEvent(event);
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("springV4.xml");

        App app = context.getBean(App.class);
        Event event = context.getBean(Event.class);
        CacheFileEventLogger cacheFileEventLogger = context.getBean(CacheFileEventLogger.class);
        cacheFileEventLogger.logEvent(event);

        event = context.getBean(Event.class);
        cacheFileEventLogger.logEvent(event);
        event = context.getBean(Event.class);
        cacheFileEventLogger.logEvent(event);
        event = context.getBean(Event.class);
        cacheFileEventLogger.logEvent(event);
        event = context.getBean(Event.class);
        cacheFileEventLogger.logEvent(event);
        event = context.getBean(Event.class);
        cacheFileEventLogger.logEvent(event);

        context.close();
    }
}
