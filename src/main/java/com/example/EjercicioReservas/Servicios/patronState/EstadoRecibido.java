package com.example.EjercicioReservas.Servicios.patronState;

import com.example.EjercicioReservas.Dto.EnvioEstadoDTO;
import com.example.EjercicioReservas.Servicios.EstadoEnvio;

public class EstadoRecibido implements Estado{
    @Override
    public String cambiarEstado(EnvioEstadoDTO envioEstadoDTO){
        envioEstadoDTO.setEstado(new EstadoEnRuta());

        return EstadoEnvio.EN_RUTA.getEstado();

    }
}
