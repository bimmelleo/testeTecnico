package testeTecnico.dto;

//recebe dados externos (usuário) para transferir para as camadas de service
//e controller conseguirem manipular
public class AbastecerInputDTO {

    private Double quant;

    public Double getQuant() {
        return quant;
    }

    public void setQuant(Double quant) {
        this.quant = quant;
    }
}
