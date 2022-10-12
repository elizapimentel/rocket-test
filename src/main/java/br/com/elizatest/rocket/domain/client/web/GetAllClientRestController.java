package br.com.elizatest.rocket.domain.client.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.elizatest.rocket.domain.client.application.queries.GetAllClients;
import br.com.elizatest.rocket.shared.query.ApplicationQueryDispatcher;

@RequestMapping
@RestController("get-all-clients")
public class GetAllClientRestController {
    public final ApplicationQueryDispatcher queryDispatcher;

    public GetAllClientRestController(ApplicationQueryDispatcher query) {
        this.queryDispatcher = query;
    }

    @GetMapping("/clients/all")
    public List<GetAllClients.ClientResult> getAllClients() {
        var query = new GetAllClients();
        var result = queryDispatcher.execute(query);
        return result;
    }
    
    
}
