package br.com.elizatest.rocket.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.elizatest.rocket.model.Order;

public interface OrderDAO extends JpaRepository<Order, Integer> {
	//Order findClient(String email);
}
