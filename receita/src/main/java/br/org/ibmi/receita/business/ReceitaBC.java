
package br.org.ibmi.receita.business;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.org.ibmi.receita.domain.*;
import java.util.*;
import javax.faces.model.*;
import br.org.ibmi.receita.persistence.ReceitaDAO;

// To remove unused imports press: Ctrl+Shift+o

@BusinessController
public class ReceitaBC extends DelegateCrud<Receita, Long, ReceitaDAO> {
	private static final long serialVersionUID = 1L;
	
	
}