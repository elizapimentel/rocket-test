package br.com.elizatest.rocket.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name="delivery_address", length = 150, nullable = false)
	private String deliveryAddress;
	@Column(name = "total_order", nullable = false)
	private Double totalOrder;
	
	@ManyToOne
	@JoinColumn(name="client_id")
	private Client client;
		
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("order")
	private List<OrderItem> items;

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void setItems(List<OrderItem> items) {
		this.items = items;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public Double getTotalOrder() {
		return totalOrder;
	}

	public void setTotalOrder(Double totalOrder) {
		this.totalOrder = totalOrder;
	}

}
