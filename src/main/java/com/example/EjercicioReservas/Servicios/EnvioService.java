package com.example.EjercicioReservas.Servicios;

import com.example.EjercicioReservas.Dto.EnvioCambiarEstadoDTO;
import com.example.EjercicioReservas.Dto.EnvioCreadoDTO;
import com.example.EjercicioReservas.Dto.EnvioDTO;
import com.example.EjercicioReservas.Dto.EnvioDetalleDTO;
import com.example.EjercicioReservas.Entity.Cliente;
import com.example.EjercicioReservas.Entity.Empleado;
import com.example.EjercicioReservas.Entity.Envio;
import com.example.EjercicioReservas.Entity.Paquete;
import com.example.EjercicioReservas.Excepciones.ExcepcionesMensajeria;
import com.example.EjercicioReservas.Repository.ClienteRepository;
import com.example.EjercicioReservas.Repository.EmpleadoRepository;
import com.example.EjercicioReservas.Repository.EnvioRepository;
import com.example.EjercicioReservas.Repository.PaqueteRepository;
import com.example.EjercicioReservas.Servicios.patronState.Estado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class    EnvioService {

    private EnvioRepository envioRepository;
    private ClienteRepository clienteRepository;
    private EmpleadoRepository empleadoRepository;
    private PaqueteRepository paqueteRepository;

    @Autowired
    public EnvioService(EnvioRepository envioRepository, ClienteRepository clienteRepository, EmpleadoRepository empleadoRepository, PaqueteRepository paqueteRepository) {
        this.envioRepository = envioRepository;
        this.clienteRepository = clienteRepository;
        this.empleadoRepository = empleadoRepository;
        this.paqueteRepository = paqueteRepository;
    }


    public EnvioDTO enviar(EnvioDTO envioDTO) {
        Integer cedula = envioDTO.getCedula();
        String ciudadOrigen = envioDTO.getCiudadOrigen();
        String ciudadDestino = envioDTO.getCiudadDestino();
        String direccionDestino = envioDTO.getDireccionDestino();
        String nombreRecibe = envioDTO.getNombreRecibe();
        Integer celularRecibe = envioDTO.getCelularRecibe();
        Double valorDeclarado = envioDTO.getValorDeclarado();
        Integer peso = envioDTO.getPeso();
        Integer idPaquete = envioDTO.getIdPaquete();
        if (cedula == null || ciudadOrigen == null || ciudadDestino == null || direccionDestino == null || nombreRecibe == null || celularRecibe == null || valorDeclarado == null || peso == null) {
            throw new RuntimeException("Por favor digite todos los campos, de lo contrario el envío no es válido");
        }
        Optional<Cliente> cliente = this.clienteRepository.findById(cedula);

        Optional<Paquete> paquete = this.paqueteRepository.findById(idPaquete);

        if (cliente.isPresent() && paquete.isPresent()) {


            String tipoPaquete = tipoPaquete(envioDTO.getPeso());

            Envio envio1 = new Envio();

            if (tipoPaquete.equals("GRANDE")) {
                envio1.setValorEnvio(50000.0);

            } else if (tipoPaquete.equals("MEDIANO")) {
                envio1.setValorEnvio(40000.0);

            } else if (tipoPaquete.equals("Liviano")) {
                envio1.setValorEnvio(30000.0);

            } else {
                throw new ExcepcionesMensajeria("El tipo de paquete no es válido, seleccione entre grande, mediano o liviano");
            }

            envio1.setEstadoEnvio("RECIBIDO");
            envio1.setCliente(cliente.get());
            envio1.setCiudadOrigen(ciudadOrigen);
            envio1.setCiudadDestino(ciudadDestino);
            envio1.setDireccionDestino(direccionDestino);
            envio1.setNombreRecibe(nombreRecibe);
            envio1.setCelularRecibe(celularRecibe);
            envio1.setPaquete(paquete.get());

            this.envioRepository.save(envio1);

        } else {
            throw new ExcepcionesMensajeria("El cliente" + cedula + " o el paquete" + paquete + " no existen en la base de datos");
        }

        return envioDTO;


    }

    public String tipoPaquete(Integer peso) {
        if (peso < 2) {
            return "LIVIANO";
        } else if (peso >= 2 && peso < 5) {
            return "MEDIANO";
        }
        return "GRANDE";
    }

    public String hora() {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public EnvioCreadoDTO cambiarEstado(EnvioCambiarEstadoDTO envioCambiarEstadoDTO) {

        Optional<Envio> envioPorId = this.envioRepository.findById(envioCambiarEstadoDTO.getNumGuia());
        Optional<Empleado> empleadoPorId = this.empleadoRepository.findById(envioCambiarEstadoDTO.getCedulaEmpleado());

        if (!empleadoPorId.isPresent() || !envioPorId.isPresent()) {
            throw new ExcepcionesMensajeria("el empleado con  cedula " + envioCambiarEstadoDTO.getCedulaEmpleado() + " o el numero de guia del envio " + envioCambiarEstadoDTO.getNumGuia() + " no son validos");
        }

        if (empleadoPorId.get().getTipo().equals("REPARTIDOR") || empleadoPorId.get().getTipo().equals("COORDINADOR")) {
            String estadoActual = envioCambiarEstadoDTO.getEstado().toUpperCase();


            if (estadoActual.equals("RECIBIDO") || estadoActual.equals("EN_RUTA") || estadoActual.equals("ENTREGADO")) {
                Envio envio = envioPorId.get();

                envioPorId.get().setEstadoEnvio(envioPorId);

                envioRepository.save(envio);

                EnvioCreadoDTO respuestaDTO = new EnvioCreadoDTO(
                        envioPorId.get().getNumeroGuia(),
                        envioPorId.get().getEstadoEnvio()
                );

                return respuestaDTO;
            } else {
                throw new ExcepcionesMensajeria("El estado del envio no corresponde a una de las opciones habilitadas que son :(RECIBIDO, EN_RUTA, ENTREGADO) ");
            }

        } else {
            throw new ExcepcionesMensajeria("El empleado con cedula: " + empleadoPorId + " no esta autorizado para cambiar el estado del envio");
        }

    }
    public EnvioDetalleDTO buscar (Integer numGuia){

        if (numGuia==null){
            throw new ExcepcionesMensajeria("El cliente no existe en la base de datos");
        }
        Optional<Envio> envio = envioRepository.findById(numGuia);

        if (envio.isPresent()){
            EnvioDetalleDTO envioDetalleDTO = new EnvioDetalleDTO(
                    envio.get().getNumeroGuia(),
                    envio.get().getNumeroGuia(),
                    envio.get().getCiudadOrigen(),
                    envio.get().getCiudadDestino(),
                    envio.get().getDireccionDestino(),
                    envio.get().getNombreRecibe(),
                    envio.get().getCelularRecibe(),
                    envio.get().getValorEnvio(),
                    envio.get().getPaquete().getValorDeclarado(),
                    envio.get().getPaquete().getPeso(),
                    envio.get().getCliente().getCedula()


            );
            return envioDetalleDTO;
        }else{
        throw new ExcepcionesMensajeria("La guia con el ID: "+ numGuia + " no es valido");
    }
    }
    public List<Envio> filtrar(String estado){
        String estadoToUpperCase = estado.toUpperCase();

        if(!estadoToUpperCase.equals("RECIBIDO") && !estadoToUpperCase.equals("EN_RUTA") && !estadoToUpperCase.equals("ENTREGADO")){
            throw new ExcepcionesMensajeria("Estado no encontrado en la base de datos, recuerde seleccionar entre Recibidio, en ruta y entregado");
        }
        List<Envio> resultado= envioRepository.filtrarPorEstado(estadoToUpperCase).stream().collect(Collectors.toList());
        if (resultado.isEmpty()){
            throw new ExcepcionesMensajeria("No existen envíos con ese estado");
        }
        return resultado;
    }
}
   /* public EnvioCreadoDTO cambiarEstado(EnvioCambiarEstadoDTO envioCambiarEstadoDTO){
        Optional<Envio> envioPorId= this.envioRepository.findById(envioCambiarEstadoDTO.getNumGuia());
        Optional<Empleado> empleadoPorId = this.empleadoRepository.findById(envioCambiarEstadoDTO.getCedulaEmpleado());

        if(!empleadoPorId.isPresent() || envioPorId.isPresent()){
            throw new ExcepcionesMensajeria("Empleado o numero de guía inválidos");
        }
        if (empleadoPorId.get().getTipo().equals("REPARTIDOR")|| empleadoPorId.get().getTipo().equals("COORDINADOR")){
            String estadoActual = envioCambiarEstadoDTO.getEstado().toUpperCase();


        if (estadoActual.equals("RECIBIDO")) || estadoActual.equals("EN RUTA") || estadoActual.equals("ENTREGADO")){

        Envio envio = envioPorId.get();
        envioPorId.get().setEstadoEnvio(envioCambiarEstadoDTO.());

        envioRepository.save(envio);

        EnvioCreadoDTO respuestaDTO= new EnvioCreadoDTO(
                envioPorId.get().getNumeroGuia(),
                envioPorId.get().getEstadoEnvio()
        );

        return respuestaDTO;

            }

        }
    }

}



  /* public EnvioDTO enviar(Integer cedula, Integer id, String fechaEnvio) {

        return null;
    }*/