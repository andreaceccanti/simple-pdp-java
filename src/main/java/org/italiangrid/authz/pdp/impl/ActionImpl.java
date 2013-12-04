package org.italiangrid.authz.pdp.impl;

import org.italiangrid.authz.pdp.Action;
import org.italiangrid.authz.pdp.AttributeContextID;
import org.italiangrid.authz.pdp.AttributeID;


public class ActionImpl extends AttributeContextImpl implements Action {

	public ActionImpl(String id) {
		super(AttributeContextID.ACTION);
		addAttribute(AttributeID.ACTION_ID, id);
	}

}
