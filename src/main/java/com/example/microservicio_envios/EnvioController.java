package com.example.microservicio_envios;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class EnvioController {

    private List<Envio> envios = new ArrayList<>();

    public EnvioController() {
        // Inicializar la lista con 3 datos en memoria
        envios.add(new Envio(1, "Pedro Sanchez", "En preparación", "Bodega Central",
                Arrays.asList(new Producto("P01", "Saco Dog Chow 15kg"), new Producto("P02", "Collar Antipulgas"))));

        envios.add(new Envio(2, "Maria Lopez", "En ruta", "Camión Reparto RM",
                Arrays.asList(new Producto("P03", "Arena para gatos 10kg"))));

        envios.add(new Envio(3, "Carlos Pinto", "Entregado", "Domicilio Cliente",
                Arrays.asList(new Producto("P04", "Hueso de goma"), new Producto("P05", "Plato acero inoxidable"))));
    }

    // 1. Consultar todos los envíos
    @GetMapping("/envios")
    public List<Envio> getEnvios() {
        return envios;
    }

    // 2. Consultar la ubicación e información de un envío específico por ID
    @GetMapping("/envios/{id}")
    public Envio getEnvioById(@PathVariable("id") int id) {
        for (Envio envio : envios) {
            if (envio.getId() == id) {
                return envio;
            }
        }
        return null;
    }

    // 3. Actualizar el estado y ubicación de un envío usando variables de ruta
    @GetMapping(path = "/envios/actualizar/{id}/{nuevoEstado}/{nuevaUbicacion}")
    public Envio actualizarEstado(
            @PathVariable("id") int id,
            @PathVariable("nuevoEstado") String nuevoEstado,
            @PathVariable("nuevaUbicacion") String nuevaUbicacion) {

        for (Envio envio : envios) {
            if (envio.getId() == id) {
                envio.setEstado(nuevoEstado);
                envio.setUbicacionActual(nuevaUbicacion);
                return envio;
            }
        }
        return null;
    }

    // 4. Registrar un nuevo envío
    @GetMapping(path = "/envios/registrar/{id}/{cliente}/{estado}/{ubicacion}")
    public Envio registrarEnvio(
            @PathVariable("id") int id,
            @PathVariable("cliente") String cliente,
            @PathVariable("estado") String estado,
            @PathVariable("ubicacion") String ubicacion) {

        List<Producto> productosBasicos = Arrays.asList(new Producto("P99", "Producto Genérico Mascotas"));
        Envio nuevoEnvio = new Envio(id, cliente, estado, ubicacion, productosBasicos);

        envios.add(nuevoEnvio);
        return nuevoEnvio;
    }
}
