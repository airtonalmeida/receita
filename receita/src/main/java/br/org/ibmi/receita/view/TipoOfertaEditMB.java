
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
@PreviousView("./tipoOferta_list.jsf")
public class TipoOfertaEditMB extends AbstractEditPageBean<TipoOferta, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private TipoOfertaBC tipoOfertaBC;
	

	
	@Override
	@Transactional
	public String delete() {
		this.tipoOfertaBC.delete(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String insert() {
		this.tipoOfertaBC.insert(this.getBean());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		this.tipoOfertaBC.update(this.getBean());
		return getPreviousView();
	}
	
	@Override
	protected TipoOferta handleLoad(Long id) {
		return this.tipoOfertaBC.load(id);
	}	
}