package com.co.softcaribbean.facturaelectronica.dao;

import com.co.softcaribbean.facturaelectronica.dao.contracts.PacienteDao;
import com.co.softcaribbean.facturaelectronica.models.Mascota;
import com.co.softcaribbean.facturaelectronica.models.Paciente;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class PacienteDaoImpl implements PacienteDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Paciente> getPacinete() {
        String query = "FROM Paciente";
        return entityManager.createQuery(query).getResultList();

    }


    @Override
    public void eliminar(Paciente paciente) {
        entityManager.remove(paciente);
        entityManager.close();

    }

    @Override
    public Paciente registrar(Paciente paciente) {
        Paciente pacienteRespuesta =  entityManager.merge(paciente);
        entityManager.close();
        return  pacienteRespuesta;
    }

    @Override
    public Paciente obtenerPacientePorId(Long id) {
        String query = "SELECT P FROM Paciente P WHERE id = :id";
        Paciente paciente = (Paciente) entityManager.createQuery(query)
                .setParameter("id", id)
                .getSingleResult();
        entityManager.close();
        if (paciente != null) {
            entityManager.close();
            return paciente;
        }
        return null;
    }

    @Override
    public Paciente actualizarPaciente(Paciente paciente) {
        return entityManager.merge(paciente);
    }


}

