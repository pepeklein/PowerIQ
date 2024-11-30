package com.dao;

import com.models.Meta;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MetaDAO {
    public void inserir(Meta meta) throws SQLException {
        String sql = "INSERT INTO Meta (ID_Meta, ID_Empresa, Descricao_Meta, Percentual_Reduzir, Status_Meta) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, meta.getIdMeta());
            stmt.setInt(2, meta.getIdEmpresa());
            stmt.setString(3, meta.getDescricaoMeta());
            stmt.setFloat(4, meta.getPercentualReduzir());
            stmt.setString(5, meta.getStatusMeta());
            stmt.executeUpdate();
        }
    }

    public List<Meta> listar() throws SQLException {
        String sql = "SELECT * FROM Meta";
        List<Meta> metas = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Meta meta = new Meta();
                meta.setIdMeta(rs.getInt("ID_Meta"));
                meta.setIdEmpresa(rs.getInt("ID_Empresa"));
                meta.setDescricaoMeta(rs.getString("Descricao_Meta"));
                meta.setPercentualReduzir(rs.getFloat("Percentual_Reduzir"));
                meta.setStatusMeta(rs.getString("Status_Meta"));
                metas.add(meta);
            }
        }
        return metas;
    }

    public void atualizar(Meta meta) throws SQLException {
        String sql = "UPDATE Meta SET ID_Empresa = ?, Descricao_Meta = ?, Percentual_Reduzir = ?, Status_Meta = ? WHERE ID_Meta = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, meta.getIdEmpresa());
            stmt.setString(2, meta.getDescricaoMeta());
            stmt.setFloat(3, meta.getPercentualReduzir());
            stmt.setString(4, meta.getStatusMeta());
            stmt.setInt(5, meta.getIdMeta());
            stmt.executeUpdate();
        }
    }

    public void excluir(int idMeta) throws SQLException {
        String sql = "DELETE FROM Meta WHERE ID_Meta = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idMeta);
            stmt.executeUpdate();
        }
    }
}
