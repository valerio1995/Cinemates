package mvp;

import java.util.List;

public interface NotificationDAO {
    void saveNotification(Notification notification);
    List<Notification> getRequestNotifications(String senderUsername);
    List<Notification> getNotifications(String receiverUsername);
    void updateNotification(Notification notification);
}
