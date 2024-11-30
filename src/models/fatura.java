package com.models;

public class Fatura {
    private int idFatura;
    private int idEmpresa;
    private String mesReferencia;
    private double valorTotal;
    private String dataEmissao;

    public Fatura() {
    }

    public Fatura(String dataEmissao, double valorTotal, String mesReferencia, int idEmpresa) {
        this.dataEmissao = dataEmissao;
        this.valorTotal = valorTotal;
        this.mesReferencia = mesReferencia;
        this.idEmpresa = idEmpresa;
    }

    // Getters e Setters
    public int getIdFatura() {
        return idFatura;
    }

    public void setIdFatura(int idFatura) {
        this.idFatura = idFatura;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getMesReferencia() {
        return mesReferencia;
    }

    public void setMesReferencia(String mesReferencia) {
        this.mesReferencia = mesReferencia;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(String dataEmissao) {
        this.dataEmissao = dataEmissao;
    }
}
