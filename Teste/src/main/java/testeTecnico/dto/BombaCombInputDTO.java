package testeTecnico.dto;

//recebe dados externos (usuário) para transferir para as camadas de service
//e controller conseguirem manipular
public class BombaCombInputDTO {
    private String name;
    private Long tipoCombId;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Long getTipoCombId() { return tipoCombId; }
    public void setTipoCombId(Long tipoCombId) { this.tipoCombId = tipoCombId; }
}