package testeTecnico.bombacomb;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/bombas")
public class BombaCombController {

    private final BombaCombService service;

    public BombaCombController(BombaCombService service) {
        this.service = service;
    }

    @PostMapping("/tipo/{tipoId}")
    public BombaComb criar(@PathVariable Long tipoId,
                           @RequestBody BombaComb b) {
        return service.criar(tipoId, b);
    }

    @GetMapping
    public List<BombaComb> listar() {
        return service.listar();
    }
}