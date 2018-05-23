package br.org.ibmi.receita.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dizimo")
public class Dizimo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="cod_dizimo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@Column (name="valor_dizimo")
	private BigDecimal valorDizimo;
	
	@Column (name="valor_dizimo_string")
	private String valorDizimoString;
	
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public BigDecimal getValorDizimo() {
		return valorDizimo;
	}

	public void setValorDizimo(BigDecimal valorDizimo) {
		this.valorDizimo = valorDizimo;
	}
	
	public String getValorDizimoString() {
		return valorDizimoString;
	}

	public void setValorDizimoString(String valorDizimoString) {
		this.valorDizimoString = valorDizimoString;
	}

	
	public Dizimo(Long codigo, BigDecimal valorDizimo) {
		super();
		this.codigo = codigo;
		this.valorDizimo = valorDizimo;
	}
	
	public Dizimo() {
		super();
	
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result
				+ ((valorDizimo == null) ? 0 : valorDizimo.hashCode());
		result = prime
				* result
				+ ((valorDizimoString == null) ? 0 : valorDizimoString
						.hashCode());
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
		Dizimo other = (Dizimo) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (valorDizimo == null) {
			if (other.valorDizimo != null)
				return false;
		} else if (!valorDizimo.equals(other.valorDizimo))
			return false;
		if (valorDizimoString == null) {
			if (other.valorDizimoString != null)
				return false;
		} else if (!valorDizimoString.equals(other.valorDizimoString))
			return false;
		return true;
	}


	


	
	
	

}
