package pl.lodz.uni.math.bank.dao;

import pl.lodz.uni.math.bank.model.Account;
import pl.lodz.uni.math.bank.model.Client;

public interface AccountDao {
	Account create(Account account);
	Account delete(Account account);
}
