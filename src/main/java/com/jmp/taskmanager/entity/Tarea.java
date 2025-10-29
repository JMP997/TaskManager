package com.jmp.taskmanager.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Tarea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String titulo;
    @Column(length = 1000)
    String descripcion;

    public enum Estado {PENDIENTE,EN_PROGRESO,COMPLETADA}
    public enum Prioridad {BAJA,MEDIA,ALTA}

    @Enumerated(EnumType.STRING)
    private Estado estado;
    @Enumerated(EnumType.STRING)
    private Prioridad prioridad;

    // Relación N:1 con Proyecto
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "proyecto_id", nullable = false)
    private Proyecto proyecto;
}
