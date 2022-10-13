package br.com.elizatest.rocket.domain.order.infrasctructure;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.elizatest.rocket.domain.order.core.ClientOrder;
import br.com.elizatest.rocket.domain.order.core.Order;
import br.com.elizatest.rocket.domain.order.core.OrderRepository;

@Service
public class OrderJPARepository implements OrderRepository {

    private final OrderRepositoryDAO dao;


    public OrderJPARepository(OrderRepositoryDAO dao) {
        this.dao = dao;
    }


    @Override
    public Optional<Order> load(Integer id) {
        var order = dao.findById(id).orElse(null);
        if(order != null) {
            return Optional.of(order.toOrder());
        }
        return Optional.empty();
    }


    @Override
    public void save(Order order) {
        OrderModel orderModel = this.convertToModel(order);    
        dao.save(orderModel);
    }

    private ClientOrderModel convertToModel(ClientOrder client) {
        return new ClientOrderModel(client.getId(), client.getName(), client.getCpf(), client.getEmail(), client.getPhone(), client.getAddress(), client.getBirth(), client.getDeleted());
    }

    private OrderModel convertToModel(Order order) {
        OrderModel orderModel = new OrderModel();
        orderModel.setId(order.getId());
        orderModel.setDeliveryAddress(order.getDeliveryAddress());
        orderModel.setTotalOrder(order.getTotalOrder());
        //onde colocar condição de caso cliente seja nulo?
        orderModel.setClient(convertToModel(order.getClient()));
        var convertItems = order.getItems().stream().map(item -> new OrderItemModel(item.getSku(), item.getName(), item.getValue(), item.getQuantity(), item.getTotal(), orderModel)).collect(Collectors.toList());
        orderModel.setItems(convertItems);
        return orderModel;
    }

    //deletar cliente sem deletar pedido ??
    @Override
    public void deleteOrder(Order deleteOrder) {
        OrderModel order = new OrderModel(); 
        order.setId(deleteOrder.getId());
        order.setDeliveryAddress(deleteOrder.getDeliveryAddress());
        order.setTotalOrder(deleteOrder.getTotalOrder());
        order.setClient(convertToModel(deleteOrder.getClient()));   
        var convertItem = deleteOrder.getItems().stream().map(item -> new OrderItemModel(item.getSku(), item.getName(), item.getValue(), item.getQuantity(), item.getTotal(), order)).collect(Collectors.toList());
        order.setItems(convertItem);
        dao.save(order);
        
    }
   
    
}
