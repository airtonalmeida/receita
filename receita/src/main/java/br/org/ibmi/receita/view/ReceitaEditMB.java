
package br.org.ibmi.receita.view;

import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;

import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.org.ibmi.receita.business.ReceitaBC;
import br.org.ibmi.receita.business.TipoOfertaBC;
import br.org.ibmi.receita.domain.Dizimo;
import br.org.ibmi.receita.domain.Oferta;
import br.org.ibmi.receita.domain.Receita;
import br.org.ibmi.receita.domain.RecursoDiverso;
import br.org.ibmi.receita.domain.TipoOferta;

// To remove unused imports press: Ctrl+Shift+o

@ViewController
@PreviousView("./receita_list.jsf")
public class ReceitaEditMB extends AbstractEditPageBean<Receita, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private ReceitaBC receitaBC;
	
	@Inject
	private TipoOfertaBC tipoOfertaBC;
	
	public List<TipoOferta> getTipoOfertaList(){
		return tipoOfertaBC.findAll();
	}

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
	
	public void obterDiaNumeroSemana(){
		
		   Date data = new Date(); 
		  
		   data =  this.getBean().getData();  
		   
		   Calendar cal = new GregorianCalendar();
		   
		   cal.setTime(data);
		
		   String diaDaSemana = new DateFormatSymbols().getWeekdays()[cal.get(Calendar.DAY_OF_WEEK)];
		   
		   this.getBean().setDiaSemana(diaDaSemana);
		   
		   Integer numeroDaSemana = cal.get(Calendar.WEEK_OF_MONTH);		   
		   
		   this.getBean().setNumeroSemanaMes(numeroDaSemana);		
		
	}
	
	public void calcularValorTotalDizimo() {
		
		Receita receita = new Receita();
		
		receita = receitaBC.calcularValorTotalDizimo(this.getBean());
		
		this.getBean().setValorTotalDizimoString(receita.getValorTotalDizimoString());
		
		
	}
}