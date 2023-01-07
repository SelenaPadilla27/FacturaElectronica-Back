package com.co.softcaribbean.facturaelectronica.services;

import com.co.softcaribbean.facturaelectronica.dao.contracts.MascotaDao;
import com.co.softcaribbean.facturaelectronica.dao.contracts.PacienteDao;

import com.co.softcaribbean.facturaelectronica.models.Mascota;
import com.co.softcaribbean.facturaelectronica.models.Paciente;
import com.co.softcaribbean.facturaelectronica.services.contracts.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class PacienteServiceImpl implements PacienteService {

    @Autowired
    private PacienteDao pacienteDao;
    @Autowired
    private MascotaDao mascotaDao;


    @Transactional(readOnly = true)
    @Override
    public List<Paciente> getPacinete() {
        return pacienteDao.getPacinete();
    }

    @Transactional
    @Override
    public boolean eliminar(Long id) {
        Paciente paciente = pacienteDao.obtenerPacientePorId(id);
        if (paciente != null) {
            try {
                pacienteDao.eliminar(paciente);
                return true;
            } catch (Exception e){
                return false;
            }

        }
        return false;

    }

    @Transactional
    @Override
    public Paciente registrar(Paciente paciente, Long id) {
        Mascota mascota = mascotaDao.obtenerMascotaPorId(id);
        if (mascota != null && paciente != null) {
            paciente.setMascota(mascota);
            return pacienteDao.registrar(paciente);
        }
        return null;
    }

    @Transactional(readOnly = true)
    @Override
    public Paciente obtenerPacientePorId(Long id) {
        Paciente paciente = pacienteDao.obtenerPacientePorId(id);
        if (paciente != null) return paciente;
        return null;
    }
    @Transactional
    @Override
    public Paciente actualizarPaciente(Paciente paciente, Long id) {
        Mascota mascota = mascotaDao.obtenerMascotaPorId(id);
        Paciente pacienteTemp = new Paciente();
        if (mascota != null && paciente != null) {
            pacienteTemp = pacienteDao.obtenerPacientePorId(paciente.getId());
            if(pacienteTemp != null){
                pacienteTemp.setMascota(mascota);
                pacienteTemp.setFecRegistro(paciente.getFecRegistro());
                return pacienteDao.actualizarPaciente(pacienteTemp);
            }

        }
        return pacienteTemp;
    }
}
