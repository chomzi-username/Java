package pl.lodz.uni.math.bank.dao;

import pl.lodz.uni.math.bank.model.Client;

public interface ClientDao {
	Client create(Client client);
	Client read(Integer id);
	Client update(Client client);
	void delete(Client client);
}
