package org.italiangrid.authz.pdp.impl;

import java.util.List;

import org.italiangrid.authz.pdp.Attribute;
import org.italiangrid.authz.pdp.AttributeContext;
import org.italiangrid.authz.pdp.AttributeID;
import org.italiangrid.authz.pdp.MatchRule;



public class StringEqualsAttributeMatchRule<T extends AttributeContext> 
	implements MatchRule<T> {

	AttributeID attributeId;
	String value;
	
	public StringEqualsAttributeMatchRule(AttributeID attrId, String val) {
		attributeId = attrId;
		value = val;
	}
	
	@Override
	public boolean matches(T other) {
		List<Attribute> attrList  = other.getAttributesById(attributeId);
		
		for (Attribute a: attrList){
			if (a.getValue().equals(value))
				return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return String.format("'%s' == %s", attributeId, value);
	}

}
