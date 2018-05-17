package br.org.ibmi.receita.view;

import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.org.ibmi.receita.business.ReceitaBC;
import br.org.ibmi.receita.domain.Receita;

@ViewController
@NextView("./receita_edit.jsf")
@PreviousView("./receita_list.jsf")
public class ReceitaListMB extends AbstractListPageBean<Receita, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private ReceitaBC receitaBC;
	
	@Override
	protected List<Receita> handleResultList() {
		return this.receitaBC.findAll();
	}
	
	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long id = iter.next();
			delete = getSelection().get(id);
			if (delete) {
				receitaBC.delete(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}

}