package by.vabramov.spring.core.course.v2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    private Client client;
    private ConsoleEventLogger consoleEventLogger;

    public App(Client client, ConsoleEventLogger consoleEventLogger) {
        this.client = client;
        this.consoleEventLogger = consoleEventLogger;
    }

    public void logEvent(String msg) {
        String message = msg.replaceAll(client.getId(), client.getFullName());
        consoleEventLogger.logEvent(message);
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("springV2.xml");

        App app = context.getBean(App.class);
        app.logEvent("Hello, 1!!!");
        app.logEvent("1 created simple app.");
    }
}
