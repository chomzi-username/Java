
package pl.lodz.uni.math.Class;

import java.util.Date;


public class WireOut {
    private String description;
    private double amount;
    private Integer nummberPerClient;
    private Date date;
    private double toAccount;
    private String country;
    private Integer swift;
    private static WireOut wireOut=null;
    
    public static WireOut getInstance(){
        if(wireOut==null){
            wireOut = new WireOut();
        }
        return wireOut;
    }

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

    public Integer getNummberPerClient() {
        return nummberPerClient;
    }

    public void setNummberPerClient(Integer nummberPerClient) {
        this.nummberPerClient = nummberPerClient;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getToAccount() {
        return toAccount;
    }

    public void setToAccount(double toAccount) {
        this.toAccount = toAccount;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getSwift() {
        return swift;
    }

    public void setSwift(Integer swift) {
        this.swift = swift;
    }

    public WireOut(String description, double amount, Integer nummberPerClient, Date date, double toAccount, String country, Integer swift) {
        this.description = description;
        this.amount = amount;
        this.nummberPerClient = nummberPerClient;
        this.date = date;
        this.toAccount = toAccount;
        this.country = country;
        this.swift = swift;
    }

    @Override
    public String toString() {
        return "WireOut{" + "description=" + description + ", amount=" + amount + ", nummberPerClient=" + nummberPerClient + ", date=" + date + ", toAccount=" + toAccount + ", country=" + country + ", swift=" + swift + '}';
    }

    private WireOut() {
    }
    
    
}
