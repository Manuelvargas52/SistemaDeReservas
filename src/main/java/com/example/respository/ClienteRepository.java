package com.example.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
