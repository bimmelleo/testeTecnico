package com.Tecnico.Teste.tipocomb;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/tipos")
public class TipoCombController {

    private final TipoCombService service;

    public TipoCombController(TipoCombService service) {
        this.service = service;
    }

    @PostMapping
    public TipoComb criar(@RequestBody TipoComb t) {
        return service.criar(t);
    }

    @GetMapping
    public List<TipoComb> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public TipoComb buscar(@PathVariable Long id) {
        return service.buscar(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}