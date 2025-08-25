
import java.util.HashMap;
import java.util.Map;

public class PaymentService {
    private final Map<String, PaymentProvider> providers = new HashMap<>();

    public PaymentService() {
        providers.put("CARD", new CardProvider());
        providers.put("UPI", new UpiProvider());
        providers.put("WALLET", new WalletProvider());
    }

    public String pay(Payment p) {
        PaymentProvider provider = providers.get(p.provider);
        if (provider == null) throw new RuntimeException("No provider");
        return provider.pay(p.amount);
    }
}

interface PaymentProvider {
    String pay(double amount);
}

class CardProvider implements PaymentProvider {
    @Override
    public String pay(double amount) { return "Charged card: " + amount; }
}

class UpiProvider implements PaymentProvider {
    @Override
    public String pay(double amount) { return "Paid via UPI: " + amount; }
}

class WalletProvider implements PaymentProvider {
    @Override
    public String pay(double amount) { return "Wallet debit: " + amount; }
}