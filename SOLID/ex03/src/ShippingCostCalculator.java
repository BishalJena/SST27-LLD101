import java.util.HashMap;
import java.util.Map;

public class ShippingCostCalculator {
    private final Map<String, ShippingStrategy> strategies = new HashMap<>();

    public ShippingCostCalculator() {
        strategies.put("STANDARD", new StandardShipping());
        strategies.put("EXPRESS", new ExpressShipping());
        strategies.put("OVERNIGHT", new OvernightShipping());
    }

    public double cost(Shipment s) {
        ShippingStrategy strategy = strategies.get(s.type);
        if (strategy == null) throw new IllegalArgumentException("Unknown type: " + s.type);
        return strategy.calculate(s.weightKg);
    }
}

interface ShippingStrategy {
    double calculate(double weightKg);
}

class StandardShipping implements ShippingStrategy {
    @Override
    public double calculate(double weightKg) { return 50 + 5 * weightKg; }
}

class ExpressShipping implements ShippingStrategy {
    @Override
    public double calculate(double weightKg) { return 80 + 8 * weightKg; }
}

class OvernightShipping implements ShippingStrategy {
    @Override
    public double calculate(double weightKg) { return 120 + 10 * weightKg; }
}
