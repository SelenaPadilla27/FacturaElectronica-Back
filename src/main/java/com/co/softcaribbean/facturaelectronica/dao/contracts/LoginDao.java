package com.co.softcaribbean.facturaelectronica.dao.contracts;

import com.co.softcaribbean.facturaelectronica.models.Cliente;
import com.co.softcaribbean.facturaelectronica.models.Login;

public interface LoginDao {

    Login obtenerUsuarioPorCrediales(Login login);

    void registrar(Login login);
}
