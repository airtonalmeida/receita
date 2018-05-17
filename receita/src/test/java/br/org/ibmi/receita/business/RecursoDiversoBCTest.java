

package br.org.ibmi.receita.business;

import static org.junit.Assert.*;
import java.util.*;
import javax.inject.Inject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import br.gov.frameworkdemoiselle.junit.DemoiselleRunner;
import br.org.ibmi.receita.domain.RecursoDiverso;
import br.org.ibmi.receita.business.RecursoDiversoBC;

@RunWith(DemoiselleRunner.class)
public class RecursoDiversoBCTest {

    @Inject
	private RecursoDiversoBC recursoDiversoBC;
	
	@Before
	public void before() {
		for (RecursoDiverso recursoDiverso : recursoDiversoBC.findAll()) {
			recursoDiversoBC.delete(recursoDiverso.getCodigo());
		}
	}	
	
	
	@Test
	public void testInsert() {
				
		// modifique para inserir dados conforme o construtor
		RecursoDiverso recursoDiverso = new RecursoDiverso();
		recursoDiversoBC.insert(recursoDiverso);
		List<RecursoDiverso> listOfRecursoDiverso = recursoDiversoBC.findAll();
		assertNotNull(listOfRecursoDiverso);
		assertEquals(1, listOfRecursoDiverso.size());
	}	
	
	@Test
	public void testDelete() {
		
		// modifique para inserir dados conforme o construtor
		RecursoDiverso recursoDiverso = new RecursoDiverso();
		recursoDiversoBC.insert(recursoDiverso);
		
		List<RecursoDiverso> listOfRecursoDiverso = recursoDiversoBC.findAll();
		assertNotNull(listOfRecursoDiverso);
		assertEquals(1, listOfRecursoDiverso.size());
		
		recursoDiversoBC.delete(recursoDiverso.getCodigo());
		listOfRecursoDiverso = recursoDiversoBC.findAll();
		assertEquals(0, listOfRecursoDiverso.size());
	}
	
	@Test
	public void testUpdate() {
		// modifique para inserir dados conforme o construtor
		RecursoDiverso recursoDiverso = new RecursoDiverso();
		recursoDiversoBC.insert(recursoDiverso);
		
		List<RecursoDiverso> listOfRecursoDiverso = recursoDiversoBC.findAll();
		RecursoDiverso recursoDiverso2 = (RecursoDiverso)listOfRecursoDiverso.get(0);
		assertNotNull(listOfRecursoDiverso);

		// alterar para tratar uma propriedade existente na Entidade RecursoDiverso
		// recursoDiverso2.setUmaPropriedade("novo valor");
		recursoDiversoBC.update(recursoDiverso2);
		
		listOfRecursoDiverso = recursoDiversoBC.findAll();
		RecursoDiverso recursoDiverso3 = (RecursoDiverso)listOfRecursoDiverso.get(0);
		
		// alterar para tratar uma propriedade existente na Entidade RecursoDiverso
		// assertEquals("novo valor", recursoDiverso3.getUmaPropriedade());
	}

}