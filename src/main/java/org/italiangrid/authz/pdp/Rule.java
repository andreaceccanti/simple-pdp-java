package org.italiangrid.authz.pdp;

import java.util.List;

public interface Rule extends Identifiable {

	public Effect getEffect();

	public List<MatchingRule> getMatchingRules();
	
}
