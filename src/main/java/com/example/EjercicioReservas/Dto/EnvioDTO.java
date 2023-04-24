package com.example.EjercicioReservas.Dto;

public class EnvioDTO {

    private  String numeroGuia;
    private Integer cedula;
    private String ciudadOrigen;
    private  String ciudadDestino;
    private String direccionDestino;
    private String nombreRecibe;
    private Integer celularRecibe;
    private String horaEntrega;
    private String estadoEnvio;
    private Double valorEnvio;
    private Integer peso;
    private  double valorDeclarado;
    private Integer idPaquete;


    public EnvioDTO() {
    }

    public EnvioDTO( Integer cedula, String ciudadOrigen, String ciudadDestino, String direccionDestino, String nombreRecibe, Integer celularRecibe, String horaEntrega, String estadoEnvio, Double valorEnvio, Integer peso, double valorDeclarado, Integer idPaquete) {

        this.cedula = cedula;
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        this.direccionDestino = direccionDestino;
        this.nombreRecibe = nombreRecibe;
        this.celularRecibe = celularRecibe;
        this.horaEntrega = horaEntrega;
        this.estadoEnvio = estadoEnvio;
        this.valorEnvio = valorEnvio;
        this.peso = peso;
        this.valorDeclarado = valorDeclarado;
        this.idPaquete = idPaquete;
    }

    public EnvioDTO(String numeroGuia) {
        this.numeroGuia = numeroGuia;
    }

    public EnvioDTO(String numeroGuia, String direccionDestino, Double valorEnvio) {

    }

    public String getNumeroGuia() {
        return numeroGuia;
    }

    public void setNumeroGuia(String numeroGuia) {
        this.numeroGuia = numeroGuia;
    }

    public Integer getCedula() {
        return cedula;
    }

    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }

    public String getCiudadOrigen() {
        return ciudadOrigen;
    }

    public void setCiudadOrigen(String ciudadOrigen) {
        this.ciudadOrigen = ciudadOrigen;
    }

    public String getCiudadDestino() {
        return ciudadDestino;
    }

    public void setCiudadDestino(String ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }

    public String getDireccionDestino() {
        return direccionDestino;
    }

    public void setDireccionDestino(String direccionDestino) {
        this.direccionDestino = direccionDestino;
    }

    public String getNombreRecibe() {
        return nombreRecibe;
    }

    public void setNombreRecibe(String nombreRecibe) {
        this.nombreRecibe = nombreRecibe;
    }

    public Integer getCelularRecibe() {
        return celularRecibe;
    }

    public void setCelularRecibe(Integer celularRecibe) {
        this.celularRecibe = celularRecibe;
    }

    public String getHoraEntrega() {
        return horaEntrega;
    }

    public void setHoraEntrega(String horaEntrega) {
        this.horaEntrega = horaEntrega;
    }

    public String getEstadoEnvio() {
        return estadoEnvio;
    }

    public void setEstadoEnvio(String estadoEnvio) {
        this.estadoEnvio = estadoEnvio;
    }

    public Double getValorEnvio() {
        return valorEnvio;
    }

    public void setValorEnvio(Double valorEnvio) {
        this.valorEnvio = valorEnvio;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public double getValorDeclarado() {
        return valorDeclarado;
    }

    public void setValorDeclarado(double valorDeclarado) {
        this.valorDeclarado = valorDeclarado;
    }

    public Integer getIdPaquete() {
        return idPaquete;
    }

    public void setIdPaquete(Integer idPaquete) {
        this.idPaquete = idPaquete;
    }
}
