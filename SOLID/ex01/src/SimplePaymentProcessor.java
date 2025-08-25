public class SimplePaymentProcessor implements PaymentProcessor {
    @Override
    public void process(double amount) {
        System.out.println("Processed payment of $" + amount);
    }
}
