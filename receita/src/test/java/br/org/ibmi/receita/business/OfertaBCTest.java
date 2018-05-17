

package br.org.ibmi.receita.business;

import static org.junit.Assert.*;
import java.util.*;
import javax.inject.Inject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import br.gov.frameworkdemoiselle.junit.DemoiselleRunner;
import br.org.ibmi.receita.domain.Oferta;
import br.org.ibmi.receita.business.OfertaBC;

@RunWith(DemoiselleRunner.class)
public class OfertaBCTest {

    @Inject
	private OfertaBC ofertaBC;
	
	@Before
	public void before() {
		for (Oferta oferta : ofertaBC.findAll()) {
			ofertaBC.delete(oferta.getCodigo());
		}
	}	
	
	
	@Test
	public void testInsert() {
				
		// modifique para inserir dados conforme o construtor
		Oferta oferta = new Oferta();
		ofertaBC.insert(oferta);
		List<Oferta> listOfOferta = ofertaBC.findAll();
		assertNotNull(listOfOferta);
		assertEquals(1, listOfOferta.size());
	}	
	
	@Test
	public void testDelete() {
		
		// modifique para inserir dados conforme o construtor
		Oferta oferta = new Oferta();
		ofertaBC.insert(oferta);
		
		List<Oferta> listOfOferta = ofertaBC.findAll();
		assertNotNull(listOfOferta);
		assertEquals(1, listOfOferta.size());
		
		ofertaBC.delete(oferta.getCodigo());
		listOfOferta = ofertaBC.findAll();
		assertEquals(0, listOfOferta.size());
	}
	
	@Test
	public void testUpdate() {
		// modifique para inserir dados conforme o construtor
		Oferta oferta = new Oferta();
		ofertaBC.insert(oferta);
		
		List<Oferta> listOfOferta = ofertaBC.findAll();
		Oferta oferta2 = (Oferta)listOfOferta.get(0);
		assertNotNull(listOfOferta);

		// alterar para tratar uma propriedade existente na Entidade Oferta
		// oferta2.setUmaPropriedade("novo valor");
		ofertaBC.update(oferta2);
		
		listOfOferta = ofertaBC.findAll();
		Oferta oferta3 = (Oferta)listOfOferta.get(0);
		
		// alterar para tratar uma propriedade existente na Entidade Oferta
		// assertEquals("novo valor", oferta3.getUmaPropriedade());
	}

}