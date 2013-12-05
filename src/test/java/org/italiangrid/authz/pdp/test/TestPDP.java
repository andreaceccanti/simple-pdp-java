package org.italiangrid.authz.pdp.test;

import static org.junit.Assert.assertEquals;

import org.italiangrid.authz.pdp.Decision;
import org.italiangrid.authz.pdp.Effect;
import org.italiangrid.authz.pdp.MatchingRule;
import org.italiangrid.authz.pdp.PDP;
import org.italiangrid.authz.pdp.Policy;
import org.italiangrid.authz.pdp.PolicyEvaluationListener;
import org.italiangrid.authz.pdp.Request;
import org.italiangrid.authz.pdp.Rule;
import org.italiangrid.authz.pdp.impl.PolicyImpl;
import org.italiangrid.authz.pdp.impl.RequestBuilder;
import org.italiangrid.authz.pdp.impl.RuleImpl;
import org.italiangrid.authz.pdp.impl.SimplePDP;
import org.italiangrid.authz.pdp.impl.StringEqualsAttributeMatchRule;
import org.italiangrid.authz.pdp.impl.StringRegexAttributeMatchRule;
import org.junit.Test;



public class TestPDP implements PolicyEvaluationListener{

	protected Request buildRequest(String principal, String resource, String action){
		
		RequestBuilder rb = new RequestBuilder();
		rb
			.addAttribute(TestAttributeTypes.PRINCIPAL_NAME.getAttributeType(), principal)
			.addAttribute(TestAttributeTypes.RESOURCE_ID.getAttributeType(), resource)
			.addAttribute(TestAttributeTypes.ACTION_ID.getAttributeType(), action);
		
		
		return rb.build();
		
	}
	
	protected MatchingRule buildRegexMatchingRule(TestAttributeTypes t, String regex){
		return new StringRegexAttributeMatchRule(t.getAttributeType(), regex);
	}
	
	protected MatchingRule buildEqualsMatchingRule(TestAttributeTypes t, String value){
		return new StringEqualsAttributeMatchRule(t.getAttributeType(), value);
	}
	
	protected Rule buildRegexRule(Effect e, String principalRegex, String resourceRegex, String actionRegex){
		
		RuleImpl r = new RuleImpl();
		r.setEffect(e);
		
		r.addMatchingRule(buildRegexMatchingRule(TestAttributeTypes.PRINCIPAL_NAME, principalRegex));
		r.addMatchingRule(buildRegexMatchingRule(TestAttributeTypes.RESOURCE_ID, resourceRegex));
		r.addMatchingRule(buildRegexMatchingRule(TestAttributeTypes.ACTION_ID, actionRegex));
		
		return r;
	}
	
	protected PDP buildPDP(){
		PDP pdp = new SimplePDP();
		pdp.setPolicyEvaluationListener(this);
		return pdp;
	}
	

	@Test
	public void testPermitRegex1() {
		
		Request r = buildRequest(
				"Andrea", 
				"tuneyards.cnaf.infn.it", 
				"destroy");

		PDP pdp = buildPDP();
		
		Policy p = new PolicyImpl();
		p.getRules().add(buildRegexRule(Effect.PERMIT, "Andrea", 
			".*", ".*"));
		
		pdp.addPolicy(p);
		assertEquals(Decision.PERMIT, pdp.evaluateRequest(r));
	}

	@Test
	public void testNotApplicableNoPolicies(){
		Request r = buildRequest(
				"Andrea", 
				"tuneyards.cnaf.infn.it", 
				"destroy");
		
		PDP pdp = buildPDP();

		assertEquals(Decision.NOT_APPLICABLE, pdp.evaluateRequest(r));

	}

	@Override
	public void requestEvaluationOutcome(Request r, Decision decision) {
		System.out.format("Decision '%s' for request '%s'\n", decision, r);
		
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
		System.out.format("Rule '%s' " + (matchFound ? "matches" : "does not match")+" with request '%s'\n", rule, req);
	}

	@Override
	public void matchingRuleEvaluationStart(Request req, MatchingRule mr) {
		
	}

	@Override
	public void matchingRuleEvaluationOutcome(Request req, MatchingRule mr,
			boolean matchFound) {
		
	}

}
