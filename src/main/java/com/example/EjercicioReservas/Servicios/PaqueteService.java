package com.example.EjercicioReservas.Servicios;


import com.example.EjercicioReservas.Entity.Paquete;
import com.example.EjercicioReservas.Repository.PaqueteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaqueteService {

    private PaqueteRepository paqueteRepository;


    @Autowired
    public PaqueteService(PaqueteRepository paqueteRepository){
        this.paqueteRepository = paqueteRepository;}




    public Paquete crear(Paquete paquete) {
        return this.paqueteRepository.save(paquete);
    }
}
