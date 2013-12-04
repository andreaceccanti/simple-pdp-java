package org.italiangrid.authz.pdp.impl;

import org.italiangrid.authz.pdp.Identifiable;


public abstract class BaseIdentifiable implements Identifiable {

	protected String id;
	
	protected  BaseIdentifiable(String id) {
		this.id = id;
	}
	
	@Override
	public String getID() {
		return id;
	}
}
