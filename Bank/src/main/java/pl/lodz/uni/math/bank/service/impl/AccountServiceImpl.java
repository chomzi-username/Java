package pl.lodz.uni.math.bank.service.impl;

import pl.lodz.uni.math.bank.dao.AccountDao;
import pl.lodz.uni.math.bank.model.Account;
import pl.lodz.uni.math.bank.service.AccountService;
import pl.lodz.uni.math.bank.dao.impl.*;

public class AccountServiceImpl implements AccountService {
	
	private static AccountService instance = null;
	private Integer lastInsertedNumber = 100000;
	AccountDao accountDao;
	
	public AccountServiceImpl(){
		accountDao = AccountDaoImpl.getInstance();
	}
	
	public static AccountService getInstance(){
		if(instance == null){
			instance = new AccountServiceImpl();
		}
		return instance;
	}
	
	public Account create(Account account) {
		lastInsertedNumber++;
		account.setNumber(lastInsertedNumber.toString());
		return accountDao.create(account);
	}

}
