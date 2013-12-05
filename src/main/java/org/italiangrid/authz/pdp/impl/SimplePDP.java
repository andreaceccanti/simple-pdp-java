package org.italiangrid.authz.pdp.impl;

import java.util.ArrayList;
import java.util.List;

import org.italiangrid.authz.pdp.Decision;
import org.italiangrid.authz.pdp.Effect;
import org.italiangrid.authz.pdp.MatchingRule;
import org.italiangrid.authz.pdp.PDP;
import org.italiangrid.authz.pdp.Policy;
import org.italiangrid.authz.pdp.PolicyEvaluationListener;
import org.italiangrid.authz.pdp.Request;
import org.italiangrid.authz.pdp.Rule;
import org.italiangrid.authz.pdp.RuleMatchingStrategy;



public class SimplePDP implements PDP{ 

	List<Policy> policies;
	RuleMatchingStrategy matchingStrategy;
	PolicyEvaluationListener listener;
	
	class DefaultMatchingStrategy implements RuleMatchingStrategy{

		@Override
		public boolean matches(Rule rule, Request request) {
			if (rule.getMatchingRules().isEmpty())
				return false;
			
			for (MatchingRule mr : rule.getMatchingRules()){
				listener.matchingRuleEvaluationStart(request, mr);
				final boolean matchFound = mr.matches(request);
				listener.matchingRuleEvaluationOutcome(request, mr, matchFound);
				if (!matchFound)
					return false;
			}
			return true;
		}
		
	}
	
	public SimplePDP() {
		policies = new ArrayList<Policy>();
		matchingStrategy = new DefaultMatchingStrategy();
		listener = NullListener.INSTANCE;
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
			listener.policyEvaluationStart(r, p);
			for (Rule rule: p.getRules()){
					listener.ruleEvaluationStart(r, rule);
					final boolean ruleMatches = matchingStrategy.matches(rule, r);
					listener.ruleEvaluationOutcome(r, rule, ruleMatches);

					if (ruleMatches){
						final Decision d = decisionFromEffect(rule.getEffect());
						listener.policyEvaluationOutcome(r, p, true);
						listener.requestEvaluationOutcome(r, d);
						return d;
						
					}
			}
			listener.policyEvaluationOutcome(r, p, false);
		}
		
		// If we got this far it means no policy that matches has been found
		final Decision d = Decision.NOT_APPLICABLE;
		listener.requestEvaluationOutcome(r, d);
		return d;
	}

	@Override
	public List<Policy> getPolicies() {
		return getPolicies();
	}

	@Override
	public void setPolicyEvaluationListener(PolicyEvaluationListener l) {
		listener = l;
	}
	
	
}
