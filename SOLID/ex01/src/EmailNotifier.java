public class EmailNotifier implements Notifier {
    @Override
    public void notify(String email, String message) {
        System.out.println("Sent email to " + email + ": " + message);
    }
}
