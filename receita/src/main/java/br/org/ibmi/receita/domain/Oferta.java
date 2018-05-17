package br.org.ibmi.receita.domain;

import java.io.Serializable;

import javax.money.MonetaryAmount;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.javamoney.moneta.Money;

@Entity
@Table(name="oferta")
public class Oferta implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="cod_oferta")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	
	@Column
	private Money valorOferta;
	
	@ManyToOne(optional = true)
	@JoinColumn(name = "cod_tipo_oferta", nullable=false)
	private TipoOferta tipoOferta;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}	

	public TipoOferta getTipoOferta() {
		return tipoOferta;
	}

	public void setTipoOferta(TipoOferta tipoOferta) {
		this.tipoOferta = tipoOferta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result
				+ ((tipoOferta == null) ? 0 : tipoOferta.hashCode());
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
		Oferta other = (Oferta) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (tipoOferta == null) {
			if (other.tipoOferta != null)
				return false;
		} else if (!tipoOferta.equals(other.tipoOferta))
			return false;
		return true;
	}

	public Money getValorOferta() {
		return valorOferta;
	}

	public void setValorOferta(Money valorOferta) {
		this.valorOferta = valorOferta;
	}

	
	
	
	

}
