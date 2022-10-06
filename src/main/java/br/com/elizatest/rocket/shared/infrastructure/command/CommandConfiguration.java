package br.com.elizatest.rocket.shared.infrastructure.command;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.elizatest.rocket.shared.command.ApplicationCommandDispatcher;

@Configuration
public class CommandConfiguration {
    @Bean
    ApplicationCommandDispatcher inProcessApplicationCommandDispatcher() {
        return new InProcessApplicationCommandDispatcher();
    }
}
