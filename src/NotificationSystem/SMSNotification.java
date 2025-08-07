package NotificationSystem;

public class SMSNotification implements NotificationStrategy{
    @Override
    public void send(String message, String recipient) {
        System.out.println("Sending SMS to " + recipient + ": " + message);
    }
    
}
