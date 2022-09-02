package br.com.elizatest.rocket.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.elizatest.rocket.dao.OrderDAO;
import br.com.elizatest.rocket.model.Client;
import br.com.elizatest.rocket.model.Order;
import br.com.elizatest.rocket.model.OrderItem;

@Service
public class OrderServiceImpl implements IOrderService{
	@Autowired
	OrderDAO dao;
	
	@Override
	public Order createOrder(Order order) {
		for(OrderItem item: order.getItems() ) {
			item.setOrder(order);
		}
		return dao.save(order);
	}

	@Override
	public void deleteOrder(Integer id) {
		dao.deleteById(id);
		
	}

	@Override
	public ArrayList<Order> getAll() {
		return (ArrayList<Order>) dao.findAll();
	}

	@Override
	public Client getClientById(Integer id) {
		
		return null;
	}

}
