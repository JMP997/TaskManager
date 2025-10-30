package com.jmp.taskmanager.repository;

import com.jmp.taskmanager.entity.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProyectoRepository extends JpaRepository <Proyecto, Long>{
    Proyecto findByNombre(String nombre);
}
