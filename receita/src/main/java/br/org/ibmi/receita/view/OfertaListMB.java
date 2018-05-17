package br.org.ibmi.receita.view;

import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.org.ibmi.receita.business.OfertaBC;
import br.org.ibmi.receita.domain.Oferta;

@ViewController
@NextView("./oferta_edit.jsf")
@PreviousView("./oferta_list.jsf")
public class OfertaListMB extends AbstractListPageBean<Oferta, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private OfertaBC ofertaBC;
	
	@Override
	protected List<Oferta> handleResultList() {
		return this.ofertaBC.findAll();
	}
	
	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long id = iter.next();
			delete = getSelection().get(id);
			if (delete) {
				ofertaBC.delete(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}

}