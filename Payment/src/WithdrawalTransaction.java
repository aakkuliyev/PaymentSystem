import java.util.Date;

public class WithdrawalTransaction extends Transactions {
    public WithdrawalTransaction(Integer id, Date date, Double amountOfMoney) {
        setId(id);
        setDate(new Date());
        setType("Withdrawal");
        setAmountOfMoney(amountOfMoney);
    }
}

