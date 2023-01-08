package com.co.softcaribbean.facturaelectronica.services.contracts;
import com.co.softcaribbean.facturaelectronica.models.Cliente;
import com.co.softcaribbean.facturaelectronica.models.Paciente;
import java.util.List;

public interface ClienteService {
    List<Cliente> getCliente();
    void eliminar(Long id);
    Cliente registrar(Cliente cliente);
    Cliente obtenerClientePorId(Long id);
    Cliente actualizarCliente(Cliente cliente, Long id);
}

