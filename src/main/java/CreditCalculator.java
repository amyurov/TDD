public interface CreditCalculator {
    Double totalAmount();
    Double perMonth(double total);
    Double overpayment(double total);
}
