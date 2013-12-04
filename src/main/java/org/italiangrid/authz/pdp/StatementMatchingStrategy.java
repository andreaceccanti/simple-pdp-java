package org.italiangrid.authz.pdp;


public interface StatementMatchingStrategy {
	
	public boolean matches(Statement s, Request r);

}
