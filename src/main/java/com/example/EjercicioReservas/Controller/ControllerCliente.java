package com.example.EjercicioReservas.Controller;

import com.example.EjercicioReservas.Dto.ClienteDTO;
import com.example.EjercicioReservas.Entity.Cliente;
import com.example.EjercicioReservas.Servicios.ClienteService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/")
public class ControllerCliente {

  private ClienteService clienteService;

  @Autowired
  public ControllerCliente(ClienteService clienteService){
    this.clienteService =clienteService;
  }

  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "OK"),
          @ApiResponse(code = 404, message = " Error, servidor no encontrado"),
          @ApiResponse(code = 500, message = "Por favor, intente de nuevo más tarde")
  })


  //@ApiOperation(value = "Crear cliente")
 // @PostMapping("/prueba")
  //public String prueba(){
   // return "holamundo";
  //}
  @ApiOperation(value = "Crear cliente, este sí")
  @PostMapping("/clientes")
  public ClienteDTO crearCliente(@RequestBody ClienteDTO cliente){
    return clienteService.crearCliente(cliente);
  }

  @ApiOperation(value = "buscar cliente")
  @GetMapping("clientes/{cedula}")
  public ClienteDTO consultar(@PathVariable("cedula") Integer cedula){
    return clienteService.consultar(cedula);
  }

  @ApiOperation(value ="actualizar cliente")
  @PutMapping ("/prueba")
  public  String prueba2(){
    return "hola world";
  }

  @ApiOperation(value = "Actualizar cliente")
  @PutMapping ("/clientes")
  public ClienteDTO actualizar(@RequestBody ClienteDTO clienteActualizado){
   return clienteService.actualizar(clienteActualizado);

  }

  @ApiOperation(value="traer Clientes")
  @GetMapping("/prueba")
  public String prueba1(){
    return "hola mundosssss";
  }
  @ApiOperation(value = "Borrar Cliente")
  @DeleteMapping ("/clientes/{cedula}")
  public String borrar( @PathVariable("cedula") Integer cedula){
    return  clienteService.borrar(cedula);
  }






}
