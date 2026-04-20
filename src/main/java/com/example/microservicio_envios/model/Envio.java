package com.example.microservicio_envios.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "envios")
public class Envio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre del cliente es obligatorio")
    private String cliente;

    @NotBlank(message = "El estado no puede estar vacío")
    private String estado;

    @NotBlank(message = "La ubicación actual es obligatoria")
    private String ubicacionActual;

    @OneToMany(mappedBy = "envio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Producto> productos = new ArrayList<>();

    // Método manual necesario para asegurar la relación bidireccional
    public void setProductos(List<Producto> productos) {
        this.productos = productos;
        if(productos != null) {
            for(Producto p : productos) {
                p.setEnvio(this);
            }
        }
    }
}
