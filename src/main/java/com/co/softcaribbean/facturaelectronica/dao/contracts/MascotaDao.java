package com.co.softcaribbean.facturaelectronica.dao.contracts;

import com.co.softcaribbean.facturaelectronica.models.Cliente;
import com.co.softcaribbean.facturaelectronica.models.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MascotaDao {
    List<Mascota> getMascota();

    void eliminar(Mascota mascota);

    Mascota registrar(Mascota mascota);

    Mascota obtenerMascotaPorId(Long id);

    Mascota actualizarMascota(Mascota mascota);

}
