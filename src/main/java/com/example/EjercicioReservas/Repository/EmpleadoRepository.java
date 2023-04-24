package com.example.EjercicioReservas.Repository;


import com.example.EjercicioReservas.Entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Integer > {

}
