package br.com.travelmate.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.travelmate.model.Acessounidade; 

public class AcessoUnidadeDao implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private EntityManager manager;
	
	public Acessounidade salvar(Acessounidade acessounidade) {
		acessounidade = manager.merge(acessounidade);
        return acessounidade;
    } 
   
    public Acessounidade consultar(String sql)  {
        Query q = manager.createQuery(sql);
        Acessounidade acessounidade = null; 
        if (q.getResultList().size() > 0) {
        	acessounidade =  (Acessounidade) q.getResultList().get(0);
        } 
        return acessounidade;
    }
    
    public void excluir(int idcrm) {
		Acessounidade acessounidade = manager.find(Acessounidade.class, idcrm);
        manager.remove(acessounidade);
    }
    
    public List<Acessounidade> lista(String sql){
        Query q = manager.createQuery(sql);
        List<Acessounidade> lista = q.getResultList();
        return lista;
    }

}
