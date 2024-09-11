package com.example.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Servicio;

public interface ServicioRepository extends JpaRepository<Servicio, Long> {

}
