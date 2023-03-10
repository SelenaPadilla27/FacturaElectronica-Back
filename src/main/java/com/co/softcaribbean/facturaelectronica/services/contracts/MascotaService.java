package com.co.softcaribbean.facturaelectronica.services.contracts;
import com.co.softcaribbean.facturaelectronica.models.Mascota;
import java.util.List;
public interface MascotaService {

    List<Mascota> getMascota();

    void eliminar(Long id);

    Mascota registrar(Mascota mascota, Long id);

   Mascota obtenerMascotaPorId(Long id);

    Mascota actualizarMascota(Mascota mascota, Long id);
}
