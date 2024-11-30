package com.models;

public class Meta {
    private int idMeta;
    private int idEmpresa;
    private String descricaoMeta;
    private float percentualReduzir;
    private String statusMeta;

    public Meta() {
    }

    public Meta(String descricaoMeta, float percentualReduzir, String statusMeta, int idEmpresa) {
        this.descricaoMeta = descricaoMeta;
        this.percentualReduzir = percentualReduzir;
        this.statusMeta = statusMeta;
        this.idEmpresa = idEmpresa;
    }

    // Getters e Setters
    public int getIdMeta() {
        return idMeta;
    }

    public void setIdMeta(int idMeta) {
        this.idMeta = idMeta;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getDescricaoMeta() {
        return descricaoMeta;
    }

    public void setDescricaoMeta(String descricaoMeta) {
        this.descricaoMeta = descricaoMeta;
    }

    public float getPercentualReduzir() {
        return percentualReduzir;
    }

    public void setPercentualReduzir(float percentualReduzir) {
        this.percentualReduzir = percentualReduzir;
    }

    public String getStatusMeta() {
        return statusMeta;
    }

    public void setStatusMeta(String statusMeta) {
        this.statusMeta = statusMeta;
    }
}
