package com.Tecnico.Teste.bombacomb;

import com.Tecnico.Teste.tipocomb.TipoComb;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class BombaComb {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "tipo_id")
    private TipoComb tipoComb;

    @OneToMany(mappedBy = "bomba")
    private List<com.Tecnico.Teste.abastecer.Abastecer> abastecimentos;

    public BombaComb() {}

    public BombaComb(String name, TipoComb tipoComb) {
        this.name = name;
        this.tipoComb = tipoComb;
    }

    public Long getId() { return id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public TipoComb getTipoComb() { return tipoComb; }

    public void setTipoComb(TipoComb tipoComb) { this.tipoComb = tipoComb; }
}