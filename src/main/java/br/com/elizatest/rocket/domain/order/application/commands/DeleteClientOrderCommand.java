package br.com.elizatest.rocket.domain.order.application.commands;

import br.com.elizatest.rocket.shared.command.ApplicationCommand;

public class DeleteClientOrderCommand implements ApplicationCommand<Void> {
    
    public final Integer id;

    public DeleteClientOrderCommand(Integer id) {
        this.id = id;
    }
    
    
}
