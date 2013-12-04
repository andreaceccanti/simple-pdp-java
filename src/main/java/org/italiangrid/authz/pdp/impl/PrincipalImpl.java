package org.italiangrid.authz.pdp.impl;

import org.italiangrid.authz.pdp.AttributeContextID;
import org.italiangrid.authz.pdp.AttributeID;
import org.italiangrid.authz.pdp.Principal;



public class PrincipalImpl extends AttributeContextImpl implements Principal{

	public PrincipalImpl(String name) {
		super(AttributeContextID.PRINCIPAL);
		addAttribute(AttributeID.USERNAME, name);
	}

}
