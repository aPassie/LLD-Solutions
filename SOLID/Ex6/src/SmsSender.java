public class SmsSender implements NotificationSender {

    @Override
    public void send(Notification n, AuditLog audit) {
        // sms only uses phone + body which is fine - that's the nature of sms
        System.out.println("SMS -> to=" + n.phone + " body=" + n.body);
        audit.add("sms sent");
    }
}
