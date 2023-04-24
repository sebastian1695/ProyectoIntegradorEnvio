package com.example.EjercicioReservas.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "Empleado")
public class Empleado {

    @Id
    @Column(name= "cedula")
    private  Integer cedula;
    @Column(name="nombre")
    private String nombre;
    @Column(name="apellido")
    private String apellido;
    @Column(name="celular")
    private Integer celular;
    @Column(name="correo")
    private String correo;
    @Column(name="direccion")
    private String direccion;
    @Column(name="ciudad")
    private String ciudad;
    @Column(name="antiguedad")
    private Double antiguedad;
    @Column(name="rh")
    private String rh;

    @Column(name="tipo")
    private String tipo;

    public Empleado() {
    }

    public Empleado(Integer cedula, String nombre, String apellido, Integer celular, String correo, String direccion, String ciudad, Double antiguedad, String rh, String tipo) {
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

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Integer getCelular() {
        return celular;
    }

    public String getCorreo() {
        return correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public Double getAntiguedad() {
        return antiguedad;
    }

    public String getRh() {
        return rh;
    }

    public String getTipo() {
        return tipo;
    }

    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCelular(Integer celular) {
        this.celular = celular;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setAntiguedad(Double antiguedad) {
        this.antiguedad = antiguedad;
    }

    public void setRh(String rh) {
        this.rh = rh;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
