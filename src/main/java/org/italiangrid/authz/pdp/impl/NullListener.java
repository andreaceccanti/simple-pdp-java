package org.italiangrid.authz.pdp.impl;

import org.italiangrid.authz.pdp.Decision;
import org.italiangrid.authz.pdp.MatchingRule;
import org.italiangrid.authz.pdp.Policy;
import org.italiangrid.authz.pdp.PolicyEvaluationListener;
import org.italiangrid.authz.pdp.Request;
import org.italiangrid.authz.pdp.Rule;

public enum NullListener implements PolicyEvaluationListener{

	INSTANCE;

	@Override
	public void requestEvaluationOutcome(Request r, Decision decision) {
	}

	@Override
	public void policyEvaluationStart(Request r, Policy p) {
	}

	@Override
	public void policyEvaluationOutcome(Request r, Policy p, boolean matchFound) {
	}

	@Override
	public void ruleEvaluationStart(Request req, Rule rule) {
	}

	@Override
	public void ruleEvaluationOutcome(Request req, Rule rule, boolean matchFound) {
	}

	@Override
	public void matchingRuleEvaluationStart(Request req, MatchingRule mr) {
	}

	@Override
	public void matchingRuleEvaluationOutcome(Request req, MatchingRule mr,
			boolean matchFound) {
	}
}
