package com.co.softcaribbean.facturaelectronica.controllers;
import com.co.softcaribbean.facturaelectronica.models.Login;
import com.co.softcaribbean.facturaelectronica.services.contracts.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/login")
public class AuthController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Map<String, String> login(@RequestBody Login login) {
        Map<String, String> respuesta = new HashMap<>();
         respuesta.put("token", loginService.obtenerUsuarioPorCrediales(login));
        return respuesta;
    }
    @RequestMapping(value = "/agregarlogin", method = RequestMethod.POST)
    public void registrarlogin(@RequestBody Login login) {
        loginService.registrar(login);
    }
}

