package br.com.elizatest.rocket.shared.infrastructure.query;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.elizatest.rocket.shared.query.ApplicationQueryDispatcher;

@Configuration
public class QueryConfiguration {
    @Bean
    ApplicationQueryDispatcher InProcessApplicationQueryDispatcher() {
        return new InProcessApplicationQueryDispatcher();
    }
}
