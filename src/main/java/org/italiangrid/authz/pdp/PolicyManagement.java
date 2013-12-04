package org.italiangrid.authz.pdp;

import java.util.Set;


public interface PolicyManagement {
	public Set<Policy> getPolicies();
	public boolean addPolicy(Policy p);
	public void clearPolicies();
}
