package com.co.softcaribbean.facturaelectronica.dao;
import com.co.softcaribbean.facturaelectronica.dao.contracts.ClienteDao;
import com.co.softcaribbean.facturaelectronica.models.Cliente;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ClienteDaoImpl implements ClienteDao{
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public List<Cliente> getCliente(){
        String query = "FROM Cliente";
        return entityManager.createQuery(query).getResultList();
    }
    @Override
    public void eliminar(Cliente cliente){
        entityManager.remove(cliente);
        entityManager.close();
    }
    @Override
    public Cliente registrar(Cliente cliente){
      /*  try{
            Cliente clienteRespuesta = entityManager.merge(cliente);
            entityManager.getTransaction().commit();
        }catch(Exception e){
            entityManager.getTransaction().rollback();
            entityManager.close();
        }*/
        Cliente clienteRespuesta = entityManager.merge(cliente);
        entityManager.close();
        return clienteRespuesta;
    }
    @Override
    public Cliente obtenerClientePorId(Long id){
        String query = "SELECT C FROM Cliente C WHERE id = :id";
        Cliente cliente = (Cliente)
                entityManager.createQuery(query).setParameter("id", id).getSingleResult();
                entityManager.close();
        if (cliente != null) { entityManager.close();
            return cliente;
        }
        return null;
    }
    @Override
    public Cliente actualizarCliente(Cliente cliente){
           return entityManager.merge(cliente);
    }
}
