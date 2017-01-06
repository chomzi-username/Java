package pl.lodz.uni.math;

import pl.lodz.uni.math.App;
import org.junit.*;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.easymock.EasyMockRule;
import org.easymock.EasyMockSupport;
import org.easymock.IMocksControl;
import org.easymock.Mock;
import org.easymock.TestSubject;

import pl.lodz.uni.math.bank.dao.*;
import pl.lodz.uni.math.bank.dao.impl.*;
import pl.lodz.uni.math.bank.enumType.TransactionType;
import pl.lodz.uni.math.bank.model.Account;
import pl.lodz.uni.math.bank.model.Client;
import pl.lodz.uni.math.bank.model.transaction.Transaction;
import pl.lodz.uni.math.bank.service.ClientService;
import pl.lodz.uni.math.bank.service.impl.AccountServiceImpl;
import pl.lodz.uni.math.bank.service.impl.ClientServiceImpl;
import pl.lodz.uni.math.bank.service.impl.TransactionServiceImpl;

import static org.easymock.EasyMock.*;

public class AppTest extends EasyMockSupport {

	@TestSubject
	private IMocksControl ctrl;
	private Account newAccount = new Account(1,"asdasd");

	@Mock
	AccountDaoImpl accountDaoImpl;
	
	@Rule
    public ExpectedException thrown = ExpectedException.none();

	@Test
	public void createAccountTest() {
		Account account = new Account(1, "asdas");
		AccountDaoImpl accountImpl = new AccountDaoImpl();
		assertEquals(account, accountImpl.create(account));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void createAccountTestException(){
		Account account = new Account();
		AccountDaoImpl accountImpl = new AccountDaoImpl();
		accountImpl.create(account);
	}

	@Test
	public void deleteAccountTest() {
		Account account = new Account(1, "asdas");
		AccountDaoImpl accountImpl = new AccountDaoImpl();
		assertEquals(account, accountImpl.delete(account));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void deleteAccountTestException(){
		Account account = new Account();
		AccountDaoImpl accountImpl = new AccountDaoImpl();
		accountImpl.delete(account);
		thrown.expectMessage("Problem with removal client");
	}

	@Test
	public void createClientTest() {
		Client client = new Client("Marek", "Nowak");
		ClientDaoImpl clientImpl = new ClientDaoImpl();
		assertEquals(client, clientImpl.create(client));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void createClientTestException(){
		Client client = new Client();
		ClientDaoImpl clientImpl = new ClientDaoImpl();
		clientImpl.create(client);
		thrown.expectMessage("Problem with creating a client");
	}

	@Test
	public void deteleClientTest() {
		Client client = new Client("Marek", "Nowak");
		ClientDaoImpl clientImpl = new ClientDaoImpl();
		assertEquals(client, clientImpl.delete(client));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void deleteClientTestException(){
		Client client = new Client();
		ClientDaoImpl clientImpl = new ClientDaoImpl();
		clientImpl.delete(client);
		thrown.expectMessage("Problem with removal client");
	}

	@Test
	public void readClientTest() {
		createClientTest();
		ClientDaoImpl clientImpl = new ClientDaoImpl();
		assertEquals(0, clientImpl.read(0)); 
	}
	
	@Test
	public void updateClientTest(){
		ClientDaoImpl clientDao = new ClientDaoImpl();
		Client client = null;
		assertEquals(client, clientDao.update(client));
	}

	@Test
	public void createTransactionTest() {
		TransactionDaoImpl tran = new TransactionDaoImpl();
		Transaction transaction = null;
		assertEquals(transaction, tran.create(transaction));
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void createTransactionTestException(){
		TransactionDaoImpl tran = new TransactionDaoImpl();
		Transaction transaction = null;
		tran.create(transaction);
		thrown.expectMessage("Problem with creating transaction");
	}
	
	@Test
	public void createAccountServiceTest(){
		AccountServiceImpl accountService = new AccountServiceImpl();
		Integer lastInsertedNumber = 100000;
		lastInsertedNumber++;
		Account account = new Account();
		account.setNumber(lastInsertedNumber.toString());
		accountService.create(account);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void createAccountServiceTestException(){
		AccountServiceImpl accountService = new AccountServiceImpl();
		Integer lastInsertedNumber = 100000;
		lastInsertedNumber++;
		Account account = new Account();
		//account.setNumber(lastInsertedNumber.toString());
		accountService.create(account);
		thrown.expectMessage("wrong format for creating account");
	}
	
	@Test
	public void deleteAccountServiceTest(){
		AccountServiceImpl accountService = new AccountServiceImpl();
		Integer lastInsertedNumber = 100000;
		lastInsertedNumber--;
		Account account = new Account();
		account.setNumber(lastInsertedNumber.toString());
		accountService.delete(account);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void deleteAccountServiceTestException(){
		AccountServiceImpl accountService = new AccountServiceImpl();
		Integer lastInsertedNumber = 100000;
		lastInsertedNumber--;
		Account account = new Account();
		//account.setNumber(lastInsertedNumber.toString());
		accountService.delete(account);
		thrown.expectMessage("wrong format for delete account");
	}
	
	@Test
	public void createClientServiceTest(){
		ClientServiceImpl clientService = new ClientServiceImpl();
		Client client = new Client();
		assertEquals(client, clientService.create(client));
	}
	
	@Test
	public void deleteClientServiceTest(){
		ClientServiceImpl clientService = new ClientServiceImpl();
		Client client = new Client();
		assertEquals(client, clientService.delete(client));
	}
	
	@Test
	public void updateClientServiceTest(){
		ClientServiceImpl clientService = new ClientServiceImpl();
		Client client = new Client();
		assertEquals(client, clientService.update(client));
	}
	
	@Test
	public void createTransactionServiceTest(){
		TransactionServiceImpl transactionService = new TransactionServiceImpl();
		Transaction transaction = null ;
		assertEquals(transaction, transactionService.create(transaction));
	}
	

}
