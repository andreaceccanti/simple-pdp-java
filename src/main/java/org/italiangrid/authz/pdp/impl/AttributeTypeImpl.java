package org.italiangrid.authz.pdp.impl;

import org.italiangrid.authz.pdp.AttributeScope;
import org.italiangrid.authz.pdp.AttributeType;

public class AttributeTypeImpl implements AttributeType {

	String id;
	AttributeScope scope;
	
	public AttributeTypeImpl(String i, AttributeScope s) {
		id = i;
		scope = s;
	}

	@Override
	public String getID() {
		return id;
	}

	@Override
	public AttributeScope getAttributeScope() {
		return scope;
	}
	
	
	@Override
	public String toString() {
		return String.format("%s:%s", scope, id);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((scope == null) ? 0 : scope.hashCode());
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
		AttributeTypeImpl other = (AttributeTypeImpl) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (scope != other.scope)
			return false;
		return true;
	}
}
