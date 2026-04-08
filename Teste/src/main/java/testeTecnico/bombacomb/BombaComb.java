package testeTecnico.bombacomb;

import testeTecnico.tipocomb.TipoComb;
import jakarta.persistence.*;

@Entity
public class BombaComb {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "tipo_id", nullable = false) // 🔥 impede null no banco
    private TipoComb tipoComb;

    public Long getId() { return id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public TipoComb getTipoComb() { return tipoComb; }
    public void setTipoComb(TipoComb tipoComb) { this.tipoComb = tipoComb; }
}