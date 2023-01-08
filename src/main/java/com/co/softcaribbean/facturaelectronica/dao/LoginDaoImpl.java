package com.co.softcaribbean.facturaelectronica.dao;
import com.co.softcaribbean.facturaelectronica.dao.contracts.LoginDao;
import com.co.softcaribbean.facturaelectronica.models.Login;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository
public class LoginDaoImpl implements LoginDao {
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public Login obtenerUsuarioPorCrediales(Login login){
        String query = "FROM Login WHERE email = :email";
        List<Login> lista = entityManager.createQuery(query)
                .setParameter("email", login.getEmail())
                .getResultList();
        if (lista.isEmpty() && lista.size() <= 0){
            return null;
        }
        return lista.get(0);
    }
    @Override
    public void registrar(Login login){
        entityManager.merge(login);
        entityManager.close();
    }
}
