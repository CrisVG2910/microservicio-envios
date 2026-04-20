package com.example.microservicio_envios.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.microservicio_envios.model.Envio;
import com.example.microservicio_envios.service.EnvioService;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/envios")
@CrossOrigin(origins = "*")
public class EnvioController {

    @Autowired
    private EnvioService envioService;

    @GetMapping
    public List<Envio> getAllEnvios() {
        return envioService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Optional<Envio> getEnvioById(@PathVariable Long id) {
        return envioService.obtenerPorId(id);
    }

    @PostMapping
    public Envio crearEnvio(@Valid @RequestBody Envio envio) {
        return envioService.crearEnvio(envio);
    }

    @PutMapping("/{id}")
    public Envio actualizarEnvio(@PathVariable Long id, @Valid @RequestBody Envio envio) {
        return envioService.actualizarEnvio(id, envio);
    }

    @DeleteMapping("/{id}")
    public void eliminarEnvio(@PathVariable Long id) {
        envioService.eliminarEnvio(id);
    }
}
