package org.italiangrid.authz.pdp;

import java.util.List;



public interface AttributeContext {
	public AttributeContextID getId();
	public List<Attribute> getAttributesById(AttributeID id);
	public List<Attribute> getAttributes();
}
