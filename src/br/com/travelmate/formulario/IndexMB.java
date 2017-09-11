package br.com.travelmate.formulario;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.travelmate.model.Banco;
import br.com.travelmate.util.GerarListas;

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
		listaBanco = GerarListas.listarBancos();
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
