package by.vabramov.spring.core.course.v6;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    private Client client;
    private EventLogger eventLogger;

    public App(Client client, EventLogger eventLogger) {
        this.client = client;
        this.eventLogger = eventLogger;
    }

    public void logEvent(Event event) {
        event.setMsg(client.getFullName() + " checked this event");
        eventLogger.logEvent(event);
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("springV6.xml");

        App app = context.getBean(App.class);
        Event event = context.getBean(Event.class);
        event.setEventType(EventType.ERROR);
        app.logEvent(event);

        event = context.getBean(Event.class);
        event.setEventType(EventType.INFO);
        app.logEvent(event);
        event = context.getBean(Event.class);
        event.setEventType(EventType.INFO);
        app.logEvent(event);
        event = context.getBean(Event.class);
        event.setEventType(EventType.ERROR);
        app.logEvent(event);
        event = context.getBean(Event.class);
        app.logEvent(event);
        event = context.getBean(Event.class);
        app.logEvent(event);

        context.close();
    }
}
