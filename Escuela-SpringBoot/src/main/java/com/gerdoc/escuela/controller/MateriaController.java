package com.gerdoc.escuela.controller;

import com.gerdoc.escuela.model.Materia;
import com.gerdoc.escuela.service.MateriaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag( name = "Materias", description = "Operaciones CRUD para la administración de materias")
@RestController
@RequestMapping("/api/materias")
@RequiredArgsConstructor
public class MateriaController
{
    private final MateriaService materiaService;

    @Operation(summary = "Consultar materias", description = "Obtiene la lista completa de materias registrados")
    @GetMapping
    public ResponseEntity<List<Materia>> findAll()
    {
        return ResponseEntity.ok(materiaService.findAll());
    }

    @Operation(summary = "Consultar materia por ID", description = "Obtiene un registro de materia por su ID")
    @GetMapping("/{id}")
    public ResponseEntity<Materia> findById(@PathVariable Long id)
    {
        return materiaService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Crear materia", description = "Crea un nuevo registro de materia en el sistema")
    @PostMapping
    public ResponseEntity<Materia> create(@RequestBody Materia materia)
    {
        materia.setId(null);
        Materia nuevo = materiaService.save(materia);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(nuevo);
    }

    @Operation(summary = "Actualizar materia", description = "Actualiza los datos de un registro existente de materia")
    @PutMapping("/{id}")
    public ResponseEntity<Materia> update(@PathVariable Long id, @RequestBody Materia materia)
    {
        return materiaService.findById(id)
                .map(existente -> {
                    materia.setId(existente.getId());
                    Materia actualizado = materiaService.save(materia);
                    return ResponseEntity.ok(actualizado);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Eliminar materia por ID", description = "Elimina un registro de materia por su ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id)
    {
        if (!materiaService.existsById(id))
        {
            return ResponseEntity.notFound().build();
        }
        materiaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
