package br.com.elizatest.rocket.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.elizatest.rocket.model.Client;
import br.com.elizatest.rocket.model.Order;
import br.com.elizatest.rocket.service.IOrderService;

@RestController
public class OrderController {
	@Autowired
	IOrderService service;
	
	@GetMapping("/orders")
	public ArrayList<Order> getAll() {
		return (ArrayList<Order>) service.getAll();
	}
	
	@PostMapping("/orders")
	public ResponseEntity<Order> createOrder(@RequestBody Order order){
		if(order.getClient().getId() == null) {
			Client client = new Client();
			client.setId(1);
			client.setName(order.getClient().getName());
			client.setAddress(order.getClient().getAddress());
			client.setPhone(order.getClient().getPhone());
			client.setEmail(order.getClient().getEmail());
			order.setClient(client);
		}
		else {
			Client client = new Client();
			client.setId(order.getClient().getId());
			client.setName(order.getClient().getName());
			client.setAddress(order.getClient().getAddress());
			client.setPhone(order.getClient().getPhone());
			client.setEmail(order.getClient().getEmail());
			order.setClient(client);
		}		
		Double total = 0.0;
		for(int i = 0; i < order.getItems().size(); i++) {
			total += order.getItems().get(i).getTotal();
		}
		order.setTotalOrder(total);
		service.createOrder(order);
		return ResponseEntity.status(201).body(order);
	}


	@DeleteMapping("/orders/{id}")
	public void deleteOrder(@PathVariable Integer id) {
		try{
			service.deleteOrder(id);

		} catch (Exception e) {
			ResponseEntity.status(404).build();
		}
	}


}
