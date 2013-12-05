package org.italiangrid.authz.pdp;



public interface Attribute extends Identifiable{
	AttributeType getAttributeType();
	String getValue();
}
