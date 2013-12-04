package org.italiangrid.authz.pdp;

public interface Statement extends Identifiable {

	Effect getEffect();

	MatchRule<Principal> getPrincipalMatchRule();

	MatchRule<Resource> getResourceMatchRule();

	MatchRule<Action> getActionMatchRule();
	
}
