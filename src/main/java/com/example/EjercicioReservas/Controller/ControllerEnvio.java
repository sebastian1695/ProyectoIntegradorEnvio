package com.example.EjercicioReservas.Controller;

import com.example.EjercicioReservas.Dto.EnvioCambiarEstadoDTO;
import com.example.EjercicioReservas.Dto.EnvioCreadoDTO;
import com.example.EjercicioReservas.Dto.EnvioDTO;
import com.example.EjercicioReservas.Dto.EnvioDetalleDTO;
import com.example.EjercicioReservas.Entity.Envio;
import com.example.EjercicioReservas.Servicios.EnvioService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class ControllerEnvio {

    private EnvioService envioService;


    @Autowired
    public ControllerEnvio(EnvioService envioService){this.envioService =envioService;}


    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = " Error, servidor no encontrado"),
            @ApiResponse(code = 500, message = "Por favor, intente de nuevo más tarde")
    })

    @ApiOperation(value= "Crear envío")
    @PostMapping("/envio")
    public EnvioDTO enviar(@RequestBody EnvioDTO envio){
        return envioService.enviar(envio);
    }
    @ApiOperation(value = "Actualizar envío")
    @PutMapping ("/envio/estado")
    public EnvioCreadoDTO cambiarEstado(@RequestBody EnvioCambiarEstadoDTO envioCambiarEstadoDTO ){
        return envioService.cambiarEstado(envioCambiarEstadoDTO);
    }

    @ApiOperation(value = "BuscarEnvío")
    @GetMapping ("/envio/{num-guia}")

    public EnvioDetalleDTO buscar(@PathVariable ("num-guia")Integer numGuia){
        return envioService.buscar(numGuia);
    }

    @ApiOperation(value = "Filtrar Envío")
    @GetMapping("/envio/estado/{estado}")
    public List<Envio> filtrar(@PathVariable ("estado") String estado){
        return envioService.filtrar(estado);
    }


}
