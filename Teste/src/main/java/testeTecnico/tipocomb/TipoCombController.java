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

    //metodo para criação dos tipos
    @PostMapping
    public TipoComb criar(@RequestBody TipoComb tipo) {
        return repo.save(tipo);
    }

    //metodo para listagem dos tipos
    @GetMapping
    public List<TipoComb> listar() {
        return repo.findAll();
    }

    //metodo para atualização dos tipos de combustível pelo ID
    @PutMapping("/{id}")
    public TipoComb atualizar(@PathVariable Long id, @RequestBody TipoComb novo) {

        TipoComb tipo = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("TipoComb não encontrado"));

        tipo.setName(novo.getName());
        tipo.setPrecoComb(novo.getPrecoComb());

        return repo.save(tipo);
    }

    //metodo para deletar tipos pelo ID com uma validação se existe alguma relação
    //de tipo com bombas
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {

        if (bombaRepo.existsByTipoCombId(id)) {
            throw new RuntimeException("Não é possível deletar: TipoComb está em uso por bombas");
        }

        repo.deleteById(id);
    }
}