package pl.lodz.uni.math.bank.dao;

import java.util.List;

import pl.lodz.uni.math.bank.model.*;
import pl.lodz.uni.math.bank.model.transaction.*;

public interface TransactionDao {
	Transaction create(Transaction transaction);
	List<Transaction> findAccountHistory(Account account);
}
