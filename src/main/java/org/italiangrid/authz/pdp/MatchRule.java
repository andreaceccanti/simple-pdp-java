package org.italiangrid.authz.pdp;


public interface MatchRule<T>{
	public boolean matches(T other);
}
