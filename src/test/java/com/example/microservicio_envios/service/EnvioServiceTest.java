package com.example.microservicio_envios.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.microservicio_envios.model.Envio;
import com.example.microservicio_envios.repository.EnvioRepository;

@ExtendWith(MockitoExtension.class)
public class EnvioServiceTest {

    @Mock
    private EnvioRepository repository;

    @InjectMocks
    private EnvioServiceImpl service;

    // PRUEBA 2: Verifica la lógica de guardar un envío
    @Test
    void testCrearEnvio() {
        Envio envio = new Envio();
        envio.setCliente("Ana Gómez");
        when(repository.save(any(Envio.class))).thenReturn(envio);

        Envio resultado = service.crearEnvio(envio);
        assertEquals("Ana Gómez", resultado.getCliente());
        verify(repository, times(1)).save(envio);
    }

    // PRUEBA 3: Verifica la búsqueda por ID
    @Test
    void testObtenerPorId() {
        Envio envio = new Envio();
        envio.setUbicacionActual("Sucursal Origen");
        when(repository.findById(1L)).thenReturn(Optional.of(envio));

        Optional<Envio> resultado = service.obtenerPorId(1L);
        assertTrue(resultado.isPresent());
        assertEquals("Sucursal Origen", resultado.get().getUbicacionActual());
    }
}
