package br.com.elizatest.rocket.client.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.elizatest.rocket.client.application.queries.GetClientById;
import br.com.elizatest.rocket.client.application.queries.GetClientById.ClientResult;
import br.com.elizatest.rocket.shared.query.ApplicationQueryDispatcher;

@RequestMapping
@RestController("get-client-by-id")
public class GetClientByIdRestController {
    public final ApplicationQueryDispatcher queryDispatcher;
    

    public GetClientByIdRestController(ApplicationQueryDispatcher queryDispatcher) {
        this.queryDispatcher = queryDispatcher;
    }

    @GetMapping("/client/{id}")
    public ResponseEntity<?> getClientById(@PathVariable Integer id) {
        try{
            var query = new GetClientById(id);
            var result = queryDispatcher.execute(query);
            return ResponseEntity.ok(result);
        } catch (IllegalStateException | IllegalArgumentException i) {
            i.printStackTrace();
            return ResponseEntity.unprocessableEntity().body(i.getMessage());
        }
        catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        } 
    }
    
}
