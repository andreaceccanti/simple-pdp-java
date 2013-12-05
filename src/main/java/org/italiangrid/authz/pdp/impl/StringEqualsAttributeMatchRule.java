package org.italiangrid.authz.pdp.impl;

import org.italiangrid.authz.pdp.Attribute;
import org.italiangrid.authz.pdp.AttributeBag;
import org.italiangrid.authz.pdp.AttributeType;
import org.italiangrid.authz.pdp.Request;

public class StringEqualsAttributeMatchRule extends AttributeMatchingRule{

	String value;
	
	public StringEqualsAttributeMatchRule(AttributeType at, String val) {
		super(at);
		value = val;
	}
	
	public boolean matches(Request r){
		AttributeBag attrBag = r.getAttributes(getAttributeType().getAttributeScope());
		
		// TODO: should we warn about this?
		if (attrBag == null)
			return false;
		
		for (Attribute a: attrBag.getAttributesByID(getAttributeType().getID())){
			if (a.getValue().equals(value))
				return true;
		}
		
		return false;
	}

	@Override
	public String toString() {
		return String.format("'%s' == %s", getAttributeType(), value);
	}

}
