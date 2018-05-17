
package br.org.ibmi.receita.view;

import javax.inject.Inject;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.org.ibmi.receita.business.*;
import br.org.ibmi.receita.domain.*;
import javax.faces.model.*;
import org.primefaces.event.TransferEvent;
import org.primefaces.model.DualListModel;
import java.util.*;

// To remove unused imports press: Ctrl+Shift+o

@ViewController
@PreviousView("./oferta_list.jsf")
public class OfertaEditMB extends AbstractEditPageBean<Oferta, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private OfertaBC ofertaBC;
	

	@Inject
	private TipoOfertaBC tipoOfertaBC;
	
	public List<TipoOferta> getTipoOfertaList(){
		return tipoOfertaBC.findAll();
	}
			
	
	@Override
	@Transactional
	public String delete() {
		this.ofertaBC.delete(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String insert() {
		this.ofertaBC.insert(this.getBean());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		this.ofertaBC.update(this.getBean());
		return getPreviousView();
	}
	
	@Override
	protected Oferta handleLoad(Long id) {
		return this.ofertaBC.load(id);
	}	
}