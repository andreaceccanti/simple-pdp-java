package org.italiangrid.authz.pdp;


public interface MatchingRule{
	public boolean matches(Request request);
}
