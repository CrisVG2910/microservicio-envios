package com.example.microservicio_envios.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.microservicio_envios.model.Envio;
import com.example.microservicio_envios.service.EnvioService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(EnvioController.class)
public class EnvioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EnvioService service;

    @Autowired
    private ObjectMapper mapper;

    // PRUEBA 4: Verifica el endpoint de creación y la respuesta HTTP
    @Test
    @SuppressWarnings("null")
    void testCrearEnvioEndpoint() throws Exception {
        Envio envio = new Envio();
        envio.setCliente("Carlos Díaz");
        envio.setEstado("Entregado");
        envio.setUbicacionActual("Domicilio Cliente");

        when(service.crearEnvio(any(Envio.class))).thenReturn(envio);

        mockMvc.perform(post("/api/envios")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(envio)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.cliente").value("Carlos Díaz"));
    }
}
