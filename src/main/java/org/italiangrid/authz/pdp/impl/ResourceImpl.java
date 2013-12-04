package org.italiangrid.authz.pdp.impl;

import org.italiangrid.authz.pdp.AttributeContextID;
import org.italiangrid.authz.pdp.AttributeID;
import org.italiangrid.authz.pdp.Resource;


public class ResourceImpl extends AttributeContextImpl implements Resource{

	public ResourceImpl(String id) {
		super(AttributeContextID.RESOURCE);
		addAttribute(AttributeID.RESOURCE_ID, id);
	}

}
