package com.Tecnico.Teste.bombacomb;

import com.Tecnico.Teste.tipocomb.TipoComb;
import com.Tecnico.Teste.tipocomb.TipoCombRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BombaCombService {

    private final BombaCombRepository repo;
    private final TipoCombRepository tipoRepo;

    public BombaCombService(BombaCombRepository repo, TipoCombRepository tipoRepo) {
        this.repo = repo;
        this.tipoRepo = tipoRepo;
    }

    public BombaComb criar(Long tipoId, BombaComb b) {
        TipoComb tipo = tipoRepo.findById(tipoId)
                .orElseThrow(() -> new RuntimeException("Tipo não encontrado"));

        b.setTipoComb(tipo);
        return repo.save(b);
    }

    public List<BombaComb> listar() {
        return repo.findAll();
    }
}