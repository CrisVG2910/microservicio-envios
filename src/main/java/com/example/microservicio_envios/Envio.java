package com.example.microservicio_envios;

import java.util.List;

public class Envio {
    private int id;
    private String cliente;
    private String estado;
    private String ubicacionActual;
    private List<Producto> productos;

    public Envio(int id, String cliente, String estado, String ubicacionActual, List<Producto> productos) {
        this.id = id;
        this.cliente = cliente;
        this.estado = estado;
        this.ubicacionActual = ubicacionActual;
        this.productos = productos;
    }

    public int getId() {
        return id;
    }

    public String getCliente() {
        return cliente;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUbicacionActual() {
        return ubicacionActual;
    }

    public void setUbicacionActual(String ubicacionActual) {
        this.ubicacionActual = ubicacionActual;
    }

    public List<Producto> getProductos() {
        return productos;
    }
}
