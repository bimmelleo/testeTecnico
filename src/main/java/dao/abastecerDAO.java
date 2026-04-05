package dao;

import model.abastecer;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class abastecerDAO {

    // CREATE
    public boolean inserir(abastecer a) {
        String sql = "INSERT INTO abastecimento (bomba, data, valor, quantidade) VALUES (?, ?, ?, ?)";

        try (Connection conn = conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, a.getBomba());
            stmt.setDate(2, new Date(a.getDate().getTime()));
            stmt.setDouble(3, a.getValor());
            stmt.setDouble(4, a.getQuant());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Erro ao inserir: " + e.getMessage());
            return false;
        }
    }


    public List<abastecer> listar() {
        List<abastecer> lista = new ArrayList<>();
        String sql = "SELECT * FROM abastecimento";

        try (Connection conn = conexao.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                abastecer a = new abastecer(
                        rs.getString("bomba"),
                        rs.getDate("data"),
                        rs.getDouble("valor"),
                        rs.getDouble("quantidade")
                );

                a.setIdAbast(rs.getInt("id"));

                lista.add(a);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar: " + e.getMessage());
        }

        return lista;
    }


    public abastecer buscarPorId(int id) {
        String sql = "SELECT * FROM abastecimento WHERE id = ?";

        try (Connection conn = conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                abastecer a = new abastecer(
                        rs.getString("bomba"),
                        rs.getDate("data"),
                        rs.getDouble("valor"),
                        rs.getDouble("quantidade")
                );

                a.setIdAbast(rs.getInt("id"));

                return a;
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar: " + e.getMessage());
        }

        return null;
    }


    public boolean atualizar(abastecer a) {
        String sql = "UPDATE abastecimento SET bomba=?, data=?, valor=?, quantidade=? WHERE id=?";

        try (Connection conn = conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, a.getBomba());
            stmt.setDate(2, new java.sql.Date(a.getDate().getTime()));
            stmt.setDouble(3, a.getValor());
            stmt.setDouble(4, a.getQuant());
            stmt.setInt(5, a.getIdAbast());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar: " + e.getMessage());
            return false;
        }
    }


    public boolean deletar(int id) {
        String sql = "DELETE FROM abastecimento WHERE id = ?";

        try (Connection conn = conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Erro ao deletar: " + e.getMessage());
            return false;
        }
    }
}