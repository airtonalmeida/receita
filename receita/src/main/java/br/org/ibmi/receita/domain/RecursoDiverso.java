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
@Table(name="recurso_diverso")
public class RecursoDiverso implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="cod_recurso_diverso")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@Column
	private String descricao;
	
	@Column (name="valor_rec_div")
	private BigDecimal valorRecursoDiverso;
	
	@Column (name="valor_rec__div_string")
	private String valorRecursoDiversoString;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}	
	
	public BigDecimal getValorRecursoDiverso() {
		return valorRecursoDiverso;
	}

	public void setValorRecursoDiverso(BigDecimal valorRecursoDiverso) {
		this.valorRecursoDiverso = valorRecursoDiverso;
	}

	public String getValorRecursoDiversoString() {
		return valorRecursoDiversoString;
	}

	public void setValorRecursoDiversoString(String valorRecursoDiversoString) {
		this.valorRecursoDiversoString = valorRecursoDiversoString;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime
				* result
				+ ((valorRecursoDiverso == null) ? 0 : valorRecursoDiverso
						.hashCode());
		result = prime
				* result
				+ ((valorRecursoDiversoString == null) ? 0
						: valorRecursoDiversoString.hashCode());
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
		RecursoDiverso other = (RecursoDiverso) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (valorRecursoDiverso == null) {
			if (other.valorRecursoDiverso != null)
				return false;
		} else if (!valorRecursoDiverso.equals(other.valorRecursoDiverso))
			return false;
		if (valorRecursoDiversoString == null) {
			if (other.valorRecursoDiversoString != null)
				return false;
		} else if (!valorRecursoDiversoString
				.equals(other.valorRecursoDiversoString))
			return false;
		return true;
	}

	

	

}
