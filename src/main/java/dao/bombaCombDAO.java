package dao;

import model.bombaComb;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class bombaCombDAO {

    // CREATE
    public boolean inserir(bombaComb a) {
        String sql = "INSERT INTO bombaComb (name, combAbast) VALUES (?, ?)";

        try (Connection conn = conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, a.getName());
            stmt.setString(2, a.getCombAbast());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Erro ao inserir: " + e.getMessage());
            return false;
        }
    }

    // READ (LISTAR)
    public List<bombaComb> listar() {
        List<bombaComb> lista = new ArrayList<>();
        String sql = "SELECT * FROM bombaComb";

        try (Connection conn = conexao.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                bombaComb a = new bombaComb(
                        rs.getString("name"),
                        rs.getString("combAbast")
                );
                lista.add(a);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar: " + e.getMessage());
        }
        return lista;
    }

    // READ (BUSCAR POR NAME)
    public bombaComb buscarPorName(String name) {
        String sql = "SELECT * FROM bombaComb WHERE name = ?";

        try (Connection conn = conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                bombaComb a = new bombaComb(
                        rs.getString("name"),
                        rs.getString("combAbast")
                );
                return a;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar: " + e.getMessage());
        }
        return null;
    }

    // UPDATE
    public boolean atualizar(bombaComb a) {
        String sql = "UPDATE bombaComb SET name=?, combAbast=? WHERE name=?";

        try (Connection conn = conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, a.getName());
            stmt.setString(2, a.getCombAbast());
            stmt.setString(3, a.getName());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar: " + e.getMessage());
            return false;
        }
    }

    // DELETE
    public boolean deletar(String name) {
        String sql = "DELETE FROM bombaComb WHERE name = ?";

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