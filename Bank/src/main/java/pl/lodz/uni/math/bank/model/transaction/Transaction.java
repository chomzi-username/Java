package pl.lodz.uni.math.bank.model.transaction;

import pl.lodz.uni.math.bank.constant.TransactionType;

public interface Transaction {
	TransactionType getType();
	String getInfo();
}
