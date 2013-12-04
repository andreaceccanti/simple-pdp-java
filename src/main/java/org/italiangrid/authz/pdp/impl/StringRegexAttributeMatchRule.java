package org.italiangrid.authz.pdp.impl;

import java.util.List;

import org.italiangrid.authz.pdp.Attribute;
import org.italiangrid.authz.pdp.AttributeContext;
import org.italiangrid.authz.pdp.AttributeID;
import org.italiangrid.authz.pdp.MatchRule;



public class StringRegexAttributeMatchRule<T extends AttributeContext> 
	implements MatchRule<T> {
	
	protected AttributeID attributeId;
	protected String regexValue;
	
	
	public StringRegexAttributeMatchRule(AttributeID attrId, String reg) {
		attributeId = attrId;
		regexValue = reg;
	}

	@Override
	public boolean matches(T other) {
		List<Attribute> attrList  = other.getAttributesById(attributeId);
		
		for (Attribute a: attrList){
			if (a.getValue().matches(regexValue))
				return true;
		}

		return false;
	}
	
	@Override
	public String toString() {
		return String.format("'%s' matches %s", attributeId, regexValue);
	}

}
