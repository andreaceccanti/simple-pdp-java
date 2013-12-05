package org.italiangrid.authz.pdp.impl;

import java.util.ArrayList;
import java.util.List;

import org.italiangrid.authz.pdp.Attribute;
import org.italiangrid.authz.pdp.AttributeBag;
import org.italiangrid.authz.pdp.AttributeScope;
import org.italiangrid.authz.pdp.AttributeType;

public class AttributeBagImpl implements AttributeBag {

	protected AttributeScope scope;
	protected List<Attribute> attributes; 
	
	public AttributeBagImpl(AttributeScope s) {
		attributes = new ArrayList<Attribute>();
		scope = s;
	}

	@Override
	public AttributeScope getScope() {
		return scope;
	}
	
	@Override
	public List<Attribute> getAllAttributes() {
		return attributes;
	}
	
	@Override
	public List<Attribute> getAttributesByID(String id) {
		List<Attribute> result = new ArrayList<Attribute>();

		for (Attribute a: attributes){
			if (a.getID().equals(id))
				result.add(a);
		}

		return result;
	}

	public boolean addAttribute(Attribute a){

		if (!a.getAttributeType().getAttributeScope().equals(scope)){
			throw new IllegalArgumentException(
					String.format("Attribute scope does not match bag scope: '%s' != '%s'", 
					a.getAttributeType().getAttributeScope(),
					scope));
		}

		return attributes.add(a);
	}

	@Override
	public String toString() {
		return String.format("%s: %s", scope.getID(), getAllAttributes());
	}

}
