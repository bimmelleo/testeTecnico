package com.Tecnico.Teste.abastecer;

import com.Tecnico.Teste.bombacomb.BombaComb;
import com.Tecnico.Teste.bombacomb.BombaCombRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbastecerService {

    private final AbastecerRepository repo;
    private final BombaCombRepository bombaRepo;

    public AbastecerService(AbastecerRepository repo, BombaCombRepository bombaRepo) {
        this.repo = repo;
        this.bombaRepo = bombaRepo;
    }

    public Abastecer criar(Long bombaId, Abastecer a) {
        BombaComb bomba = bombaRepo.findById(bombaId)
                .orElseThrow(() -> new RuntimeException("Bomba não encontrada"));

        a.setBomba(bomba);
        return repo.save(a);
    }

    public List<Abastecer> listar() {
        return repo.findAll();
    }
}