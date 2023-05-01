import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.Date;

public class PaymentManagement {
    private HashMap<Integer, UserAccount> accounts;
    private TreeSet<Transactions> transactions;
    private Date date;

    public PaymentManagement() {
        accounts = new HashMap<>();
        transactions = new TreeSet<>(Comparator.comparing(Transactions::getDate));
    }

    public boolean addUserAccount(UserAccount userAccount) {
        if (!accounts.containsKey(userAccount.getId())) {
            accounts.put(userAccount.getId(), userAccount);
            return true;
        }
        return false;
    }

    public void logTransaction(UserAccount userAccount, Transactions transaction) {
        transactions.add(transaction);
        userAccount.getTransactionsHistory().add(transaction);
        writeTransactionToFile(transaction);
    }

    private void writeTransactionToFile(Transactions transaction) {
        try (FileWriter writer = new FileWriter("transactions.txt", true)) {
            writer.write(transaction.toString() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Transactions> getUserTransactions(Integer userId) {
        UserAccount userAccount = accounts.get(userId);
        if (userAccount != null) {
            return userAccount.getTransactionsHistory();
        }
        return Collections.emptyList();
    }

    public boolean processExternalPayment(Integer userId, Double amount, Payments paymentType) {
        UserAccount userAccount = accounts.get(userId);
        if (userAccount != null && paymentType.processPayment(amount)) {
            userAccount.setBalance(userAccount.getBalance() + amount);
            logTransaction(new UserAccount(userAccount.getId(), userAccount.getName(),
                    userAccount.getSurname(),userAccount.getBalance(), userAccount.getPaymentType()
            ), new DepositTransaction(userId, date, amount ));
            printPaymentStatement(amount, paymentType);
            return true;
        }
        return false;
    }

    public boolean processWithdrawalPayment(Integer userId, Double amount, Payments paymentType) {
        UserAccount userAccount = accounts.get(userId);
        if (userAccount != null && paymentType.processPayment(amount)) {
            userAccount.setBalance(userAccount.getBalance() - amount);
            logTransaction(new UserAccount(userAccount.getId(), userAccount.getName(),
                    userAccount.getSurname(),userAccount.getBalance(), userAccount.getPaymentType()
            ), new WithdrawalTransaction(userId, date, amount ));
            printPaymentStatement(amount, paymentType);
            return true;
        }
        return false;
    }



    private void printPaymentStatement(Double amount, Payments paymentType) {
        System.out.println("Payment statement: " + amount + " processed by " + paymentType.getClass().getSimpleName());
    }

    public boolean isValidTransaction(Integer userId, Transactions transaction) {
        UserAccount userAccount = accounts.get(userId);
        if (userAccount != null) {
            Double balance = userAccount.getBalance();
            if (transaction.getAmountOfMoney() <= balance) {
                return true;
            } else {
                System.out.println("Insufficient funds!");
            }
        } else {
            System.out.println("Invalid user id!");
        }
        return false;
    }


    public List<UserAccount> getUsers() {
        return new ArrayList<>(accounts.values());
    }

    public void printUserDetails(Integer userId) {
        UserAccount userAccount = accounts.get(userId);
        if (userAccount != null) {
            System.out.println(userAccount.toString());
        } else {
            System.out.println("User not found.");
        }
    }
}


