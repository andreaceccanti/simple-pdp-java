package org.italiangrid.authz.pdp;

public interface Request extends Identifiable {

	Principal getPrincipal();

	Environment getEnvironment();

	Resource getResource();

	Action getAction();

}
