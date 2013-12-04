package org.italiangrid.authz.pdp.impl;

import org.italiangrid.authz.pdp.Attribute;
import org.italiangrid.authz.pdp.AttributeID;


public class AttributeImpl implements Attribute, 
	Comparable<AttributeImpl> {

	AttributeID id;
	String value;
	
	public AttributeImpl(AttributeID id, String value){
		this.id = id;
		this.value = value;
	}

	@Override
	public AttributeID getID() {
		return id;
	}
	
	@Override
	public String getValue() {
		return value;
	}
	
	@Override
	public int compareTo(AttributeImpl o) {
		return id.compareTo(o.id);
	}

	@Override
	public int hashCode() {

		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return	String.format("%s = %s", id, value);
	}
}
