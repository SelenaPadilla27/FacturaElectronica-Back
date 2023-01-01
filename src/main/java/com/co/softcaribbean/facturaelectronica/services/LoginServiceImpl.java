package com.co.softcaribbean.facturaelectronica.services;

import com.co.softcaribbean.facturaelectronica.dao.contracts.ClienteDao;
import com.co.softcaribbean.facturaelectronica.dao.contracts.LoginDao;
import com.co.softcaribbean.facturaelectronica.models.Login;
import com.co.softcaribbean.facturaelectronica.services.contracts.LoginService;
import com.co.softcaribbean.facturaelectronica.utils.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private JWTUtil jwtUtil;
    @Autowired
    private LoginDao loginDao;

    @Transactional
    @Override
    public String obtenerUsuarioPorCrediales(Login login) {
        Login loginTem = loginDao.obtenerUsuarioPorCrediales(login);
        if (loginTem != null) {
            String passwordHashed = loginTem.getPassword();
            Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
            if (argon2.verify(passwordHashed, login.getPassword())) {
                return jwtUtil.create(String.valueOf(loginTem.getId()), loginTem.getEmail());
            }
        }
        return "FAIL";
    }

    @Transactional
    @Override
    public void registrar(Login login) {
        if (login != null) {
            Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
            String hash = argon2.hash(1, 1024, 1, login.getPassword());
            login.setPassword(hash);
            loginDao.registrar(login);
        }
    }
}
