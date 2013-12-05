package org.italiangrid.authz.pdp.impl;

import java.util.regex.Pattern;

import org.italiangrid.authz.pdp.Attribute;
import org.italiangrid.authz.pdp.AttributeBag;
import org.italiangrid.authz.pdp.AttributeType;
import org.italiangrid.authz.pdp.Request;



public class StringRegexAttributeMatchRule extends AttributeMatchingRule{
	
	protected String regexValue;
	protected Pattern pattern;
	
	public StringRegexAttributeMatchRule(AttributeType at, String reg) {
		super(at);
		regexValue = reg;
		pattern = Pattern.compile(regexValue);
	}

	@Override
	public boolean matches(Request r) {
		
		AttributeBag attrBag = r.getAttributes(getAttributeType().getAttributeScope());

		// TODO: should we warn about this?
		if (attrBag == null)
			return false;

		for (Attribute a: attrBag.getAttributesByID(getAttributeType().getID())){
			if (pattern.matcher(a.getValue()).matches())
				return true;
		}

		return false;
	}
	
	@Override
	public String toString() {
		return String.format("'%s' matches %s", getAttributeType(), regexValue);
	}

}
