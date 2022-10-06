package br.com.elizatest.rocket.service;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.Filter;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.elizatest.rocket.dao.ClientDAO;
import br.com.elizatest.rocket.model.Client;

@Service // @Service is a specialization of @Component for classes that provide some business functionality.
// polimosphism from IClientService
public class ClientServiceImpl implements IClientService {

	@Autowired // @Autowired is used to inject the object dependency implicitly. Without using "new" keyword.
	ClientDAO dao;

	private EntityManager em; // @PersistenceContext is used to inject EntityManager instance.

	@PersistenceContext // @PersistenceContext is used to inject EntityManager instance.
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

	@Override
	public ArrayList<Client> getAll(Boolean isDeleted) {
		Session session = em.unwrap(Session.class);
		Filter filter = session.enableFilter("deletedClientFilter");
		filter.setParameter("isDeleted", isDeleted);
		ArrayList<Client> users = (ArrayList<Client>) dao.findAll();
		session.disableFilter("deletedClientFilter");
		return users;
	}

	@Override
	public Client postClient(Client newClient) {
		Client storeUserDetails = dao.findByEmail(newClient.getEmail());
		if (storeUserDetails != null)
			throw new RuntimeException("User already exists");
		Client client = new Client();
		BeanUtils.copyProperties(newClient, client);
		return storeUserDetails = dao.save(client);

	}

	@Override
	public Client updateClient(Integer id, Client updateClient) {
		// if email already registered
		Client storeUserDetails = dao.findByEmail(updateClient.getEmail());
		if (storeUserDetails != null)
			throw new RuntimeException("User already exists");
		// if id not found
		Client client = dao.findById(id).orElse(null);
		if (client == null)
			throw new RuntimeException("User not found");
		BeanUtils.copyProperties(updateClient, client);
		return storeUserDetails = dao.save(client);

	}

	@Override
	public void deleteClient(Integer id) {
		dao.deleteById(id);
	}

	@Override
	public Client getClientById(Integer id) {
		return dao.findById(id).get();
	}

}
