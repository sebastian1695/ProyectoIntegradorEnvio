package com.example.EjercicioReservas.Repository;


import com.example.EjercicioReservas.Entity.Paquete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaqueteRepository extends JpaRepository<Paquete, Integer> {

}
