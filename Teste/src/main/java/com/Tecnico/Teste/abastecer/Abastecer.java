package com.Tecnico.Teste.abastecer;

import com.Tecnico.Teste.bombacomb.BombaComb;
import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Abastecer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double valor;
    private double quant;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @ManyToOne
    @JoinColumn(name = "bomba_id")
    private BombaComb bomba;

    public Abastecer() {}

    public Abastecer(BombaComb bomba, Date date, double valor, double quant) {
        this.bomba = bomba;
        this.date = date;
        this.valor = valor;
        this.quant = quant;
    }

    public Long getId() { return id; }

    public double getValor() { return valor; }

    public void setValor(double valor) { this.valor = valor; }

    public double getQuant() { return quant; }

    public void setQuant(double quant) { this.quant = quant; }

    public Date getDate() { return date; }

    public void setDate(Date date) { this.date = date; }

    public BombaComb getBomba() { return bomba; }

    public void setBomba(BombaComb bomba) { this.bomba = bomba; }
}