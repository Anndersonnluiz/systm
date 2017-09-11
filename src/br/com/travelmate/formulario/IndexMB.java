package br.com.travelmate.formulario;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import br.com.travelmate.dao.BancoDao;
import br.com.travelmate.model.Banco;

@ManagedBean(name = "indexMB")
@ViewScoped
public class IndexMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Banco banco;
	private List<Banco> listaBanco;
	
	
	@PostConstruct
	public void init(){
		BancoDao bancoDao = new BancoDao();
		try {
			listaBanco = bancoDao.listar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

 
	public Banco getBanco() {
		return banco;
	}


	public void setBanco(Banco banco) {
		this.banco = banco;
	}


	public List<Banco> getListaBanco() {
		return listaBanco;
	}


	public void setListaBanco(List<Banco> listaBanco) {
		this.listaBanco = listaBanco;
	}

	
	
}
