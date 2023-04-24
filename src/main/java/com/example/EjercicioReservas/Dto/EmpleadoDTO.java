package com.example.EjercicioReservas.Dto;

import com.example.EjercicioReservas.Entity.Empleado;

public class EmpleadoDTO extends Empleado {
    private Integer cedula;
    private String nombre;
    private String apellido;
    private Integer celular;
    private String correo;
    private String direccion;
    private String ciudad;
    private Double antiguedad;
    private String rh;
    private String tipo;

    public EmpleadoDTO() {
    }

    public EmpleadoDTO(Integer cedula, String nombre, String apellido, Integer celular, String correo, String direccion, String ciudad, Double antiguedad, String rh, String tipo) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.celular = celular;
        this.correo = correo;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.antiguedad = antiguedad;
        this.rh = rh;
        this.tipo = tipo;
    }


    public Integer getCedula() {
        return cedula;
    }

    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getCelular() {
        return celular;
    }

    public void setCelular(Integer celular) {
        this.celular = celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Double getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(Double antiguedad) {
        this.antiguedad = antiguedad;
    }

    public String getRh() {
        return rh;
    }

    public void setRh(String rh) {
        this.rh = rh;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}

