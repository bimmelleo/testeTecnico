package model;

    //criando a classe padrão para os tipos de combustíveis do posto
public class tipoComb {
    private String name;
    private double precoComb;

    //encapsulamento utilizando os get e set
    public tipoComb(String name, double precoComb) {
        this.name = name;
        this.precoComb = precoComb;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrecoComb () {
        return precoComb;
    }

    public void setPrecoComb (double precoComb) {
        this.precoComb = precoComb;
    }

    //definir como irá ser apreentado os objetos de combustível criados
    @Override
    public String toString() {
        return "Nome: " + name + " | Preço por litro: R$ " + precoComb;
    }
}
