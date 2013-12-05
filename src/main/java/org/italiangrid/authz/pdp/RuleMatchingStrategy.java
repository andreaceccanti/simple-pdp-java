package org.italiangrid.authz.pdp;


public interface RuleMatchingStrategy {
	
	public boolean matches(Rule rule, Request request);

}
