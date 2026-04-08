package testeTecnico.dto;

import testeTecnico.dto.TipoCombDTO;

//define quais dados e como eles devem ser retornados para o Usuário
//após serem lapidados nas camadas de service e controller
public class BombaCombOutputDTO {
    private Long id;
    private String name;
    private TipoCombDTO tipoComb;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public TipoCombDTO getTipoComb() { return tipoComb; }
    public void setTipoComb(TipoCombDTO tipoComb) { this.tipoComb = tipoComb; }
}