package br.com.elizatest.rocket.service;

import java.util.ArrayList;

import br.com.elizatest.rocket.model.Client;
import br.com.elizatest.rocket.model.Order;

public interface IOrderService {
	public Order createOrder(Order order);
	public void deleteOrder(Integer id);
	public ArrayList<Order> getAll();
	public Client getClientById(Integer id);
}
