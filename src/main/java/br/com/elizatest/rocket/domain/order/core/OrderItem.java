package br.com.elizatest.rocket.domain.order.core;

public class OrderItem {
    private Integer sku;
    private String name;
    private Double value;
    private Integer quantity;
    private Double total;

    public OrderItem(Integer sku, String name, Double value, Integer quantity) {
        this.sku = sku;
        this.name = name;
        this.value = value;
        this.quantity = quantity;
        this.total = this.value * this.quantity;
    }

    public OrderItem() {

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
        return value;
    }
    public void setValue(Double value) {
        if(value == 0.0) throw new IllegalArgumentException("Value is invalid");
        this.value = value;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public Double getTotal() {
        return total;
    }
    public void setTotal(Double total) {
        this.total = total;
    } 
        
    
}
