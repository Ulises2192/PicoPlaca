package com.example.picoyplaca.models;

public class BitacoraModel {

    String fechaConsulta, numeroPlaca;
    boolean contravecion;

    public BitacoraModel(String fechaConsulta, String numeroPlaca, boolean contravecion) {
        this.fechaConsulta = fechaConsulta;
        this.numeroPlaca = numeroPlaca;
        this.contravecion = contravecion;
    }

    public String getFechaConsulta() {
        return fechaConsulta;
    }

    public void setFechaConsulta(String fechaConsulta) {
        this.fechaConsulta = fechaConsulta;
    }

    public String getNumeroPlaca() {
        return numeroPlaca;
    }

    public void setNumeroPlaca(String numeroPlaca) {
        this.numeroPlaca = numeroPlaca;
    }

    public boolean isContravecion() {
        return contravecion;
    }

    public void setContravecion(boolean contravecion) {
        this.contravecion = contravecion;
    }
}
