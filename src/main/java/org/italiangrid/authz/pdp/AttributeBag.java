package org.italiangrid.authz.pdp;

import java.util.List;

public interface AttributeBag {
	public AttributeScope getScope();
	public List<Attribute> getAttributesByID(String id);
	public List<Attribute> getAllAttributes();
	public boolean addAttribute(Attribute a);
}
