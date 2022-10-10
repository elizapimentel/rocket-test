package br.com.elizatest.rocket.client.core.domains;

import br.com.elizatest.rocket.client.core.ClientRepository;

public class ValidateEmailImpl implements ValidateEmail {
    public final ClientRepository clientRepository;

    public ValidateEmailImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public void emailExists(String email) {
        if (clientRepository.emailExists(email)) {
            throw new IllegalArgumentException("email já cadastrado");
        }
        
    }

}
