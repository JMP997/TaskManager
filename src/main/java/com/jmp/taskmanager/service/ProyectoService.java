package com.jmp.taskmanager.service;

import com.jmp.taskmanager.entity.Proyecto;

public interface ProyectoService {
    Proyecto crearProyecto(Proyecto proyecto);
    Proyecto obtenerProyecto(Long id);
    Proyecto actualizarProyecto(Long id, Proyecto cambios);
    void eliminarProyecto(Long id);
}
