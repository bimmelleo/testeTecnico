package org.example;

public class Main {
    public static void main(String[] args) {

        //criando o objeto service para conseguir aplicar
        //os métodos de TipoCombService
        TipoCombService service = new TipoCombService();

        //criando/adicionando os objetos combustiveis
        service.adicionar(new tipoComb("Gasolina Adtivada", 6.49));
        service.adicionar(new tipoComb("Gasolina Comum", 6.59));
        service.adicionar(new tipoComb("Etanol", 4.99));

        //listando os combustiveis
        //com a variável t que recebe a cada "volta" do for um item
        System.out.println("Lista:");
        for (tipoComb t : service.listar()) {
            System.out.println(t);
        }

        //alterando informações dos combustiveis
        //apenas adicionando as informações atualizadas
        service.atualizar("Gasolina Comum", 6.49);
        service.atualizar("Gasolina Adtivada", 6.59);

        //função simples para remover um item
        service.remover("Etanol");

        //mesma ideia da listagem anterior
        //agora aparecerá tudo com as informações atualizadas
        System.out.println("\nApós alterações:");
        for (tipoComb t : service.listar()) {
            System.out.println(t);
        }
    }
}
