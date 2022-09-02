package br.com.elizatest.rocket.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="order_items")
public class OrderItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="SKU")
	private Integer sku;
	@Column(length = 50, nullable = false)
	private String name;
	@Column(nullable = false)
	private Double value;
	@Column(nullable = false)
	private Integer quantity;
	@Column(nullable = false)
	private Double total;
	
	@ManyToOne
	@JoinColumn(name="order_id")
	@JsonIgnoreProperties("items")
	private Order order;
	
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Integer getSku() {
		return sku;
	}
	public void setSku(Integer sku) {
		this.sku = sku;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getValue() {
		if(value == 0.0) throw new RuntimeException("Value is invalid");
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getTotal() {
		total = value * quantity;
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	

}
