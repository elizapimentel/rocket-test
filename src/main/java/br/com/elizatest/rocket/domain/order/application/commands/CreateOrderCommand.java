package br.com.elizatest.rocket.domain.order.application.commands;

import java.util.List;

import br.com.elizatest.rocket.domain.order.core.ClientOrder;
import br.com.elizatest.rocket.domain.order.core.OrderItem;
import br.com.elizatest.rocket.shared.command.ApplicationCommand;

public class CreateOrderCommand implements ApplicationCommand<Void>{
    
    public final String deliveryAddress;
    public final Double totalOrder;
    public final ClientOrder client_id;
    public final List<OrderItem> items;

    public CreateOrderCommand(String deliveryAddress, Double totalOrder, ClientOrder client_id,List<OrderItem> items) {
        this.deliveryAddress = deliveryAddress;
        this.totalOrder = totalOrder;
        this.client_id = client_id;
        this.items = items;
    }

}
