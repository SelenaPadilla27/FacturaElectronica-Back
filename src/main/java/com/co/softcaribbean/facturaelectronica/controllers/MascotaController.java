package com.co.softcaribbean.facturaelectronica.controllers;
import com.co.softcaribbean.facturaelectronica.models.Mascota;
import com.co.softcaribbean.facturaelectronica.services.contracts.MascotaService;
import com.co.softcaribbean.facturaelectronica.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("api/mascota")
public class MascotaController {
    @Autowired
    private MascotaService mascotaService;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Mascota> obtenerMascota(@RequestHeader(value = "Authorization") String token){
        if(!validarToken(token)) return null;
        return  mascotaService.getMascota();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void eliminar(@RequestHeader(value = "Authorization") String token, @PathVariable Long id) {
        if(validarToken(token))
        mascotaService.eliminar(id);
    }

    @RequestMapping(value = "/agregarMascota/{id}", method = RequestMethod.POST)
    public Mascota  registrarMascota(@RequestHeader(value = "Authorization") String token, @RequestBody Mascota mascota, @PathVariable Long id){
        if(validarToken(token))
            return mascotaService.registrar(mascota, id);
        return  null;
    }

    @RequestMapping(value = "/obtenerPorId/{id}", method = RequestMethod.GET)
    public Mascota obtenerPorId(@RequestHeader(value = "Authorization") String token, @PathVariable Long id){
        if(!validarToken(token)) return null;
        return mascotaService.obtenerMascotaPorId(id);
    }

    @RequestMapping(value = "/actualizarMascota/{id}", method = RequestMethod.POST)
    public Mascota  actualizarMascota(@RequestHeader(value = "Authorization") String token, @RequestBody Mascota mascota, @PathVariable Long id){
        if(validarToken(token)) return mascotaService.actualizarMascota(mascota, id);
        return null;
    }
    private boolean validarToken(String token){
        String usuarioId = jwtUtil.getKey(token);
        return usuarioId != null;
    }

}
