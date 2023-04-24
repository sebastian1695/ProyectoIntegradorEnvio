package com.example.EjercicioReservas.Entity;

import javax.persistence.*;

@Entity
@Table (name ="paquete")
public class Paquete {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name ="identificacion")
    private Integer identificacion;
    @Column(name = "tipo")
    private String tipo;
    @Column (name ="peso")
    private Integer peso;
    @Column (name= "valorDeclarado")
    private Double valorDeclarado;

    public Paquete() {
    }

    public Paquete(String tipo, Integer peso, Double valorDeclarado) {

        this.tipo = tipo;
        this.peso = peso;
        this.valorDeclarado = valorDeclarado;
    }

    public Integer getId() {
        return identificacion;
    }

    public String getTipo() {
        return tipo;
    }

    public Integer getPeso() {
        return peso;
    }

    public Double getValorDeclarado() {
        return valorDeclarado;
    }

    public void setId(Integer id) {
        this.identificacion = identificacion;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public void setValorDeclarado(Double valorDeclarado) {
        this.valorDeclarado = valorDeclarado;
    }



}
