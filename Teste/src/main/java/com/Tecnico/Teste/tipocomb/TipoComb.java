package com.Tecnico.Teste.tipocomb;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class TipoComb {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double precoComb;

    @OneToMany(mappedBy = "tipoComb")
    private List<com.Tecnico.Teste.bombacomb.BombaComb> bombas;

    public TipoComb() {}

    public TipoComb(String name, double precoComb) {
        this.name = name;
        this.precoComb = precoComb;
    }

    public Long getId() { return id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public double getPrecoComb() { return precoComb; }

    public void setPrecoComb(double precoComb) { this.precoComb = precoComb; }
}