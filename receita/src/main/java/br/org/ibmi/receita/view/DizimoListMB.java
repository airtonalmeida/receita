package br.org.ibmi.receita.view;

import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.org.ibmi.receita.business.DizimoBC;
import br.org.ibmi.receita.domain.Dizimo;

@ViewController
@NextView("./dizimo_edit.jsf")
@PreviousView("./dizimo_list.jsf")
public class DizimoListMB extends AbstractListPageBean<Dizimo, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private DizimoBC dizimoBC;
	
	@Override
	protected List<Dizimo> handleResultList() {
		return this.dizimoBC.findAll();
	}
	
	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long id = iter.next();
			delete = getSelection().get(id);
			if (delete) {
				dizimoBC.delete(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}

}