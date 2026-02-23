public class WhatsAppSender implements NotificationSender {

    @Override
    public void send(Notification n, AuditLog audit) {
        // fixed: accept any phone number without throwing, just like other senders
        System.out.println("WA -> to=" + n.phone + " body=" + n.body);
        audit.add("wa sent");
    }
}
