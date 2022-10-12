package br.com.elizatest.rocket.domain.client.web;

import java.time.LocalDate;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.elizatest.rocket.domain.client.application.commands.CreateClientCommand;
import br.com.elizatest.rocket.shared.command.ApplicationCommandDispatcher;

class CreateClientRequest {    

    public final String name;	
	public final String cpf;
	public final String email;
	public final String phone;
	public final String address;	
	public final LocalDate birth;

    public CreateClientRequest(String name, String cpf, String email, String phone, String address, LocalDate birth) {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.birth = birth;
    }
}

@RestController
public class CreateClientRestController {
    
    private final ApplicationCommandDispatcher commands;

    public CreateClientRestController(ApplicationCommandDispatcher commands) {
        this.commands = commands;
    }

    @PostMapping("/v2/clients")
    public ResponseEntity<Object> createClientRequestHandler(@RequestBody CreateClientRequest createClientRequest) {
		CreateClientCommand command = new CreateClientCommand(createClientRequest.name, createClientRequest.cpf, createClientRequest.email, createClientRequest.phone, createClientRequest.address, createClientRequest.birth);
        commands.execute(command);
        return ResponseEntity.ok(null);

	}	

}

