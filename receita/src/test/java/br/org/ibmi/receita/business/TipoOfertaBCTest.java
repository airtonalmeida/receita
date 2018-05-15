

package br.org.ibmi.receita.business;

import static org.junit.Assert.*;
import java.util.*;
import javax.inject.Inject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import br.gov.frameworkdemoiselle.junit.DemoiselleRunner;
import br.org.ibmi.receita.domain.TipoOferta;
import br.org.ibmi.receita.business.TipoOfertaBC;

@RunWith(DemoiselleRunner.class)
public class TipoOfertaBCTest {

    @Inject
	private TipoOfertaBC tipoOfertaBC;
	
	@Before
	public void before() {
		for (TipoOferta tipoOferta : tipoOfertaBC.findAll()) {
			tipoOfertaBC.delete(tipoOferta.getCodigo());
		}
	}	
	
	
	@Test
	public void testInsert() {
				
		// modifique para inserir dados conforme o construtor
		TipoOferta tipoOferta = new TipoOferta();
		tipoOfertaBC.insert(tipoOferta);
		List<TipoOferta> listOfTipoOferta = tipoOfertaBC.findAll();
		assertNotNull(listOfTipoOferta);
		assertEquals(1, listOfTipoOferta.size());
	}	
	
	@Test
	public void testDelete() {
		
		// modifique para inserir dados conforme o construtor
		TipoOferta tipoOferta = new TipoOferta();
		tipoOfertaBC.insert(tipoOferta);
		
		List<TipoOferta> listOfTipoOferta = tipoOfertaBC.findAll();
		assertNotNull(listOfTipoOferta);
		assertEquals(1, listOfTipoOferta.size());
		
		tipoOfertaBC.delete(tipoOferta.getCodigo());
		listOfTipoOferta = tipoOfertaBC.findAll();
		assertEquals(0, listOfTipoOferta.size());
	}
	
	@Test
	public void testUpdate() {
		// modifique para inserir dados conforme o construtor
		TipoOferta tipoOferta = new TipoOferta();
		tipoOfertaBC.insert(tipoOferta);
		
		List<TipoOferta> listOfTipoOferta = tipoOfertaBC.findAll();
		TipoOferta tipoOferta2 = (TipoOferta)listOfTipoOferta.get(0);
		assertNotNull(listOfTipoOferta);

		// alterar para tratar uma propriedade existente na Entidade TipoOferta
		// tipoOferta2.setUmaPropriedade("novo valor");
		tipoOfertaBC.update(tipoOferta2);
		
		listOfTipoOferta = tipoOfertaBC.findAll();
		TipoOferta tipoOferta3 = (TipoOferta)listOfTipoOferta.get(0);
		
		// alterar para tratar uma propriedade existente na Entidade TipoOferta
		// assertEquals("novo valor", tipoOferta3.getUmaPropriedade());
	}

}