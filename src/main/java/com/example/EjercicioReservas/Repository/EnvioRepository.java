package com.example.EjercicioReservas.Repository;


import com.example.EjercicioReservas.Entity.Envio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface EnvioRepository extends JpaRepository<Envio, Integer> {

@Query(value= "SELECT COUNT(*) FROM ENVIO WHERE CLIENTE=: CEDULA AND FECHA=: FECHA", nativeQuery = true)
    public Integer disponibilidadQuery (@Param("cedula") Integer numero, @Param("fecha")Date fecha);


@Query (value = "SELECT * FROM ENVIO WHERE TIPOPAQUETE=: LIVIANO", nativeQuery = true)
    public Integer tipoPaqueteQuery (@Param("tipoPaquete") String tipo);

@Query(value = "select * from envio where estado =:estado", nativeQuery = true)
public List<Envio> filtrarPorEstado(@Param("estado") String tipo);

}
