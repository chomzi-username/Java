package pl.lodz.uni.math.bank.service.impl;

import pl.lodz.uni.math.bank.dao.*;
import pl.lodz.uni.math.bank.dao.impl.*;
import pl.lodz.uni.math.bank.model.*;
import pl.lodz.uni.math.bank.service.*;

public class ClientServiceImpl implements ClientService {
	
	private static ClientService instance = null;
	private ClientDao clientDao;
	
	public ClientServiceImpl(){
		this.clientDao = ClientDaoImpl.getInstance();
	}
	
	public static ClientService getInstance(){
		if (instance == null) {
            instance = new ClientServiceImpl();
        }
        return instance;
	}
	public Client create(Client client) {
        return clientDao.create(client);
    }

    public Client read(Integer id) {
        return clientDao.read(id);
    }

    public Client update(Client client) {
        return clientDao.update(client);
    }

    public Client delete(Client client) {
        return clientDao.delete(client);
    }
	
}
