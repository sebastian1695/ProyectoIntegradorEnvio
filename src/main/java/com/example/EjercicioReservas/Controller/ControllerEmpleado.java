package com.example.EjercicioReservas.Controller;


import com.example.EjercicioReservas.Dto.EmpleadoDTO;
import com.example.EjercicioReservas.Servicios.EmpleadoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class ControllerEmpleado {

    private EmpleadoService empleadoService;


    @Autowired
    public ControllerEmpleado(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = " Error, servidor no encontrado"),
            @ApiResponse(code = 500, message = "Por favor, intente de nuevo más tarde")
    })

    @ApiOperation(value = "Crear empleado")
    @PostMapping("/empleados")
    public EmpleadoDTO crear(@RequestBody EmpleadoDTO empleado){
        return empleadoService.crear(empleado);
    }

    @ApiOperation(value = "Buscar empleado")
    @GetMapping("/empleados")
    public EmpleadoDTO consultar(@PathVariable("cedula") Integer cedula){
        return empleadoService.consultar(cedula);
    }

    @ApiOperation(value = "Actualizar empleado")
    @PutMapping("/empleados/{cedula}")
    public EmpleadoDTO actualizar(@RequestBody EmpleadoDTO empleadoActualizado){
        return empleadoService.actualizar(empleadoActualizado);

    }

    @ApiOperation(value = "Borrar empleado")
    @DeleteMapping ("/empleados/{cedula}")
    public String borrar(@PathVariable("cedula") Integer cedula){
        return empleadoService.borrar(cedula);
    }




}
