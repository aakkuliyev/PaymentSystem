import java.util.Date;

public abstract class Transactions {
    private Integer id;
    private Date date;
    private String type;
    private Double amountOfMoney;

    public Transactions() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getAmountOfMoney() {
        return amountOfMoney;
    }

    public void setAmountOfMoney(Double amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }

    @Override
    public String toString() {
        return "Transactions{" +
                "id=" + id +
                ", date=" + date +
                ", type='" + type + '\'' +
                ", amountOfMoney=" + amountOfMoney +
                '}';
    }
}
