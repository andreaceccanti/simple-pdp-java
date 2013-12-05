package org.italiangrid.authz.pdp.test;

import org.italiangrid.authz.pdp.AttributeScope;
import org.italiangrid.authz.pdp.AttributeType;
import org.italiangrid.authz.pdp.impl.AttributeTypeImpl;

public enum TestAttributeTypes {

	PRINCIPAL_NAME("name", AttributeScope.PRINCIPAL),
	VO("vo", AttributeScope.PRINCIPAL),
	RESOURCE_ID("id", AttributeScope.RESOURCE),
	ACTION_ID("id", AttributeScope.ACTION);
	
	private TestAttributeTypes(String name, AttributeScope scope){
		attributeType = new AttributeTypeImpl(name, scope);
	}
	
	private AttributeType attributeType;

	public AttributeType getAttributeType() {
		return attributeType;
	}

}
