package org.italiangrid.authz.pdp;

public interface PolicyEvaluationListener {
	
	public void requestEvaluationOutcome(Request r, Decision decision);

	public void policyEvaluationStart(Request r, Policy p);
	public void policyEvaluationOutcome(Request r, Policy p, boolean matchFound);

	public void ruleEvaluationStart(Request req, Rule rule);
	public void ruleEvaluationOutcome(Request req, Rule rule, boolean matchFound);
	
	public void matchingRuleEvaluationStart(Request req, MatchingRule mr);
	public void matchingRuleEvaluationOutcome(Request req, MatchingRule mr, boolean matchFound);

}
