package com.example.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Reserva;

public interface ReservaRespository extends JpaRepository<Reserva, Long>{

}
