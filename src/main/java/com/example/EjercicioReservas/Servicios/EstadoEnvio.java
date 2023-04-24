package com.example.EjercicioReservas.Servicios;

public enum EstadoEnvio {
   ENTREGADO ("ENTREGADO"),
    EN_RUTA("EN RUTA"),
    RECIBIDO ("RECIBIDO");

   private String estado;
   EstadoEnvio (String estado) {this.estado=estado;}
    public String getEstado(){
       return estado;
    }


}
