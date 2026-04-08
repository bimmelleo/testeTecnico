package testeTecnico.dto;

import testeTecnico.dto.BombaCombOutputDTO;
import java.util.Date;

//define quais dados e como eles devem ser retornados para o Usuário
//após serem lapidados nas camadas de service e controller
public class AbastecerOutputDTO {
    private Long id;
    private double valor;
    private double quant;
    private Date date;
    private BombaCombOutputDTO bomba;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public double getValor() { return valor; }
    public void setValor(double valor) { this.valor = valor; }

    public double getQuant() { return quant; }
    public void setQuant(double quant) { this.quant = quant; }

    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }

    public BombaCombOutputDTO getBomba() { return bomba; }
    public void setBomba(BombaCombOutputDTO bomba) { this.bomba = bomba; }
}