package br.com.elizatest.rocket.shared.infrastructure.event;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.elizatest.rocket.shared.event.ApplicationEventBus;

@Configuration
public class ApplicationEventConfiguration {

    @Bean
    public ApplicationEventBus eventBus() {
        return new InProcessApplicationEventBus();
    }
}
