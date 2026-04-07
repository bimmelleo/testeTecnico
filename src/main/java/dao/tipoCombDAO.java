package dao;

import model.tipoComb;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class tipoCombDAO {


    public boolean inserir(tipoComb a) {
        String sql = "INSERT INTO tipoComb (name, precoComb) VALUES (?, ?)";

        try (Connection conn = conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, a.getName());
            stmt.setDouble(2, a.getPrecoComb());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Erro ao inserir: " + e.getMessage());
            return false;
        }
    }


    public List<tipoComb> listar() {
        List<tipoComb> lista = new ArrayList<>();
        String sql = "SELECT * FROM tipoComb";

        try (Connection conn = conexao.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                tipoComb a = new tipoComb(
                        rs.getString("name"),
                        rs.getDouble("precoComb")
                );
                lista.add(a);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar: " + e.getMessage());
        }
        return lista;
    }


    public tipoComb buscarPorName(String name) {
        String sql = "SELECT * FROM tipoComb WHERE name = ?";

        try (Connection conn = conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                tipoComb a = new tipoComb(
                        rs.getString("name"),
                        rs.getDouble("precoComb")
                );
                return a;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar: " + e.getMessage());
        }
        return null;
    }


    public boolean atualizar(tipoComb a) {
        String sql = "UPDATE tipoComb SET name=?, precoComb=? WHERE name=?";

        try (Connection conn = conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, a.getName());
            stmt.setDouble(2, a.getPrecoComb());
            stmt.setString(3, a.getName());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar: " + e.getMessage());
            return false;
        }
    }


    public boolean deletar(String name) {
        String sql = "DELETE FROM tipoComb WHERE name = ?";

        try (Connection conn = conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, name);

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao deletar: " + e.getMessage());
            return false;
        }
    }
}