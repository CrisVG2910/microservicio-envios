package com.example.microservicio_envios.service;

import com.example.microservicio_envios.model.Envio;
import java.util.List;
import java.util.Optional;

public interface EnvioService {
    List<Envio> obtenerTodos();
    Optional<Envio> obtenerPorId(Long id);
    Envio crearEnvio(Envio envio);
    Envio actualizarEnvio(Long id, Envio envio);
    void eliminarEnvio(Long id);
}
