package testeTecnico.abastecer;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/abastecimentos")
public class AbastecerController {

    private final AbastecerService service;

    public AbastecerController(AbastecerService service) {
        this.service = service;
    }

    @PostMapping("/bomba/{bombaId}")
    public Abastecer criar(@PathVariable Long bombaId,
                           @RequestBody Abastecer a) {
        return service.criar(bombaId, a);
    }

    @GetMapping
    public List<Abastecer> listar() {
        return service.listar();
    }
}