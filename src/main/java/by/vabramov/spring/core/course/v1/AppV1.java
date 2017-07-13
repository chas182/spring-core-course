package by.vabramov.spring.core.course.v1;

public class AppV1 {

    private ClientV1 clientV1;
    private ConsoleEventLoggerV1 consoleEventLogger;

    public void logEvent(String msg) {
        String message = msg.replaceAll(clientV1.getId(), clientV1.getFullName());
        consoleEventLogger.logEvent(message);
    }

    public static void main(String[] args) {
        AppV1 appV1 = new AppV1();

        appV1.clientV1 = new ClientV1("1", "John Smith");
        appV1.consoleEventLogger = new ConsoleEventLoggerV1();

        appV1.logEvent("Hello, 1!!!");
    }
}
