import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int choice = -1;
        PaymentManagement paymentManagement = new PaymentManagement();

        Payments creditCardPayment = new CreditCardPayment();
        Payments cashPayment = new CashPayment();

        // Создание дефолтного аккаунта
        UserAccount john = new UserAccount(1, "John", "Doe", 1000.0, cashPayment);
        UserAccount jane = new UserAccount(2, "Jane", "Smith", 500.0, creditCardPayment);

        // добавим их в базу
        paymentManagement.addUserAccount(john);
        paymentManagement.addUserAccount(jane);

        while (choice != 0) {
            System.out.println("Welcome to the Payment Management System");
            System.out.println("1. Add a unique user account");
            System.out.println("2. Deposit Payment");
            System.out.println("3. Withdrawal Payment");
            System.out.println("4. Transfer money to receiver");
            System.out.println("5. Get info about user");
            System.out.println("6. Get transaction info about user");
            System.out.println("7. Get info about all user");
            System.out.println("0. Exit");

            choice = in.nextInt();
            Scanner sc = new Scanner(System.in);
            switch (choice) {
                case 1:
                    //Создание своего аккаунта
                    System.out.println("UserId for accounting:");
                    int userId = sc.nextInt();
                    System.out.println("Name:");
                    String userName = sc.next();
                    System.out.println("Surname:");
                    String userSurname = sc.next();
                    System.out.println("Balance:");
                    double userBalance = sc.nextDouble();
                    System.out.println("PaymentType: cash/creditCard");
                    String userPaymentType = sc.next();
                    if (userPaymentType.equals("cash")) {
                        UserAccount user = new UserAccount(userId, userName, userSurname, userBalance, cashPayment);
                        paymentManagement.addUserAccount(user);
                    } else if (userPaymentType.equals("creditCard")) {
                        UserAccount user = new UserAccount(userId, userName, userSurname, userBalance, creditCardPayment);
                        paymentManagement.addUserAccount(user);
                    }
                case 2:
                    System.out.println("Process of External Payment");
                    paymentManagement.processExternalPayment(1, 250.0, creditCardPayment);
                    paymentManagement.processExternalPayment(2, 150.0, cashPayment);

                    System.out.println("UserId for deposit payment:");
                    int userId_forExternalPayment = sc.nextInt();
                    System.out.println("Amount of Money:");
                    double amount_forExternalPayment = sc.nextDouble();
                    System.out.println("PaymentType: cash/creditCard");
                    String userPaymentType_forExternalPayment = sc.next();
                    if (userPaymentType_forExternalPayment.equals("cash")) {
                        paymentManagement.processExternalPayment(userId_forExternalPayment, amount_forExternalPayment, cashPayment);
                    } else if (userPaymentType_forExternalPayment.equals("creditCard")) {
                        paymentManagement.processExternalPayment(userId_forExternalPayment, amount_forExternalPayment, creditCardPayment);
                    } else System.out.println("You're input an incorrect type of payment!");
                case 3:
                    System.out.println("Process of Internal Payment");

                    paymentManagement.processExternalPayment(2, 56.0, creditCardPayment);
                    paymentManagement.processExternalPayment(1, 51.0, cashPayment);

                    System.out.println("UserId for withdrawal payment:");
                    int userId_forWithdrawalPayment = sc.nextInt();
                    System.out.println("Amount of Money:");
                    double amount_forWithdrawalPayment = sc.nextDouble();
                    System.out.println("PaymentType: cash/creditCard");
                    String userPaymentType_forWithdrawalPayment = sc.next();
                    if (userPaymentType_forWithdrawalPayment.equals("cash")) {
                        paymentManagement.processWithdrawalPayment(userId_forWithdrawalPayment, amount_forWithdrawalPayment, cashPayment);
                    } else if (userPaymentType_forWithdrawalPayment.equals("creditCard")) {
                        paymentManagement.processWithdrawalPayment(userId_forWithdrawalPayment, amount_forWithdrawalPayment, creditCardPayment);
                    } else System.out.println("You're input an incorrect type of payment!");
                case 4:
                    System.out.println("Transferring money from John to Jane:");
                    double transferAmount = 100.0;
                    if (paymentManagement.isValidTransaction(1, new TransferTransaction(1, transferAmount, 2))) {
                        john.setBalance(john.getBalance() - transferAmount);
                        jane.setBalance(jane.getBalance() + transferAmount);
                        paymentManagement.logTransaction(john, new TransferTransaction(1, transferAmount, jane.getId()));
                        paymentManagement.logTransaction(jane, new TransferTransaction(2, transferAmount, john.getId()));
                    }
                case 5:
                    System.out.println("UserId for getting info:");
                    int userId_forGettingInfo = sc.nextInt();
                    paymentManagement.printUserDetails(userId_forGettingInfo);
                case 6:
                    System.out.println("UserId for getting transaction history:");
                    int userId_forGettingTransactionHistory = sc.nextInt();
                    System.out.println("Transaction history for user:");
                    List<Transactions> userTransactions = paymentManagement.getUserTransactions(userId_forGettingTransactionHistory);
                    for (Transactions transaction : userTransactions) {
                        System.out.println(transaction.toString());
                    }
                case 7:
                    paymentManagement.getUsers();
                case 0:
                    break;
            }
        }
    }
}
