package org.gerdoc.service;

import java.util.List;
import org.gerdoc.model.AlumnoMateria;

public interface AlumnoMateriaService {
    List<AlumnoMateria> getAlumnoMateriaList();
    AlumnoMateria getAlumnoMateriaById(Integer id);
    boolean addAlumnoMateria(AlumnoMateria alumnoMateria);
    boolean updateAlumnoMateria(AlumnoMateria alumnoMateria);
    boolean deleteAlumnoMateria(AlumnoMateria alumnoMateria);
}
