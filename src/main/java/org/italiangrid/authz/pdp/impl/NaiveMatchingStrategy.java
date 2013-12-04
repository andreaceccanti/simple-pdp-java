package org.italiangrid.authz.pdp.impl;

import org.italiangrid.authz.pdp.Request;
import org.italiangrid.authz.pdp.Statement;
import org.italiangrid.authz.pdp.StatementMatchingStrategy;



public class NaiveMatchingStrategy implements StatementMatchingStrategy {

	public boolean matchPrincipal(Statement s, Request r){
		return s.getPrincipalMatchRule().matches(r.getPrincipal());
	}
	
	public boolean matchResource(Statement s, Request r){
		return s.getResourceMatchRule().matches(r.getResource());
	}
	
	public boolean matchAction(Statement s, Request r){
		return s.getActionMatchRule().matches(r.getAction());
	}
	
	@Override
	public boolean matches(Statement s, Request r) {

		boolean matches = false;
		matches = matchPrincipal(s, r);
		
		if (! matches )
			return false;
		
		matches = matchResource(s, r);
		if (! matches)
			return false;
		
		matches = matchAction(s, r);
		if (! matches)
			return false;
		
		return true;
	}

}
