public class WhatsAppSender extends NotificationSender {

    public WhatsAppSender(AuditLog audit) {
        super(audit);
    }

    @Override
    protected void doSend(Notification n) {

        String phone = n.phone == null ? "" : n.phone;

        // Instead of throwing, normalize phone safely
        if (!phone.startsWith("+")) {
            phone = "+" + phone;
        }

        System.out.println("WA -> to=" + phone + " body=" + n.body);
        audit.add("wa sent");
    }
}