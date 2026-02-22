public class DefaultDiscountPolicy implements DiscountPolicy {
    public double discountAmount(String customerType, double subtotal, int distinctLines) {
        return DiscountRules.discountAmount(customerType, subtotal, distinctLines);
    }
}