package com.example.microservicio_envios.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.microservicio_envios.model.Envio;
import com.example.microservicio_envios.repository.EnvioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EnvioServiceImpl implements EnvioService {

    @Autowired
    private EnvioRepository envioRepository;

    @Override
    public List<Envio> obtenerTodos() {
        return envioRepository.findAll();
    }

    @Override
    public Optional<Envio> obtenerPorId(Long id) {
        return envioRepository.findById(id);
    }

    @Override
    public Envio crearEnvio(Envio envio) {
        if (envio.getProductos() != null) {
            envio.setProductos(envio.getProductos());
        }
        return envioRepository.save(envio);
    }

    @Override
    public Envio actualizarEnvio(Long id, Envio envio) {
        if (envioRepository.existsById(id)) {
            envio.setId(id);
            if (envio.getProductos() != null) {
                envio.setProductos(envio.getProductos());
            }
            return envioRepository.save(envio);
        } else {
            return null;
        }
    }

    @Override
    public void eliminarEnvio(Long id) {
        envioRepository.deleteById(id);
    }
}
