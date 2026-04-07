package testeTecnico.abastecer;

import testeTecnico.bombacomb.BombaComb;
import testeTecnico.bombacomb.BombaCombRepository;
import org.springframework.stereotype.Service;
import testeTecnico.dto.AbastecerInputDTO;

import java.util.Date;
import java.util.List;

@Service
public class AbastecerService {

    private final AbastecerRepository repo;
    private final BombaCombRepository bombaRepo;

    public AbastecerService(AbastecerRepository repo, BombaCombRepository bombaRepo) {
        this.repo = repo;
        this.bombaRepo = bombaRepo;
    }

    public Abastecer criar(Long bombaId, AbastecerInputDTO dto) {

        if (dto.getQuant() <= 0) {
            throw new RuntimeException("Quantidade deve ser maior que zero");
        }

        BombaComb bomba = bombaRepo.findById(bombaId)
                .orElseThrow(() -> new RuntimeException("Bomba não encontrada"));

        Abastecer a = new Abastecer();
        a.setBomba(bomba);
        a.setQuant(dto.getQuant());

        double preco = bomba.getTipoComb().getPrecoComb();

        double valor = dto.getQuant() * preco;

        // arredondamento (2 casas decimais)
        valor = Math.round(valor * 100.0) / 100.0;

        a.setValor(valor);
        a.setDate(new Date());

        return repo.save(a);
    }

    public List<Abastecer> listar() {
        return repo.findAll();
    }
}