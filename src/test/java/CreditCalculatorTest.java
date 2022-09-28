import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class CreditCalculatorTest {

   static final Double RATE = 1.12;
    static final int TOTAL_MONTH = 36;
    static final int CREDIT_AMOUNT = 250_000;

   static final Double EXPECTED_TOTAL = 351232.0;
   static final Double EXPECTED_MONTHLY_PAYMENT = 9756.0;
   static final Double EXPECTED_OVERPAYMENT = 101232.0;


    CreditCalculator creditCalculator = null;

    @Test
    @DisplayName("Тест рассчета полной суммы выплаты")
    public void totalSummTest() {
        Double actualTotal = creditCalculator.totalAmount(RATE, TOTAL_MONTH, CREDIT_AMOUNT);
        Double expectedTotal = 351232.0;

        Assert.assertEquals(expectedTotal, actualTotal);
    }

    @Test
    @DisplayName("Тест расчета ежемесячного платежа")
    public void perMonthTest() {

        Double actualMonthlyPayment = creditCalculator.perMonth(EXPECTED_TOTAL, TOTAL_MONTH);

        Assert.assertNotNull(actualMonthlyPayment);
        Assert.assertEquals(EXPECTED_MONTHLY_PAYMENT, actualMonthlyPayment);
    }

    @Test
    @DisplayName("Тест рассчета суммы переплаты")
    public void overpaymentTest() {

        Double actualOverpayment = creditCalculator.overpayment(EXPECTED_TOTAL, CREDIT_AMOUNT);

        Assert.assertEquals(EXPECTED_OVERPAYMENT, actualOverpayment);
    }
}
