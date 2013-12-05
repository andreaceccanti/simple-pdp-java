package org.italiangrid.authz.pdp.impl;

import org.italiangrid.authz.pdp.MatchingRule;
import org.italiangrid.authz.pdp.Request;

public class AllOfAttributeMatchRule extends CompositeAttributeMatchingRule {

	@Override
	public boolean matches(Request request) {
		for (MatchingRule r: getRules()){
			if (!r.matches(request))
				return false;
		}
		return true;
	}


}
