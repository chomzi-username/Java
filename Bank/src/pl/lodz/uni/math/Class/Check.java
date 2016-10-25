
package pl.lodz.uni.math.Class;

import java.util.Date;
import org.apache.log4j.Logger;


public class Check  {
    private String description;
    private double amount;
    private Integer nummberPerAccount;
    private Date date;
    private double toAccount;
    private static Check check=null;
    
    public static Check getInstance(){
        if(check==null){
            check = new Check();
        }
        return check;
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


    public double getToAccount() {
        return toAccount;
    }

    public void setToAccount(double toAccount) {
        this.toAccount = toAccount;
    }
    //private static final Logger LOG = Logger.getLogger(Check.class.getName());

    private Check() {
    }

    public Check(String description, double amount, Integer nummberPerAccount, Date date, double toAccount) {
        this.description = description;
        this.amount = amount;
        this.nummberPerAccount = nummberPerAccount;
        this.date = date;
        this.toAccount = toAccount;
    }

    @Override
    public String toString() {
        return "Check{" + "description=" + description + ", amount=" + amount + ", nummberPerAccount=" + nummberPerAccount + ", date=" + date + ", toAccount=" + toAccount + '}';
    }
      
//    public Check getCheckByID(int id){
//        return new Check("NUMER PRZELEWU",100);
//    }
    
    
}
