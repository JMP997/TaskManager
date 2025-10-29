package com.jmp.taskmanager.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String nombre;
    @Column(length = 1000)
    String descripcion;

    // Relacion 1:N con Tarea
    @OneToMany(mappedBy = "proyecto",
            cascade= CascadeType.ALL,
            orphanRemoval = true)
    private List<Tarea> tareas = new ArrayList<>();
}
