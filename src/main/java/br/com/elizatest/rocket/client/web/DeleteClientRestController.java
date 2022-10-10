package br.com.elizatest.rocket.client.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.elizatest.rocket.client.application.DeleteClientCommand;
import br.com.elizatest.rocket.shared.command.ApplicationCommandDispatcher;

class DeleteClientRequest {    
    public final Integer id;	

    public DeleteClientRequest(Integer id) {
        this.id = id;
    }
}
@RestController
public class DeleteClientRestController {
    private final ApplicationCommandDispatcher commands;
    

    public DeleteClientRestController(ApplicationCommandDispatcher commands) {
        this.commands = commands;
        
    }

    @DeleteMapping("/v2/clients/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable Integer id) {
        DeleteClientRequest request = new DeleteClientRequest(id);
        DeleteClientCommand command = new DeleteClientCommand(request.id);
        commands.execute(command);
        return ResponseEntity.ok().build();
    }
   

}
