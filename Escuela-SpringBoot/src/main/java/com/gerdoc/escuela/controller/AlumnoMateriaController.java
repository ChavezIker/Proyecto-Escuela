package com.gerdoc.escuela.controller;

import com.gerdoc.escuela.model.AlumnoMateria;
import com.gerdoc.escuela.service.AlumnoMateriaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag( name = "Alumno-Materia", description = "Operaciones CRUD para la administración de inscripciones alumno-materia")
@RestController
@RequestMapping("/api/alumno-materias")
@RequiredArgsConstructor
public class AlumnoMateriaController
{
    private final AlumnoMateriaService alumnoMateriaService;

    @Operation(summary = "Consultar inscripciones alumno-materia", description = "Obtiene la lista completa de inscripciones alumno-materia registrados")
    @GetMapping
    public ResponseEntity<List<AlumnoMateria>> findAll()
    {
        return ResponseEntity.ok(alumnoMateriaService.findAll());
    }

    @Operation(summary = "Consultar inscripción alumno-materia por ID", description = "Obtiene un registro de inscripción alumno-materia por su ID")
    @GetMapping("/{id}")
    public ResponseEntity<AlumnoMateria> findById(@PathVariable Long id)
    {
        return alumnoMateriaService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Crear inscripción alumno-materia", description = "Crea un nuevo registro de inscripción alumno-materia en el sistema")
    @PostMapping
    public ResponseEntity<AlumnoMateria> create(@RequestBody AlumnoMateria alumnoMateria)
    {
        alumnoMateria.setId(null);
        AlumnoMateria nuevo = alumnoMateriaService.save(alumnoMateria);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(nuevo);
    }

    @Operation(summary = "Actualizar inscripción alumno-materia", description = "Actualiza los datos de un registro existente de inscripción alumno-materia")
    @PutMapping("/{id}")
    public ResponseEntity<AlumnoMateria> update(@PathVariable Long id, @RequestBody AlumnoMateria alumnoMateria)
    {
        return alumnoMateriaService.findById(id)
                .map(existente -> {
                    alumnoMateria.setId(existente.getId());
                    AlumnoMateria actualizado = alumnoMateriaService.save(alumnoMateria);
                    return ResponseEntity.ok(actualizado);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Eliminar inscripción alumno-materia por ID", description = "Elimina un registro de inscripción alumno-materia por su ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id)
    {
        if (!alumnoMateriaService.existsById(id))
        {
            return ResponseEntity.notFound().build();
        }
        alumnoMateriaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
