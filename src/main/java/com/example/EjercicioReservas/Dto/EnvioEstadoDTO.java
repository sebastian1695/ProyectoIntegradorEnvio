package com.example.EjercicioReservas.Dto;

import com.example.EjercicioReservas.Servicios.patronState.Estado;
import com.example.EjercicioReservas.Servicios.patronState.EstadoRecibido;
import org.springframework.beans.factory.annotation.Autowired;

public class EnvioEstadoDTO {

    private static final String ESTADO_INICIAL= "RECIBIDO";

    private Estado estado;

   @Autowired
   public EnvioEstadoDTO(){
       this.estado = new EstadoRecibido();
   }

   public String cambiarEstado() {return estado.cambiarEstado(this);}

    public String getEstadoInicial(){
       return ESTADO_INICIAL;
    }

    public void setEstado( Estado estado){this.estado = estado;}
}

