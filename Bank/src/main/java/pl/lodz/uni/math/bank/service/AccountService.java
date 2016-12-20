package pl.lodz.uni.math.bank.service;

import pl.lodz.uni.math.bank.model.Account;

public interface AccountService {
	Account create(Account account);
	Account delete(Account account);
}
