package com.jmp.taskmanager.service.impl;

import com.jmp.taskmanager.entity.Proyecto;
import com.jmp.taskmanager.repository.ProyectoRepository;
import com.jmp.taskmanager.service.ProyectoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProyectoServiceImpl implements ProyectoService {

    private final ProyectoRepository proyectoRepository;

    @Override
    public Proyecto crearProyecto(Proyecto proyecto) {
        if (proyecto.getNombre() == null || proyecto.getNombre().isBlank()) {
            throw new RuntimeException("El nombre del proyecto es obligatorio");
        }
        if (proyectoRepository.findByNombre(proyecto.getNombre()) != null) {
            throw new RuntimeException("Ya existe un proyecto con ese nombre");
        }
        return proyectoRepository.save(proyecto);
    }

    @Override
    public Proyecto obtenerProyecto(Long id) {
        if(id == null){
            throw new RuntimeException("El id del proyecto es obligatorio");
        }
        return proyectoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró el proyecto con id: " + id));
    }

    @Override
    public Proyecto actualizarProyecto(Long id, Proyecto cambios) {
        return null;
    }

    @Override
    public void eliminarProyecto(Long id) {

    }
}
