package org.italiangrid.authz.pdp;


public interface PolicyDecisionPoint {
	
	public Decision evaluateRequest(Request r);
	public void setPolicyEvaluationListener(PolicyEvaluationListener l);

}
