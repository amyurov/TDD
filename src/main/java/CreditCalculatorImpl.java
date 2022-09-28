public class CreditCalculatorImpl implements CreditCalculator {

    private final double rate;
    private final int totalMonth;
    private final int creditAmount;

    public CreditCalculatorImpl(double rate, int totalMonth, int creditAmount) {
        this.rate = 1 + rate / 100;
        this.totalMonth = totalMonth;
        this.creditAmount = creditAmount;
    }

    @Override
    public Double totalAmount() {
        int exponent = totalMonth/12;
        double coefficient = Math.pow(rate, exponent);
        double total = coefficient * creditAmount;
        System.out.println("111 " + total);
        return (double) Math.round(total);
    }

    @Override
    public Double perMonth(double total) {
        return (double) Math.round(total / totalMonth);
    }

    @Override
    public Double overpayment(double total) {
        return total - creditAmount;
    }

    public double getRate() {
        return rate;
    }

    public int getTotalMonth() {
        return totalMonth;
    }

    public int getCreditAmount() {
        return creditAmount;
    }
}
