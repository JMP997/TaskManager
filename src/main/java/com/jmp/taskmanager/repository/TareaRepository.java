package com.jmp.taskmanager.repository;

import com.jmp.taskmanager.entity.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TareaRepository extends JpaRepository <Tarea, Long> {
    Tarea findByTitulo(String titulo);
}
