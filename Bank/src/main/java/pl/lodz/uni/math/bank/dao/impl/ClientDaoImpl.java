package pl.lodz.uni.math.bank.dao.impl;

import pl.lodz.uni.math.bank.dao.ClientDao;
import org.apache.log4j.*;
import pl.lodz.uni.math.bank.model.Client;
import java.util.ArrayList;
import java.util.List;

public class ClientDaoImpl implements ClientDao {
	
	private static Logger logger = LogManager.getLogger(ClientDaoImpl.class);
	
	private static ClientDao instance = null;
	private List<Client> clients;
	
	public ClientDaoImpl() {
		clients = new ArrayList<Client>();
	}
	
	public static ClientDao getInstance(){
		if(instance == null){
			instance = new ClientDaoImpl();
		}
		return instance;
	}
	
	public Client create(Client client){
		try{
			clients.add(client);
			Integer id = clients.size()+1;
			client.setId(id);
			
		}catch(IllegalArgumentException e){
			logger.error("Problem with creating a client");
		}
		
		return client;
	}
	
	public Client read(Integer id){
		return clients.get(id-1);
		
	}
	
	public Client update(Client client){
		return null;
	}
	
	public Client delete(Client client){
		try{
			Integer id = clients.size()-1;
			client.setId(id);
			clients.remove(client);
		}catch(IllegalArgumentException e){
			logger.error("Problem with removal client" );
		}
		
		return client;
		
	}
	
	
}
