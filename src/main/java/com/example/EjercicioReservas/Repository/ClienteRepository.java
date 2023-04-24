package com.example.EjercicioReservas.Repository;

import com.example.EjercicioReservas.Entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer > {

}
