package com.listadecompras;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ListaDAO {

    public void adicionarItem(Item item) {
        String sql = "INSERT INTO lista (nome, quantidade, comprado) VALUES (?, ?, ?)";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, item.getNome());
            stmt.setInt(2, item.getQuantidade());
            stmt.setBoolean(3, item.isComprado());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Item> listarItens() {
        List<Item> itens = new ArrayList<>();
        String sql = "SELECT * FROM lista";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                itens.add(new Item(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getInt("quantidade"),
                        rs.getBoolean("comprado")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return itens;
    }

    public Item buscarPorId(int id) {
        String sql = "SELECT * FROM lista WHERE id = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Item(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getInt("quantidade"),
                        rs.getBoolean("comprado")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void atualizarItem(Item item) {
        String sql = "UPDATE lista SET nome = ?, quantidade = ?, comprado = ? WHERE id = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, item.getNome());
            stmt.setInt(2, item.getQuantidade());
            stmt.setBoolean(3, item.isComprado());
            stmt.setInt(4, item.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removerItem(int id) {
        String deleteSQL = "DELETE FROM lista WHERE id = ?";
        String reorganizarSQL = "SET @count = 0; " +
                "UPDATE lista SET id = (@count := @count + 1); " +
                "ALTER TABLE lista AUTO_INCREMENT = 1;";
        try (Connection conn = Conexao.conectar();
             PreparedStatement deleteStmt = conn.prepareStatement(deleteSQL)) {

            deleteStmt.setInt(1, id);
            int afetados = deleteStmt.executeUpdate();

            if (afetados > 0) {
                try (Statement stmt = conn.createStatement()) {
                    stmt.execute("SET @count = 0;");
                    stmt.execute("UPDATE lista SET id = (@count := @count + 1);");
                    stmt.execute("ALTER TABLE lista AUTO_INCREMENT = 1;");
                }
            } else {
                System.out.println("Item com ID " + id + " não encontrado.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void marcarComoComprado(int id) {
        String sql = "UPDATE lista SET comprado = TRUE WHERE id = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void desmarcarComoComprado(int id) {
        String sql = "UPDATE lista SET comprado = false WHERE id = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas == 0) {
                System.out.println("Item com ID " + id + " não encontrado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void limparLista() {
        String sqlDelete = "DELETE FROM lista";
        String sqlReset = "ALTER TABLE lista AUTO_INCREMENT = 1";

        try (Connection conn = Conexao.conectar();
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sqlDelete);
            stmt.execute(sqlReset);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
