package pl.lodz.uni.math.bank.service;

import pl.lodz.uni.math.bank.model.Account;
import pl.lodz.uni.math.bank.model.transaction.*;
import java.util.*;

public interface TransactionService {
	Transaction create(Transaction transaction);
	List<Transaction> findAccountHistory(Account account);
}
