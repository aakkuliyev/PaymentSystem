import java.util.Scanner;

public class CreditCardPayment implements Payments {
    private String cardNumber;
    private String cardHolderName;
    private String expirationDate;
    private String securityCode;

    public CreditCardPayment() {
    }

    public CreditCardPayment(String cardNumber, String cardHolderName, String expirationDate, String securityCode) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.expirationDate = expirationDate;
        this.securityCode = securityCode;
    }

    @Override
    public boolean processPayment(double amount) {
        boolean paymentSuccessful = false;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the credit card details:");
        System.out.print("Card number: ");
        String enteredCardNumber = scanner.nextLine();
        System.out.print("Card holder name: ");
        String enteredCardHolderName = scanner.nextLine();
        System.out.print("Expiration date (MM/YY): ");
        String enteredExpirationDate = scanner.nextLine();
        System.out.print("Security code: ");
        String enteredSecurityCode = scanner.nextLine();

        if (enteredCardNumber.equals(cardNumber) &&
                enteredCardHolderName.equals(cardHolderName) &&
                enteredExpirationDate.equals(expirationDate) &&
                enteredSecurityCode.equals(securityCode)) {
            System.out.println("Payment successful.");
            paymentSuccessful = true;
        } else {
            System.out.println("Invalid credit card details. Payment unsuccessful.");
        }

        return paymentSuccessful;
    }
}

