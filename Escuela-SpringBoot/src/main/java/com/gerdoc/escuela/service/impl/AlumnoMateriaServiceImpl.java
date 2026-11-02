package com.gerdoc.escuela.service.impl;

import com.gerdoc.escuela.model.AlumnoMateria;
import com.gerdoc.escuela.repository.AlumnoMateriaRepository;
import com.gerdoc.escuela.service.AlumnoMateriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AlumnoMateriaServiceImpl implements AlumnoMateriaService
{
    private final AlumnoMateriaRepository alumnoMateriaRepository;

    @Override
    @Transactional(readOnly = true)
    public List<AlumnoMateria> findAll()
    {
        return alumnoMateriaRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<AlumnoMateria> findById(Long id)
    {
        return alumnoMateriaRepository.findById(id);
    }

    @Override
    @Transactional
    public AlumnoMateria save(AlumnoMateria alumnoMateria)
    {
        return alumnoMateriaRepository.save(alumnoMateria);
    }

    @Override
    @Transactional
    public void deleteById(Long id)
    {
        alumnoMateriaRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsById(Long id)
    {
        return alumnoMateriaRepository.existsById(id);
    }
}
