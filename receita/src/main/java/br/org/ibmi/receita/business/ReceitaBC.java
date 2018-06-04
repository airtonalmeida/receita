
package br.org.ibmi.receita.business;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Iterator;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.org.ibmi.receita.domain.Dizimo;
import br.org.ibmi.receita.domain.Oferta;
import br.org.ibmi.receita.domain.Receita;
import br.org.ibmi.receita.domain.RecursoDiverso;
import br.org.ibmi.receita.persistence.ReceitaDAO;
import br.org.ibmi.receita.util.Util;


// To remove unused imports press: Ctrl+Shift+o

@BusinessController
public class ReceitaBC extends DelegateCrud<Receita, Long, ReceitaDAO> {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Util util;
	
	public Receita calcularValorTotalDizimo(Receita receita) {
		BigDecimal valorTotalDizimo = new BigDecimal(0);
		BigDecimal valorTotalReceita = new BigDecimal(0);
		BigDecimal valorTotalOferta = new BigDecimal(0);
		BigDecimal valorTotalRecursoDiverso = new BigDecimal(0);
		
		for (Iterator<Dizimo> iterator = receita.getDizimos().iterator(); iterator
				.hasNext();) {
			Dizimo dizimo = iterator.next();

			if (dizimo.getValorDizimoString() != null) {
				valorTotalDizimo = valorTotalDizimo.add
						(util.converteStringBigDecimal(dizimo.getValorDizimoString()));
			}
		}
		
		receita.setValorTotalDizimoString(util.converteBigDecimalString(valorTotalDizimo));
		
		receita.setValorTotalDizimo(valorTotalDizimo);
		
		if(receita.getValorTotalOferta()!=null){
			
			valorTotalOferta = receita.getValorTotalOferta();
			
		}if(receita.getValorTotalRecursoDiverso()!=null){
			
			valorTotalRecursoDiverso = receita.getValorTotalRecursoDiverso();
		}
		
		
		valorTotalReceita = receita.getValorTotalDizimo().add(valorTotalOferta)
				.add(valorTotalRecursoDiverso);
		
		receita.setValorTotalReceitaString(util.converteBigDecimalString(valorTotalReceita));
		
		receita.setValorTotalReceita(valorTotalReceita);		
		
		return receita;		
		
	}	
	
	
	public Receita calcularValorTotalDizimoSubtrair(Receita receita, String valor) {
		BigDecimal valorTotalDizimo = new BigDecimal(0);
		BigDecimal valorTotalReceita = new BigDecimal(0);
		BigDecimal valorTotalOferta = new BigDecimal(0);
		BigDecimal valorTotalRecursoDiverso = new BigDecimal(0);
		
		if(receita.getValorTotalDizimo()!=null){
			
			valorTotalDizimo = receita.getValorTotalDizimo();			
		
		}if(receita.getValorTotalReceita()!=null){
			
			valorTotalReceita = receita.getValorTotalReceita();			
		
		}if(receita.getValorTotalOferta()!=null){
			
			valorTotalOferta = receita.getValorTotalOferta();			
		
		}if(receita.getValorTotalRecursoDiverso()!=null){
			
			valorTotalRecursoDiverso = receita.getValorTotalRecursoDiverso();			
		}
		
		if(valor==""){
			
			valor="0";
		}
		
		valorTotalDizimo = valorTotalDizimo.subtract(util.converteStringBigDecimal(valor));
		
		receita.setValorTotalDizimo(valorTotalDizimo);
				
		receita.setValorTotalDizimoString(util.converteBigDecimalString(valorTotalDizimo));		
		
		if(receita.getValorTotalOferta()!=null){
			
			valorTotalOferta = receita.getValorTotalOferta();
			
		}if(receita.getValorTotalRecursoDiverso()!=null){
			
			valorTotalRecursoDiverso = receita.getValorTotalRecursoDiverso();
		}
		
		
		valorTotalReceita = receita.getValorTotalDizimo().add(valorTotalOferta)
				.add(valorTotalRecursoDiverso);
		
		receita.setValorTotalReceitaString(util.converteBigDecimalString(valorTotalReceita));
		
		receita.setValorTotalReceita(valorTotalReceita);		
		
		return receita;		
		
	}
	
	public Receita calcularValorTotalOferta(Receita receita) {
		BigDecimal valorTotalDizimo = new BigDecimal(0);
		BigDecimal valorTotalReceita = new BigDecimal(0);
		BigDecimal valorTotalOferta = new BigDecimal(0);
		BigDecimal valorTotalRecursoDiverso = new BigDecimal(0);
		
		for (Iterator<Oferta> iterator = receita.getOfertas().iterator(); iterator
				.hasNext();) {
			Oferta oferta = iterator.next();

			if (oferta.getValorOfertaString() != null) {
				valorTotalOferta = valorTotalOferta.add
						(util.converteStringBigDecimal(oferta.getValorOfertaString()));
			}
		}
		
		receita.setValorTotalOfertaString(util.converteBigDecimalString(valorTotalOferta));
		
		receita.setValorTotalOferta(valorTotalOferta);
		
		if(receita.getValorTotalDizimo()!=null){
			
			valorTotalDizimo = receita.getValorTotalDizimo();
			
		}if(receita.getValorTotalRecursoDiverso()!=null){
			
			valorTotalRecursoDiverso = receita.getValorTotalRecursoDiverso();
		}
		
		
		valorTotalReceita = receita.getValorTotalOferta().add(valorTotalDizimo)
				.add(valorTotalRecursoDiverso);
		
		receita.setValorTotalReceitaString(util.converteBigDecimalString(valorTotalReceita));
		
		receita.setValorTotalReceita(valorTotalReceita);		
		
		return receita;		
		
	}
	
