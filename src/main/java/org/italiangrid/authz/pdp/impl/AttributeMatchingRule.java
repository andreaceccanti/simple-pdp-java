package org.italiangrid.authz.pdp.impl;

import org.italiangrid.authz.pdp.AttributeType;
import org.italiangrid.authz.pdp.MatchingRule;

public abstract class AttributeMatchingRule implements MatchingRule {
	
	protected AttributeType attributeType;
	
	protected AttributeMatchingRule(AttributeType at){
		attributeType = at;
	}
	
	protected AttributeType getAttributeType(){
		return attributeType;
	}
}
