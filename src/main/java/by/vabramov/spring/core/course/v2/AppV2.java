package by.vabramov.spring.core.course.v2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppV2 {

    private ClientV2 clientV2;
    private ConsoleEventLoggerV2 consoleEventLoggerV2;

    public AppV2(ClientV2 clientV1, ConsoleEventLoggerV2 consoleEventLoggerV2) {
        this.clientV2 = clientV1;
        this.consoleEventLoggerV2 = consoleEventLoggerV2;
    }

    public void logEvent(String msg) {
        String message = msg.replaceAll(clientV2.getId(), clientV2.getFullName());
        consoleEventLoggerV2.logEvent(message);
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("springV2.xml");

        AppV2 app = context.getBean(AppV2.class);
        app.logEvent("Hello, 1!!!");
        app.logEvent("1 created simple app.");
    }
}
