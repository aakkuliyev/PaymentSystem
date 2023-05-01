import java.util.Date;

public class TransferTransaction extends Transactions {
    private Integer recipientId;

    public TransferTransaction(Integer id, Double amountOfMoney, Integer recipientId) {
        setId(id);
        setDate(new Date());
        setType("Transfer");
        setAmountOfMoney(amountOfMoney);
        this.recipientId = recipientId;
    }

    @Override
    public String toString() {
        return "TransferTransaction{" +
                "id=" + getId() +
                ", date=" + getDate() +
                ", type='" + getType() + '\'' +
                ", amountOfMoney=" + getAmountOfMoney() +
                ", recipientId=" + recipientId +
                '}';
    }
}

