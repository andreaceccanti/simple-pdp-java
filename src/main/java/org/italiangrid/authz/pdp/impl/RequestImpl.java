package org.italiangrid.authz.pdp.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.italiangrid.authz.pdp.Attribute;
import org.italiangrid.authz.pdp.AttributeBag;
import org.italiangrid.authz.pdp.AttributeScope;
import org.italiangrid.authz.pdp.Request;



public class RequestImpl extends BaseIdentifiable implements Request {

	Map<AttributeScope, AttributeBag> attributeBags;
	
	public RequestImpl() {
		super(UUID.randomUUID().toString());

		attributeBags = new HashMap<AttributeScope, AttributeBag>();

		attributeBags.put(AttributeScope.PRINCIPAL, new AttributeBagImpl(AttributeScope.PRINCIPAL));
		attributeBags.put(AttributeScope.RESOURCE, new AttributeBagImpl(AttributeScope.RESOURCE));
		attributeBags.put(AttributeScope.ACTION, new AttributeBagImpl(AttributeScope.ACTION));
		attributeBags.put(AttributeScope.ENVIRONMENT, new AttributeBagImpl(AttributeScope.ENVIRONMENT));
		
	}
	
	@Override
	public String toString() {
		return String.format("Request [%s] { %s, %s, %s }",
			id,
			getAttributes(AttributeScope.PRINCIPAL),
			getAttributes(AttributeScope.RESOURCE),
			getAttributes(AttributeScope.ACTION),
			getAttributes(AttributeScope.ENVIRONMENT));
	}

	@Override
	public AttributeBag getAttributes(AttributeScope scope) {
		return attributeBags.get(scope);
	}
	
	public boolean addAttribute(Attribute a){
		return attributeBags.get(a.getAttributeType().getAttributeScope()).addAttribute(a);
	}
}
