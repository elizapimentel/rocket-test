package br.com.elizatest.rocket.domain.order.web;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.elizatest.rocket.domain.order.application.commands.CreateOrderCommand;

import br.com.elizatest.rocket.shared.command.ApplicationCommandDispatcher;

class CreateOrderRequest {
    public final String deliveryAddress;
    public final Double totalOrder;
    public final Client client;
    public final List<Item> items;

    public CreateOrderRequest(String deliveryAddress, Double totalOrder, Client client, List<Item> items) {
        this.deliveryAddress = deliveryAddress;
        this.totalOrder = totalOrder;
        this.client = client;
        this.items = items;
    }    

}

//adicionar itens e construtor
class Client {
    public final Integer id;
    public final String name;
    public final String cpf;
    public final String email;
    public final String phone;
    public final String address;
    public final LocalDate birth;

    public Client(Integer id, String name, String cpf, String email, String phone, String address, LocalDate birth, Boolean deleted) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.birth = birth;
    }


}

class Item {
    public final Integer sku;
    public final String name;
    public final Double value;
    public final Integer quantity;
    public final Double total;

    public Item(Integer sku, String name, Double value, Integer quantity, Double total) {
        this.sku = sku;
        this.name = name;
        this.value = value;
        this.quantity = quantity;
        this.total = total;
    }
    

}

@RestController
public class CreateOrderRestController {

    private final ApplicationCommandDispatcher commands;

    public CreateOrderRestController(ApplicationCommandDispatcher commands) {
        this.commands = commands;
    }

    @PostMapping("/v2/orders")
    public ResponseEntity<?> createOrderRequestHandler(@RequestBody CreateOrderRequest createOrderRequest) {
        try {
            var client = new CreateOrderCommand.ClientOrder(createOrderRequest.client.id, createOrderRequest.client.name, createOrderRequest.client.cpf, createOrderRequest.client.email, createOrderRequest.client.phone, createOrderRequest.client.address, createOrderRequest.client.birth, null);
            var items = createOrderRequest.items
            .stream()
            .map(item -> new CreateOrderCommand.OrderItems(item.sku, item.name, item.value, item.quantity, item.total))
            .collect(Collectors.toList());
            CreateOrderCommand command = new CreateOrderCommand(createOrderRequest.deliveryAddress, createOrderRequest.totalOrder, client, items);
            commands.execute(command);
            return ResponseEntity.ok(null);            
        } catch (IllegalStateException | IllegalArgumentException i) {
            i.printStackTrace();
            return ResponseEntity.unprocessableEntity().body(i.getMessage());
        }
        catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        } 
         
    }
    
}
