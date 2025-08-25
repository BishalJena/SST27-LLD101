public class OrderService {
    private final PaymentProcessor paymentProcessor;
    private final Notifier notifier;

    public OrderService(PaymentProcessor paymentProcessor, Notifier notifier) {
        this.paymentProcessor = paymentProcessor;
        this.notifier = notifier;
    }

    public void checkout(String email, double amount) {
        paymentProcessor.process(amount);
        notifier.notify(email, "Order placed for amount: " + amount);
    }
}