package com.co.softcaribbean.facturaelectronica.services.contracts;
import com.co.softcaribbean.facturaelectronica.models.Paciente;
import java.util.List;

public interface PacienteService {

    List<Paciente> getPacinete();

    boolean eliminar(Long id);

    Paciente registrar(Paciente paciente, Long id);

    Paciente obtenerPacientePorId(Long id);

    Paciente actualizarPaciente(Paciente paciente, Long id);

}
