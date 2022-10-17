package br.com.elizatest.rocket.domain.order.core;

import java.util.List;

public class Order {
    private Integer id;
    private String deliveryAddress;
    private Double totalOrder;
    private final ClientOrder client; //final não edita (n tem set)
    private List<OrderItem> items;

    public Order(Integer id, String deliveryAddress, Double totalOrder, ClientOrder client, List<OrderItem> items) {
        this.id = id;
        this.deliveryAddress = deliveryAddress;
        this.totalOrder = totalOrder;
        this.client = client;
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
        totalOrder = items.stream().map(OrderItem::getTotal).reduce(0D, (t, u) -> Double.sum(t, u));
        if (totalOrder == 0.0) throw new IllegalArgumentException("Total order is invalid");
        return totalOrder;
    }

    public void setTotalOrder(Double totalOrder) {
        this.totalOrder = totalOrder;
    }

    public ClientOrder getClient() {
        return client;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    
}
