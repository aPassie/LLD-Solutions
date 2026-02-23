public class EmailSender implements NotificationSender {

    @Override
    public void send(Notification n, AuditLog audit) {
        // fixed: send full body without truncating
        System.out.println("EMAIL -> to=" + n.email + " subject=" + n.subject + " body=" + n.body);
        audit.add("email sent");
    }
}
