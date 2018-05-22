
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
		BigDecimal valor = null;
		
		 if(receita.getValorTotalDizimo() !=null){
			 
			 valor = receita.getValorTotalDizimo();
		 }else{
			 
			 valor = new BigDecimal(0);			 
		 }
	
		BigDecimal valorTotalDizimo = valor;
		
		for (Iterator<Dizimo> iterator = receita.getDizimos().iterator(); iterator
				.hasNext();) {
			Dizimo dizimo = iterator.next();

			if (dizimo.getValorDizimoString() != null) {
				valorTotalDizimo = valorTotalDizimo.add
						(util.converteStringBigDecimal(dizimo.getValorDizimoString()));
			}
		}
		
		BigDecimal bd = BigDecimal.valueOf(valorTotalDizimo.doubleValue());
		
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		
		String s = nf.format (bd);
		
		receita.setValorTotalDizimoString(s);
		
		receita.setValorTotalDizimo(valorTotalDizimo);
		
		return receita;		
		
	}
}
