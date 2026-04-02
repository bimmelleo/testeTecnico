package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class conexao {

    public static void main(String[] args) throws SQLException {
        Connection conexao = null;

        try {
            Class.forName("org.postgresql.Driver");
            conexao = DriverManager.getConnection
                    ("jdbc:postgresql://localhost:5432/postgres",
                            "bimmelleo", "123456");
            ResultSet resultado = conexao.createStatement().executeQuery("SELECT * FROM PUBLIC.ABASTECIMENTO");
            while (resultado.next()) {
                System.out.println("Nome: " + resultado.getString("ID"));
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver do Banco de Dados NÃO LOCALIZADO.");
        } catch (SQLException ex) {
            System.out.println("ERRO de conexão com Banco de Dados: " + ex.getMessage());
        } finally {
            if (conexao != null) {
                conexao.close();
            }
        }
    }
}