package com.gerdoc.escuela.controller;

import com.gerdoc.escuela.model.ProfesorMateria;
import com.gerdoc.escuela.service.ProfesorMateriaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag( name = "Profesor-Materia", description = "Operaciones CRUD para la administración de asignaciones profesor-materia")
@RestController
@RequestMapping("/api/profesor-materias")
@RequiredArgsConstructor
public class ProfesorMateriaController
{
    private final ProfesorMateriaService profesorMateriaService;

    @Operation(summary = "Consultar asignaciones profesor-materia", description = "Obtiene la lista completa de asignaciones profesor-materia registrados")
    @GetMapping
    public ResponseEntity<List<ProfesorMateria>> findAll()
    {
        return ResponseEntity.ok(profesorMateriaService.findAll());
    }

    @Operation(summary = "Consultar asignación profesor-materia por ID", description = "Obtiene un registro de asignación profesor-materia por su ID")
    @GetMapping("/{id}")
    public ResponseEntity<ProfesorMateria> findById(@PathVariable Long id)
    {
        return profesorMateriaService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Crear asignación profesor-materia", description = "Crea un nuevo registro de asignación profesor-materia en el sistema")
    @PostMapping
    public ResponseEntity<ProfesorMateria> create(@RequestBody ProfesorMateria profesorMateria)
    {
        profesorMateria.setId(null);
        ProfesorMateria nuevo = profesorMateriaService.save(profesorMateria);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(nuevo);
    }

    @Operation(summary = "Actualizar asignación profesor-materia", description = "Actualiza los datos de un registro existente de asignación profesor-materia")
    @PutMapping("/{id}")
    public ResponseEntity<ProfesorMateria> update(@PathVariable Long id, @RequestBody ProfesorMateria profesorMateria)
    {
        return profesorMateriaService.findById(id)
                .map(existente -> {
                    profesorMateria.setId(existente.getId());
                    ProfesorMateria actualizado = profesorMateriaService.save(profesorMateria);
                    return ResponseEntity.ok(actualizado);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Eliminar asignación profesor-materia por ID", description = "Elimina un registro de asignación profesor-materia por su ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id)
    {
        if (!profesorMateriaService.existsById(id))
        {
            return ResponseEntity.notFound().build();
        }
        profesorMateriaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
