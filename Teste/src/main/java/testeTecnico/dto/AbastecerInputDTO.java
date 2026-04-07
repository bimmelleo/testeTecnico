package testeTecnico.dto;

public class AbastecerInputDTO {
    private double quant; // quantidade de litros ou unidades
    // Não precisa do valor, vamos calcular a partir da bomba

    public double getQuant() { return quant; }
    public void setQuant(double quant) { this.quant = quant; }
}
