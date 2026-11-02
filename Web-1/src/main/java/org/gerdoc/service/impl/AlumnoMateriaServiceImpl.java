package org.gerdoc.service.impl;

import java.util.List;
import org.gerdoc.dao.AlumnoMateriaDao;
import org.gerdoc.dao.impl.AlumnoMateriaDaoImpl;
import org.gerdoc.model.AlumnoMateria;
import org.gerdoc.service.AlumnoMateriaService;

public class AlumnoMateriaServiceImpl implements AlumnoMateriaService {

    private AlumnoMateriaDao alumnoMateriaDao = new AlumnoMateriaDaoImpl();

    @Override
    public List<AlumnoMateria> getAlumnoMateriaList() {
        return alumnoMateriaDao.getAlumnoMateriaList();
    }

    @Override
    public AlumnoMateria getAlumnoMateriaById(Integer id) {
        return alumnoMateriaDao.getAlumnoMateriaById(id);
    }

    @Override
    public boolean addAlumnoMateria(AlumnoMateria alumnoMateria) {
        return alumnoMateriaDao.addAlumnoMateria(alumnoMateria);
    }

    @Override
    public boolean updateAlumnoMateria(AlumnoMateria alumnoMateria) {
        return alumnoMateriaDao.updateAlumnoMateria(alumnoMateria);
    }

    @Override
    public boolean deleteAlumnoMateria(AlumnoMateria alumnoMateria) {
        return alumnoMateriaDao.deleteAlumnoMateria(alumnoMateria);
    }
}
