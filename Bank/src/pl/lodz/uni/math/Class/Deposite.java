
package pl.lodz.uni.math.Class;

import java.util.Date;

/**
 *
 * @author Artur
 */
public class Deposite {
    private String description;
    private double amount;
    private Integer nummberPerAccount;
    private Date date;
    private double fromAccount;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Integer getNummberPerAccount() {
        return nummberPerAccount;
    }

    public void setNummberPerAccount(Integer nummberPerAccount) {
        this.nummberPerAccount = nummberPerAccount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(double fromAccount) {
        this.fromAccount = fromAccount;
    }

    public Deposite(String description, double amount, Integer nummberPerAccount, Date date, double fromAccount) {
        this.description = description;
        this.amount = amount;
        this.nummberPerAccount = nummberPerAccount;
        this.date = date;
        this.fromAccount = fromAccount;
    }
    
    
}
