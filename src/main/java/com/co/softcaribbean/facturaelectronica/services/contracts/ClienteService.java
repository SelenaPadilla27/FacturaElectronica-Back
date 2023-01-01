package com.co.softcaribbean.facturaelectronica.services.contracts;

import com.co.softcaribbean.facturaelectronica.models.Cliente;
import java.util.List;

public interface ClienteService {


    List<Cliente> getCliente();

    void eliminar(Long id);

    void registrar(Cliente cliente);

    Cliente obtenerClientePorId(Long id);
}

