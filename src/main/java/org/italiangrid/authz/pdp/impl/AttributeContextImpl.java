package org.italiangrid.authz.pdp.impl;

import java.util.ArrayList;
import java.util.List;

import org.italiangrid.authz.pdp.Attribute;
import org.italiangrid.authz.pdp.AttributeContext;
import org.italiangrid.authz.pdp.AttributeContextID;
import org.italiangrid.authz.pdp.AttributeID;



public abstract class AttributeContextImpl implements AttributeContext {

	protected AttributeContextID id;
	protected List<Attribute> attributes; 
	
	protected AttributeContextImpl(AttributeContextID id) {
		attributes = new ArrayList<Attribute>();
		this.id = id;
	}

	@Override
	public AttributeContextID getId() {
		return id;
	}
	
	@Override
	public List<Attribute> getAttributes() {
		return attributes;
	}
	
	@Override
	public List<Attribute> getAttributesById(AttributeID id) {
		List<Attribute> result = new ArrayList<Attribute>();

		for (Attribute a: attributes){
			if (a.getID().equals(id))
				result.add(a);
		}

		return result;
	}

	protected boolean addAttribute(AttributeID id, String value){
		Attribute a = new AttributeImpl(id, value);
		return attributes.add(a);
	}

	@Override
	public String toString() {
		return String.format("%s: %s", id.getID(), getAttributes());
	}
}
