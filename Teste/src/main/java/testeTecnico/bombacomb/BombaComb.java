package testeTecnico.bombacomb;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import testeTecnico.tipocomb.TipoComb;
import testeTecnico.abastecer.Abastecer;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class BombaComb {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.EAGER) // garante que os dados sejam carregados
    @JoinColumn(name = "tipo_id")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    private TipoComb tipoComb;

    @OneToMany(mappedBy = "bomba")
    private List<Abastecer> abastecimentos;

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