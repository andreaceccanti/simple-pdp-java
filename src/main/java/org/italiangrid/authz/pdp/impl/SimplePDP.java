package org.italiangrid.authz.pdp.impl;

import java.util.HashSet;
import java.util.Set;

import org.italiangrid.authz.pdp.Decision;
import org.italiangrid.authz.pdp.Effect;
import org.italiangrid.authz.pdp.PDP;
import org.italiangrid.authz.pdp.Policy;
import org.italiangrid.authz.pdp.Request;
import org.italiangrid.authz.pdp.Statement;
import org.italiangrid.authz.pdp.StatementMatchingStrategy;



public class SimplePDP implements PDP{ 

	Set<Policy> policies;
	StatementMatchingStrategy matchingStrategy = new NaiveMatchingStrategy();
	
	public SimplePDP() {
		policies = new HashSet<Policy>();
	}
	
	public boolean addPolicy(Policy p){
		return policies.add(p);
	}
	
	public void clearPolicies(){
		policies.clear();
	}

	protected Decision decisionFromEffect(Effect e){
		if (e.equals(Effect.DENY))
			return Decision.DENY;

		return Decision.PERMIT;
	}
		
	@Override
	public Decision evaluateRequest(Request r) {

		for (Policy p: policies){
			for (Statement s: p.getStatements()){
				if (matchingStrategy.matches(s, r))
					return decisionFromEffect(s.getEffect());
			}
		}

		return Decision.NOT_APPLICABLE;
	}

	@Override
	public Set<Policy> getPolicies() {
		return getPolicies();
	}
	
	
}
