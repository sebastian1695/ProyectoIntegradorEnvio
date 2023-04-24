package com.example.EjercicioReservas.Servicios.patronState;

import com.example.EjercicioReservas.Dto.EnvioEstadoDTO;
import com.example.EjercicioReservas.Servicios.EstadoEnvio;

public class EstadoEnRuta implements Estado{
    @Override
    public String cambiarEstado(EnvioEstadoDTO envioEstadoDTO){
        envioEstadoDTO.setEstado ((Estado) new EstadoEntregado());
        return EstadoEnvio.ENTREGADO.getEstado();
    }
}
