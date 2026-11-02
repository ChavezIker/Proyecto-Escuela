package com.gerdoc.escuela.service;

import com.gerdoc.escuela.model.Materia;

import java.util.List;
import java.util.Optional;

public interface MateriaService
{
    // Consultar todos los registros
    List<Materia> findAll();
    // Consultar un registro por ID
    Optional<Materia> findById(Long id);
    // Guardar o actualizar un registro
    Materia save(Materia materia);
    // Eliminar un registro por ID
    void deleteById(Long id);
    // Verificar si existe un registro
    boolean existsById(Long id);
}
