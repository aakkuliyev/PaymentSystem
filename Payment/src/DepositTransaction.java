import java.util.Date;

public class DepositTransaction extends Transactions {
    public DepositTransaction(Integer id, Date date, Double amountOfMoney) {
        setId(id);
        setDate(new Date());
        setType("Deposit");
        setAmountOfMoney(amountOfMoney);
    }
}
