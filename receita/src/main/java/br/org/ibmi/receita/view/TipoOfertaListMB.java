package br.org.ibmi.receita.view;

import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.org.ibmi.receita.business.TipoOfertaBC;
import br.org.ibmi.receita.domain.TipoOferta;

@ViewController
@NextView("./tipoOferta_edit.jsf")
@PreviousView("./tipoOferta_list.jsf")
public class TipoOfertaListMB extends AbstractListPageBean<TipoOferta, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private TipoOfertaBC tipoOfertaBC;
	
	@Override
	protected List<TipoOferta> handleResultList() {
		return this.tipoOfertaBC.findAll();
	}
	
	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long id = iter.next();
			delete = getSelection().get(id);
			if (delete) {
				tipoOfertaBC.delete(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}

}