	public Receita calcularValorTotalOfertaSubtrair(Receita receita, String valor) {
		BigDecimal valorTotalDizimo = new BigDecimal(0);
		BigDecimal valorTotalReceita = new BigDecimal(0);
		BigDecimal valorTotalOferta = new BigDecimal(0);
		BigDecimal valorTotalRecursoDiverso = new BigDecimal(0);
		
		if(receita.getValorTotalDizimo()!=null){
			
			valorTotalDizimo = receita.getValorTotalDizimo();			
		
		}if(receita.getValorTotalReceita()!=null){
			
			valorTotalReceita = receita.getValorTotalReceita();			
		
		}if(receita.getValorTotalOferta()!=null){
			
			valorTotalOferta = receita.getValorTotalOferta();			
		
		}if(receita.getValorTotalRecursoDiverso()!=null){
			
			valorTotalRecursoDiverso = receita.getValorTotalRecursoDiverso();			
		}
		
		if(valor==""){
			
			valor="0";
		}
		
		valorTotalOferta = valorTotalOferta.subtract(util.converteStringBigDecimal(valor));
		
		receita.setValorTotalOferta(valorTotalOferta);
				
		receita.setValorTotalOfertaString(util.converteBigDecimalString(valorTotalOferta));		
		
		if(receita.getValorTotalDizimo()!=null){
			
			valorTotalDizimo = receita.getValorTotalDizimo();
			
		}if(receita.getValorTotalRecursoDiverso()!=null){
			
			valorTotalRecursoDiverso = receita.getValorTotalRecursoDiverso();
		}
		
		
		valorTotalReceita = receita.getValorTotalOferta().add(valorTotalDizimo)
				.add(valorTotalRecursoDiverso);
		
		receita.setValorTotalReceitaString(util.converteBigDecimalString(valorTotalReceita));
		
		receita.setValorTotalReceita(valorTotalReceita);		
		
		return receita;		
		
	}
	
	public Receita calcularValorTotalRecursoDiverso(Receita receita) {
		BigDecimal valorTotalDizimo = new BigDecimal(0);
		BigDecimal valorTotalReceita = new BigDecimal(0);
		BigDecimal valorTotalOferta = new BigDecimal(0);
		BigDecimal valorTotalRecursoDiverso = new BigDecimal(0);
		
		for (Iterator<RecursoDiverso> iterator = receita.getRecursosDiversos().iterator(); iterator
				.hasNext();) {
			RecursoDiverso recursoDiverso = iterator.next();

			if (recursoDiverso.getValorRecursoDiversoString() != null) {
				valorTotalRecursoDiverso = valorTotalRecursoDiverso.add
						(util.converteStringBigDecimal(recursoDiverso.getValorRecursoDiversoString()));
			}
		}
		
		receita.setValorTotalRecursoDiversoString(util.converteBigDecimalString(valorTotalRecursoDiverso));
		
		receita.setValorTotalRecursoDiverso(valorTotalRecursoDiverso);
		
		if(receita.getValorTotalOferta()!=null){
			
			valorTotalOferta = receita.getValorTotalOferta();
			
		}if(receita.getValorTotalDizimo()!=null){
			
			valorTotalDizimo = receita.getValorTotalDizimo();
		}
		
		
		valorTotalReceita = receita.getValorTotalRecursoDiverso().add(valorTotalOferta)
				.add(valorTotalDizimo);
		
		receita.setValorTotalReceitaString(util.converteBigDecimalString(valorTotalReceita));
		
		receita.setValorTotalReceita(valorTotalReceita);		
		
		return receita;		
		
	}	
	
	
	public Receita calcularValorTotalRecursoDiversoSubtrair(Receita receita, String valor) {
		BigDecimal valorTotalDizimo = new BigDecimal(0);
		BigDecimal valorTotalReceita = new BigDecimal(0);
		BigDecimal valorTotalOferta = new BigDecimal(0);
		BigDecimal valorTotalRecursoDiverso = new BigDecimal(0);
		
		if(receita.getValorTotalDizimo()!=null){
			
			valorTotalDizimo = receita.getValorTotalDizimo();			
		
		}if(receita.getValorTotalReceita()!=null){
			
			valorTotalReceita = receita.getValorTotalReceita();			
		
		}if(receita.getValorTotalOferta()!=null){
			
			valorTotalOferta = receita.getValorTotalOferta();			
		
		}if(receita.getValorTotalRecursoDiverso()!=null){
			
			valorTotalRecursoDiverso = receita.getValorTotalRecursoDiverso();			
		}
		
		if(valor==""){
			
			valor="0";
		}
		
		valorTotalRecursoDiverso = valorTotalRecursoDiverso.subtract(util.converteStringBigDecimal(valor));
		
		receita.setValorTotalRecursoDiverso(valorTotalRecursoDiverso);
				
		receita.setValorTotalRecursoDiversoString(util.converteBigDecimalString(valorTotalRecursoDiverso));		
		
		if(receita.getValorTotalOferta()!=null){
			
			valorTotalOferta = receita.getValorTotalOferta();
			
		}if(receita.getValorTotalDizimo()!=null){
			
			valorTotalDizimo = receita.getValorTotalDizimo();
		}
		
		
		valorTotalReceita = receita.getValorTotalRecursoDiverso().add(valorTotalOferta)
				.add(valorTotalDizimo);
		
		receita.setValorTotalReceitaString(util.converteBigDecimalString(valorTotalReceita));
		
		receita.setValorTotalReceita(valorTotalReceita);		
		
		return receita;		
		
	}
}
