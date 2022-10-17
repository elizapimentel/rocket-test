package br.com.elizatest.rocket.domain.order.application.commands;

import br.com.elizatest.rocket.shared.command.ApplicationCommand;

public class DeleteOrderCommand implements ApplicationCommand<Void>{
        
        public final Integer id;
    
        public DeleteOrderCommand(Integer id) {
            this.id = id;
        }
        
    
}
