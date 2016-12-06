package pl.lodz.uni.math;

import pl.lodz.uni.math.App;
import org.junit.*;
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
import pl.lodz.uni.math.bank.model.Account;
import pl.lodz.uni.math.bank.model.Client;

import static org.easymock.EasyMock.*;

public class AppTest extends EasyMockSupport {

	// MOCK TESTING
	@TestSubject
	private AccountDaoImpl accountDaoImpl;
	private Account newAccount = new Account(1,"new Account");
	private IMocksControl ctrl;
	
	//For Junit
	private ClientDaoImpl clientDaoI;
	//private Client client = new Client("Artur","Goralczyk");
	
	@Before
	public void setUp() {
		ctrl = EasyMock.createControl();
//		newAccount = new Account(1, "new Account");
//		accountDaoImpl = new AccountDaoImpl();
		accountDaoImpl.create(newAccount);
	}

	@Test
	public void addAccount()throws Exception {//sprawdzam dodawanie konta
		setUp();
		ctrl.reset();
		List<Account> accounts = new ArrayList<Account>();
		assertEquals(1,accounts.add(newAccount));
		ctrl.verify();
	}
	
	// JUNIT TESTING

	
	@Test
	public void returnClientID(){
		Client client = new Client();
		List<Client>clients = new ArrayList<Client>();
		clientDaoI.create(client);
		Integer id = clients.size()+1;
		
		//assertEquals(1, client.setId(id));
	}
	
}
