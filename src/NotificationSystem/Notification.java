package NotificationSystem;

public class Notification {
    private NotificationStrategy strategy;
    private String message;
    private String recipient;

    public Notification(NotificationStrategy strategy, String message, String recipient) {
        this.strategy = strategy;
        this.message = message;
        this.recipient = recipient;
    }

    public void send() {
        strategy.send(message, recipient);
    }
}

