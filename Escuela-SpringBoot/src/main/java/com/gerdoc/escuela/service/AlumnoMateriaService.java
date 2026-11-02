package com.gerdoc.escuela.service;

import com.gerdoc.escuela.model.AlumnoMateria;

import java.util.List;
import java.util.Optional;

public interface AlumnoMateriaService
{
    // Consultar todos los registros
    List<AlumnoMateria> findAll();
    // Consultar un registro por ID
    Optional<AlumnoMateria> findById(Long id);
    // Guardar o actualizar un registro
    AlumnoMateria save(AlumnoMateria alumnoMateria);
    // Eliminar un registro por ID
    void deleteById(Long id);
    // Verificar si existe un registro
    boolean existsById(Long id);
}
