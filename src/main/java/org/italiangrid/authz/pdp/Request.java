package org.italiangrid.authz.pdp;

public interface Request extends Identifiable {
	public AttributeBag getAttributes(AttributeScope scope);
}
