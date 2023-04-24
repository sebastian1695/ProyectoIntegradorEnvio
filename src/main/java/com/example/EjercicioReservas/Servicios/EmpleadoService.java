package com.example.EjercicioReservas.Servicios;


import com.example.EjercicioReservas.Dto.EmpleadoDTO;
import com.example.EjercicioReservas.Entity.Empleado;
import com.example.EjercicioReservas.Excepciones.ExcepcionesMensajeria;
import com.example.EjercicioReservas.Repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@Service
public class EmpleadoService {
    private EmpleadoRepository empleadoRepository;
    private List<Empleado> empleados;

    @Autowired
    public EmpleadoService(EmpleadoRepository empleadoRepository){
        this.empleadoRepository = empleadoRepository;
    }
    public EmpleadoDTO crear(Empleado empleadoDTO) {

        if (empleadoDTO.getNombre() == null || empleadoDTO.getApellido() == null || empleadoDTO.getCedula() == null) {
            throw new RuntimeException("Empleado, digite correctamente los campos");
        }
        Empleado empleado = new Empleado(
                empleadoDTO.getCedula(),
                empleadoDTO.getNombre(),
                empleadoDTO.getApellido(),
                empleadoDTO.getCelular(),
                empleadoDTO.getCorreo(),
                empleadoDTO.getDireccion(),
                empleadoDTO.getCiudad(),
                empleadoDTO.getAntiguedad(),
                empleadoDTO.getRh(),
                empleadoDTO.getTipo()
        );
        empleadoRepository.save(empleado);
        return (EmpleadoDTO) empleadoDTO;
    }

    public EmpleadoDTO consultar(Integer cedula){
        if (cedula ==null){
            throw new ExcepcionesMensajeria("Cédula no encontrada");
        }
        Optional<Empleado> empleado = empleadoRepository.findById(cedula);

        if (!empleado.isPresent()){
            throw new ExcepcionesMensajeria("El empleado con cedula "+cedula+"no fue encontrado en la base de datos");
        }
        EmpleadoDTO empleadoDTO = new EmpleadoDTO(
                empleado.get().getCedula(),
                empleado.get().getNombre(),
                empleado.get().getApellido(),
                empleado.get().getCelular(),
                empleado.get().getCorreo(),
                empleado.get().getDireccion(),
                empleado.get().getCiudad(),
                empleado.get().getAntiguedad(),
                empleado.get().getRh(),
                empleado.get().getTipo()
        );
        return empleadoDTO;
    }

    public EmpleadoDTO actualizar(EmpleadoDTO empleadoDTO){

        Integer cedula = empleadoDTO.getCedula();

        if (cedula==null){
            throw new ExcepcionesMensajeria("Empleado no se ha registrado");}

    Optional<Empleado> empleadoActual = empleadoRepository.findById(cedula);

        if (empleadoActual.isPresent()) {
            Empleado empleado = empleadoActual.get();

            empleadoActual.get().setNombre(empleadoDTO.getNombre());
            empleadoActual.get().setApellido(empleadoDTO.getApellido());
            empleadoActual.get().setCelular(empleadoDTO.getCelular());
            empleadoActual.get().setDireccion(empleadoDTO.getDireccion());
            empleadoActual.get().setCiudad(empleadoDTO.getCiudad());
            empleadoActual.get().setAntiguedad(empleadoDTO.getAntiguedad());
            empleadoActual.get().setRh(empleadoDTO.getRh());
            empleadoActual.get().setTipo(empleadoDTO.getTipo());



            empleadoRepository.save(empleado);

            return empleadoDTO;

        }else{

            throw new ExcepcionesMensajeria("El empleado no existe en la base de datos");
        }


    }
    public String borrar(Integer cedula){
        if (cedula ==null){
            throw new ExcepcionesMensajeria("la cedula no puede ser nula");
        }
        Optional<Empleado> empleado = this.empleadoRepository.findById(cedula);

        if (!empleado.isPresent()){
            throw new ExcepcionesMensajeria("Empleado no presente en la base de datos");
        }
        Empleado empleadoObtenido= empleado.get();
        empleadoRepository.delete(empleado.get());
        return "Empleado eliminido correctamente";
    }



};
