package com.example.microservicio_envios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.microservicio_envios.model.Envio;

@Repository
public interface EnvioRepository extends JpaRepository<Envio, Long> {

}
