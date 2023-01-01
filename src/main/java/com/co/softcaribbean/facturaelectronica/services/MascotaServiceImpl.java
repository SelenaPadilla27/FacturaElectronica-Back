package com.co.softcaribbean.facturaelectronica.services;

import com.co.softcaribbean.facturaelectronica.dao.contracts.ClienteDao;
import com.co.softcaribbean.facturaelectronica.dao.contracts.MascotaDao;
import com.co.softcaribbean.facturaelectronica.models.Cliente;
import com.co.softcaribbean.facturaelectronica.models.Mascota;
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
    public void registrar(Mascota mascota, Long id) {
        Cliente cliente = clienteDao.obtenerClientePorId(id);
        if(cliente != null && mascota != null){
            mascota.setCliente(cliente);
            mascotaDao.registrar(mascota);

        }
    }

    @Transactional(readOnly = true)
    @Override
    public Mascota obtenerMascotaPorId(Long id) {
        Mascota mascota = mascotaDao.obtenerMascotaPorId(id);
        if (mascota != null) return mascota;
        return null;
    }
}
