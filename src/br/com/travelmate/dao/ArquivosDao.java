package br.com.travelmate.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.com.travelmate.connection.ConectionFactory;
import br.com.travelmate.model.Arquivos;

public class ArquivosDao {
	 	
	public Arquivos salvar(Arquivos arquivos) throws SQLException{
		EntityManager manager = ConectionFactory.getInstance(); 
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		arquivos = manager.merge(arquivos); 
		tx.commit();
		return arquivos;
	}
	    
	public Arquivos consultar(int idArquivos) throws SQLException{
		EntityManager manager;
        manager = ConectionFactory.getInstance();
        Arquivos arquivos = manager.find(Arquivos.class, idArquivos);
        
        return arquivos;
    }
	    
	public void excluir(int idArquivos) throws SQLException{
		EntityManager manager;
		manager = ConectionFactory.getInstance();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		Arquivos arquivos = manager.find(Arquivos.class, idArquivos);
		manager.remove(arquivos);
		tx.commit();
		
	}
	    
	public List<Arquivos> listar(String sql)throws SQLException{
		EntityManager manager;
		manager = ConectionFactory.getInstance();
		Query q = manager.createQuery(sql);
		List<Arquivos> lista = null;
		if (q.getResultList().size()>0){
			lista =  q.getResultList();
		}
		
		return lista;
	}
}
