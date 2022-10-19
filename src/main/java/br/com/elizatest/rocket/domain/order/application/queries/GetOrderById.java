package br.com.elizatest.rocket.domain.order.application.queries;

import java.util.List;

import br.com.elizatest.rocket.domain.order.infrasctructure.ClientOrderModel;
import br.com.elizatest.rocket.domain.order.infrasctructure.OrderItemModel;
import br.com.elizatest.rocket.shared.query.ApplicationQuery;

public class GetOrderById implements ApplicationQuery<GetOrderById.OrderResult> {

    public final Integer id;

    public GetOrderById(Integer id) {
        this.id = id;
    }

    public static class OrderResult {
        public final String deliveryAddress;
        public final Double totalOrder;
        public final ClientOrderModel client;
        public final List<OrderItemModel> items;
        
        public OrderResult(String deliveryAddress, Double totalOrder, ClientOrderModel client, List<OrderItemModel> items) {
            this.deliveryAddress = deliveryAddress;
            this.totalOrder = totalOrder;
            this.client = client;
            this.items = items;
        }        

    }

    
    
}
