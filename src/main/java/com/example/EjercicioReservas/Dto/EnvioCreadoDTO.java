package com.example.EjercicioReservas.Dto;

public class EnvioCreadoDTO {
    private String numGuia;
    private String estado= "ENTREGADO";

    public EnvioCreadoDTO(String numGuia, String estado){
        this.numGuia = numGuia;
        this.estado=estado;
    }
    public String getNumGuia(){
        return numGuia;
    }
    public String getEstado(){
        return estado;
    }
}
