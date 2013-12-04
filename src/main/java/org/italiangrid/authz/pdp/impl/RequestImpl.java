package org.italiangrid.authz.pdp.impl;

import java.util.UUID;

import org.italiangrid.authz.pdp.Action;
import org.italiangrid.authz.pdp.Environment;
import org.italiangrid.authz.pdp.Principal;
import org.italiangrid.authz.pdp.Request;
import org.italiangrid.authz.pdp.Resource;



public class RequestImpl extends BaseIdentifiable implements Request {

	Principal principal;
	Resource resource;
	Action action;
	Environment environment;
	
	public RequestImpl() {
		super(UUID.randomUUID().toString());
	}
	@Override
	public Principal getPrincipal() {
		return principal;
	}

	@Override
	public Environment getEnvironment() {
		return environment;
	}

	@Override
	public Resource getResource() {
		return resource;
	}

	@Override
	public Action getAction() {
		return action;
	}

	public void setPrincipal(Principal principal) {
		this.principal = principal;
	}
	
	public void setResource(Resource resource) {
		this.resource = resource;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}
	
	@Override
	public String toString() {
		return String.format("Request [%s] { %s, %s, %s }",
			id,
			principal,
			action,
			resource);
	}
}
