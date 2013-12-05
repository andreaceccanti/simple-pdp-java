package org.italiangrid.authz.pdp;


public enum AttributeScope implements Identifiable{
	
	PRINCIPAL("principal"),
	ENVIRONMENT("environment"),
	RESOURCE("resource"),
	ACTION("action");
	
	private AttributeScope(String id){
		this.id = id;
	}

	public String getID(){
		return id;
	}
	
	private String id;
}
