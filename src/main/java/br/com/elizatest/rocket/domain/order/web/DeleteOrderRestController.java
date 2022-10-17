package br.com.elizatest.rocket.domain.order.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.elizatest.rocket.domain.order.application.commands.DeleteOrderCommand;
import br.com.elizatest.rocket.shared.command.ApplicationCommandDispatcher;

class DeleteOrderRequest {    
    public final Integer id;	

    public DeleteOrderRequest(Integer id) {
        this.id = id;
    }
}

@RestController
public class DeleteOrderRestController {
    private final ApplicationCommandDispatcher commands;

    public DeleteOrderRestController(ApplicationCommandDispatcher commands) {
        this.commands = commands;
    }

    @DeleteMapping("/v2/orders/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable Integer id) {
        DeleteOrderRequest request = new DeleteOrderRequest(id);
        DeleteOrderCommand command = new DeleteOrderCommand(request.id);
        commands.execute(command);
        return ResponseEntity.ok().body(command);
    }
    
}
