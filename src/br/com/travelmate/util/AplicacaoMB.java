package br.com.travelmate.util;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import br.com.travelmate.facade.CambioFacade;
import br.com.travelmate.facade.ParametrosProdutosFacade;
import br.com.travelmate.facade.RegraVendaFacade;
import br.com.travelmate.facade.UsuarioPontosFacade;
import br.com.travelmate.facade.VendasFacade;
import br.com.travelmate.model.Cambio;
import br.com.travelmate.model.Parametrosprodutos;
import br.com.travelmate.model.Pontuacaovendas;
import br.com.travelmate.model.Regravenda;
import br.com.travelmate.model.Usuariopontos;
import br.com.travelmate.model.Vendas;
import br.com.travelmate.util.Formatacao;
import br.com.travelmate.util.Mensagem;

@Named
@ApplicationScoped
public class AplicacaoMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String mascara8;
	private String mascara9;
	private Parametrosprodutos parametrosprodutos;  
	private String iata;
	private String uds;
	private String eur;
	private String gbp;
	private String cad;
	private String aud;
	private String nzd;
	private String chf;
	private String zar;
	private List<Cambio> listaCambio;
	private String datacambio;

	@PostConstruct
	public void init() {
		mascara8 = "(99)9999-9999";
		mascara9 = "(99)99999-9999";
		ParametrosProdutosFacade parametrosProdutosFacade = new ParametrosProdutosFacade();
		parametrosprodutos = parametrosProdutosFacade.consultar();
		carregarCambioDia(new Date());
	}

	public String getMascara8() {
		return mascara8;
	}

	public void setMascara8(String mascara8) {
		this.mascara8 = mascara8;
	}

	public String getMascara9() {
		return mascara9;
	}

	public void setMascara9(String mascara9) {
		this.mascara9 = mascara9;
	}

	public Parametrosprodutos getParametrosprodutos() {
		return parametrosprodutos;
	}

	public void setParametrosprodutos(Parametrosprodutos parametrosprodutos) {
		this.parametrosprodutos = parametrosprodutos;
	}

	public String getIata() {
		return iata;
	}

	public void setIata(String iata) {
		this.iata = iata;
	}

	public String getUds() {
		return uds;
	}

	public void setUds(String uds) {
		this.uds = uds;
	}

	public String getEur() {
		return eur;
	}

	public void setEur(String eur) {
		this.eur = eur;
	}

	public String getGbp() {
		return gbp;
	}

	public void setGbp(String gbp) {
		this.gbp = gbp;
	}

	public String getCad() {
		return cad;
	}

	public void setCad(String cad) {
		this.cad = cad;
	}

	public String getAud() {
		return aud;
	}

	public void setAud(String aud) {
		this.aud = aud;
	}

	public String getNzd() {
		return nzd;
	}

	public void setNzd(String nzd) {
		this.nzd = nzd;
	}

	public String getChf() {
		return chf;
	}

	public void setChf(String chf) {
		this.chf = chf;
	}

	public String getZar() {
		return zar;
	}

	public void setZar(String zar) {
		this.zar = zar;
	}

	public List<Cambio> getListaCambio() {
		return listaCambio;
	}

	public void setListaCambio(List<Cambio> listaCambio) {
		this.listaCambio = listaCambio;
	}

	public String getDatacambio() {
		return datacambio;
	}

	public void setDatacambio(String datacambio) {
		this.datacambio = datacambio;
	}

	public String validarMascaraTelefone(boolean digitosTelefone) {
		if (digitosTelefone) {
			return getMascara9();
		} else {
			return getMascara8();
		}
	}

	public boolean checkBoxTelefone(int numeroTelefone, String qntdNumTelefone) {
		if (numeroTelefone == 9) {
			if (qntdNumTelefone != null && qntdNumTelefone.length() > 0) {
				if (qntdNumTelefone.length() < 14) {
					return false;
				}
			}
			return true;
		} else {
			if (qntdNumTelefone != null && qntdNumTelefone.length() > 0) {
				if (qntdNumTelefone.length() > 13) {
					return true;
				}
			}
			return false;
		}
	}

	public void carregarCambioDia(Date datacambiohoje) {
		String data = null;
		data = Formatacao.ConvercaoDataSql(datacambiohoje);
		CambioFacade cambioFacade = new CambioFacade();
		listaCambio = cambioFacade.listar(data);
		int contador = 0;
		if ((listaCambio != null) && (listaCambio.size() == 0)) {
			listaCambio = null;
		}
		if (listaCambio == null) {
			while (listaCambio == null) {
				try {
					data = Formatacao.SubtarirDatas(new Date(), contador, "yyyy/MM/dd");
				} catch (Exception ex) {
					Logger.getLogger(UsuarioLogadoMB.class.getName()).log(Level.SEVERE, null, ex);
				}
				listaCambio = cambioFacade.listar(data);
				if ((listaCambio != null) && (listaCambio.size() == 0)) {
					listaCambio = null;
				}
				contador++;
			}
		}

		if (listaCambio == null) {
			datacambio = "Erro";
			iata = "0,0000";
			uds = "0,0000";
			eur = "0,0000";
			gbp = "0,0000";
			cad = "0,0000";
			aud = "0,0000";
			nzd = "0,0000";
			chf = "0,0000";
		} else {
			boolean liberar = true;
			for (int i = 0; i < listaCambio.size(); i++) {
				if(listaCambio.get(i).getValor()==0 && listaCambio.get(i).getMoedas().getIdmoedas()!=8){
					liberar=false;
				}
			}
			if(liberar){
				datacambio = (Formatacao.ConvercaoDataPadrao(listaCambio.get(0).getData()));
				for (int i = 0; i < listaCambio.size(); i++) {
					if (listaCambio.get(i).getMoedas().getSigla().equalsIgnoreCase("IATA")) {
						iata = (Formatacao.formatarValorCambio(listaCambio.get(i).getValor()));
					} else if (listaCambio.get(i).getMoedas().getSigla().equalsIgnoreCase("USD")) {
						uds = (Formatacao.formatarValorCambio(listaCambio.get(i).getValor()));
					} else if (listaCambio.get(i).getMoedas().getSigla().equalsIgnoreCase("EUR")) {
						eur = (Formatacao.formatarValorCambio(listaCambio.get(i).getValor()));
					} else if (listaCambio.get(i).getMoedas().getSigla().equalsIgnoreCase("GBP")) {
						gbp = (Formatacao.formatarValorCambio(listaCambio.get(i).getValor()));
					} else if (listaCambio.get(i).getMoedas().getSigla().equalsIgnoreCase("cad")) {
						cad = (Formatacao.formatarValorCambio(listaCambio.get(i).getValor()));
					} else if (listaCambio.get(i).getMoedas().getSigla().equalsIgnoreCase("aud")) {
						aud = (Formatacao.formatarValorCambio(listaCambio.get(i).getValor()));
					} else if (listaCambio.get(i).getMoedas().getSigla().equalsIgnoreCase("nzd")) {
						nzd = (Formatacao.formatarValorCambio(listaCambio.get(i).getValor()));
					} else if (listaCambio.get(i).getMoedas().getSigla().equalsIgnoreCase("chf")) {
						chf = (Formatacao.formatarValorCambio(listaCambio.get(i).getValor()));
					} else if (listaCambio.get(i).getMoedas().getSigla().equalsIgnoreCase("zar")) {
						zar = (Formatacao.formatarValorCambio(listaCambio.get(i).getValor()));
					}
				} 
			}else{
				Mensagem.lancarMensagemErro("Atenção!", "Moedas com valores zerados!");
			}
		}

	}



}
