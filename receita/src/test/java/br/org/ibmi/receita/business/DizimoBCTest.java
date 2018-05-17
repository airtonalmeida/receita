

package br.org.ibmi.receita.business;

import static org.junit.Assert.*;
import java.util.*;
import javax.inject.Inject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import br.gov.frameworkdemoiselle.junit.DemoiselleRunner;
import br.org.ibmi.receita.domain.Dizimo;
import br.org.ibmi.receita.business.DizimoBC;

@RunWith(DemoiselleRunner.class)
public class DizimoBCTest {

    @Inject
	private DizimoBC dizimoBC;
	
	@Before
	public void before() {
		for (Dizimo dizimo : dizimoBC.findAll()) {
			dizimoBC.delete(dizimo.getCodigo());
		}
	}	
	
	
	@Test
	public void testInsert() {
				
		// modifique para inserir dados conforme o construtor
		Dizimo dizimo = new Dizimo();
		dizimoBC.insert(dizimo);
		List<Dizimo> listOfDizimo = dizimoBC.findAll();
		assertNotNull(listOfDizimo);
		assertEquals(1, listOfDizimo.size());
	}	
	
	@Test
	public void testDelete() {
		
		// modifique para inserir dados conforme o construtor
		Dizimo dizimo = new Dizimo();
		dizimoBC.insert(dizimo);
		
		List<Dizimo> listOfDizimo = dizimoBC.findAll();
		assertNotNull(listOfDizimo);
		assertEquals(1, listOfDizimo.size());
		
		dizimoBC.delete(dizimo.getCodigo());
		listOfDizimo = dizimoBC.findAll();
		assertEquals(0, listOfDizimo.size());
	}
	
	@Test
	public void testUpdate() {
		// modifique para inserir dados conforme o construtor
		Dizimo dizimo = new Dizimo();
		dizimoBC.insert(dizimo);
		
		List<Dizimo> listOfDizimo = dizimoBC.findAll();
		Dizimo dizimo2 = (Dizimo)listOfDizimo.get(0);
		assertNotNull(listOfDizimo);

		// alterar para tratar uma propriedade existente na Entidade Dizimo
		// dizimo2.setUmaPropriedade("novo valor");
		dizimoBC.update(dizimo2);
		
		listOfDizimo = dizimoBC.findAll();
		Dizimo dizimo3 = (Dizimo)listOfDizimo.get(0);
		
		// alterar para tratar uma propriedade existente na Entidade Dizimo
		// assertEquals("novo valor", dizimo3.getUmaPropriedade());
	}

}