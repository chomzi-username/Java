package pl.lodz.uni.math.bank.service.impl;

import pl.lodz.uni.math.bank.dao.*;
import pl.lodz.uni.math.bank.dao.impl.*;
import pl.lodz.uni.math.bank.model.*;
import pl.lodz.uni.math.bank.model.transaction.*;
import pl.lodz.uni.math.bank.service.*;

import java.util.*;

public class TransactionServiceImpl implements TransactionService {

	private static TransactionService instance;
	private TransactionDao transactionDao;
	
	public TransactionServiceImpl(){
		transactionDao = TransactionDaoImpl.getInstance();
	}
	
	public static TransactionService getInstance() {
        if (instance == null) {
            instance = new TransactionServiceImpl();
        }
        return instance;
    }

    public Transaction create(Transaction transaction) {
        return transactionDao.create(transaction);
    }

    public List<Transaction> findAccountHistory(Account account) {
        return transactionDao.findAccountHistory(account);
    }
}
