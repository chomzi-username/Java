package pl.lodz.uni.math;

import java.util.*;
import pl.lodz.uni.math.bank.model.*;
import pl.lodz.uni.math.bank.model.transaction.Check;
import pl.lodz.uni.math.bank.model.transaction.Deposit;
import pl.lodz.uni.math.bank.model.transaction.Transaction;
import pl.lodz.uni.math.bank.model.transaction.WireOut;
import pl.lodz.uni.math.bank.service.*;
import pl.lodz.uni.math.bank.service.impl.*;
import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import java.util.InputMismatchException;

public class App {
	private static final Logger logger = LogManager.getLogger(App.class);

	public static void main(String[] args) {
		BasicConfigurator.configure();
		logger.setLevel(Level.INFO);

		ClientService clientService = ClientServiceImpl.getInstance();
		// First client
		Client clientArtur = clientService.create(new Client("Artur", "Goralczyk"));
		logger.info(clientService.read(1));

		AccountService accountService = AccountServiceImpl.getInstance();
		Account arturAccount1 = accountService.create(new Account(clientArtur.getId(), "Konto1"));
		logger.info(arturAccount1);

		// Make check
		TransactionService transactionService = TransactionServiceImpl.getInstance();
		Check check = new Check();
		check.setFromAccount(arturAccount1.getNumber());

		try {
			check.setToAccount("123");
			check.setAmount(10.00);
			check.setDate(new Date(System.currentTimeMillis()));
			check.setDescription("testowy przelew");
		} catch (IllegalArgumentException e) {
			logger.error("Illegal argument in check tranasction");
		}

		transactionService.create(check);

		// Make wireout
		WireOut wireOut = new WireOut();
		wireOut.setFromAccount(arturAccount1.getNumber());

		try {
			wireOut.setToAccount("456");
			wireOut.setAmount(99.99);
			wireOut.setSwift("PL123456");
			wireOut.setCountry("PL");
		} catch (IllegalArgumentException e) {
			logger.error("Illegal argument in wire transaction");
		}

		transactionService.create(wireOut);

		// Make deposit
		Deposit deposit = new Deposit();
		deposit.setFromAccount(arturAccount1.getNumber());
		try {

			deposit.setToAccount("111");
			deposit.setAmount(1000.00);
			deposit.setDate(new Date(System.currentTimeMillis()));
			deposit.setDescription("testowy depozyt");

		} catch (IllegalArgumentException e) {
			logger.error("Illegal argument in deposit transaction");
		}

		transactionService.create(deposit);

		List<Transaction> arturHistory = transactionService.findAccountHistory(arturAccount1);
		logger.info(arturHistory);

	}
}
