package pl.lodz.uni.math.bank.model.transaction;

import pl.lodz.uni.math.bank.enumType.TransactionType;

public interface Transaction {
	TransactionType getType();
	String getInfo();
}
