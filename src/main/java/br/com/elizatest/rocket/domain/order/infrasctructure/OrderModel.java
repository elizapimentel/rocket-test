package br.com.elizatest.rocket.domain.order.infrasctructure;

import java.util.List;
import java.util.stream.Collectors;

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

import br.com.elizatest.rocket.domain.order.core.ClientOrder;
import br.com.elizatest.rocket.domain.order.core.Order;

@Entity
@Table(name="orders")
public class OrderModel {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name="delivery_address", length = 150, nullable = false)
	private String deliveryAddress;
	@Column(name = "total_order", nullable = false)
	private Double totalOrder;
	
	@ManyToOne
	@JoinColumn(name="client_id")
	private ClientOrder client;
		
	@OneToMany(mappedBy = "orders", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("orders")
	private List<OrderItemModel> items;

	public OrderModel(Integer id, String deliveryAddress, Double totalOrder, ClientOrder client, List<OrderItemModel> items) {
		this.id = id;
		this.deliveryAddress = deliveryAddress;
		this.totalOrder = totalOrder;
		this.client = client;
		this.items = items;
	}
	
	public Order toOrder() {	
		var itensConvertidos = items.stream().map(item -> item.toOrderItem()).collect(Collectors.toList());	
		return new Order(id, deliveryAddress, totalOrder, client, itensConvertidos);
	}
	
	public OrderModel() {

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

	public ClientOrder getClient() {
		return client;
	}

	public void setClient(ClientOrder client) {
		this.client = client;
	}

	public List<OrderItemModel> getItems() {
		return items;
	}

	public void setItems(List<OrderItemModel> items) {
		this.items = items;
	}

	
	
}
