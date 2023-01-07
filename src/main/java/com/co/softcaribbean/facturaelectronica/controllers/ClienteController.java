package com.co.softcaribbean.facturaelectronica.controllers;

import com.co.softcaribbean.facturaelectronica.models.Cliente;
import com.co.softcaribbean.facturaelectronica.models.Paciente;
import com.co.softcaribbean.facturaelectronica.services.contracts.ClienteService;
import com.co.softcaribbean.facturaelectronica.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Cliente> obtenerCliente(@RequestHeader(value = "Authorization") String token){
        if(!validarToken(token)) return null;
        return  clienteService.getCliente();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void eliminar(@RequestHeader(value = "Authorization") String token, @PathVariable Long id) {
        if(validarToken(token))
        clienteService.eliminar(id);
    }
    @RequestMapping(value = "/agregarCliente", method = RequestMethod.POST)
    public Cliente registrarCliente(@RequestHeader(value = "Authorization") String token, @RequestBody Cliente cliente){
        if(validarToken(token))
            return clienteService.registrar(cliente);
        return null;
    }

    @RequestMapping(value = "/actualizarCliente/{id}", method = RequestMethod.POST)
    public Cliente  actualizarCliente(@RequestHeader(value = "Authorization") String token, @RequestBody Cliente cliente, @PathVariable Long id){
        if(validarToken(token))
            return clienteService.actualizarCliente(cliente, id);
        return null;
    }
    @RequestMapping(value = "/obtenerPorId/{id}", method = RequestMethod.GET)
    public Cliente obtenerPorId(@RequestHeader(value = "Authorization") String token, @PathVariable Long id){
        if(!validarToken(token)) return null;
        return clienteService.obtenerClientePorId(id);
    }

    private boolean validarToken(String token){
        String usuarioId = jwtUtil.getKey(token);
        return usuarioId != null;
    }
}
