import java.util.Scanner;

public class CashPayment implements Payments {
    @Override
    public boolean processPayment(double amount) {
        boolean paymentSuccessful = false;
        double cashReceived = 0.0;

        // Количество денег которых он переводит наличными.
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount of cash received: ");
        cashReceived = scanner.nextDouble();

        if (cashReceived >= amount) {
            double change = cashReceived - amount;
            System.out.println("Payment successful.");
            System.out.printf("Amount paid: %.2f\n", amount);
            System.out.printf("Cash received: %.2f\n", cashReceived);
            System.out.printf("Change: %.2f\n", change);
            paymentSuccessful = true;
        } else {
            System.out.println("Insufficient cash received. Payment unsuccessful.");
        }

        return paymentSuccessful;
    }
}

