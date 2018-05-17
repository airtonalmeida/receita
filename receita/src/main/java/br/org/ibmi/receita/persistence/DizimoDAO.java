package br.org.ibmi.receita.persistence;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

import br.org.ibmi.receita.domain.Dizimo;

@PersistenceController
public class DizimoDAO extends JPACrud<Dizimo, Long> {

	private static final long serialVersionUID = 1L;
	

}
