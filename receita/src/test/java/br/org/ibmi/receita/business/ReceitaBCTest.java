

package br.org.ibmi.receita.business;

import static org.junit.Assert.*;
import java.util.*;
import javax.inject.Inject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import br.gov.frameworkdemoiselle.junit.DemoiselleRunner;
import br.org.ibmi.receita.domain.Receita;
import br.org.ibmi.receita.business.ReceitaBC;

@RunWith(DemoiselleRunner.class)
public class ReceitaBCTest {

    @Inject
	private ReceitaBC receitaBC;
	
	@Before
	public void before() {
		for (Receita receita : receitaBC.findAll()) {
			receitaBC.delete(receita.getCodigo());
		}
	}	
	
	
	@Test
	public void testInsert() {
				
		// modifique para inserir dados conforme o construtor
		Receita receita = new Receita();
		receitaBC.insert(receita);
		List<Receita> listOfReceita = receitaBC.findAll();
		assertNotNull(listOfReceita);
		assertEquals(1, listOfReceita.size());
	}	
	
	@Test
	public void testDelete() {
		
		// modifique para inserir dados conforme o construtor
		Receita receita = new Receita();
		receitaBC.insert(receita);
		
		List<Receita> listOfReceita = receitaBC.findAll();
		assertNotNull(listOfReceita);
		assertEquals(1, listOfReceita.size());
		
		receitaBC.delete(receita.getCodigo());
		listOfReceita = receitaBC.findAll();
		assertEquals(0, listOfReceita.size());
	}
	
	@Test
	public void testUpdate() {
		// modifique para inserir dados conforme o construtor
		Receita receita = new Receita();
		receitaBC.insert(receita);
		
		List<Receita> listOfReceita = receitaBC.findAll();
		Receita receita2 = (Receita)listOfReceita.get(0);
		assertNotNull(listOfReceita);

		// alterar para tratar uma propriedade existente na Entidade Receita
		// receita2.setUmaPropriedade("novo valor");
		receitaBC.update(receita2);
		
		listOfReceita = receitaBC.findAll();
		Receita receita3 = (Receita)listOfReceita.get(0);
		
		// alterar para tratar uma propriedade existente na Entidade Receita
		// assertEquals("novo valor", receita3.getUmaPropriedade());
	}

}