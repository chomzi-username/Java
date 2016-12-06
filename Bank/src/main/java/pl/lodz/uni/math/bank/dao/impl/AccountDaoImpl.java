package pl.lodz.uni.math.bank.dao.impl;

import pl.lodz.uni.math.bank.dao.AccountDao;
import pl.lodz.uni.math.bank.model.Account;
import org.apache.log4j.*;
import java.util.*;

public class AccountDaoImpl implements AccountDao {
	private static Logger logger = LogManager.getLogger(AccountDaoImpl.class);
	
	private static AccountDao instance;
	
	private List<Account> accounts;
	
	public AccountDaoImpl(){
		accounts = new ArrayList<Account>();
	}
	
	public static AccountDao getInstance(){
		if(instance==null){
			instance = new AccountDaoImpl();
		}
		
		return instance;
	}
	
	public Account create(Account account){
		try{
			accounts.add(account);//mockowac accounts, sprawdzic czy add dodaje konto, sprawdzic proces dodawania | if sprawdzic true albo false
			logger.info(accounts);
		}catch(NullPointerException e){
			logger.error("Problem with creating account");
		}
		
		return account;
	}
	
}
