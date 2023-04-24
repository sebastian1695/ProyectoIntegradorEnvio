package com.example.EjercicioReservas.Dto;

public class EnvioDetalleDTO {
    private Integer numGuia;
    private String numeroGuia;
    private String numeroGuia1;
    private String direccionDestino;
    private Integer cedulaCliente;
    private String nombreCliente;
    private String ciudadOrigen;
    private String ciudadDestino;
    private String dirDestino;
    private String nombreRecibe;
    private Integer celularRecibe;
    private double valorDeclarado;
    private double peso;
    private double valorEnvio;

    public EnvioDetalleDTO(Integer numGuia, Integer cedulaCliente, String nombreCliente, String ciudadOrigen, String ciudadDestino, String dirDestino, String nombreRecibe, Integer celularRecibe, double valorDeclarado, double peso, double valorEnvio) {
        this.numGuia = numGuia;
        this.cedulaCliente = cedulaCliente;
        this.nombreCliente = nombreCliente;
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        this.dirDestino = dirDestino;
        this.nombreRecibe = nombreRecibe;
        this.celularRecibe = celularRecibe;
        this.valorDeclarado = valorDeclarado;
        this.peso = peso;
        this.valorEnvio = valorEnvio;
    }

    public EnvioDetalleDTO(String numeroGuia, String numeroGuia1, String ciudadOrigen, String ciudadDestino, String direccionDestino, String nombreRecibe, Integer celularRecibe, Double valorEnvio, Double valorDeclarado, Integer peso, Integer cedulaCliente) {
    this.numeroGuia = numeroGuia;
    this.numeroGuia1=numeroGuia1;
    this.ciudadOrigen=ciudadOrigen;
    this.ciudadDestino=ciudadDestino;
    this.direccionDestino=direccionDestino;
    this.nombreRecibe=nombreRecibe;
    this.celularRecibe=celularRecibe;
    this.valorEnvio=valorEnvio;
    this.valorDeclarado=valorDeclarado;
    this.peso=peso;
    this.cedulaCliente=cedulaCliente;

    }

    public Integer getNumGuia() {
        return numGuia;
    }

    public void setNumGuia(Integer numGuia) {
        this.numGuia = numGuia;
    }

    public Integer getCedulaCliente() {
        return cedulaCliente;
    }

    public void setCedulaCliente(Integer cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
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

    public String getDirDestino() {
        return dirDestino;
    }

    public void setDirDestino(String dirDestino) {
        this.dirDestino = dirDestino;
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

    public double getValorDeclarado() {
        return valorDeclarado;
    }

    public void setValorDeclarado(double valorDeclarado) {
        this.valorDeclarado = valorDeclarado;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getValorEnvio() {
        return valorEnvio;
    }

    public void setValorEnvio(double valorEnvio) {
        this.valorEnvio = valorEnvio;
    }
}
