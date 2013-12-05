package org.italiangrid.authz.pdp.impl;

import org.italiangrid.authz.pdp.Attribute;
import org.italiangrid.authz.pdp.AttributeType;


public class AttributeImpl implements Attribute{

	AttributeType type;
	String value;
	
	public AttributeImpl(AttributeType type, String value){
		this.type = type;
		this.value = value;
	}

	@Override
	public String getID() {
		return type.getID();
	}
	
	@Override
	public String getValue() {
		return value;
	}
	
	
	@Override
	public String toString() {
		return	String.format("%s = %s", type, value);
	}
	

	@Override
	public AttributeType getAttributeType() {
		return type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AttributeImpl other = (AttributeImpl) obj;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}
}
