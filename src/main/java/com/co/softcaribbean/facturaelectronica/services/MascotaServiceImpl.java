package com.co.softcaribbean.facturaelectronica.services;

import com.co.softcaribbean.facturaelectronica.dao.contracts.ClienteDao;
import com.co.softcaribbean.facturaelectronica.dao.contracts.MascotaDao;
import com.co.softcaribbean.facturaelectronica.models.Cliente;
import com.co.softcaribbean.facturaelectronica.models.Mascota;
import com.co.softcaribbean.facturaelectronica.models.Paciente;
import com.co.softcaribbean.facturaelectronica.services.contracts.MascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MascotaServiceImpl implements MascotaService {

    @Autowired
    private MascotaDao mascotaDao;
    @Autowired
    private ClienteDao clienteDao;

    @Transactional(readOnly = true)
    @Override
    public List<Mascota> getMascota() {
        return mascotaDao.getMascota();
    }

    @Transactional
    @Override
    public void eliminar(Long id) {
        Mascota mascota = mascotaDao.obtenerMascotaPorId(id);
        if (mascota != null) mascotaDao.eliminar(mascota);
    }

    @Transactional
    @Override
    public Mascota registrar(Mascota mascota, Long id) {
        Cliente cliente = clienteDao.obtenerClientePorId(id);
        if(cliente != null && mascota != null){
            mascota.setCliente(cliente);
            return mascotaDao.registrar(mascota);
        }
         return  null;
    }

    @Transactional(readOnly = true)
    @Override
    public Mascota obtenerMascotaPorId(Long id) {
        Mascota mascota = mascotaDao.obtenerMascotaPorId(id);
        if (mascota != null) return mascota;
        return null;
    }

    @Transactional
    @Override
    public Mascota actualizarMascota(Mascota mascota, Long id) {
        Cliente cliente = clienteDao.obtenerClientePorId(id);
        Mascota mascotaTemp = new Mascota();
        if (cliente != null && mascota != null) {
            mascotaTemp = mascotaDao.obtenerMascotaPorId(mascota.getId());
            if(mascotaTemp != null){
                mascotaTemp.setCliente(cliente);
                mascotaTemp.setColorMascota(mascota.getColorMascota());
                mascotaTemp.setEspecieMascota(mascota.getEspecieMascota());
                mascotaTemp.setNomMascota(mascota.getNomMascota());
                mascotaTemp.setRazaMascota(mascota.getRazaMascota());

                return mascotaDao.actualizarMascota(mascotaTemp);
            }

        }
        return mascotaTemp;
    }

}
