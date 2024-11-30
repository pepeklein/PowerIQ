package com.dao;

import com.models.Simulacao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SimulacaoDAO {
    public void inserir(Simulacao simulacao) throws SQLException {
        String sql = "INSERT INTO Simulacao (ID_Simulacao, ID_Empresa, Tipo_Energia, Economia_Anual, Custo_Investimento, Retorno_Investimento) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, simulacao.getIdSimulacao());
            stmt.setInt(2, simulacao.getIdEmpresa());
            stmt.setString(3, simulacao.getTipoEnergia());
            stmt.setDouble(4, simulacao.getEconomiaAnual());
            stmt.setDouble(5, simulacao.getCustoInvestimento());
            stmt.setInt(6, simulacao.getRetornoInvestimento());
            stmt.executeUpdate();
        }
    }

    public List<Simulacao> listar() throws SQLException {
        String sql = "SELECT * FROM Simulacao";
        List<Simulacao> simulacoes = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Simulacao simulacao = new Simulacao();
                simulacao.setIdSimulacao(rs.getInt("ID_Simulacao"));
                simulacao.setIdEmpresa(rs.getInt("ID_Empresa"));
                simulacao.setTipoEnergia(rs.getString("Tipo_Energia"));
                simulacao.setEconomiaAnual(rs.getDouble("Economia_Anual"));
                simulacao.setCustoInvestimento(rs.getDouble("Custo_Investimento"));
                simulacao.setRetornoInvestimento(rs.getInt("Retorno_Investimento"));
                simulacoes.add(simulacao);
            }
        }
        return simulacoes;
    }

    public void atualizar(Simulacao simulacao) throws SQLException {
        String sql = "UPDATE Simulacao SET ID_Empresa = ?, Tipo_Energia = ?, Economia_Anual = ?, Custo_Investimento = ?, Retorno_Investimento = ? WHERE ID_Simulacao = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, simulacao.getIdEmpresa());
            stmt.setString(2, simulacao.getTipoEnergia());
            stmt.setDouble(3, simulacao.getEconomiaAnual());
            stmt.setDouble(4, simulacao.getCustoInvestimento());
            stmt.setInt(5, simulacao.getRetornoInvestimento());
            stmt.setInt(6, simulacao.getIdSimulacao());
            stmt.executeUpdate();
        }
    }

    public void excluir(int idSimulacao) throws SQLException {
        String sql = "DELETE FROM Simulacao WHERE ID_Simulacao = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idSimulacao);
            stmt.executeUpdate();
        }
    }
}
