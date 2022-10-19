package br.com.elizatest.rocket.domain.order.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.elizatest.rocket.domain.order.application.queries.GetOrderById;
import br.com.elizatest.rocket.shared.query.ApplicationQueryDispatcher;

@RequestMapping
@RestController("get-order-by-id")
public class GetOrderByIdRestController {
    public final ApplicationQueryDispatcher queryDispatcher;

    public GetOrderByIdRestController(ApplicationQueryDispatcher queryDispatcher) {
        this.queryDispatcher = queryDispatcher;
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<?> getOrderById(@PathVariable Integer id) {
        try {
            var query = new GetOrderById(id);
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
