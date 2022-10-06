package br.com.elizatest.rocket.client.web;

import java.time.LocalDate;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.elizatest.rocket.client.application.commands.UpdateClientCommand;
import br.com.elizatest.rocket.shared.command.ApplicationCommandDispatcher;

class UpdateClientRequest {
    
    public final String name;	
	public final String cpf;
	public final String email;
	public final String phone;
	public final String address;	
	public final LocalDate birth;

    public UpdateClientRequest(String name, String cpf, String email, String phone, String address, LocalDate birth) {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.birth = birth;
    }
}

@RestController
public class UpdateClientRestController {
    
    private final ApplicationCommandDispatcher commands;

    public UpdateClientRestController(ApplicationCommandDispatcher commands) {
        this.commands = commands;
    }

    @PutMapping("/v2/clients/{id}")
    public ResponseEntity<?> updateClientRequestHandler(@RequestBody UpdateClientRequest updateClientRequest, @PathVariable Integer id) {
        UpdateClientCommand command = new UpdateClientCommand(id, updateClientRequest.name, updateClientRequest.cpf, updateClientRequest.email, updateClientRequest.phone, updateClientRequest.address, updateClientRequest.birth);
        commands.execute(command);                
        return ResponseEntity.ok().build();
    }
}