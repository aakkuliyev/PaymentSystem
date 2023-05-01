import java.util.ArrayList;

public class UserAccount {
    private Integer id;
    private String name;
    private String surname;
    private Double balance;
    private Payments paymentType;
    private ArrayList<Transactions> transactionsHistory;

    public UserAccount(Integer id, String name, String surname, Double balance, Payments paymentType) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.balance = balance;
        this.paymentType = paymentType;
        this.transactionsHistory = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Payments getPaymentType() {
        return paymentType;
    }

    public ArrayList<Transactions> getTransactionsHistory() {
        return transactionsHistory;
    }


    @Override
    public String toString() {
        return "UserAccount{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", balance=" + balance +
                ", paymentType=" + paymentType +
                ", transactionsHistory=" + transactionsHistory +
                '}';
    }
}

