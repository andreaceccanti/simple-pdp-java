package org.italiangrid.authz.pdp;


public enum AttributeContextID implements Identifiable{
	
	PRINCIPAL("principal"),
	ENVIRONMENT("environment"),
	RESOURCE("resource"),
	ACTION("action");
	
	private AttributeContextID(String id){
		this.id = id;
	}

	public String getID(){
		return id;
	}
	
	private String id;
}
