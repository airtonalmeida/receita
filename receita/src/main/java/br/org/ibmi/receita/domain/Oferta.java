package br.org.ibmi.receita.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
	
	
	@Column (name="valor_oferta")
	private BigDecimal valorOferta;
	
	@Column (name="valor_oferta_string")
	private String valorOfertaString;
	
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

	
	public BigDecimal getValorOferta() {
		return valorOferta;
	}

	public void setValorOferta(BigDecimal valorOferta) {
		this.valorOferta = valorOferta;
	}

	public String getValorOfertaString() {
		return valorOfertaString;
	}

	public void setValorOfertaString(String valorOfertaString) {
		this.valorOfertaString = valorOfertaString;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result
				+ ((tipoOferta == null) ? 0 : tipoOferta.hashCode());
		result = prime * result
				+ ((valorOferta == null) ? 0 : valorOferta.hashCode());
		result = prime
				* result
				+ ((valorOfertaString == null) ? 0 : valorOfertaString
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
		if (valorOferta == null) {
			if (other.valorOferta != null)
				return false;
		} else if (!valorOferta.equals(other.valorOferta))
			return false;
		if (valorOfertaString == null) {
			if (other.valorOfertaString != null)
				return false;
		} else if (!valorOfertaString.equals(other.valorOfertaString))
			return false;
		return true;
	}

	
	
	
	
	
	

}
