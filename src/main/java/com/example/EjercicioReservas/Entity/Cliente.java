package com.example.EjercicioReservas.Entity;

import com.example.EjercicioReservas.Dto.ClienteDTO;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name= "cliente")
public class Cliente{
    @Id
    private Integer cedula;

    @Column (name="nombre")
    private String nombre;

    @Column (name= "apellido")
    private String apellidos;

    @Column (name = "celular")
    private Integer celular;

    @Column (name = "correo")
    private String correo;

    @Column(name="direccion")
    private String direccion;
    @Column(name = "ciudad")
    private String ciudad;



    public Cliente() {
    }

    public Cliente(Integer cedula, String nombre, String apellidos, Integer celular, String correo, String direccion, String ciudad) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.celular = celular;
        this.correo = correo;
        this.direccion = direccion;
        this.ciudad = ciudad;

    }

    public Integer getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
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

    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setCelular(Integer celular) {
        this.celular = celular;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setDirection(String direccion) {
        this.direccion = direccion;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
}
