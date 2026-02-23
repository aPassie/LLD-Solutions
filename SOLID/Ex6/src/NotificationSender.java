public interface NotificationSender {
    void send(Notification n, AuditLog audit);
}
