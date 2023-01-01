package com.co.softcaribbean.facturaelectronica.dao.contracts;

import com.co.softcaribbean.facturaelectronica.models.Cliente;

import java.util.List;

public interface ClienteDao  {

    List<Cliente> getCliente();

    void eliminar(Cliente cliente);

    void registrar(Cliente cliente);

    Cliente obtenerClientePorId(Long id);
}
