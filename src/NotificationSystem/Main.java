package NotificationSystem;

public class Main {
    public static void main(String[] args) {
        NotificationManager manager = new NotificationManager();

        manager.addNotification(new Notification(new EmailNotification(), "Welcome!", "user@example.com"));
        manager.addNotification(new Notification(new SMSNotification(), "Your code is 1234", "+255712345678"));
        manager.addNotification(new Notification(new PushNotification(), "New offer available", "user123"));

        manager.sendAll();
    }
}

