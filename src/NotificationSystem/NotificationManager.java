package NotificationSystem;

import java.util.LinkedList;
import java.util.Queue;

public class NotificationManager {
    private Queue<Notification> notificationQueue;

    public NotificationManager() {
        notificationQueue = new LinkedList<>();
    }

    public void addNotification(Notification notification) {
        notificationQueue.offer(notification);
    }

    public void sendAll() {
        while (!notificationQueue.isEmpty()) {
            Notification notification = notificationQueue.poll();
            notification.send();
        }
    }
}

