package br.org.ibmi.receita.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.money.MonetaryAmount;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.javamoney.moneta.Money;


@Entity
@Table(name="receita")
public class Receita implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="cod_receita")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;	
	
	@Column(name="valor_total_receita")
	private Money valorTotalReceita;
	
	@Column(name="valor_total_dizimo")
	private Money valorTotalDizimo;
	
	@Column(name="valor_total_oferta")
	private Money valorTotalOferta;
	
	@Column(name="valor_total_rec_div")
	private Money valorTotalRecursoDiverso;	
	
	@Column(name="valor_total_receita_str")
	private String valorTotalReceitaString;
	
	@Column(name="valor_total_dizimo_str")
	private String valorTotalDizimoString;
	
	@Column(name="valor_total_oferta_str")
	private String valorTotalOfertaString;
	
	@Column(name="valor_total_rec_div_str")
	private String valorTotalRecursoDiversoString;	
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "cod_receita")
	private List<Dizimo> dizimos = new ArrayList<Dizimo>();	
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "cod_receita")
	private List<Oferta> ofertas = new ArrayList<Oferta>();	
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "cod_receita")
	private List<RecursoDiverso> recursosDiversos = new ArrayList<RecursoDiverso>();
	
	@Temporal(value = TemporalType.DATE)
	private Date data;
	
	@Column
	private String diaSemana;
	
	@Column
	private Integer numeroSemanaMes;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public MonetaryAmount getValorTotalReceita() {
		return valorTotalReceita;
	}

	public List<Oferta> getOfertas() {
		return ofertas;
	}

	public void setOfertas(List<Oferta> ofertas) {
		this.ofertas = ofertas;
	}

	public List<RecursoDiverso> getRecursosDiversos() {
		return recursosDiversos;
	}

	public void setRecursosDiversos(List<RecursoDiverso> recursosDiversos) {
		this.recursosDiversos = recursosDiversos;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	public List<Dizimo> getDizimos() {
		return dizimos;
	}

	public void setDizimos(List<Dizimo> dizimos) {
		this.dizimos = dizimos;
	}

	public String getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}

	public Integer getNumeroSemanaMes() {
		return numeroSemanaMes;
	}

	public void setNumeroSemanaMes(Integer numeroSemanaMes) {
		this.numeroSemanaMes = numeroSemanaMes;
	}	

	public Money getValorTotalDizimo() {
		return valorTotalDizimo;
	}

	public void setValorTotalDizimo(Money valorTotalDizimo) {
		this.valorTotalDizimo = valorTotalDizimo;
	}

	public Money getValorTotalOferta() {
		return valorTotalOferta;
	}

	public void setValorTotalOferta(Money valorTotalOferta) {
		this.valorTotalOferta = valorTotalOferta;
	}

	public Money getValorTotalRecursoDiverso() {
		return valorTotalRecursoDiverso;
	}

	public void setValorTotalRecursoDiverso(Money valorTotalRecursoDiverso) {
		this.valorTotalRecursoDiverso = valorTotalRecursoDiverso;
	}

	public void setValorTotalReceita(Money valorTotalReceita) {
		this.valorTotalReceita = valorTotalReceita;
	}

	public String getValorTotalReceitaString() {
		return valorTotalReceitaString;
	}

	public void setValorTotalReceitaString(String valorTotalReceitaString) {
		this.valorTotalReceitaString = valorTotalReceitaString;
	}

	public String getValorTotalDizimoString() {
		return valorTotalDizimoString;
	}

	public void setValorTotalDizimoString(String valorTotalDizimoString) {
		this.valorTotalDizimoString = valorTotalDizimoString;
	}

	public String getValorTotalOfertaString() {
		return valorTotalOfertaString;
	}

	public void setValorTotalOfertaString(String valorTotalOfertaString) {
		this.valorTotalOfertaString = valorTotalOfertaString;
	}

	public String getValorTotalRecursoDiversoString() {
		return valorTotalRecursoDiversoString;
	}

	public void setValorTotalRecursoDiversoString(
			String valorTotalRecursoDiversoString) {
		this.valorTotalRecursoDiversoString = valorTotalRecursoDiversoString;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result
				+ ((diaSemana == null) ? 0 : diaSemana.hashCode());
		result = prime * result + ((dizimos == null) ? 0 : dizimos.hashCode());
		result = prime * result
				+ ((numeroSemanaMes == null) ? 0 : numeroSemanaMes.hashCode());
		result = prime * result + ((ofertas == null) ? 0 : ofertas.hashCode());
		result = prime
				* result
				+ ((recursosDiversos == null) ? 0 : recursosDiversos.hashCode());
		result = prime
				* result
				+ ((valorTotalDizimo == null) ? 0 : valorTotalDizimo.hashCode());
		result = prime
				* result
				+ ((valorTotalDizimoString == null) ? 0
						: valorTotalDizimoString.hashCode());
		result = prime
				* result
				+ ((valorTotalOferta == null) ? 0 : valorTotalOferta.hashCode());
		result = prime
				* result
				+ ((valorTotalOfertaString == null) ? 0
						: valorTotalOfertaString.hashCode());
		result = prime
				* result
				+ ((valorTotalReceita == null) ? 0 : valorTotalReceita
						.hashCode());
		result = prime
				* result
				+ ((valorTotalReceitaString == null) ? 0
						: valorTotalReceitaString.hashCode());
		result = prime
				* result
				+ ((valorTotalRecursoDiverso == null) ? 0
						: valorTotalRecursoDiverso.hashCode());
		result = prime
				* result
				+ ((valorTotalRecursoDiversoString == null) ? 0
						: valorTotalRecursoDiversoString.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Receita other = (Receita) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (diaSemana == null) {
			if (other.diaSemana != null)
				return false;
		} else if (!diaSemana.equals(other.diaSemana))
			return false;
		if (dizimos == null) {
			if (other.dizimos != null)
				return false;
		} else if (!dizimos.equals(other.dizimos))
			return false;
		if (numeroSemanaMes == null) {
			if (other.numeroSemanaMes != null)
				return false;
		} else if (!numeroSemanaMes.equals(other.numeroSemanaMes))
			return false;
		if (ofertas == null) {
			if (other.ofertas != null)
				return false;
		} else if (!ofertas.equals(other.ofertas))
			return false;
		if (recursosDiversos == null) {
			if (other.recursosDiversos != null)
				return false;
		} else if (!recursosDiversos.equals(other.recursosDiversos))
			return false;
		if (valorTotalDizimo == null) {
			if (other.valorTotalDizimo != null)
				return false;
		} else if (!valorTotalDizimo.equals(other.valorTotalDizimo))
			return false;
		if (valorTotalDizimoString == null) {
			if (other.valorTotalDizimoString != null)
				return false;
		} else if (!valorTotalDizimoString.equals(other.valorTotalDizimoString))
			return false;
		if (valorTotalOferta == null) {
			if (other.valorTotalOferta != null)
				return false;
		} else if (!valorTotalOferta.equals(other.valorTotalOferta))
			return false;
		if (valorTotalOfertaString == null) {
			if (other.valorTotalOfertaString != null)
				return false;
		} else if (!valorTotalOfertaString.equals(other.valorTotalOfertaString))
			return false;
		if (valorTotalReceita == null) {
			if (other.valorTotalReceita != null)
				return false;
		} else if (!valorTotalReceita.equals(other.valorTotalReceita))
			return false;
		if (valorTotalReceitaString == null) {
			if (other.valorTotalReceitaString != null)
				return false;
		} else if (!valorTotalReceitaString
				.equals(other.valorTotalReceitaString))
			return false;
		if (valorTotalRecursoDiverso == null) {
			if (other.valorTotalRecursoDiverso != null)
				return false;
		} else if (!valorTotalRecursoDiverso
				.equals(other.valorTotalRecursoDiverso))
			return false;
		if (valorTotalRecursoDiversoString == null) {
			if (other.valorTotalRecursoDiversoString != null)
				return false;
		} else if (!valorTotalRecursoDiversoString
				.equals(other.valorTotalRecursoDiversoString))
			return false;
		return true;
	}	
	
	

}
