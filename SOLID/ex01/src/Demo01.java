public class Demo01 {
    public static void main(String[] args) {
        PaymentProcessor payment = new SimplePaymentProcessor();
        Notifier notifier = new EmailNotifier();
        OrderService orderService = new OrderService(payment, notifier);
        orderService.checkout("a@shop.com", 100.0);
    }
}
