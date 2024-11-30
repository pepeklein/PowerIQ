package com.dao;

import com.models.Consumo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConsumoDAO {
    public void inserir(Consumo consumo) throws SQLException {
        String sql = "INSERT INTO Consumo (ID_Consumo, ID_Empresa, Categoria, Data_Registro, Valor_Consumo, Custo_Consumo) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, consumo.getIdConsumo());
            stmt.setInt(2, consumo.getIdEmpresa());
            stmt.setString(3, consumo.getCategoria());
            stmt.setDate(4, Date.valueOf(consumo.getDataRegistro()));
            stmt.setFloat(5, consumo.getValorConsumo());
            stmt.setDouble(6, consumo.getCustoConsumo());
            stmt.executeUpdate();
        }
    }

    public List<Consumo> listar() throws SQLException {
        String sql = "SELECT * FROM Consumo";
        List<Consumo> consumos = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Consumo consumo = new Consumo();
                consumo.setIdConsumo(rs.getInt("ID_Consumo"));
                consumo.setIdEmpresa(rs.getInt("ID_Empresa"));
                consumo.setCategoria(rs.getString("Categoria"));
                consumo.setDataRegistro(rs.getDate("Data_Registro").toString());
                consumo.setValorConsumo(rs.getFloat("Valor_Consumo"));
                consumo.setCustoConsumo(rs.getDouble("Custo_Consumo"));
                consumos.add(consumo);
            }
        }
        return consumos;
    }

    public void atualizar(Consumo consumo) throws SQLException {
        String sql = "UPDATE Consumo SET ID_Empresa = ?, Categoria = ?, Data_Registro = ?, Valor_Consumo = ?, Custo_Consumo = ? WHERE ID_Consumo = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, consumo.getIdEmpresa());
            stmt.setString(2, consumo.getCategoria());
            stmt.setDate(3, Date.valueOf(consumo.getDataRegistro()));
            stmt.setFloat(4, consumo.getValorConsumo());
            stmt.setDouble(5, consumo.getCustoConsumo());
            stmt.setInt(6, consumo.getIdConsumo());
            stmt.executeUpdate();
        }
    }

    public void excluir(int idConsumo) throws SQLException {
        String sql = "DELETE FROM Consumo WHERE ID_Consumo = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idConsumo);
            stmt.executeUpdate();
        }
    }
}
