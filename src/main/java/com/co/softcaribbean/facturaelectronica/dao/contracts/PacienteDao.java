package com.co.softcaribbean.facturaelectronica.dao.contracts;
import com.co.softcaribbean.facturaelectronica.models.Paciente;
import java.util.List;

public interface PacienteDao {

    List<Paciente> getPacinete();
    void eliminar(Paciente paciente);
    Paciente registrar(Paciente paciente);
    Paciente obtenerPacientePorId(Long id);
    Paciente actualizarPaciente(Paciente paciente);
}
