
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
@PreviousView("./receita_list.jsf")
public class ReceitaEditMB extends AbstractEditPageBean<Receita, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private ReceitaBC receitaBC;
	

	private DataModel<Dizimo> dizimoList;
	
	public void addDizimo() {
		this.getBean().getDizimos().add(new Dizimo());
	}
	public void deleteDizimo() {
	   this.getBean().getDizimos().remove(getDizimoList().getRowData());
	}
	public DataModel<Dizimo> getDizimoList() {
	   if (dizimoList == null) {
		   dizimoList = new ListDataModel<Dizimo>(this.getBean().getDizimos());
	   }
	   return dizimoList;
	} 
	private DataModel<Oferta> ofertaList;
	
	public void addOferta() {
		this.getBean().getOfertas().add(new Oferta());
	}
	public void deleteOferta() {
	   this.getBean().getOfertas().remove(getOfertaList().getRowData());
	}
	public DataModel<Oferta> getOfertaList() {
	   if (ofertaList == null) {
		   ofertaList = new ListDataModel<Oferta>(this.getBean().getOfertas());
	   }
	   return ofertaList;
	} 
	private DataModel<RecursoDiverso> recursoDiversoList;
	
	public void addRecursoDiverso() {
		this.getBean().getRecursosDiversos().add(new RecursoDiverso());
	}
	public void deleteRecursoDiverso() {
	   this.getBean().getRecursosDiversos().remove(getRecursoDiversoList().getRowData());
	}
	public DataModel<RecursoDiverso> getRecursoDiversoList() {
	   if (recursoDiversoList == null) {
		   recursoDiversoList = new ListDataModel<RecursoDiverso>(this.getBean().getRecursosDiversos());
	   }
	   return recursoDiversoList;
	} 
	
	@Override
	@Transactional
	public String delete() {
		this.receitaBC.delete(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String insert() {
		this.receitaBC.insert(this.getBean());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		this.receitaBC.update(this.getBean());
		return getPreviousView();
	}
	
	@Override
	protected Receita handleLoad(Long id) {
		return this.receitaBC.load(id);
	}	
}