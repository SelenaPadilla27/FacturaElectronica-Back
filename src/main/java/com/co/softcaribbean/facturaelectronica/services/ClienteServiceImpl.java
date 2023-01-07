package com.co.softcaribbean.facturaelectronica.services;

import com.co.softcaribbean.facturaelectronica.dao.contracts.ClienteDao;
import com.co.softcaribbean.facturaelectronica.models.Cliente;
import com.co.softcaribbean.facturaelectronica.models.Mascota;
import com.co.softcaribbean.facturaelectronica.models.Paciente;
import com.co.softcaribbean.facturaelectronica.services.contracts.ClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteDao clienteDao;

    @Transactional(readOnly = true)
    @Override
    public List<Cliente> getCliente() {
        return clienteDao.getCliente();
    }

    @Transactional
    @Override
    public void eliminar(Long id) {
        Cliente cliente = clienteDao.obtenerClientePorId(id);
        if (cliente != null) clienteDao.eliminar(cliente);

    }

    @Transactional
    @Override
    public Cliente registrar(Cliente cliente) {
        if (cliente != null)
            return clienteDao.registrar(cliente);
        return null;
    }
    @Transactional(readOnly = true)
    @Override
    public Cliente obtenerClientePorId(Long id) {
        Cliente cliente = clienteDao.obtenerClientePorId(id);
        if (cliente != null) return cliente;
        return null;
    }

    @Transactional
    @Override
    public Cliente actualizarCliente(Cliente cliente, Long id) {
        Cliente clienteTem = clienteDao.obtenerClientePorId(id);
        if (clienteTem != null && cliente != null) {
            clienteTem.setApellido(cliente.getApellido());
            clienteTem.setCiudad(cliente.getCiudad());
            clienteTem.setNombre(cliente.getNombre());
            clienteTem.setDireccion(cliente.getDireccion());
            return clienteDao.actualizarCliente(clienteTem);
        }
        return null;
    }
}
