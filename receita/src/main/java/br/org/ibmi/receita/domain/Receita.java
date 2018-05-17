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
	
	@Column
	private Money valorTotalReceita;
	
	@Column
	private Money valorTotalDizimo;
	
	@Column
	private Money valorTotalOferta;
	
	@Column
	private Money valorTotalRecursoDiverso;	
	
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
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
		return true;
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
	
	

}
