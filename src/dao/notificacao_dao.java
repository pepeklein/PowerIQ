package com.dao;

import com.models.Notificacao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NotificacaoDAO {
    public void inserir(Notificacao notificacao) throws SQLException {
        String sql = "INSERT INTO Notificacao (ID_Notificacao, ID_Empresa, Tipo_Notificacao, Data_Envio, Mensagem) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, notificacao.getIdNotificacao());
            stmt.setInt(2, notificacao.getIdEmpresa());
            stmt.setString(3, notificacao.getTipoNotificacao());
            stmt.setTimestamp(4, Timestamp.valueOf(notificacao.getDataEnvio()));
            stmt.setString(5, notificacao.getMensagem());
            stmt.executeUpdate();
        }
    }

    public List<Notificacao> listar() throws SQLException {
        String sql = "SELECT * FROM Notificacao";
        List<Notificacao> notificacoes = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Notificacao notificacao = new Notificacao();
                notificacao.setIdNotificacao(rs.getInt("ID_Notificacao"));
                notificacao.setIdEmpresa(rs.getInt("ID_Empresa"));
                notificacao.setTipoNotificacao(rs.getString("Tipo_Notificacao"));
                notificacao.setDataEnvio(rs.getTimestamp("Data_Envio").toString());
                notificacao.setMensagem(rs.getString("Mensagem"));
                notificacoes.add(notificacao);
            }
        }
        return notificacoes;
    }

    public void atualizar(Notificacao notificacao) throws SQLException {
        String sql = "UPDATE Notificacao SET ID_Empresa = ?, Tipo_Notificacao = ?, Data_Envio = ?, Mensagem = ? WHERE ID_Notificacao = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, notificacao.getIdEmpresa());
            stmt.setString(2, notificacao.getTipoNotificacao());
            stmt.setTimestamp(3, Timestamp.valueOf(notificacao.getDataEnvio()));
            stmt.setString(4, notificacao.getMensagem());
            stmt.setInt(5, notificacao.getIdNotificacao());
            stmt.executeUpdate();
        }
    }

    public void excluir(int idNotificacao) throws SQLException {
        String sql = "DELETE FROM Notificacao WHERE ID_Notificacao = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idNotificacao);
            stmt.executeUpdate();
        }
    }
}
