package br.org.ibmi.receita.util;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;


public class Util implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public Double converteStringDouble (String valor){
		DecimalFormat formato = new DecimalFormat("");
		
		Double valorDouble = null;
		
		try {
			formato.applyLocalizedPattern("#.#00,0#");
			valorDouble = formato.parse(valor).doubleValue();
			
					
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
							
		return valorDouble;
			
	}
	
		
	public String converteDoubleString (Double valor){
		
		NumberFormat df = NumberFormat.getCurrencyInstance();
		
		String dx = df.format(valor);
							
		return dx.substring(3);	
		
	}
	
	public BigDecimal converteStringBigDecimal (String valor){	
		
		DecimalFormat formato = new DecimalFormat("");
				
		BigDecimal valorBigDecimal = null;			
		
		formato.applyLocalizedPattern("#.#00,0#");
		formato.setParseBigDecimal(true);
		try {
			valorBigDecimal = (BigDecimal) formato.parse(valor);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
							
		return valorBigDecimal;
			
	}
	
	public String converteBigDecimalString (BigDecimal valor){
		
		BigDecimal bd = BigDecimal.valueOf(valor.doubleValue());
		
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		
		String valorTotalDizimoString = nf.format (bd);
		
		return valorTotalDizimoString;
		
	}
	
	public String converteBigDecimalStringSemCifrao (BigDecimal valor){		
			
		NumberFormat df = NumberFormat.getCurrencyInstance();
		
		String dx = df.format(valor.doubleValue());
							
		return dx.substring(3);
		
	}
	
	
		
}
