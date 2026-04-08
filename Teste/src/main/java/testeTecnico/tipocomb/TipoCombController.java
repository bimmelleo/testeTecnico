package testeTecnico.tipocomb;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import testeTecnico.bombacomb.BombaCombRepository;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/tipos")
public class TipoCombController {

    private final TipoCombRepository repo;
    private final BombaCombRepository bombaRepo;

    public TipoCombController(TipoCombRepository repo, BombaCombRepository bombaRepo) {
        this.repo = repo;
        this.bombaRepo = bombaRepo;
    }

    // 🔹 CREATE
    @PostMapping
    public TipoComb criar(@RequestBody TipoComb tipo) {
        return repo.save(tipo);
    }

    // 🔹 READ
    @GetMapping
    public List<TipoComb> listar() {
        return repo.findAll();
    }

    // 🔹 UPDATE
    @PutMapping("/{id}")
    public TipoComb atualizar(@PathVariable Long id, @RequestBody TipoComb novo) {

        TipoComb tipo = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("TipoComb não encontrado"));

        tipo.setName(novo.getName());
        tipo.setPrecoComb(novo.getPrecoComb());

        return repo.save(tipo);
    }

    // 🔹 DELETE (com validação)
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {

        if (bombaRepo.existsByTipoCombId(id)) {
            throw new RuntimeException("Não é possível deletar: TipoComb está em uso por bombas");
        }

        repo.deleteById(id);
    }
}