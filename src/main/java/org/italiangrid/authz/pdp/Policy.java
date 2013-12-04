package org.italiangrid.authz.pdp;

import java.util.List;


public interface Policy extends Identifiable{
	List<Statement> getStatements();
}
