package by.vabramov.spring.core.course.v3;

import org.springframework.context.ApplicationContext;
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
        ApplicationContext context = new ClassPathXmlApplicationContext("springV3.xml");

        App app = context.getBean(App.class);
        Event event = context.getBean(Event.class);
        app.logEvent(event);

        event = context.getBean(Event.class);
        app.logEvent(event);
    }
}
