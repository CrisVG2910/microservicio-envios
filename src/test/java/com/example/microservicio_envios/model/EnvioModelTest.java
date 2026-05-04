package com.example.microservicio_envios.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class EnvioModelTest {

    // PRUEBA 1: Verifica getters, setters y la relación con Producto
    @Test
    void testRelacionEnvioProducto() {
        Envio envio = new Envio();
        envio.setCliente("Juan Pérez");

        Producto producto = new Producto();
        producto.setCodigo("PROD-001");

        List<Producto> lista = new ArrayList<>();
        lista.add(producto);
        envio.setProductos(lista);

        assertEquals("Juan Pérez", envio.getCliente());
        assertEquals(1, envio.getProductos().size());
    }
}
