package com.example.EjercicioReservas.Entity;



import javax.persistence.*;
import java.util.Optional;

@Entity
@Table (name= "envio")
public class Envio {
    @Id
    @Column (name = "numeroGuia")
    private String numeroGuia;


    @OneToOne
    @JoinColumn(name = "cliente")
    private Cliente cliente;
    @Column (name ="ciudadOrigen")
    private String ciudadOrigen;
    @Column (name ="ciudadDestino")
    private String ciudadDestino;
    @Column (name = "direccionDestino")
    private String direccionDestino;
    @Column (name = "nombreRecibe")
    private String nombreRecibe;
    @Column (name ="celularRecibe")
    private Integer celularRecibe;
    @Column (name ="horaEntrega")
    private String horaEntrega;
    @Column (name = "estadoEnvio")
    private String estadoEnvio;
    @Column (name ="valorEnvio")
    private Double valorEnvio;




    @OneToOne
    private Paquete paquete;


    public Envio() {
    }

    public Envio(Cliente cliente,  String ciudadOrigen, String ciudadDestino, String direccionDestino, String nombreRecibe, Integer celularRecibe, String horaEntrega, String estadoEnvio, Double valorEnvio, Paquete paquete) {

        this.cliente = cliente;
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        this.direccionDestino = direccionDestino;
        this.nombreRecibe = nombreRecibe;
        this.celularRecibe = celularRecibe;
        this.horaEntrega = horaEntrega;
        this.estadoEnvio = estadoEnvio;
        this.valorEnvio = valorEnvio;
        this.paquete = paquete;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getNumeroGuia() {
        return numeroGuia;
    }

    public void setNumeroGuia(String numeroGuia) {
        this.numeroGuia = numeroGuia;
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

    public Paquete getPaquete() {
        return paquete;
    }

    public void setPaquete(Paquete paquete) {
        this.paquete = paquete;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setEstadoEnvio(Optional<Envio> envioPorId) {
    }
}
