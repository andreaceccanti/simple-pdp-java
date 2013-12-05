package org.italiangrid.authz.pdp.impl;

import org.italiangrid.authz.pdp.Attribute;
import org.italiangrid.authz.pdp.AttributeType;
import org.italiangrid.authz.pdp.Request;

public class RequestBuilder {
	
	private RequestImpl request;
	
	public RequestBuilder() {

		request = new RequestImpl();
	}
	
	public RequestBuilder addAttribute(AttributeType t, String value){
		Attribute a = new AttributeImpl(t, value);
		request.addAttribute(a);
		return this;
	}
	
	public RequestBuilder addAttribute(Attribute a){
		request.addAttribute(a);
		return this;
	}

	public Request build(){
		return request;
	}

}
