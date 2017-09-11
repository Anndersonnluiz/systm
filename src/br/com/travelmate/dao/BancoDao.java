package br.com.travelmate.dao;
import br.com.travelmate.connection.ConectionFactory;
import br.com.travelmate.connection.pool.Transactional;
import br.com.travelmate.model.Banco; 

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Wolverine
 */
public class BancoDao {
	
	@Inject
	private EntityManager manager;
    
	
	@Transactional
    public List<Banco> listar() throws SQLException{
    	manager = ConectionFactory.getInstance();
        Query q = manager.createQuery("select b from Banco b order by b.nome");
        List<Banco> lista = q.getResultList();
        return lista;
    }
    
    
	@Transactional
    public List<Banco> listar(String sql) throws SQLException{
    	manager = ConectionFactory.getInstance();
        Query q = manager.createQuery(sql);
        List<Banco> lista = q.getResultList();
        return lista;
    }
    
	@Transactional
    public Banco getBanco(String sql) throws SQLException{
        manager = ConectionFactory.getInstance();
        Query q = manager.createQuery(sql);
        Banco banco = null;
        if (q.getResultList().size()>0){
        	banco = (Banco) q.getResultList().get(0);
        }
        return banco;
    }
    
    
    @Transactional
    public Banco salvar(Banco banco) throws SQLException{
        banco = manager.merge(banco);
        return banco;
    }
      
}
