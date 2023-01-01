package com.co.softcaribbean.facturaelectronica.dao.contracts;

import com.co.softcaribbean.facturaelectronica.models.Cliente;
import com.co.softcaribbean.facturaelectronica.models.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PacienteDao {

    List<Paciente> getPacinete();

    void eliminar(Paciente paciente);

    void registrar(Paciente paciente);

    Paciente obtenerPacientePorId(Long id);

    Paciente actualizarPaciente(Paciente paciente);


}
