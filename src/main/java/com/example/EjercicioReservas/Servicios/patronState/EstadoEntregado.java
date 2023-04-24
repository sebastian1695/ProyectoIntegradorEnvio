package com.example.EjercicioReservas.Servicios.patronState;

import com.example.EjercicioReservas.Dto.EnvioEstadoDTO;

public class EstadoEntregado implements Estado{
    @Override
    public String cambiarEstado(EnvioEstadoDTO envioEstadoDTO){return "Paquete ya ha sido entregado";}
}
