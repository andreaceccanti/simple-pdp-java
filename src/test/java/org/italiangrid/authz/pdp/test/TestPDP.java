package org.italiangrid.authz.pdp.test;

import static org.junit.Assert.assertEquals;

import org.italiangrid.authz.pdp.Decision;
import org.italiangrid.authz.pdp.Effect;
import org.italiangrid.authz.pdp.Factory;
import org.italiangrid.authz.pdp.PDP;
import org.italiangrid.authz.pdp.Policy;
import org.italiangrid.authz.pdp.Request;
import org.junit.Test;



public class TestPDP {

	@Test
	public void testPermitRegex1() {
		
		Request r = Factory.newRequest("Andrea", 
			"tuneyards.cnaf.infn.it", 
			"destroy");

		PDP pdp = Factory.newPDP();
		
		Policy p = Factory.newPolicy();
		p.getStatements().add(Factory.newStatement(Effect.PERMIT, "Andrea", 
			".*", ".*"));
		
		pdp.addPolicy(p);
		assertEquals(Decision.PERMIT, pdp.evaluateRequest(r));
	}

	@Test
	public void testDENYRegex1() {
		Request r = Factory.newRequest("Andrea", 
			"tuneyards.cnaf.infn.it", 
			"destroy");
		

		PDP pdp = Factory.newPDP();
		Policy p = Factory.newPolicy();
		p.getStatements().add(Factory.newStatement(Effect.DENY, "Andrea", 
			".*", ".*"));
		
		pdp.addPolicy(p);
		assertEquals(Decision.DENY, pdp.evaluateRequest(r));
	}
	
	@Test
	public void testNotApplicableNoPolicies(){
		Request r = Factory.newRequest("Andrea", 
			"tuneyards.cnaf.infn.it", 
			"destroy");
		
		PDP pdp = Factory.newPDP();

		assertEquals(Decision.NOT_APPLICABLE, pdp.evaluateRequest(r));

	}

	@Test
	public void testFirstApplicable(){
		Request r = Factory.newRequest("Andrea", 
			"tuneyards.cnaf.infn.it", 
			"destroy");
		
		PDP pdp = Factory.newPDP();
		Policy p = Factory.newPolicy();
		
		p.getStatements().add(Factory.newStatement(Effect.DENY, 
			"Ciccio", "tuneyards.cnaf.infn.it", "destroy"));

		p.getStatements().add(Factory.newStatement(Effect.DENY, 
			"Andrea", "illo.cnaf.infn.it", "destroy"));

		p.getStatements().add(Factory.newStatement(Effect.DENY, 
			"Andrea", "tuneyards.cnaf.infn.it", "destroy"));
		
		p.getStatements().add(Factory.newStatement(Effect.PERMIT, 
			"Andrea", "tuneyards.cnaf.infn.it", "destroy"));

		pdp.addPolicy(p);

		assertEquals(Decision.DENY, pdp.evaluateRequest(r));

	}

	@Test
	public void testActionMatch(){
		Request r = Factory.newRequest("Andrea", 
			"tuneyards.cnaf.infn.it", 
			"destroy");
		
		PDP pdp = Factory.newPDP();
		Policy p = Factory.newPolicy();
		
		p.getStatements().add(Factory.newStatement(Effect.DENY, 
			"Ciccio", ".*", ".*"));

		p.getStatements().add(Factory.newStatement(Effect.PERMIT, 
			".*", "tuneyards.cnaf.infn.it", ".*"));

		pdp.addPolicy(p);

		assertEquals(Decision.PERMIT, pdp.evaluateRequest(r));

	}
}
