package pl.lodz.uni.math.bank.service.impl;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import pl.lodz.uni.math.App;
import pl.lodz.uni.math.bank.dao.AccountDao;
import pl.lodz.uni.math.bank.model.Account;
import pl.lodz.uni.math.bank.service.AccountService;
import pl.lodz.uni.math.bank.dao.impl.*;


public class AccountServiceImpl implements AccountService {
	
	private static final Logger logger = LogManager.getLogger(AccountServiceImpl.class);
	
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
		try{
			lastInsertedNumber++;
			account.setNumber(lastInsertedNumber.toString());
		}catch(IllegalArgumentException e){
			logger.error("wrong format for creating account");
		}
		
		return accountDao.create(account);
	}
	
	public Account delete(Account account){
		try{
			lastInsertedNumber--;
			account.setNumber(lastInsertedNumber.toString());
		}catch(IllegalArgumentException e){
			logger.error("wrong format for delete account");
		}
		
		return accountDao.delete(account);
	}

}
