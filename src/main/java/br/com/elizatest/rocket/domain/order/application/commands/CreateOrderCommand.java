package br.com.elizatest.rocket.domain.order.application.commands;

import java.time.LocalDate;
import java.util.List;

import br.com.elizatest.rocket.shared.command.ApplicationCommand;

public class CreateOrderCommand implements ApplicationCommand<Void>{
    
    public final String deliveryAddress;
    public final Double totalOrder;
    public final ClientOrder client_id;
    public final List<OrderItems> items;

    public CreateOrderCommand(String deliveryAddress, Double totalOrder,  ClientOrder client_id,List<OrderItems> items) {
        this.deliveryAddress = deliveryAddress;
        this.totalOrder = totalOrder;
        this.client_id = client_id;
        this.items = items;
    }

    // add todos os itens e construtor
    public static class ClientOrder {
        public final Integer id;
        public final String name;
        public final String cpf;
        public final String email;
        public final String phone;
        public final String address;
        public final LocalDate birth;
        

        public ClientOrder(Integer id, String name, String cpf, String email, String phone, String address, LocalDate birth) {
            this.id = id;
            this.name = name;
            this.cpf = cpf;
            this.email = email;
            this.phone = phone;
            this.address = address;
            this.birth = birth;
            
        }


    }

    public static class OrderItems {
        public final Integer sku;
        public final String name;
        public final Double value;
        public final Integer quantity;
        public final Double total;

        public OrderItems(Integer sku, String name, Double value, Integer quantity, Double total) {
            this.sku = sku;
            this.name = name;
            this.value = value;
            this.quantity = quantity;
            this.total = total;
        }
        
    }

    

}
