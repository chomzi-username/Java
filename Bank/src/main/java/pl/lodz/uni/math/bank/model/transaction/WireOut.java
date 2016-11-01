package pl.lodz.uni.math.bank.model.transaction;

import pl.lodz.uni.math.bank.constant.TransactionType;
import java.util.Date;

public class WireOut implements Transaction{
	private String id;

    private String country;

    private String swift;

    private String fromAccount;

    private String toAccount;

    private Double amount;

    private Date date;

    private String description;

    private TransactionType type = TransactionType.WIREOUT;

    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSwift() {
        return swift;
    }

    public void setSwift(String swift) {
        this.swift = swift;
    }

    public String getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(String fromAccount) {
        this.fromAccount = fromAccount;
    }

    public String getToAccount() {
        return toAccount;
    }

    public void setToAccount(String toAccount) {
        this.toAccount = toAccount;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TransactionType getType() {
        return type;
    }

    public String getInfo() {
        return toString();
    }

	@Override
	public String toString() {
		return "WireOut [id=" + id + ", country=" + country + ", swift=" + swift + ", fromAccount=" + fromAccount
				+ ", toAccount=" + toAccount + ", amount=" + amount + ", date=" + date + ", description=" + description
				+ ", type=" + type + "]";
	}
    
    

}
