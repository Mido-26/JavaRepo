package NotificationSystem;

public class PushNotification implements NotificationStrategy {
    @Override
    public void send(String message, String recipient) {
        // Logic to send a push notification
        System.out.println("Sending push notification to " + recipient + ": " + message);
    }
}
