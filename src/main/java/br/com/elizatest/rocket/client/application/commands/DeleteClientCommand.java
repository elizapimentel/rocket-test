package br.com.elizatest.rocket.client.application.commands;

import br.com.elizatest.rocket.shared.command.ApplicationCommand;

public class DeleteClientCommand implements ApplicationCommand<Void> {
    public final Integer id;

    public DeleteClientCommand(Integer id) {
        this.id = id;
    }
    
    
}
