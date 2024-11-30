package com.dao;

import com.models.Empresa;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpresaDAO {
    public void inserir(Empresa empresa) throws SQLException {
        String sql = "INSERT INTO Empresa (ID_Empresa, Nome_Empresa, CNPJ, Endereco, Setor, Plano) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, empresa.getIdEmpresa());
            stmt.setString(2, empresa.getNomeEmpresa());
            stmt.setString(3, empresa.getCnpj());
            stmt.setString(4, empresa.getEndereco());
            stmt.setString(5, empresa.getSetor());
            stmt.setString(6, empresa.getPlano());
            stmt.executeUpdate();
        }
    }

    public List<Empresa> listar() throws SQLException {
        String sql = "SELECT * FROM Empresa";
        List<Empresa> empresas = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Empresa empresa = new Empresa();
                empresa.setIdEmpresa(rs.getInt("ID_Empresa"));
                empresa.setNomeEmpresa(rs.getString("Nome_Empresa"));
                empresa.setCnpj(rs.getString("CNPJ"));
                empresa.setEndereco(rs.getString("Endereco"));
                empresa.setSetor(rs.getString("Setor"));
                empresa.setPlano(rs.getString("Plano"));
                empresas.add(empresa);
            }
        }
        return empresas;
    }

    public void atualizar(Empresa empresa) throws SQLException {
        String sql = "UPDATE Empresa SET Nome_Empresa = ?, CNPJ = ?, Endereco = ?, Setor = ?, Plano = ? WHERE ID_Empresa = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, empresa.getNomeEmpresa());
            stmt.setString(2, empresa.getCnpj());
            stmt.setString(3, empresa.getEndereco());
            stmt.setString(4, empresa.getSetor());
            stmt.setString(5, empresa.getPlano());
            stmt.setInt(6, empresa.getIdEmpresa());
            stmt.executeUpdate();
        }
    }

    public void excluir(int idEmpresa) throws SQLException {
        String sql = "DELETE FROM Empresa WHERE ID_Empresa = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idEmpresa);
            stmt.executeUpdate();
        }
    }
}
