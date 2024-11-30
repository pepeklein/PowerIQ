package com.dao;

import com.models.Fatura;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FaturaDAO {
    public void inserir(Fatura fatura) throws SQLException {
        String sql = "INSERT INTO Fatura (ID_Fatura, ID_Empresa, Mes_Referencia, Valor_Total, Data_Emissao) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, fatura.getIdFatura());
            stmt.setInt(2, fatura.getIdEmpresa());
            stmt.setDate(3, Date.valueOf(fatura.getMesReferencia()));
            stmt.setDouble(4, fatura.getValorTotal());
            stmt.setDate(5, Date.valueOf(fatura.getDataEmissao()));
            stmt.executeUpdate();
        }
    }

    public List<Fatura> listar() throws SQLException {
        String sql = "SELECT * FROM Fatura";
        List<Fatura> faturas = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Fatura fatura = new Fatura();
                fatura.setIdFatura(rs.getInt("ID_Fatura"));
                fatura.setIdEmpresa(rs.getInt("ID_Empresa"));
                fatura.setMesReferencia(rs.getDate("Mes_Referencia").toString());
                fatura.setValorTotal(rs.getDouble("Valor_Total"));
                fatura.setDataEmissao(rs.getDate("Data_Emissao").toString());
                faturas.add(fatura);
            }
        }
        return faturas;
    }

    public void atualizar(Fatura fatura) throws SQLException {
        String sql = "UPDATE Fatura SET ID_Empresa = ?, Mes_Referencia = ?, Valor_Total = ?, Data_Emissao = ? WHERE ID_Fatura = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, fatura.getIdEmpresa());
            stmt.setDate(2, Date.valueOf(fatura.getMesReferencia()));
            stmt.setDouble(3, fatura.getValorTotal());
            stmt.setDate(4, Date.valueOf(fatura.getDataEmissao()));
            stmt.setInt(5, fatura.getIdFatura());
            stmt.executeUpdate();
        }
    }

    public void excluir(int idFatura) throws SQLException {
        String sql = "DELETE FROM Fatura WHERE ID_Fatura = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idFatura);
            stmt.executeUpdate();
        }
    }
}
