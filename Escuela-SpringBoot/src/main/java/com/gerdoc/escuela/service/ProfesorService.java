package com.gerdoc.escuela.service;

import com.gerdoc.escuela.model.Profesor;

import java.util.List;
import java.util.Optional;

public interface ProfesorService
{
    // Consultar todos los registros
    List<Profesor> findAll();
    // Consultar un registro por ID
    Optional<Profesor> findById(Long id);
    // Guardar o actualizar un registro
    Profesor save(Profesor profesor);
    // Eliminar un registro por ID
    void deleteById(Long id);
    // Verificar si existe un registro
    boolean existsById(Long id);
}
