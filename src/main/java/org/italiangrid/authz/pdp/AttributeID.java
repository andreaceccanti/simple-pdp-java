package org.italiangrid.authz.pdp;


public enum AttributeID {

	// Principal attributes
	AUTHENTICATION_METHOD("principal:authentication-method"),
	VIRTUAL_ORGANIZATION("principal:vo"),
	FQAN("principal:fqan"),
	PRIMARY_FQAN("principal:pfqan"),
	SUBJECT("principal:subject"),
	ISSUER("principal:issuer"),
	CERT_CHAIN("principal:x509-cert-chain"),
	USERNAME("principal:username"),
	
	// Resource attributes
	RESOURCE_ID("resource:resource-id"),
	RESOURCE_OWNER("resource:resource-owner"),
	
	// Action attributes
	ACTION_ID("action:action-id");
	
	private AttributeID(String n){
		name = n;
	}
	
	private String name;
	
	public String getName() {
		return name;
	}

}
