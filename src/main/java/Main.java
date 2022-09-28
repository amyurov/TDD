import java.util.Scanner;

public class Main {

    private static final int MONTH_OF_THE_YEAR = 12;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Введите сумму кредитования");
                int creditAmount = Integer.parseInt(scan.nextLine());
                System.out.println("Введите период кредитования\n" +
                        "1 - 12 мес.\n" +
                        "2 - 24 мес.\n" +
                        "3 - 36 мес.");
                int period = Integer.parseInt(scan.nextLine());

                if (period > 3) {
                    System.out.println("Введите один из предложеных вариантов");
                    continue;
                }

                int totalMonth = period * MONTH_OF_THE_YEAR;

                CreditCalculatorImpl calculator = new CreditCalculatorImpl(12, totalMonth, creditAmount);

                calculator.totalAmount();
                OUT:
                while (true) {
                    System.out.println("Кредит под 12% одобрен. Выберете действие:\n" +
                            "1 - Отобразить полную сумму\n" +
                            "2 - Отобразить ежемесячный платеж\n" +
                            "3 - Отобразить сумму переплаты\n" +
                            "Для завершения введите end");

                    String in = scan.nextLine();

                    switch (in) {
                        case "1":
                            System.out.println("Полная сумма " + calculator.totalAmount());
                            break;
                        case "2":
                            System.out.println("Ежемесячный платеж составляет: " + calculator.perMonth(calculator.totalAmount()));
                            break;
                        case "3":
                            System.out.println("Сумма переплаты: " + calculator.overpayment(calculator.totalAmount()));
                            break;
                        case "end":
                            break OUT;
                        default:
                            System.out.println("Неверный ввод");
                    }
                }
            } catch (NumberFormatException ex) {
                System.out.println("Требуется ввести число");
            }


        }
    }
}
