
package br.org.ibmi.receita.view;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.annotation.PostConstruct;
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
import br.org.ibmi.receita.util.Util;

// To remove unused imports press: Ctrl+Shift+o

@ViewController
@PreviousView("./receita_list.jsf")
public class ReceitaEditMB extends AbstractEditPageBean<Receita, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private ReceitaBC receitaBC;
	
	@Inject
	private Util util;
	
	private BigDecimal percentualDizimo;
	
	private BigDecimal percentualOferta;
	
	private BigDecimal percentualRecursoDiverso;
	
	private String percentualDizimoString;
	
	private String percentualOfertaString;
	
	private String percentualRecursoDiversoString;	
	
	@Inject
	private TipoOfertaBC tipoOfertaBC;
	
	public String getPercentualOfertaString() {
		return percentualOfertaString;
	}
	public void setPercentualOfertaString(String percentualOfertaString) {
		this.percentualOfertaString = percentualOfertaString;
	}
	public String getPercentualRecursoDiversoString() {
		return percentualRecursoDiversoString;
	}
	public void setPercentualRecursoDiversoString(
			String percentualRecursoDiversoString) {
		this.percentualRecursoDiversoString = percentualRecursoDiversoString;
	}
	public String getPercentualDizimoString() {
		return percentualDizimoString;
	}
	public void setPercentualDizimoString(String percentualDizimoString) {
		this.percentualDizimoString = percentualDizimoString;
	}
	public BigDecimal getPercentualDizimo() {
		return percentualDizimo;
	}
	public void setPercentualDizimo(BigDecimal percentualDizimo) {
		this.percentualDizimo = percentualDizimo;
	}
	
	public BigDecimal getPercentualOferta() {
		return percentualOferta;
	}
	public void setPercentualOferta(BigDecimal percentualOferta) {
		this.percentualOferta = percentualOferta;
	}
	public BigDecimal getPercentualRecursoDiverso() {
		return percentualRecursoDiverso;
	}
	public void setPercentualRecursoDiverso(BigDecimal percentualRecursoDiverso) {
		this.percentualRecursoDiverso = percentualRecursoDiverso;
	}
	
	public List<TipoOferta> getTipoOfertaList(){
		return tipoOfertaBC.findAll();
	}

	private DataModel<Dizimo> dizimoList;
	
	public void addDizimo() {
		this.getBean().getDizimos().add(new Dizimo());
	}
	public void deleteDizimo() {		
		
		receitaBC.calcularValorTotalDizimoSubtrair(this.getBean(), getDizimoList().getRowData().getValorDizimoString());
				
	   this.getBean().getDizimos().remove(getDizimoList().getRowData());
	   
	   calcularPercentualDizimo();
		
	   calcularPercentualOferta();
		
	   calcularPercentualRecursoDiverso();
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
		
		receitaBC.calcularValorTotalOfertaSubtrair(this.getBean(), getOfertaList().getRowData().getValorOfertaString());
		
	   this.getBean().getOfertas().remove(getOfertaList().getRowData());
	   
	   calcularPercentualDizimo();
		
		calcularPercentualOferta();
		
		calcularPercentualRecursoDiverso();
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
		
		receitaBC.calcularValorTotalRecursoDiversoSubtrair(this.getBean(), getRecursoDiversoList().getRowData().getValorRecursoDiversoString());
		
	   this.getBean().getRecursosDiversos().remove(getRecursoDiversoList().getRowData());
	   
	   calcularPercentualDizimo();
		
		calcularPercentualOferta();
		
		calcularPercentualRecursoDiverso();
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
	
	 @PostConstruct
	    public void init(){
		 
		 	calcularPercentualDizimo();
			
			calcularPercentualOferta();
			
			calcularPercentualRecursoDiverso();
	        
	    }
	
	public void calcularValorTotalDizimo() {		
		
		receitaBC.calcularValorTotalDizimo(this.getBean());			
		
		calcularPercentualDizimo();
		
		calcularPercentualOferta();
		
		calcularPercentualRecursoDiverso();
		
	}
	
	public void calcularValorTotalOferta() {
		
		receitaBC.calcularValorTotalOferta(this.getBean());
		
		calcularPercentualDizimo();
		
		calcularPercentualOferta();
		
		calcularPercentualRecursoDiverso();
		
	}
	
	public void calcularValorTotalRecursoDiverso() {
		
		receitaBC.calcularValorTotalRecursoDiverso(this.getBean());	
		
		calcularPercentualDizimo();
		
		calcularPercentualOferta();
		
		calcularPercentualRecursoDiverso();
		
	}
	
	public void calcularPercentualDizimo(){
		
		if(this.getBean().getValorTotalDizimo()!=null){
			
			percentualDizimo = new BigDecimal(0);			
						
			BigDecimal cem = new BigDecimal(100);
			
			BigDecimal valor = new BigDecimal(0);			
			
			valor = this.getBean().getValorTotalDizimo();			
			
			if(valor.compareTo(BigDecimal.ZERO)>0){
				
				percentualDizimo = (valor.divide(this.getBean().getValorTotalReceita(),MathContext.DECIMAL32)).multiply(cem);
				
				this.percentualDizimoString = util.converteBigDecimalStringSemCifrao(percentualDizimo);
				
			}
			
		}
		
	}
	
	public void calcularPercentualOferta(){
		
		if(this.getBean().getValorTotalOferta()!=null){
		
			percentualOferta = new BigDecimal(0);			
			
			BigDecimal cem = new BigDecimal(100);
			
			BigDecimal valor = new BigDecimal(0);			
			
			valor = this.getBean().getValorTotalOferta();
			
			if(valor.compareTo(BigDecimal.ZERO)>0){
				
				percentualOferta = (valor.divide(this.getBean().getValorTotalReceita(),MathContext.DECIMAL32)).multiply(cem);
				
				this.percentualOfertaString = util.converteBigDecimalStringSemCifrao(percentualOferta);
			}
			
		}
		
	}

	public void calcularPercentualRecursoDiverso(){	
	
		if(this.getBean().getValorTotalRecursoDiverso()!=null){
			
			percentualRecursoDiverso = new BigDecimal(0);			
			
			BigDecimal cem = new BigDecimal(100);
			
			BigDecimal valor = new BigDecimal(0);			
					
			valor = this.getBean().getValorTotalRecursoDiverso();
		
			if(valor.compareTo(BigDecimal.ZERO)>0){
			
				percentualRecursoDiverso = (valor.divide(this.getBean().getValorTotalReceita(),MathContext.DECIMAL32)).multiply(cem);
				
				this.percentualRecursoDiversoString = util.converteBigDecimalStringSemCifrao(percentualRecursoDiverso);
			}
		
		}
	
	}
	
	
}