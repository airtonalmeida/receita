
package br.org.ibmi.receita.business;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Iterator;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.org.ibmi.receita.domain.Dizimo;
import br.org.ibmi.receita.domain.Receita;
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
}
