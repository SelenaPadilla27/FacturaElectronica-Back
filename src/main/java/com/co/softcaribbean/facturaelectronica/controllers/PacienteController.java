package com.co.softcaribbean.facturaelectronica.controllers;

import com.co.softcaribbean.facturaelectronica.models.Mascota;
import com.co.softcaribbean.facturaelectronica.models.Paciente;
import com.co.softcaribbean.facturaelectronica.services.contracts.MascotaService;
import com.co.softcaribbean.facturaelectronica.services.contracts.PacienteService;
import com.co.softcaribbean.facturaelectronica.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/paciente")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Paciente> obtenerPaciente(@RequestHeader(value = "Authorization") String token){
        if(!validarToken(token)) return null;
        return  pacienteService.getPacinete();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void eliminar(@RequestHeader(value = "Authorization") String token, @PathVariable Long id) {
        if(validarToken(token)) pacienteService.eliminar(id);
    }

    @RequestMapping(value = "/agregarPaciente/{id}", method = RequestMethod.POST)
    public void  registrarPaciente(@RequestHeader(value = "Authorization") String token, @RequestBody Paciente paciente, @PathVariable Long id){
        if(validarToken(token)) pacienteService.registrar(paciente, id);
    }

    @RequestMapping(value = "/obtenerPorId/{id}", method = RequestMethod.GET)
    public Paciente obtenerPorId(@RequestHeader(value = "Authorization") String token, @PathVariable Long id){
        if(!validarToken(token)) return null;
        return pacienteService.obtenerPacientePorId(id);
    }

    @RequestMapping(value = "/actualizarPaciente/{id}", method = RequestMethod.POST)
    public void  actualizarPaciente(@RequestHeader(value = "Authorization") String token, @RequestBody Paciente paciente, @PathVariable Long id){
        if(validarToken(token))  pacienteService.actualizarPaciente(paciente, id);
    }

    private boolean validarToken(String token){
        String usuarioId = jwtUtil.getKey(token);
        return usuarioId != null;
    }
}
