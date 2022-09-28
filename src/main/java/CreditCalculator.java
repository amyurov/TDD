public interface CreditCalculator {
    Double totalAmount(double rate, int totalMonth, int creditAmount);
    Double perMonth(double total, int totalMonth);
    Double overpayment(double total, int creditAmount);
}
