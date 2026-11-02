package org.gerdoc.dao;

import java.util.List;
import org.gerdoc.model.AlumnoMateria;

public interface AlumnoMateriaDao {
    List<AlumnoMateria> getAlumnoMateriaList();
    AlumnoMateria getAlumnoMateriaById(Integer id);
    boolean addAlumnoMateria(AlumnoMateria alumnoMateria);
    boolean updateAlumnoMateria(AlumnoMateria alumnoMateria);
    boolean deleteAlumnoMateria(AlumnoMateria alumnoMateria);
}
