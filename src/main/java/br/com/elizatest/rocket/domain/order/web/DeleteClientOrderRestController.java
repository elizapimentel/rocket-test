package br.com.elizatest.rocket.domain.order.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.elizatest.rocket.domain.order.application.commands.DeleteClientOrderCommand;
import br.com.elizatest.rocket.shared.command.ApplicationCommandDispatcher;

class DeleteClientOrderRequest {    
    public final Integer id;	

    public DeleteClientOrderRequest(Integer id) {
        this.id = id;
    }
}

@RestController
public class DeleteClientOrderRestController {
    private final ApplicationCommandDispatcher commands;

    public DeleteClientOrderRestController(ApplicationCommandDispatcher commands) {
        this.commands = commands;
    }

    @DeleteMapping("/v2/client/{id}")
    public ResponseEntity<?> deleteClientOrder(@PathVariable Integer id) {  
        try {
            DeleteClientOrderRequest request = new DeleteClientOrderRequest(id);
            DeleteClientOrderCommand command = new DeleteClientOrderCommand(request.id);      
            commands.execute(command);
            return ResponseEntity.ok().build();
            
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
