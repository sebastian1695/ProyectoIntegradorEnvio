package com.example.EjercicioReservas.Servicios;

import com.example.EjercicioReservas.Dto.ClienteDTO;
import com.example.EjercicioReservas.Entity.Cliente;
import com.example.EjercicioReservas.Excepciones.ExcepcionesMensajeria;
import com.example.EjercicioReservas.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ClienteService {

    private List<Cliente> clientes;
    private ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
        this.clientes = new ArrayList<>();
    }

    public ClienteDTO crearCliente(ClienteDTO clienteDTO) {
        if (clienteDTO == null) {
            throw new ExcepcionesMensajeria("el cliente no puede ser nulo");
        }
        if (clienteDTO.getCedula() == null) {
            throw new ExcepcionesMensajeria("por favor digite el nombre");
        }

        if (clienteDTO.getApellidos() == null || clienteDTO.getNombre() == null) {

            throw new ExcepcionesMensajeria("datos inválidos, por favor, apellido y cédula");
        }

        Cliente cliente = new Cliente(
                clienteDTO.getCedula(),
                clienteDTO.getNombre(),
                clienteDTO.getApellidos(),
                clienteDTO.getCelular(),
                clienteDTO.getCorreo(),
                clienteDTO.getDireccion(),
                clienteDTO.getCiudad()
        );

        clienteRepository.save(cliente);
        return clienteDTO;
    }

    public ClienteDTO consultar(Integer cedula) {
        if (cedula == null) {
            throw new ExcepcionesMensajeria("Cliente aun no existe en la base de datos");

        }

        Optional<Cliente> cliente = clienteRepository.findById(cedula);

        if (!cliente.isPresent()) {
            throw new ExcepcionesMensajeria("Cliente no existe en la base de datos");
        }


        ClienteDTO clienteDTO = new ClienteDTO(
                cliente.get().getCedula(),
                cliente.get().getNombre(),
                cliente.get().getApellidos(),
                cliente.get().getCelular(),
                cliente.get().getCorreo(),
                cliente.get().getDireccion(),
                cliente.get().getCiudad()
        );
        return clienteDTO;

    }

    public ClienteDTO actualizar(ClienteDTO clienteDTO) {

        Integer cedula = clienteDTO.getCedula();

        if (cedula == null) {
            throw new ExcepcionesMensajeria("El cliente debe haberse creado previamente");
        }

        Optional<Cliente> clienteActual = clienteRepository.findById(cedula);

        if (clienteActual.isPresent()) {
            Cliente cliente = clienteActual.get();
            clienteActual.get().setNombre(clienteDTO.getNombre());
            clienteActual.get().setApellidos(clienteDTO.getApellidos());
            clienteActual.get().setCelular(clienteDTO.getCelular());
            clienteActual.get().setCorreo(clienteDTO.getCorreo());
            clienteActual.get().setDirection(clienteDTO.getDireccion());
            clienteActual.get().setCiudad(clienteDTO.getCiudad());

            clienteRepository.save(cliente);


            return clienteDTO;
        } else {
            throw new ExcepcionesMensajeria("El cliente con cedula " + cedula + " no existe");
        }



    }
    public String borrar(Integer cedula){
        if (cedula == null){
            throw new ExcepcionesMensajeria("la cédula no puede ser nula");
        }
        Optional<Cliente> cliente = this.clienteRepository.findById(cedula);

        if (!cliente.isPresent()){
            throw new ExcepcionesMensajeria("Cliente no presente en la base de datos");

        }
        Cliente clienteObtenido = cliente.get();
        clienteRepository.delete(cliente.get());
        return "Cliente eliminado corrrectamente";
    }
};










