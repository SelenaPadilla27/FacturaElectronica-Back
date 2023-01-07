package com.co.softcaribbean.facturaelectronica.dao;

import com.co.softcaribbean.facturaelectronica.dao.contracts.MascotaDao;
import com.co.softcaribbean.facturaelectronica.models.Cliente;
import com.co.softcaribbean.facturaelectronica.models.Mascota;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class MascotaDaoImpl implements MascotaDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Mascota> getMascota() {
        String query = "FROM Mascota";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void eliminar(Mascota mascota) {
        entityManager.remove(mascota);
        entityManager.close();

    }

    @Override
    public Mascota registrar(Mascota mascota) {
        Mascota mascotaRespuesta = entityManager.merge(mascota);
        entityManager.close();
        return mascotaRespuesta;

    }

    @Override
    public Mascota obtenerMascotaPorId(Long id) {
        String query = "SELECT M FROM Mascota M WHERE id = :id";

        try {
            Mascota mascota = (Mascota) entityManager.createQuery(query)
                    .setParameter("id", id)
                    .getSingleResult();
            entityManager.close();

            if (mascota != null) {
                return mascota;
            }

        } catch (Exception e) {
            return null;
        }
        return null;
    }

    @Override
    public Mascota actualizarMascota(Mascota mascota) {
        return entityManager.merge(mascota);
    }
}
