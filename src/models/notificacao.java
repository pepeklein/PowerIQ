package com.models;

public class Notificacao {
    private int idNotificacao;
    private int idEmpresa;
    private String tipoNotificacao;
    private String dataEnvio;
    private String mensagem;

    public Notificacao() {
    }

    public Notificacao(String mensagem, String dataEnvio, String tipoNotificacao, int idEmpresa) {
        this.mensagem = mensagem;
        this.dataEnvio = dataEnvio;
        this.tipoNotificacao = tipoNotificacao;
        this.idEmpresa = idEmpresa;
    }

    // Getters e Setters
    public int getIdNotificacao() {
        return idNotificacao;
    }

    public void setIdNotificacao(int idNotificacao) {
        this.idNotificacao = idNotificacao;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getTipoNotificacao() {
        return tipoNotificacao;
    }

    public void setTipoNotificacao(String tipoNotificacao) {
        this.tipoNotificacao = tipoNotificacao;
    }

    public String getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(String dataEnvio) {
        this.dataEnvio = dataEnvio;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
