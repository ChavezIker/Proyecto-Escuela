package com.gerdoc.escuela.service.impl;

import com.gerdoc.escuela.model.ProfesorMateria;
import com.gerdoc.escuela.repository.ProfesorMateriaRepository;
import com.gerdoc.escuela.service.ProfesorMateriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfesorMateriaServiceImpl implements ProfesorMateriaService
{
    private final ProfesorMateriaRepository profesorMateriaRepository;

    @Override
    @Transactional(readOnly = true)
    public List<ProfesorMateria> findAll()
    {
        return profesorMateriaRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ProfesorMateria> findById(Long id)
    {
        return profesorMateriaRepository.findById(id);
    }

    @Override
    @Transactional
    public ProfesorMateria save(ProfesorMateria profesorMateria)
    {
        return profesorMateriaRepository.save(profesorMateria);
    }

    @Override
    @Transactional
    public void deleteById(Long id)
    {
        profesorMateriaRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsById(Long id)
    {
        return profesorMateriaRepository.existsById(id);
    }
}
