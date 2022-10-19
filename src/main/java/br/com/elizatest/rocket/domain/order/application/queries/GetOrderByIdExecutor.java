package br.com.elizatest.rocket.domain.order.application.queries;

import br.com.elizatest.rocket.domain.order.infrasctructure.OrderModel;
import br.com.elizatest.rocket.domain.order.infrasctructure.OrderRepositoryDAO;
import br.com.elizatest.rocket.shared.query.ApplicationQueryExecutor;

public class GetOrderByIdExecutor implements ApplicationQueryExecutor<GetOrderById.OrderResult, GetOrderById> {
    public final OrderRepositoryDAO dao;

    public GetOrderByIdExecutor(OrderRepositoryDAO dao) {
        this.dao = dao;
    }

    @Override
    public GetOrderById.OrderResult execute(GetOrderById command) {  
        OrderModel order = dao.findById(command.id).orElseThrow(() -> new IllegalArgumentException("Pedido não encontrado")); 
        return new GetOrderById.OrderResult(order.getDeliveryAddress(), order.getTotalOrder(), order.getClient(), order.getItems());
    }
    
}
