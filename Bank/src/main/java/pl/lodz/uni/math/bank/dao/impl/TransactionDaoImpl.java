package pl.lodz.uni.math.bank.dao.impl;

import pl.lodz.uni.math.bank.dao.TransactionDao;
import java.util.*;
import org.apache.log4j.*;
import pl.lodz.uni.math.bank.model.Account;
import pl.lodz.uni.math.bank.model.transaction.Check;
import pl.lodz.uni.math.bank.model.transaction.Deposit;
import pl.lodz.uni.math.bank.model.transaction.Transaction;
import pl.lodz.uni.math.bank.model.transaction.WireOut;

public class TransactionDaoImpl implements TransactionDao {
	private static Logger logger = LogManager.getLogger(TransactionDaoImpl.class);

    private static TransactionDao instance = null;

    private List<Transaction> transactions;

    public TransactionDaoImpl() {
        transactions = new ArrayList<Transaction>();
    }

    public static TransactionDao getInstance() {
        if (instance == null) {
            instance = new TransactionDaoImpl();
        }
        return instance;
    }

    public Transaction create(Transaction transaction) {
    	try{
    		transactions.add(transaction);
    		
    	}catch(NullPointerException e){
    		logger.error("Problem with creating transaction");
    	}
        
    	return transaction;
    }
    
    public List<Transaction> findAccountHistory(Account account){
    	List<Transaction> history = new ArrayList<Transaction>();
    	for(Transaction transaction : transactions){
    		switch(transaction.getType()){
    		case CHECK:
    			Check check = (Check) transaction;
    			if(check.getFromAccount().equals(account.getNumber())){
    				history.add(transaction);
    			}
    			break;
    		case DEPOSIT:
    			Deposit deposit = (Deposit) transaction;
    			if (deposit.getToAccount().equals(account.getNumber())) {
                    history.add(deposit);
                }
                break;
             case WIREOUT:
                WireOut wireOut = (WireOut) transaction;
                if (wireOut.getFromAccount().equals(account.getNumber())) {
                    history.add(wireOut);
                }
                break;
    		}
    	}
    	return history;
    }


}
