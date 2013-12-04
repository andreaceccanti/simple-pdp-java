package org.italiangrid.authz.pdp;

import org.italiangrid.authz.pdp.impl.ActionImpl;
import org.italiangrid.authz.pdp.impl.PolicyImpl;
import org.italiangrid.authz.pdp.impl.PrincipalImpl;
import org.italiangrid.authz.pdp.impl.RequestImpl;
import org.italiangrid.authz.pdp.impl.ResourceImpl;
import org.italiangrid.authz.pdp.impl.SimplePDP;
import org.italiangrid.authz.pdp.impl.StatementImpl;
import org.italiangrid.authz.pdp.impl.StringRegexAttributeMatchRule;


public class Factory {
	
	public static Policy newPolicy(){
		return new PolicyImpl();
	}

	public static Resource newResource(String id){
	  return new ResourceImpl(id);
	}
	
	public static Action newAction(String id){
		return new ActionImpl(id);
	}
	
	public static Principal newPrincipal(String name){
		return new PrincipalImpl(name);
	}
	
	public static Request newRequest(String principalName, 
			String resource, String action){
		
		RequestImpl r = new RequestImpl();
		r.setAction(newAction(action));
		r.setResource(newResource(resource));
		r.setPrincipal(newPrincipal(principalName));
		
		return r;
	}
	
	public static Statement newStatement(Effect e, 
		String principalName, String resource, String action){
		
		StatementImpl s = new StatementImpl();
		s.setEffect(e);

		s.setPrincipalRule(new 
			StringRegexAttributeMatchRule<Principal>(AttributeID.USERNAME, 
				principalName));

		s.setResourceRule(new 
			StringRegexAttributeMatchRule<Resource>(AttributeID.RESOURCE_ID, 
			resource));

		s.setActionRule(new 
			StringRegexAttributeMatchRule<Action>(AttributeID.ACTION_ID, action));
		
		return s;
	}
	
	public static PDP newPDP(){
		return new SimplePDP();
	}
}
