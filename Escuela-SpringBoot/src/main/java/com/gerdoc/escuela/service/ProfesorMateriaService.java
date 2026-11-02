package com.gerdoc.escuela.service;

import com.gerdoc.escuela.model.ProfesorMateria;

import java.util.List;
import java.util.Optional;

public interface ProfesorMateriaService
{
    // Consultar todos los registros
    List<ProfesorMateria> findAll();
    // Consultar un registro por ID
    Optional<ProfesorMateria> findById(Long id);
    // Guardar o actualizar un registro
    ProfesorMateria save(ProfesorMateria profesorMateria);
    // Eliminar un registro por ID
    void deleteById(Long id);
    // Verificar si existe un registro
    boolean existsById(Long id);
}
