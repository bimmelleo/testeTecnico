package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) throws SQLException {
        Connection conexao = null;

        try {
            Class.forName("org.postgresql.Driver");
            conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BancoPostgre","bimmelleo","123456");
            ResultSet resultado = conexao.createStatement().executeQuery("SELECT * FROM CLIENT");
            while (resultado.next()) {
                System.out.println("Nome: " + resultado.getString("name"));
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver do Banco de Dados NÃO LOCALIZADO.");
        } catch ( SQLException ex) {
            System.out.println("ERRO de conexão com Banco de Dados: " + ex.getMessage());
        } finally {
            if (conexao != null){
                conexao.close();
            }
        }



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
