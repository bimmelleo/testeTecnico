package testeTecnico.tipocomb;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import testeTecnico.bombacomb.BombaComb;
import jakarta.persistence.*;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TipoComb {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double precoComb;

    @OneToMany(mappedBy = "tipoComb")
    private List<BombaComb> bombas;

    public TipoComb() {}

    public TipoComb(String name, Double precoComb) {
        this.name = name;
        this.precoComb = precoComb;
    }

    public Long getId() { return id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Double getPrecoComb() { return precoComb; }

    public void setPrecoComb(Double precoComb) { this.precoComb = precoComb; }
}