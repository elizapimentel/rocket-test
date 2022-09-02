package br.com.elizatest.rocket.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.elizatest.rocket.model.Client;
import br.com.elizatest.rocket.service.IClientService;

@RestController
public class ClientController {
	@Autowired
	private IClientService service;
	
	@GetMapping("/clients")
	public ResponseEntity<ArrayList<Client>> getAll(@RequestParam (value="isDeleted", required = false, defaultValue = "false") boolean isDeleted){
		ArrayList<Client> users = service.getAll(isDeleted);
		return ResponseEntity.status(200).body(users);
	}
	
	@PostMapping("/clients")
    public ResponseEntity<Client> addClient(@RequestBody Client client) {
		Client res = service.postClient(client);
		if(res.getEmail().equals(client.getEmail())) {
			return ResponseEntity.status(201).body(client);
		} else {
			return ResponseEntity.status(422).build();
		}
	}	
	
	@PutMapping("/clients/{id}")
	public ResponseEntity<?> update(@RequestBody Client client, @PathVariable Integer id){
		try {
		Client existClient = service.getClientById(id);
		existClient.setId(id);
		service.postClient(client);
		return ResponseEntity.status(200).build();
	} catch (Error e) {
		return ResponseEntity.status(400).build();
    	}
	}
	
	@DeleteMapping("/clients/{id}")
	public void delete(@PathVariable Integer id) {
		try {
			service.deleteClient(id);
		} catch (Error e) {
			ResponseEntity.status(204).build();
    }
	
	}

}
