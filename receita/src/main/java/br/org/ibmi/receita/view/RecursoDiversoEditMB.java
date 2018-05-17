
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
@PreviousView("./recursoDiverso_list.jsf")
public class RecursoDiversoEditMB extends AbstractEditPageBean<RecursoDiverso, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private RecursoDiversoBC recursoDiversoBC;
	

	
	@Override
	@Transactional
	public String delete() {
		this.recursoDiversoBC.delete(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String insert() {
		this.recursoDiversoBC.insert(this.getBean());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		this.recursoDiversoBC.update(this.getBean());
		return getPreviousView();
	}
	
	@Override
	protected RecursoDiverso handleLoad(Long id) {
		return this.recursoDiversoBC.load(id);
	}	
}