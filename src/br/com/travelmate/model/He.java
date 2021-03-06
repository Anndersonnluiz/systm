package br.com.travelmate.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import br.com.travelmate.model.Questionariohe; 
import br.com.travelmate.model.Vendas;

/**
 *
 * @author jizid
 */
@Entity
@Table(name = "he")
public class He implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idhe")
    private Integer idhe;
    @Size(max = 50)
    @Column(name = "primeiralingua")
    private String primeiralingua;
    @Size(max = 50)
    @Column(name = "segundalingua")
    private String segundalingua;
    @Column(name = "numerosemanas")
    private Integer numerosemanas;
    @Column(name = "datainicio")
    @Temporal(TemporalType.DATE)
    private Date datainicio;  
    @Column(name = "datatermino")
    @Temporal(TemporalType.DATE)
    private Date datatermino;
    @Size(max = 100)
    @Column(name = "curso1")
    private String curso1;
    @Size(max = 100)
    @Column(name = "curso2")
    private String curso2;
    @Size(max = 100)
    @Column(name = "curso3")
    private String curso3;
    @Size(max = 20)
    @Column(name = "codigo1")
    private String codigo1;
    @Size(max = 20)
    @Column(name = "codigo2")
    private String codigo2;
    @Size(max = 20)
    @Column(name = "codigo3")
    private String codigo3;
    @Size(max = 50)
    @Column(name = "paisprograma")
    private String paisprograma;
    @Size(max = 7)
    @Column(name = "mesano1")
    private String mesano1;
    @Size(max = 7)
    @Column(name = "mesano2")
    private String mesano2;
    @Size(max = 7)
    @Column(name = "mesano3")
    private String mesano3; 
    @Size(max = 3)
    @Column(name = "possuiexame")
    private String possuiexame;
    @Size(max = 50)
    @Column(name = "nomeexame")
    private String nomeexame;
    @Size(max = 10)
    @Column(name = "notaexame")
    private String notaexame;
    @Column(name = "dataexame")
    @Temporal(TemporalType.DATE)
    private Date dataexame;
    @Size(max = 3)
    @Column(name = "cursarparhaway")
    private String cursarparhaway;
    @Size(max = 100)
    @Column(name = "nomeinstituicaoestudou")
    private String nomeinstituicaoestudou;
    @Size(max = 100)
    @Column(name = "maiorgrauformacao")
    private String maiorgrauformacao;
    @Size(max = 10)
    @Column(name = "bandeiracartao")
    private String bandeiracartao;
    @Size(max = 30)
    @Column(name = "numerocartao")
    private String numerocartao;
    @Size(max = 10)
    @Column(name = "datavlidade")
    private String datavlidade;
    @Size(max = 50)
    @Column(name = "nometitular")
    private String nometitular;
    @Size(max = 3)
    @Column(name = "codigoseguranca")
    private String codigoseguranca;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valorinscricao")
    private Float valorinscricao;
    @Column(name = "assessoriatm")
    private Float assessoriatm;
    @JoinColumn(name = "questionariohe_idquestionariohe", referencedColumnName = "idquestionariohe")
    @OneToOne(optional = false)
    private Questionariohe questionariohe;   
    @JoinColumn(name = "vendas_idvendas", referencedColumnName = "idvendas")
    @ManyToOne(optional = false)
    private Vendas vendas;
    @JoinColumn(name = "vendas_idvendas1", referencedColumnName = "idvendas")
    @ManyToOne(optional = false)
    private Vendas vendas1;
    @Column(name = "aprovado")
    private boolean aprovado;
    @Column(name = "fichafinal")
    private boolean fichafinal; 
    @Size(max = 100)
    @Column(name = "instituicaoensinomedio")
    private String instituicaoensinomedio;
    @Size(max = 4)
    @Column(name = "anoconclusao")
    private String anoconclusao;
    @Size(max = 100)
    @Column(name = "localconclusaoensinomedo")
    private String localconclusaoensinomedo;

    public He() {
    }

    public He(Integer idhe) {
        this.idhe = idhe;
    }

    public Integer getIdhe() {
        return idhe;
    }

    public void setIdhe(Integer idhe) {
        this.idhe = idhe;
    }

    public String getPrimeiralingua() {
        return primeiralingua;
    }

    public void setPrimeiralingua(String primeiralingua) {
        this.primeiralingua = primeiralingua;
    }

    public String getSegundalingua() {
        return segundalingua;
    }

    public void setSegundalingua(String segundalingua) {
        this.segundalingua = segundalingua;
    }

    public Integer getNumerosemanas() {
        return numerosemanas;
    }

    public void setNumerosemanas(Integer numerosemanas) {
        this.numerosemanas = numerosemanas;
    }

    public Date getDatainicio() {
        return datainicio;
    }

    public void setDatainicio(Date datainicio) {
        this.datainicio = datainicio;
    }

    public Date getDatatermino() {
        return datatermino;
    }

    public void setDatatermino(Date datatermino) {
        this.datatermino = datatermino;
    }

    public String getCurso1() {
        return curso1;
    }

    public void setCurso1(String curso1) {
        this.curso1 = curso1;
    }

    public String getCurso2() {
        return curso2;
    }

    public void setCurso2(String curso2) {
        this.curso2 = curso2;
    }

    public String getCurso3() {
        return curso3;
    }

    public void setCurso3(String curso3) {
        this.curso3 = curso3;
    }

    public String getCodigo1() {
        return codigo1;
    }

    public void setCodigo1(String codigo1) {
        this.codigo1 = codigo1;
    }

    public String getCodigo2() {
        return codigo2;
    }

    public void setCodigo2(String codigo2) {
        this.codigo2 = codigo2;
    }

    public String getCodigo3() {
        return codigo3;
    }

    public void setCodigo3(String codigo3) {
        this.codigo3 = codigo3;
    }

    public String getPaisprograma() {
        return paisprograma;
    }

    public void setPaisprograma(String paisprograma) {
        this.paisprograma = paisprograma;
    }

    public String getMesano1() {
        return mesano1;
    }

    public void setMesano1(String mesano1) {
        this.mesano1 = mesano1;
    }

    public String getMesano2() {
        return mesano2;
    }

    public void setMesano2(String mesano2) {
        this.mesano2 = mesano2;
    }

    public String getMesano3() {
        return mesano3;
    }

    public void setMesano3(String mesano3) {
        this.mesano3 = mesano3;
    }
 
    public String getPossuiexame() {
        return possuiexame;
    }

    public void setPossuiexame(String possuiexame) {
        this.possuiexame = possuiexame;
    }

    public String getNomeexame() {
        return nomeexame;
    }

    public void setNomeexame(String nomeexame) {
        this.nomeexame = nomeexame;
    }

    public String getNotaexame() {
        return notaexame;
    }

    public void setNotaexame(String notaexame) {
        this.notaexame = notaexame;
    }

    public Date getDataexame() {
        return dataexame;
    }

    public void setDataexame(Date dataexame) {
        this.dataexame = dataexame;
    }

    public String getCursarparhaway() {
        return cursarparhaway;
    }

    public void setCursarparhaway(String cursarparhaway) {
        this.cursarparhaway = cursarparhaway;
    }

    public String getNomeinstituicaoestudou() {
        return nomeinstituicaoestudou;
    }

    public void setNomeinstituicaoestudou(String nomeinstituicaoestudou) {
        this.nomeinstituicaoestudou = nomeinstituicaoestudou;
    }

    public String getMaiorgrauformacao() {
        return maiorgrauformacao;
    }

    public void setMaiorgrauformacao(String maiorgrauformacao) {
        this.maiorgrauformacao = maiorgrauformacao;
    }

    public String getBandeiracartao() {
        return bandeiracartao;
    }

    public void setBandeiracartao(String bandeiracartao) {
        this.bandeiracartao = bandeiracartao;
    }

    public String getNumerocartao() {
        return numerocartao;
    }

    public void setNumerocartao(String numerocartao) {
        this.numerocartao = numerocartao;
    }

    public String getDatavlidade() {
        return datavlidade;
    }

    public void setDatavlidade(String datavlidade) {
        this.datavlidade = datavlidade;
    }

    public String getNometitular() {
        return nometitular;
    }

    public void setNometitular(String nometitular) {
        this.nometitular = nometitular;
    }

    public Float getValorinscricao() {
        return valorinscricao;
    }

    public void setValorinscricao(Float valorinscricao) {
        this.valorinscricao = valorinscricao;
    }

    public Float getAssessoriatm() {
        return assessoriatm;
    }

    public void setAssessoriatm(Float assessoriatm) {
        this.assessoriatm = assessoriatm;
    }

    public Questionariohe getQuestionariohe() {
        return questionariohe;
    }

    public void setQuestionariohe(Questionariohe questionariohe) {
        this.questionariohe = questionariohe;
    }
 
    public Vendas getVendas() {
        return vendas;
    }

    public void setVendas(Vendas vendas) {
        this.vendas = vendas;
    }

    public boolean isAprovado() {
		return aprovado;
	}

	public void setAprovado(boolean aprovado) {
		this.aprovado = aprovado;
	}

	public String getCodigoseguranca() {
		return codigoseguranca;
	}

	public void setCodigoseguranca(String codigoseguranca) {
		this.codigoseguranca = codigoseguranca;
	}

	public boolean isFichafinal() {
		return fichafinal;
	}

	public void setFichafinal(boolean fichafinal) {
		this.fichafinal = fichafinal;
	} 
 

	public Vendas getVendas1() {
		return vendas1;
	}

	public void setVendas1(Vendas vendas1) {
		this.vendas1 = vendas1;
	}

	public String getInstituicaoensinomedio() {
		return instituicaoensinomedio;
	}

	public void setInstituicaoensinomedio(String instituicaoensinomedio) {
		this.instituicaoensinomedio = instituicaoensinomedio;
	}

	public String getAnoconclusao() {
		return anoconclusao;
	}

	public void setAnoconclusao(String anoconclusao) {
		this.anoconclusao = anoconclusao;
	}

	public String getLocalconclusaoensinomedo() {
		return localconclusaoensinomedo;
	}

	public void setLocalconclusaoensinomedo(String localconclusaoensinomedo) {
		this.localconclusaoensinomedo = localconclusaoensinomedo;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idhe != null ? idhe.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof He)) {
            return false;
        }
        He other = (He) object;
        if ((this.idhe == null && other.idhe != null) || (this.idhe != null && !this.idhe.equals(other.idhe))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.travelmate.model.He[ idhe=" + idhe + " ]";
    }
    
}
