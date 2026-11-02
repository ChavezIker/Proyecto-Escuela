package org.gerdoc.dao.impl;

import java.util.List;
import org.gerdoc.dao.AlumnoMateriaDao;
import org.gerdoc.helper.HibernateUtil;
import org.gerdoc.model.AlumnoMateria;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AlumnoMateriaDaoImpl implements AlumnoMateriaDao {

    @Override
    public List<AlumnoMateria> getAlumnoMateriaList() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<AlumnoMateria> list = null;
        try {
            list = session.createQuery("from AlumnoMateria", AlumnoMateria.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
    }

    @Override
    public AlumnoMateria getAlumnoMateriaById(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        AlumnoMateria alumnoMateria = null;
        try {
            alumnoMateria = session.get(AlumnoMateria.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return alumnoMateria;
    }

    @Override
    public boolean addAlumnoMateria(AlumnoMateria alumnoMateria) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        boolean success = false;
        try {
            tx = session.beginTransaction();
            session.save(alumnoMateria);
            tx.commit();
            success = true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return success;
    }

    @Override
    public boolean updateAlumnoMateria(AlumnoMateria alumnoMateria) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        boolean success = false;
        try {
            tx = session.beginTransaction();
            session.update(alumnoMateria);
            tx.commit();
            success = true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return success;
    }

    @Override
    public boolean deleteAlumnoMateria(AlumnoMateria alumnoMateria) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        boolean success = false;
        try {
            tx = session.beginTransaction();
            session.delete(alumnoMateria);
            tx.commit();
            success = true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return success;
    }
}
