package testeTecnico.dto;

//necessario para que os outros Input e Output consigam transferir os dados de tipo
//para as camadas de service
public class TipoCombDTO {
    private Long id;
    private String name;
    private Double precoComb;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Double getPrecoComb() { return precoComb; }
    public void setPrecoComb(Double precoComb) { this.precoComb = precoComb; }
}