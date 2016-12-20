package pl.lodz.uni.math.bank.service;

import pl.lodz.uni.math.bank.model.Client;

public interface ClientService {
	Client create(Client client);
	Client read(Integer id);
	Client update(Client client);
	Client delete(Client client);
}
