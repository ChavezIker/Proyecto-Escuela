package com.gerdoc.escuela.controller;

import com.gerdoc.escuela.model.Profesor;
import com.gerdoc.escuela.service.ProfesorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag( name = "Profesores", description = "Operaciones CRUD para la administración de profesores")
@RestController
@RequestMapping("/api/profesores")
@RequiredArgsConstructor
public class ProfesorController
{
    private final ProfesorService profesorService;

    @Operation(summary = "Consultar profesores", description = "Obtiene la lista completa de profesores registrados")
    @GetMapping
    public ResponseEntity<List<Profesor>> findAll()
    {
        return ResponseEntity.ok(profesorService.findAll());
    }

    @Operation(summary = "Consultar profesor por ID", description = "Obtiene un registro de profesor por su ID")
    @GetMapping("/{id}")
    public ResponseEntity<Profesor> findById(@PathVariable Long id)
    {
        return profesorService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Crear profesor", description = "Crea un nuevo registro de profesor en el sistema")
    @PostMapping
    public ResponseEntity<Profesor> create(@RequestBody Profesor profesor)
    {
        profesor.setId(null);
        Profesor nuevo = profesorService.save(profesor);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(nuevo);
    }

    @Operation(summary = "Actualizar profesor", description = "Actualiza los datos de un registro existente de profesor")
    @PutMapping("/{id}")
    public ResponseEntity<Profesor> update(@PathVariable Long id, @RequestBody Profesor profesor)
    {
        return profesorService.findById(id)
                .map(existente -> {
                    profesor.setId(existente.getId());
                    Profesor actualizado = profesorService.save(profesor);
                    return ResponseEntity.ok(actualizado);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Eliminar profesor por ID", description = "Elimina un registro de profesor por su ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id)
    {
        if (!profesorService.existsById(id))
        {
            return ResponseEntity.notFound().build();
        }
        profesorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
