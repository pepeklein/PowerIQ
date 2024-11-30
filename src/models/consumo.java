package com.models;

public class Consumo {
    private int idConsumo;
    private int idEmpresa;
    private String categoria;
    private String dataRegistro;
    private float valorConsumo;
    private double custoConsumo;

    public Consumo() {
    }

    public Consumo(String categoria, double custoConsumo, float valorConsumo, String dataRegistro, int idEmpresa) {
        this.categoria = categoria;
        this.custoConsumo = custoConsumo;
        this.valorConsumo = valorConsumo;
        this.dataRegistro = dataRegistro;
        this.idEmpresa = idEmpresa;
    }

    // Getters e Setters
    public int getIdConsumo() {
        return idConsumo;
    }

    public void setIdConsumo(int idConsumo) {
        this.idConsumo = idConsumo;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(String dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public float getValorConsumo() {
        return valorConsumo;
    }

    public void setValorConsumo(float valorConsumo) {
        this.valorConsumo = valorConsumo;
    }

    public double getCustoConsumo() {
        return custoConsumo;
    }

    public void setCustoConsumo(double custoConsumo) {
        this.custoConsumo = custoConsumo;
    }
}
