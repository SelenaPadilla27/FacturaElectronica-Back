package com.co.softcaribbean.facturaelectronica.services.contracts;

import com.co.softcaribbean.facturaelectronica.models.Cliente;
import com.co.softcaribbean.facturaelectronica.models.Login;

public interface LoginService {

    String obtenerUsuarioPorCrediales(Login login);

    void registrar(Login login);
}
