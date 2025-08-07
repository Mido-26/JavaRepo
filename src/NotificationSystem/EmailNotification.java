package NotificationSystem;

public class EmailNotification implements NotificationStrategy {
    @Override
    public void send(String message, String recipient) {
        // Logic to send an email notification
        System.out.println("Sending email to " + recipient + ": " + message);
    }
    
}
