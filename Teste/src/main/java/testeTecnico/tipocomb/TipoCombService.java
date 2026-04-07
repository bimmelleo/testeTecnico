package testeTecnico.tipocomb;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TipoCombService {

    private final TipoCombRepository repository;

    public TipoCombService(TipoCombRepository repository) {
        this.repository = repository;
    }

    public TipoComb criar(TipoComb t) {
        return repository.save(t);
    }

    public List<TipoComb> listar() {
        return repository.findAll();
    }

    public TipoComb buscar(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tipo não encontrado"));
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}