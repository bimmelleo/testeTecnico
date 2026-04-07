package testeTecnico.tipocomb;

import org.springframework.web.bind.annotation.*;
import java.util.List;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/tipos")
public class TipoCombController {

    private final TipoCombRepository repo;

    public TipoCombController(TipoCombRepository repo) {
        this.repo = repo;
    }

    @PostMapping
    public TipoComb criar(@RequestBody TipoComb tipo) {
        return repo.save(tipo);
    }

    @GetMapping
    public List<TipoComb> listar() {
        return repo.findAll();
    }
}