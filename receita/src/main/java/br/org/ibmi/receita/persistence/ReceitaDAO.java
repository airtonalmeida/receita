package br.org.ibmi.receita.persistence;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

import br.org.ibmi.receita.domain.Receita;

@PersistenceController
public class ReceitaDAO extends JPACrud<Receita, Long> {

	private static final long serialVersionUID = 1L;
	

}
