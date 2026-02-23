public class Main {
    public static void main(String[] args) {
        System.out.println("=== Notification Demo ===");
        AuditLog audit = new AuditLog();

        Notification n = new Notification("Welcome", "Hello and welcome to SST!", "riya@sst.edu", "9876543210");

        NotificationSender email = new EmailSender();
        NotificationSender sms = new SmsSender();
        NotificationSender wa = new WhatsAppSender();

        // no try-catch needed anymore, all senders follow the same contract
        email.send(n, audit);
        sms.send(n, audit);
        wa.send(n, audit);

        System.out.println("AUDIT entries=" + audit.size());
    }
}
